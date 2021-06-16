import React from 'react';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Category from './components/Category/Category';
import ListProducts from './components/Products/ListProducts';

const App = () => {
  return (
    <Router>
      <Navbar />
      <Switch>
        <Route exact path="/" component={Category} />
        <Route exact path="/products" component={ListProducts} />
      </Switch>
    </Router>
  );
};

export default App;
