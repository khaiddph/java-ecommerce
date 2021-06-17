import React, { useState } from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';

const AddProduct = () => {
  return (
    <>
      <form>
        <Form className="mb-2">
          <FormGroup className="mb-2">
            <Label>Title</Label>
            <Input
              type="text"
              name="title"
              placeholder="Enter title"
              // value={category.title}
              //   onChange={handleInputChange}
            />
          </FormGroup>
          <FormGroup className="mb-2">
            <Label>Price</Label>
            <Input
              type="number"
              name="price"
              placeholder="Enter price"
              // value={category.title}
              //   onChange={handleInputChange}
            />
          </FormGroup>
          <FormGroup className="mb-2">
            <Label>Quantity</Label>
            <Input
              type="number"
              name="quantity"
              placeholder="Enter quantity"
              // value={category.title}
              //   onChange={handleInputChange}
            />
          </FormGroup>
          <FormGroup className="mb-2">
            <Label>Image</Label>
            <Input
              type="file"
              name="image"
              placeholder="Enter image"
              // value={category.title}
              //   onChange={handleInputChange}
            />
          </FormGroup>
          <Button color="success">Submit</Button>
        </Form>
      </form>
    </>
  );
};

export default AddProduct;
