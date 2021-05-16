
import React from 'react';
import "./style/Ankiety.css"

const Pytania = ({pytania, nazwaAnkiety, wybranaAnkieta}) => {

    let i = 1;
    return(
        <div className="AnkietyKontener">
        <h1>{nazwaAnkiety}</h1>{}
        <ul>
            
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
                   <p>Komentarz(niewymagane):</p>
                    <textarea className="formKometarz"></textarea>
                </li>
                )}

                { (wybranaAnkieta === "Brak") ? null : <WyslijBtn />}
        </ul>
        </div>
    );
}
const WyslijBtn = () =>(
    <input type="submit" className="btn btn-dark btn-lg" id="WyslijAnkietyBtn" ></input>
);

export default Pytania;