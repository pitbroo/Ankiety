import React from 'react';
import Pytania from './Ankiety.Pytania.js'
import 'bootstrap/dist/css/bootstrap.min.css';
import "./style/Ankiety.css"

class Ankiety extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            ListaAnkiety: [],
            nazwaAnkiety: null
        }
    }
    czysc = () => {
        this.setState({
            ListaAnkiety: []
        }
        )
    }
    getData = () =>{

        fetch('http://localhost:8080/ankiety')
        .then(response => response.json())
        .then((dane) => this.setState({
            ListaAnkiety: dane
            
        }))
    }

    render(){
        console.log("State: "+this.state.ListaAnkiety)
        return(
            <div className="buttonContainer">
                
                <div className="buttonContainer">
                    <button onClick={this.czysc} className="btn btn-dark">Czyść</button>
               
                    <button onClick={this.getData} className="btn btn-dark" >Pobierz dane</button>
                </div>
                
                <Pytania pytania={this.state.ListaAnkiety}/>
                <div className="AnkietyWiki">
                    <h3>Czym jest ankietowanie</h3>
                    Jedna z metod badań społecznych, w której do zbierania informacji od respondentów wykorzystuje się wystandaryzowany kwestionariusz. Dla ustalenia badanej populacji konsumentów stosuje się dobór losowy, gdy niewielka jest ich liczba i nieznana ich struktura, dobór losowy systematyczny, gdy dostępna jest lista całej populacji oraz dobór losowy warstwowy dla uzyskania bardziej dokładnych wyników charakteryzujących badanych.W socjologii polega na rozdawaniu respondentom kwestionariuszy z pytaniami, z prośbą o ich wypełnienie. Wyróżnia się różne techniki ankietowe, m.in. są to ankieta pocztowa, ankieta audytoryjna. Mniej precyzyjne, często używane przez osoby nie prowadzące badań, są ankiety prasowe. Ankieta w odróżnieniu od kwestionariusza jest anonimowa i zawiera m.in. pytania otwarte.
                </div>
            
            </div>
        )
    }

}

export default Ankiety;