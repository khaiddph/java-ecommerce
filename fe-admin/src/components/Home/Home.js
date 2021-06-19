import React, { useState, useEffect } from 'react';
import {
  Container,
  Grid,
  Card,
  CardContent,
  CardActions,
  Typography,
  Button,
  CardMedia,
  Box,
  IconButton,
} from '@material-ui/core';
import { Form, FormGroup, Label, Input } from 'reactstrap';
import { Backdrop, CircularProgress } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import ProductServices from '../../services/ProductServices';
import axios from 'axios';
import './styles.css';
import styled from 'styled-components';
import { FcPrevious, FcNext } from 'react-icons/fc';

const UL = styled.ul`
  display: flex;
  list-style: none;
  /* cursor: poiter; */
`;

const LI = styled.li`
  text-decoration: none;
  border: 1px solid #888;
  padding: 5px 10px;
  border-radius: 10px;
  margin: 0 5px;
  background: #f8f8f8;
  cursor: pointer;
`;

const useStyles = makeStyles(theme => ({
  backdrop: {
    zIndex: theme.zIndex.drawer + 1,
    color: '#fff',
  },
}));

const Home = () => {
  const classes = useStyles();
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [categoriesId, setCategoriesId] = useState(1);
  const [pageNo, setPageNo] = useState(1);
  const [loading, setLoading] = useState(false);
  const [searched, setSearched] = useState('');

  useEffect(() => {
    setLoading(true);
    const getCategory = () => {
      ProductServices.getCategory().then(res => {
        setCategories(res.data.content);
        setLoading(false);
      });
    };

    const pageSize = 6;

    const url = `http://localhost:8080/api/category/${categoriesId}/product?page=${
      pageNo - 1
    }&size=${pageSize}`;

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

  const lastBtn = () => {
    if (pageNo > 1) {
      setPageNo(pageNo - 1);
    }
  };

  const nextBtn = () => {
    setPageNo(pageNo + 1);
  };
  console.log(products);
  return (
    <Container>
      <Backdrop className={classes.backdrop} open={loading}>
        <CircularProgress color="inherit" />
      </Backdrop>
      <Grid container spacing={4}>
        <Grid item xs={8}>
          <Form>
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
        </Grid>
        <Grid item xs={4}>
          <FormGroup>
            <Label>Search</Label>
            <Input
              type="text"
              placeholder="Enter keyword search"
              onChange={e => setSearched(e.target.value)}
            />
          </FormGroup>
        </Grid>
      </Grid>

      <Grid container spacing={3}>
        {products.length > 0 ? (
          products.map((val, idx) => (
            <Grid
              direction="row"
              justify="space-between"
              align="center"
              item
              key={idx}
              xs={3}
              sm={6}
              md={4}
            >
              <Card className={classes.root}>
                <CardMedia component="img" image={`${val.imagePath}`} />
                <CardContent>
                  <Typography gutterBottom variant="h5" component="h2">
                    {val.title}
                  </Typography>
                  <Typography>{val.price}$</Typography>
                </CardContent>
                <CardActions>
                  <Button size="small" color="primary">
                    ADD TO CART
                  </Button>
                </CardActions>
              </Card>
            </Grid>
          ))
        ) : (
          <Box justifyContent="center">
            <Typography variant="h6">No products</Typography>
          </Box>
        )}
        {products.length > 0 ? (
          <UL>
            <LI>
              <FcPrevious onClick={lastBtn} />
              {/* <IconButton>
              </IconButton> */}
            </LI>
            <LI>{pageNo}</LI>
            <LI>
              <FcNext onClick={nextBtn} />
            </LI>
          </UL>
        ) : (
          ''
        )}
      </Grid>
    </Container>
  );
};

export default Home;
