import React, { useState } from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';
import ProductServices from '../../services/ProductServices';

const AddProduct = ({ categoriesId, setData, data }) => {
  const [product, setProduct] = useState([]);

  const handleInputChange = event => {
    const { name, value } = event.target;
    setProduct({ ...product, [name]: value });
  };

  const onSubmit = e => {
    const body1 = {
      categoriesId: categoriesId,
      title: product.title,
      imagePath: product.imagePath,
      price: product.price,
      quantity: product.quantity,
    };
    console.log(body1);
    e.preventDefault();
    ProductServices.save(categoriesId, body1).then(res => {
      setData([...data, res.data]);
      console.log(res.data);
    });
    // axios({
    //   method: 'POST',
    //   url: `http://localhost:8080/api/category/${categoriesId}/product/`,
    //   body: body1,
    //   headers: {
    //     'Content-Type': 'application/x-www-form-urlencoded',
    //   },
    // })
    //   .then(res => {
    //     // setProduct([...product, res.data]);
    //     if (res.status === 200) {
    //       console.log(res.data);
    //     }
    //   })
    //   .catch(error => {
    //     console.log(error.res);
    //   });
    // console.log(product);
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
              // value={category.title}
              onChange={handleInputChange}
            />
          </FormGroup>
          <FormGroup className="mb-2">
            <Label>Image</Label>
            <Input
              type="text"
              name="imagePath"
              // value={category.title}
              onChange={handleInputChange}
            />
          </FormGroup>
          <FormGroup className="mb-2">
            <Label>Price</Label>
            <Input
              type="number"
              name="price"
              placeholder="Enter price"
              // value={category.title}
              onChange={handleInputChange}
            />
          </FormGroup>
          <FormGroup className="mb-2">
            <Label>Quantity</Label>
            <Input
              type="number"
              name="quantity"
              placeholder="Enter quantity"
              // value={category.title}
              onChange={handleInputChange}
            />
          </FormGroup>

          <Button color="success" onClick={onSubmit}>
            Submit
          </Button>
        </Form>
      </form>
    </>
  );
};

export default AddProduct;
