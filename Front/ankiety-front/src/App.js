
import './style/App.css';
import './Ankiety.js'
import Header from './Header.js'
import Ankiety from './Ankiety.js';
import Footer from './Footer.js';
import StronaGlowna from './StronaGlowna.js';
import {BrowserRouter as Router, Link, Route } from 'react-router-dom';
import DodawanieAnkiety from './DodawanieAnkiety';

function App() {
  return (
    <div className="App">
    <Router>
      <Header />
        <main>
          <Route path="/" component={StronaGlowna} exact/>
          <Route path="/Ankiety" component={Ankiety}/>
          <Route path="/DodajAnkiete" component={DodawanieAnkiety}/>
        </main>
    </Router>
      <Footer />

    </div>
  );
}

export default App;
