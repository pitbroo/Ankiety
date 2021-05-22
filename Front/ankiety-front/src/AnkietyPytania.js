
import React, { useState } from 'react';
import { CardDeck } from 'react-bootstrap';
import "./style/Ankiety.css"

const AnkietyPytania = ({pytania, nazwaWybranejAnkiety, wybranaAnkieta, ip}) => {
   let i = 1;
   const [listaOdpowiedzi, setListaOdpowiedzi] = useState([]);
   const nazwaAnkiety = nazwaWybranejAnkiety;
   const zanzaczonaOdp = (e) =>{
       const ipv4 = ip;
       const pytanie = e.target.name;
       const trescOdpowiedzi = e.target.value;
       const kometarz = null;
       const newObject = {
        ipv4,
        nazwaAnkiety,
        pytanie,
        trescOdpowiedzi,
        kometarz
       }
    //    if (Array.isArray(listaOdpowiedzi)) {
                if(listaOdpowiedzi.find(element => element.pytanie == newObject.pytanie) == -1 ) {
                
                console.log(-1);
            }else{
                const index = listaOdpowiedzi.findIndex(element => element.pytanie == newObject.pytanie);
                
                listaOdpowiedzi.splice(index, index + 1);
                console.log(index)
            }
                setListaOdpowiedzi(listaOdpowiedzi.concat(newObject));
//    }
        }
    //    else {
    //        console.log("Błąd! nie jest tablicą!")
    //    }
       
      
    //    setListaOdpowiedzi(listaOdpowiedzi.concat(newObject));
    
    // console.log("Ilość itemów: "+listaOdpowiedzi.length);
    // console.log(listaOdpowiedzi);
    const wyslijAnkiete = () =>{
        console.log(listaOdpowiedzi); 
        fetch('http://localhost:8080/odpowiedziOsob/listaOdpowiedzi', {
            method: 'POST',
            headers : {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(listaOdpowiedzi)
        })
            .then( resp =>  resp.json())
            .then( data => console.log(data))
    }
   return(
       <div >
           {/* Button tymczasowy? */}
           {/* <button onClick={wyslijJednaAnkiete}>zatwierdz</button> */}
       <h1>!!!!!{nazwaWybranejAnkiety}</h1>{}
       <ul className="AnkietyKontener">
           {pytania.map(pytanie => 
               <li key={pytanie.idPytania} className="Pytanie">
                   <b className="Pytanie" >{i++}. {pytanie.pytanie}</b>
                   {pytanie.tresciOdpowiedzi.map(odpowiedzi =>
                    <Odpowiedz odpowiedz={odpowiedzi.trescOdpowiedzi} pytanie={pytanie.pytanie} zanzaczonaOdp={zanzaczonaOdp}/>
                   )}
                    <p>Komentarz(niewymagane):</p>
                    <textarea name="kometarz" className="formKometarz"></textarea>
               </li>
               )}
               { (wybranaAnkieta === "Brak") ? null :  <button type="submit" onClick={wyslijAnkiete} className="btn btn-dark btn-lg" id="WyslijAnkietyBtn" >WYSLIJ</button>}
       </ul>
       </div>
   );
}
const Odpowiedz = ({odpowiedz, zanzaczonaOdp, pytanie}) =>{

    
    return(
        <>
    <ul className="OdpowiedziKontaener">
            <li onChange={zanzaczonaOdp}>
                <input type="radio"  value={odpowiedz} defaultValue={odpowiedz} name={pytanie}/>{odpowiedz} 
            </li>
    </ul>
    </>
    )
}

export default AnkietyPytania;