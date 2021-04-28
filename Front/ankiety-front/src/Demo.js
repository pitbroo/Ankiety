import React, { Component } from 'react';
import "./style/Ankiety.css"

 const trescOdpowiedzi = null;

class Demo extends Component {

    

    state = {
        wpisanaOdpowiedz: null,
        wpisanaNazwaPytania: null,
        nazwaAnkiety: "",
        pytanie: "",
        tresciOdpowiedzi: [{
            trescOdpowiedzi: ""
        }],
        nazwaAnkietyDisabled: false
    }
    componentDidMount = () =>{
        this.setState({
            trescOdpowiedzi: this.state.tresciOdpowiedzi.splice(0, 1)
        })
    }
   
    uchwytZmienajacyStan = e =>{
            this.setState({
                [e.target.name]: e.target.value
            })
        }
    zmianaOdpowiedzi = e =>{

        if (this.state.wpisanaOdpowiedz != null || this.state.wpisanaOdpowiedz != "") {     
            const trescOdpowiedzi = this.state.wpisanaOdpowiedz
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
            wpisanaNazwaPytania: ""
        })
    }
    czyszczenieTresciOdpowiedzi = () =>{
        this.setState({
            tresciOdpowiedzi: [{}]
        })
    }

    pokazState = () =>{
        // this.setState({
        //     trescOdpowiedzi: this.state.tresciOdpowiedzi.splice(0, 1)
        // })
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
        this.setState({
            trescOdpowiedzi: this.state.tresciOdpowiedzi.splice(0, 1)
        })
        const nazwaAnkiety = this.state.nazwaAnkiety;
        const pytanie = this.state.pytanie;
        const tresciOdpowiedzi = this.state.tresciOdpowiedzi;
        const ankieta = {
            nazwaAnkiety,
            pytanie,
            tresciOdpowiedzi
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
            this.setState({
                nazwaAnkietyDisabled: true
            })
    }

    render() {
        
        return (
        <div className="containerDodawanieAnkiet">
                <br></br>
                <h2>Dodaj nową ankiete</h2>
                <input placeholder="Ankieta" type="text" name="nazwaAnkiety" className="formPyt" className="formPyt" value={this.state.nazwaAnkiety} 
                onChange={this.uchwytZmienajacyStan} disabled={this.state.nazwaAnkietyDisabled} /><br></br>
                <div>
                <h4>Dodaj nowe Pytanie</h4>
                <input placeholder="Pytanie" type="text" name="wpisanaNazwaPytania" className="form-control" value={this.state.wpisanaNazwaPytania}
                onChange={this.uchwytZmienajacyStan} /><br></br>
                <div  className="container-s">
                    <h5>Lista odpowiedzi:</h5> 
                    <ul className="list-group">
                        {this.state.tresciOdpowiedzi.map(odpowiedz => (<li key={trescOdpowiedzi} className="list-group-item">{odpowiedz.trescOdpowiedzi}</li>))}
                    </ul>
                    <br></br>
                    <br></br>
                </div>
                
                <div className="input-group mb-3">
                    <input placeholder="Odpowiedz" type="text" name="wpisanaOdpowiedz" className="form-control"
                    value={this.state.wpisanaOdpowiedz} onChange={this.uchwytZmienajacyStan}
                    />
                    <div class="input-group-append">
                        <a type="text" onClick={this.zmianaOdpowiedzi} className="btn btn-outline-grey">Dodaj nową Odpowiedz</a>
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



export default Demo;