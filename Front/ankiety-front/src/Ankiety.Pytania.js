import { exportDefaultDeclaration } from '@babel/types';
import React from 'react';
import "./style/Ankiety.css"
import Button from 'react-bootstrap/Button';

const Pytania = ({pytania}) => {
    return(
        <div className="AnkietyKontener">
        <ul >
            
            {pytania.map(pytanie => 
                <li key={pytanie.idPytania}>
               <h1 className="NazwaAnkiety">{pytanie.nazwaAnkiety}</h1>
                    <b className="Pytanie">{pytanie.idPytania}. {pytanie.pytanie}</b>
                    <br></br>
                   <ul>
                    {pytanie.tresciOdpowiedzi.map(odpowiedzi => 
                        
                        <li>
                            <input type="radio" value={odpowiedzi.trescOdpowiedzi} name={pytanie.pytanie}/> {odpowiedzi.trescOdpowiedzi}
                        </li>
                    )}
                   </ul>
                </li>
                )}
        </ul>
        <input type="submit" className="btn btn-dark btn-lg"></input>
        </div>
    );
}

export default Pytania;