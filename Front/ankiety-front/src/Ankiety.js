import React from 'react';
import Pytania from './Ankiety.Pytania.js'
import 'bootstrap/dist/css/bootstrap.min.css';
import "./style/Ankiety.css"

class Ankiety extends React.Component{

    constructor(props){
        super(props);
        this.state = {
                ListaAnkiety: [],
                nazwyAnkiet: [],
                wybranaAnkieta: "Brak"
            }
        this.zmianaWybranejAnkiety = this.zmianaWybranejAnkiety.bind(this);
        this.PotwierdzenieWybranejAnkiety = this.PotwierdzenieWybranejAnkiety.bind(this);
    }
    czysc = () => {
        this.setState({
            ListaAnkiety: []
        }
        )
    }
    componentDidMount = () =>{

        fetch('http://localhost:8080/ankiety/ankietyNazwy')
        .then(response => response.json())
        .then((dane) => this.setState({
            nazwyAnkiet: dane
            
        }))
    }
    getAnkiety = () =>{
        fetch('http://localhost:8080/ankiety/odpowiedzi/'+this.state.wybranaAnkieta)
        .then(response => response.json())
        .then((dane) => this.setState({
            ListaAnkiety: dane
            
        }))
    }
    zmianaWybranejAnkiety(event) {
        this.setState({wybranaAnkieta: event.target.value});
    }
    
    PotwierdzenieWybranejAnkiety(event) {
        fetch('http://localhost:8080/ankiety/odpowiedzi/'+this.state.wybranaAnkieta)
        .then(response => response.json())
        .then((dane) => this.setState({
            ListaAnkiety: dane
            
        }))
      }

    render(){
        return(
            <div className="buttonContainer">
                <div className="buttonContainer">
                
                    <button onClick={this.czysc} className="btn btn-dark">Czyść</button>
               
                    <button onClick={this.getAnkiety} className="btn btn-dark" >Pobierz dane</button>
                    <br></br>

                    <h3>wybrana ankieta: {this.state.wybranaAnkieta}</h3>

                    <select value={this.state.wybranaAnkieta} onChange={this.zmianaWybranejAnkiety}>

                    <option value="Brak wybranej ankiety" selected>Wybierz ankiete</option>
                        {this.state.nazwyAnkiet.map(wybranaAnkieta =>{
                            return(<option value={wybranaAnkieta} key={wybranaAnkieta}>{wybranaAnkieta}</option>)
                        })} 

                    </select>

                </div>
                
                <Pytania pytania={this.state.ListaAnkiety} nazwaAnkiety={this.state.nazwaAnkiety} />
                <div className="AnkietyWiki">
                    <h3>Czym jest ankietowanie</h3>
                    Jedna z metod badań społecznych, w której do zbierania informacji od respondentów wykorzystuje się wystandaryzowany kwestionariusz. Dla ustalenia badanej populacji konsumentów stosuje się dobór losowy, gdy niewielka jest ich liczba i nieznana ich struktura, dobór losowy systematyczny, gdy dostępna jest lista całej populacji oraz dobór losowy warstwowy dla uzyskania bardziej dokładnych wyników charakteryzujących badanych.W socjologii polega na rozdawaniu respondentom kwestionariuszy z pytaniami, z prośbą o ich wypełnienie. Wyróżnia się różne techniki ankietowe, m.in. są to ankieta pocztowa, ankieta audytoryjna. Mniej precyzyjne, często używane przez osoby nie prowadzące badań, są ankiety prasowe. Ankieta w odróżnieniu od kwestionariusza jest anonimowa i zawiera m.in. pytania otwarte.
                </div>
            
            </div>
        )
    }

}

export default Ankiety;