import React from 'react';
import "./style/Header.css"
import "./style/StronaGlowna.css"
import flashCard from "./img/flash-card.png"
import test from"./img/test.png"
import { Link } from 'react-router-dom';

class StronaGlowna extends React.Component {
    render() {
        return (
            <div>
                <br></br><br></br>
                <h2>Witamy na naszej stronie z darmowymi ankietami</h2>
                <h4>Tutaj możesz dodawać ankiety zupełnie za darmo oraz wypełniać istniejące ankiety anonimowo.</h4>
                <br></br>

                    <img className="box" src="https://super-monitoring.com/blogpl/wp-content/uploads/2020/12/social-polls.png" height="230px" alt="Ankiety obrazek"></img>

                <br></br><br></br>
                <div>
                    <Link to="/NowaAnkieta">
                        <button type="button" className="buttonBox">
                            <img src={test} height="50px" alt="Dodaj nową ankietę"></img><br></br>
                        Dodaj nową ankietę
                    </button>
                    </Link>
                    <Link to="/Ankiety">
                        <button type="button" className="buttonBox">
                            <img src={flashCard} height="50px" alt="przeglądaj ankiety"></img><br></br>
                        przeglądaj ankiety
                    </button>
                    </Link>
                </div>
                <br></br><br></br>

            </div>
        )
    }
}

export default StronaGlowna;