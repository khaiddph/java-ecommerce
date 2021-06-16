import React, { useState, useEffect } from 'react';
import ProductServices from '../../services/ProductServices';
import { Container, Row, Col, Form, FormGroup, Label, Input } from 'reactstrap';
import {
  Table,
  TableContainer,
  TableHead,
  TableRow,
  TableCell,
  TableBody,
  Grid,
  Button,
} from '@material-ui/core';
import { FaEdit } from 'react-icons/fa';
import { AiTwotoneDelete } from 'react-icons/ai';
import axios from 'axios';
import styled from 'styled-components';
import { FcNext, FcPrevious } from 'react-icons/fc';
import { makeStyles } from '@material-ui/core/styles';
import { Backdrop, CircularProgress } from '@material-ui/core';

const UL = styled.ul`
  display: flex;
  list-style: none;
`;
const LI = styled.li`
  padding: 5px 11px;
  border: 1px solid;
  border-radius: 50%;
  margin: 10px;
  cursor: pointer;
`;

const useStyles = makeStyles(theme => ({
  backdrop: {
    zIndex: theme.zIndex.drawer + 1,
    color: '#fff',
  },
}));

const ListProducts = () => {
  const classes = useStyles();
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [pageNo, setPageNo] = useState(0);
  const [categoriesId, setCategoriesId] = useState(1);
  const [loading, setLoading] = useState(true);
  const [searched, setSearched] = useState('');

  useEffect(() => {
    const getCategory = () => {
      ProductServices.getCategory().then(res => {
        setCategories(res.data.content);
        setLoading(false);
      });
    };

    const pageSize = 4;
    const url = `http://localhost:8080/api/category/${categoriesId}/product?page=${pageNo}&size=${pageSize}`;

    axios({
      method: 'GET',
      url: url,
    }).then(res => {
      setProducts(res.data.content);
      setLoading(false);
    });

    const urlSearch = `http://localhost:8080/api/category/${categoriesId}/product?search=${searched}`;

    axios({
      method: 'GET',
      url: urlSearch,
    }).then(res => {
      setProducts(res.data.content);
    });

    getCategory();
  }, [pageNo, categoriesId, searched]);

  const onChangeCategories = e => {
    setCategoriesId(e.target.value);
  };

  const editRow = data => {};
  const onDelete = id => {};

  const lastBtn = () => {
    setPageNo(pageNo - 1);
  };

  const nextBtn = () => {
    setPageNo(pageNo + 1);
  };

  return (
    <Container>
      <Backdrop className={classes.backdrop} open={loading}>
        <CircularProgress color="inherit" />
      </Backdrop>
      <Button variant="contained" color="primary">
        ADD NEW PRODUCT
      </Button>
      <Row>
        <Col xs={9} md={8} sm="auto">
          <Form className={'p-3'}>
            <FormGroup>
              <Label for="exampleSelect">Category</Label>
              <Input
                onChange={onChangeCategories}
                type="select"
                name="select"
                id="exampleSelect"
              >
                {categories.map((val, idx) => (
                  <option value={val.id} key={idx}>
                    {val.title}{' '}
                  </option>
                ))}
              </Input>
            </FormGroup>
          </Form>
        </Col>
        <Col xs={3} md={4} sm="auto">
          <FormGroup className="p-3">
            <Label>Search</Label>
            <Input
              type="text"
              placeholder="Enter keyword search"
              onChange={e => setSearched(e.target.value)}
            />
          </FormGroup>
        </Col>
      </Row>
      <TableContainer>
        <Table aria-label="customized table">
          <TableHead>
            <TableRow>
              {/* <TableCell>ID</TableCell> */}
              <TableCell>Image</TableCell>
              <TableCell>Title</TableCell>
              <TableCell>Price</TableCell>
              <TableCell>Quantity</TableCell>
              <TableCell>Action</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {products.length > 0 ? (
              products.map((val, idx) => (
                <TableRow key={idx}>
                  <TableCell>
                    <img src={val.image_path} alt={val.title} />{' '}
                  </TableCell>
                  <TableCell>{val.title} </TableCell>
                  <TableCell>{val.price} </TableCell>
                  <TableCell>{val.quantity}</TableCell>
                  <TableCell>
                    <FaEdit size={'2em'} onClick={() => editRow(val)} />
                    <AiTwotoneDelete
                      size={'2em'}
                      onClick={() => onDelete(val.id)}
                    />
                  </TableCell>
                </TableRow>
              ))
            ) : (
              <TableRow>
                <TableCell colSpan={6} align="center">
                  No Products{' '}
                </TableCell>
              </TableRow>
            )}
          </TableBody>
        </Table>
      </TableContainer>
      <Grid container spacing={3}>
        <Grid item xs={4}>
          <UL>
            <LI>
              <FcPrevious onClick={lastBtn} />
            </LI>
            <LI>{pageNo} </LI>
            <LI>
              <FcNext onClick={nextBtn} />
            </LI>
          </UL>
        </Grid>
      </Grid>
    </Container>
  );
};

export default ListProducts;
