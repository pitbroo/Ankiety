import React from 'react';
import image from "./sending-surveys.png";
import { Link } from 'react-router-dom';
import "./Popup.css"


const AnkietaWyslana = props => {
    return (
        <div >
             <br></br>
            <h3>Ankieta została wysłana </h3>
            <img src={image} height="330px" alt="Ankiety obrazek" className="vibrate-1"></img><br></br><br></br>
            Dziękujemy za przesłanie ankiety. Wróć na strone główną, dodaj nową ankietę lub dodaj kolejne pytania do swojej ankiety.<br></br>
           <br></br>

            <Link to="/NowaAnkieta" >
                <button type="button" className="btn btn-outline-info">
                Dodaj nową ankietę
            </button>
            </Link>

            <Link to="/Ankiety">
                <button type="button" className="btn btn-outline-info">
                przeglądaj ankiety
            </button>
            </Link>
            <br></br><br></br>
        </div>
    );
};

export default AnkietaWyslana;