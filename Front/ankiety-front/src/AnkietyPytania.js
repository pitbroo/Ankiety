
import React from 'react';
import { CardDeck } from 'react-bootstrap';
import "./style/Ankiety.css"

const AnkietyPytania = ({pytania, nazwaAnkiety, wybranaAnkieta, zaznaczonaAnkieta, wyslijJednaAnkiete }) => {
   let i = 1;
   return(
       <div >
           <button onClick={wyslijJednaAnkiete}>zatwierdz</button>
       <h1>{nazwaAnkiety}</h1>{}
       <ul className="AnkietyKontener">
           {pytania.map(pytanie => 
               <li key={pytanie.idPytania} className="Pytanie">
                   <b className="Pytanie" >{i++}. {pytanie.pytanie}</b>
                   
                   <br></br>
                  <ul className="OdpowiedziKontaener">
                   {pytanie.tresciOdpowiedzi.map(odpowiedzi =>
                       <li>
                           <input type="radio" onChange={zaznaczonaAnkieta}  value={odpowiedzi.trescOdpowiedzi} name={pytanie.pytanie}  id={document.getElementsByName("kometarz")}/> {odpowiedzi.trescOdpowiedzi}
                       </li>
                   )}
                  </ul>
                  <p>Komentarz(niewymagane):</p>
                   <textarea name="kometarz" className="formKometarz"></textarea>
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

export default AnkietyPytania;