import React, { useState, useEffect } from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';
import CategoryService from '../../services/CategoryServices';

const EditCategory = ({ currentCategory, setEditing, setData }) => {
  const [category, setCategory] = useState({
    id: currentCategory.id,
    title: currentCategory.title,
  });

  const handleInputChange = event => {
    const { name, value } = event.target;
    setCategory({ ...category, [name]: value });
  };

  useEffect(() => {
    setCategory(currentCategory);
  }, [currentCategory]);

  const onEdit = e => {
    e.preventDefault();
    setEditing(false);
    let newCategory = {
      id: category.id,
      title: category.title,
    };
    CategoryService.update(category.id, newCategory).then(res => {
      setData(oldState => {
        let newState;
        newState = oldState.map(category => {
          return category.id === res.data.id ? res.data : category;
        });
        return newState;
      });
      setEditing(false);
    });
  };

  const onReset = () => {
    setCategory({
      id: null,
      title: '',
    });
  };
  return (
    <>
      <Form className="mb-2">
        <FormGroup className="mb-2">
          <Label>Title</Label>
          <Input
            type="text"
            name="title"
            placeholder="Enter title"
            value={category.title}
            onChange={handleInputChange}
          />
        </FormGroup>
        <Button color="success" onClick={onEdit}>
          Update
        </Button>
        <Button color="secondary" onClick={onReset}>
          Reset
        </Button>
      </Form>
    </>
  );
};

export default EditCategory;
