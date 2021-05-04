import React, { Component } from 'react';
import "./style/Ankiety.css"

 const trescOdpowiedzi = []; 

class NowaAnkieta extends Component {

    state = {
        wpisanaOdpowiedz: "",
        
        nazwaAnkiety: "",
        pytanie: "",
        tresciOdpowiedzi: [{
            trescOdpowiedzi
        }],
        nazwaAnkietyDisabled: false,
        odpowiedzSerwera: "",
        //style
        pytaniaVisable: "pytanieConteinerHidden",
        naglowekAnkiety: "Dodaj nową ankiete",
        zatwierdzenieAnkietyButton: "zatwierdzenieAnkietyButton"
    }
    componentDidMount = () =>{
        this.czyszczenieTresciOdpowiedzi();
    }
   
    uchwytZmienajacyStan = e =>{
            this.setState({
                [e.target.name]: e.target.value
            })
        }
    zmianaOdpowiedzi = e =>{
            const trescOdpowiedzi = this.state.wpisanaOdpowiedz
            if (trescOdpowiedzi === "" || trescOdpowiedzi===null || this.state.wpisanaOdpowiedz === " " || this.state.wpisanaOdpowiedz === "  ") {
                alert("Nie można dodać pustej odpowiedzi!")
            } else {
                this.setState({
                tresciOdpowiedzi: this.state.tresciOdpowiedzi.concat([{
                    trescOdpowiedzi
                }])
            });
            }
        this.czyscOdpowiedz();
    }
    czyscOdpowiedz= () =>{
        this.setState({
            wpisanaOdpowiedz: ""
        })
    }
    czyscPytanie = () =>{
        this.setState({
            pytanie: ""
        })
    }
    czyszczenieTresciOdpowiedzi = () =>{
    
        this.setState({
            trescOdpowiedzi: this.state.tresciOdpowiedzi.splice(0, this.state.tresciOdpowiedzi.length)
        })
    }

    pokazState = () =>{
        const nazwaAnkiety = this.state.nazwaAnkiety;
        const pytanie = this.state.pytanie;
        const tresciOdpowiedzi = this.state.tresciOdpowiedzi;
        const ankieta = {
            nazwaAnkiety,
            pytanie,
            tresciOdpowiedzi,
        }
        console.log(ankieta)
    }

    wyslijAnkiete = () => {

        const nazwaAnkiety = this.state.nazwaAnkiety;
        const pytanie = this.state.pytanie;
        const tresciOdpowiedzi = this.state.tresciOdpowiedzi;
        const ankieta = {
            nazwaAnkiety,
            pytanie,
            tresciOdpowiedzi,
        }
        
        fetch('http://localhost:8080/ankiety', {
            method: 'POST',
            headers : {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(ankieta)
        })  
            .then( resp =>  resp.json())
            .then( data => console.log(data))
            this.czyscPytanie();
            this.czyscOdpowiedz();
            this.czyszczenieTresciOdpowiedzi();

    }
    usunWybranaOdpowiedz = (e) =>{
        this.setState({
            trescOdpowiedzi: this.state.tresciOdpowiedzi.splice(e.target.value, 1)
        })
    }
    zatwierdzenieAnkiety = () => {
        if (this.state.nazwaAnkiety === "") {
            alert("Nazwa ankiety nie może być pusta!");
        } else {
            
            this.setState({
                    nazwaAnkietyDisabled: true,
                    pytaniaVisable: "pytanieConteinerVisable",
                    zatwierdzenieAnkietyButton: "pytanieConteinerHidden",
                    naglowekAnkiety: "Ankieta"
            })
        }
    }
    
    render() {
        
        return (
            
        <div className="containerDodawanieAnkiet">
                <br></br>
                <h2>{this.state.naglowekAnkiety}</h2>
                
                <input placeholder="Wprowadz nazwę ankiety" type="text" name="nazwaAnkiety" className="formPyt"  value={this.state.nazwaAnkiety} 
                onChange={this.uchwytZmienajacyStan} disabled={this.state.nazwaAnkietyDisabled} /><br></br>
                <br></br>
                <button onClick={this.zatwierdzenieAnkiety} className={this.state.zatwierdzenieAnkietyButton}>Dodaj ankiete</button>

                <div className={this.state.pytaniaVisable}>
                <h4>Dodaj nowe Pytanie</h4>
                <input placeholder="Pytanie" type="text" name="pytanie" className="form-control" value={this.state.pytanie}
                onChange={this.uchwytZmienajacyStan} /><br></br>
                <div  className="container-s" name="odpowiedzi">
                    <h5>Lista odpowiedzi:</h5> 
                    <ul className="list-group">
                        {this.state.tresciOdpowiedzi.map(odpowiedz => (<li key={odpowiedz} className="list-group-item">{odpowiedz.trescOdpowiedzi}
                        <button className="przyciskUsun" value={this.state.tresciOdpowiedzi.indexOf(odpowiedz)} onClick={this.usunWybranaOdpowiedz}>X</button>
                        </li>))}
                    </ul>
                    <br></br>
                    <br></br>
                </div>
                
                <div className="input-group mb-3">
                    <input placeholder="Odpowiedz" type="text" name="wpisanaOdpowiedz" className="form-control"
                    value={this.state.wpisanaOdpowiedz} onChange={this.uchwytZmienajacyStan}
                    />
                    <div className="input-group-append">
                        <a type="text" onClick={this.zmianaOdpowiedzi} href="#odpowiedzi" className="btn btn-outline-grey">Dodaj nową Odpowiedz</a>
                    </div>
                </div>
                
                <button value="Dodaj" onClick={this.wyslijAnkiete} className="btn btn-primary btn-xl">Wyślij</button>
                <br></br>
                <br></br>
                <button value="Dodaj" onClick={this.pokazState} className="btn btn-dark btn-sm"> Pokaż w konsoli</button>
                <br></br>
                <br></br>
                </div>
            
        </div>
        
    );
    }
}



export default NowaAnkieta;