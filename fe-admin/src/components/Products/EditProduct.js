import React, { useState, useEffect } from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';
import ProductServices from '../../services/ProductServices';

const EditProduct = ({ currentProduct, setData, setEditing, categoriesId }) => {
  const [product, setProduct] = useState(currentProduct);

  const handleInputChange = event => {
    const { name, value } = event.target;
    setProduct({ ...product, [name]: value });
  };

  useEffect(() => {
    setProduct(currentProduct);
  }, [currentProduct]);

  const onEdit = () => {
    let newData = {
      id: product.id,
      title: product.title,
      price: product.price,
      quantity: product.quantity,
    };
    ProductServices.update(categoriesId, product.id, newData).then(res => {
      // setData(oldState => {
      //   let newState;
      //   newState = oldState.map(product => {
      //     return product.id === res.data.id ? res.data : product;
      //   });
      //   return newState;
      // });
      setEditing(false);
    });
    console.log(newData.id);
  };
  console.log('ca', categoriesId);
  // console.log(product.id);
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
              value={product.title}
              onChange={handleInputChange}
            />
          </FormGroup>
          <FormGroup className="mb-2">
            <Label>Price</Label>
            <Input
              type="number"
              name="price"
              placeholder="Enter price"
              value={product.price}
              onChange={handleInputChange}
            />
          </FormGroup>
          <FormGroup className="mb-2">
            <Label>Quantity</Label>
            <Input
              type="number"
              name="quantity"
              placeholder="Enter quantity"
              value={product.quantity}
              onChange={handleInputChange}
            />
          </FormGroup>
          {/* <FormGroup className="mb-2">
            <Label>Image</Label>
            <Input
              type="file"
              name="image"
              placeholder="Enter image"
              // value={product.title}
              onChange={handleInputChange}
            />
          </FormGroup> */}
          <Button color="success" onClick={onEdit}>
            Submit
          </Button>
          <Button color="secondary">Reset</Button>
        </Form>
      </form>
    </>
  );
};

export default EditProduct;
