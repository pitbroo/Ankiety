import { exportDefaultDeclaration } from '@babel/types';
import React from 'react';
import "./style/Ankiety.css"
import Button from 'react-bootstrap/Button';
import Ankiety from './Ankiety';

const Pytania = ({pytania, nazwaAnkiety}) => {

    let i = 1;
    return(
        <div className="AnkietyKontener">
        <h1>{nazwaAnkiety}</h1>{}
        <ul >
            
            {pytania.map(pytanie => 
                <li key={pytanie.idPytania}>
                    <b className="Pytanie">{i++}. {pytanie.pytanie}</b>
                    
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