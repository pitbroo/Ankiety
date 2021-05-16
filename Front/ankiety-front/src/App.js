
import './style/App.css';
import './Ankiety.js'
import Header from './Header.js'
import Ankiety from './Ankiety.js';
import Footer from './Footer.js';
import StronaGlowna from './StronaGlowna.js';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import NowaAnkieta from './NowaAnkieta.js'
import Wyniki from './Wyniki.js';

import React, { Component } from 'react';

class App extends Component {
  state = {
    loading: true
  }
  componentDidMount() {
    demoAsyncCall().then(() => this.setState({ loading: false }));
  }

  render() {
    const { loading } = this.state;

    if (loading) { // if your component doesn't have to wait for an async action, remove this block 
      return (
          <div id="app" class="loader"></div>
      ); // render null when app is not ready
    }

    return (
      <div className="App">
        <Router>
          <Header />
          <main>
            <Route path="/" component={StronaGlowna} exact />
            <Route path="/Ankiety" component={Ankiety} />
            {/* <Route path="/DodajAnkiete" component={DodawanieAnkiety}/> */}
            <Route path="/NowaAnkieta" component={NowaAnkieta} />
            <Route path="/Wyniki" component={Wyniki} />
          </main>
        </Router>
        <Footer />

      </div>
    );
  }

}

function demoAsyncCall() {
  return new Promise((resolve) => setTimeout(() => resolve(), 700));
}

export default App;

