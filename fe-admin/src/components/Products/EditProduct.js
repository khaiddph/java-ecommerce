import ProductServices from '../../services/ProductServices';
import React, { useEffect, useState } from 'react';
import { Button, Form, FormGroup, Input, Label } from 'reactstrap';

const EditProduct = ({
  currentProduct,
  setData,
  setEditing,
  categoriesId,
  data,
  categories,
}) => {
  const [product, setProduct] = useState(currentProduct);
  console.log(currentProduct);

  const handleInputChange = event => {
    const { name, value } = event.target;
    setProduct({ ...product, [name]: value });
  };

  useEffect(() => {
    setProduct(currentProduct);
    // setCategoriesId(categoriesId);
  }, [currentProduct]);

  console.log(categories);

  const onEdit = e => {
    e.preventDefault();

    ProductServices.update(categoriesId, product.id, product).then(res => {
      // setData([...data, res.data]);
      // console.log(res.data);
      setData(oldState => {
        let newState;
        newState = oldState.map(product => {
          return product.id === res.data.id ? res.data : product;
        });
        return newState;
      });
      console.log(res.data);
      setEditing(false);
    });
  };
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
            <Label>Image</Label>
            <Input
              type="text"
              name="imagePath"
              value={product.imagePath}
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
