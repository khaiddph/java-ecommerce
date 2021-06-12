import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Album from './components/pages/Album.js';

const App = () => {
  return (
    <Router>
      <Switch>
        <Route to="/" exact component={Album} />
      </Switch>
    </Router>
  );
};

export default App;
