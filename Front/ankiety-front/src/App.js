
import './style/App.css';
import './Ankiety.js'
import Header from './Header.js'
import Ankiety from './Ankiety.js';
import Footer from './Footer.js';
import StronaGlowna from './StronaGlowna.js';
import {BrowserRouter as Router, Route } from 'react-router-dom';
import NowaAnkieta from './NowaAnkieta.js'

function App() {
  return (
    <div className="App">
    <Router>
      <Header />
        <main>
          <Route path="/" component={StronaGlowna} exact/>
          <Route path="/Ankiety" component={Ankiety}/>
          {/* <Route path="/DodajAnkiete" component={DodawanieAnkiety}/> */}
          <Route path="/NowaAnkieta" component={NowaAnkieta}/>
        </main>
    </Router>
      <Footer />

    </div>
  );
}

export default App;
