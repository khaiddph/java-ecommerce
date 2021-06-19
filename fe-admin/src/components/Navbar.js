import React from 'react';
import {
  AppBar,
  Toolbar,
  IconButton,
  Typography,
  Container,
  Grid,
  Box,
} from '@material-ui/core';
import { Link } from 'react-router-dom';
import { RiAccountCircleLine, RiShoppingCart2Fill } from 'react-icons/ri';

const Navbars = () => {
  return (
    <>
      <AppBar position="static">
        <Container>
          <Toolbar>
            <Typography color="inherit" variant="h5">
              E-commerce
            </Typography>
            <Box display="flex" flexGrow="1" justifyContent="center">
              <Link className="link" to="/">
                <Typography variant="h6">Home</Typography>
              </Link>
              <Link className="link" to="/category">
                <Typography variant="h6">category</Typography>
              </Link>
              <Link className="link" to="/products">
                <Typography variant="h6">product</Typography>
              </Link>
            </Box>
            <IconButton edge="end" color="inherit">
              <RiShoppingCart2Fill size="1.5em" />
            </IconButton>
            <IconButton edge="end" color="inherit">
              <RiAccountCircleLine size="1.5em" />
            </IconButton>
          </Toolbar>
        </Container>
      </AppBar>

      {/* <Navbar color="dark" dark expand="md">
        <Container>
          <NavbarBrand href="/">E-Commerce</NavbarBrand>
          <NavbarToggler />
          <Collapse navbar className="justify-content-center">
            <Nav className="mr-auto" navbar>
              <NavItem>
                <Link to="/">Home</Link>
              </NavItem>
              <NavItem>
                <Link to="/category">category</Link>
              </NavItem>
              <NavItem>
                <Link to="/products">Products</Link>
              </NavItem>
            </Nav>
          </Collapse>
        </Container>
      </Navbar> */}
    </>
  );
};

export default Navbars;
