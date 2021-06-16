import React, { useState, useEffect } from 'react';
import { Container, Table, Button } from 'reactstrap';
import { FaEdit } from 'react-icons/fa';
import { AiTwotoneDelete } from 'react-icons/ai';
import { Backdrop, CircularProgress } from '@material-ui/core';
import CategoryService from '../../services/CategoryServices';
import { makeStyles } from '@material-ui/core/styles';
import SaveCategory from './SaveCategory';
import EditCategory from './EditCategory';

const useStyles = makeStyles(theme => ({
  backdrop: {
    zIndex: theme.zIndex.drawer + 1,
    color: '#fff',
  },
}));

const Category = () => {
  const classes = useStyles();
  const [category, setCategory] = useState([]);
  const [editing, setEditing] = useState(false);
  const [open, setOpen] = useState(false);
  const [loading, setLoading] = useState(true);
  const [currentCategory, setCurrentCategory] = useState([]);

  useEffect(() => {
    CategoryService.getAll().then(res => {
      setCategory(res.data.content);
      setLoading(false);
    });
  }, []);

  const editRow = data => {
    setEditing(true);
    setCurrentCategory(data);
  };

  const onDelete = id => {
    let confirm = window.confirm('Are you sure?');
    if (confirm) {
      CategoryService.deleteById(id).then(res => {
        setCategory(category.filter(category => category.id !== id));
      });
    }
  };
  return (
    <Container>
      <Backdrop className={classes.backdrop} open={loading}>
        <CircularProgress color="inherit" />
      </Backdrop>

      <Button color="info" onClick={() => setOpen(true)}>
        ADD NEW CATEGORY
      </Button>
      {open ? (
        <SaveCategory data={category} setData={setCategory} setOpen={setOpen} />
      ) : (
        ''
      )}
      {editing ? (
        <EditCategory
          currentCategory={currentCategory}
          editing={editing}
          setEditing={setEditing}
          setData={setCategory}
          data={category}
        />
      ) : (
        ''
      )}

      <hr />
      <Table>
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {category.map((val, idx) => (
            <tr key={idx}>
              <td>{val.id} </td>
              <td>{val.title} </td>
              <td>
                <FaEdit size={'2em'} onClick={() => editRow(val)} />
                <AiTwotoneDelete
                  size={'2em'}
                  onClick={() => onDelete(val.id)}
                />
              </td>
            </tr>
          ))}
          {/* {category.length > 0 ? (
           
          ) : (
            <tr>
              <td colSpan={3}>No Category</td>
            </tr>
          )} */}
        </tbody>
      </Table>
    </Container>
  );
};

export default Category;
