import React, { useState } from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';
import CategoryService from '../../services/CategoryServices';

const SaveCategory = ({ data, setData, setOpen }) => {
  const [category, setCategory] = useState({
    id: null,
    title: '',
  });

  const handleInputChange = event => {
    const { name, value } = event.target;
    setCategory({ ...category, [name]: value });
  };

  const onSave = e => {
    e.preventDefault();
    CategoryService.save(category).then(res => {
      setData([...data, res.data]);
      setOpen(false);
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
            // value={category.title}
            onChange={handleInputChange}
          />
        </FormGroup>
        <Button color="success" onClick={onSave}>
          Submit
        </Button>
      </Form>
    </>
  );
};

export default SaveCategory;
