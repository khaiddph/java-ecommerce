import React from 'react';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  Container,
} from 'reactstrap';
import { Link } from 'react-router-dom';

const Navbars = () => {
  return (
    <>
      <Navbar color="dark" dark expand="md">
        <Container>
          <NavbarBrand href="/">E-Commerce</NavbarBrand>
          <NavbarToggler />
          <Collapse navbar className="justify-content-center">
            <Nav className="mr-auto" navbar>
              {/* <NavItem>
                <NavLink href="/category">Category</NavLink>
              </NavItem> */}
              <NavItem>
                <Link to="/products">Products</Link>
              </NavItem>
            </Nav>
          </Collapse>
        </Container>
      </Navbar>
    </>
  );
};

export default Navbars;
