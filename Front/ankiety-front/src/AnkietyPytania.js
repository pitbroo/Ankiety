
import React, { useState } from 'react';
import { CardDeck } from 'react-bootstrap';
import "./style/Ankiety.css"

const AnkietyPytania = ({pytania, nazwaAnkiety, wybranaAnkieta}) => {
   let i = 1;
   const [odp, setOdp] = useState();

   const zanzaczonaOdp = (e) =>{
       setOdp(e.target.value);
       console.log(odp)
   }
   return(
       <div >
           {/* Button tymczasowy? */}
           {/* <button onClick={wyslijJednaAnkiete}>zatwierdz</button> */}
       <h1>{nazwaAnkiety}</h1>{}
       <ul className="AnkietyKontener">
           {pytania.map(pytanie => 
               <li key={pytanie.idPytania} className="Pytanie">
                   <b className="Pytanie" >{i++}. {pytanie.pytanie}</b>
                   {pytanie.tresciOdpowiedzi.map(odpowiedzi =>
                    <Odpowiedz odpowiedz={odpowiedzi.trescOdpowiedzi} zanzaczonaOdp={zanzaczonaOdp}/>
                   )}
                    <p>Komentarz(niewymagane):</p>
                    <textarea name="kometarz" className="formKometarz"></textarea>
               </li>
               )}
               { (wybranaAnkieta === "Brak") ? null :  <input type="submit" className="btn btn-dark btn-lg" id="WyslijAnkietyBtn" ></input>}
       </ul>
       </div>
   );
}
const Odpowiedz = ({odpowiedz, zanzaczonaOdp}) =>{
    const [odp, setOdp] = useState("")
    
    return(
        <>
    <ul className="OdpowiedziKontaener">
            <li onChange={zanzaczonaOdp}>
                <input type="radio"  value={odpowiedz} defaultValue={odpowiedz} />{odpowiedz} 
            </li>
    </ul>
    </>
    )
}

export default AnkietyPytania;