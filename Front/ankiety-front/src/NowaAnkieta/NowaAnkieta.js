import React, { Component } from 'react';
import Popup from './Popup.js';
import "./Popup.css"

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
        iloscWyslanychOdp: 0,
        //style
        pytaniaVisable: "pytanieConteinerHidden",
        naglowekAnkiety: "Dodaj nową ankiete",
        zatwierdzenieAnkietyButton: "zatwierdzenieAnkietyButton",
        //popups
        popupNowaOdpowiedz: false, popupZatwierdzeniePytania: false, popupNowePytanieNiePuste: false,
        popupNazwaAnkiet: false, popupNazwaAnkietyNiePusta: false,popupCzyWyslacPytanieiOdpowiedzi: false,
        popupCzyZakonczycWysylanieAnkiet: false, popupZaMaloPytan: false,
        nastepnePytanie: "Dodaj Pytanie"
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
                this.setState({
                    popupNowaOdpowiedz: true
                })
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

    zatwierdzCalaAnkiete = () =>{
        this.props.history.push('/AnkietaWyslana');
    }
    CzyWyslacPytanieiOdpowiedzi = () =>{
        if ( this.state.pytanie == "" || this.state.tresciOdpowiedzi[1] == undefined) {
            this.setState({
                popupNowePytanieNiePuste: true
            })
        } else {
        this.setState({
            popupCzyWyslacPytanieiOdpowiedzi: true
            })
        }
    }
    wyslijAnkiete = () => {
        
            this.setState({
                nastepnePytanie: "Dodaj kolejne pytanie"
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
                popupCzyWyslacPytanieiOdpowiedzi: false
            })
            this.setState({iloscWyslanychOdp: this.iloscWyslanychOdp+1})
    }
    usunWybranaOdpowiedz = (e) =>{
        this.setState({
            trescOdpowiedzi: this.state.tresciOdpowiedzi.splice(e.target.value, 1)
        })
    }
    zatwierdzenieAnkiety = () => {
        if (this.state.nazwaAnkiety == "" || this.state.nazwaAnkiety == null ) {
            this.setState({
                popupNazwaAnkietyNiePusta: true
            })
        } else {
            this.setState({
                popupNazwaAnkiet: true
            })
        }
    }
    zatwierdzenieAnkietyTak = () =>{
        this.setState({
            nazwaAnkietyDisabled: true,
            pytaniaVisable: "pytanieConteinerVisable",
            zatwierdzenieAnkietyButton: "pytanieConteinerHidden",
            naglowekAnkiety: "Ankieta"
        })
        this.setState({popupNazwaAnkiet: false})
    }
    CzyZakonczycWysylanieAnkiet = () =>{
        if (this.state.iloscWyslanychOdp < 2) {
            this.setState({popupZaMaloPytan: true})
        } else {
            this.setState({popupCzyZakonczycWysylanieAnkiet: true})
        }
    }    
    zamknijPopup = () =>{
        this.setState({popupNowaOdpowiedz: false})
        this.setState({popupNowePytanieNiePuste: false})
        this.setState({popupNazwaAnkiet: false})
        this.setState({popupNazwaAnkietyNiePusta: false})
        this.setState({popupCzyWyslacPytanieiOdpowiedzi: false})
        this.setState({popupCzyZakonczycWysylanieAnkiet: false})
        this.setState({popupZaMaloPytan: false})
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

            <Popup trigger={this.state.popupNazwaAnkietyNiePusta} zamknijPopup={this.zamknijPopup}>
                <h3>Brak nazwy ankiety</h3>
                <p>Proszę podać nazwę ankety, ankieta nie może być pusta</p>
            </Popup>
            <Popup trigger={this.state.popupNazwaAnkiet} zamknijPopup={this.zamknijPopup}>
                <h3>Czy na pewno chcesz dodać ankiete o nazwie <b>{this.state.nazwaAnkiety}</b>?</h3>
                <p>Zmiany nie będzie można cofnąć...</p>
                <button onClick={this.zatwierdzenieAnkietyTak} className="btn btn-outline-success">TAK</button>
                <button onClick={this.zamknijPopup} class="btn btn-outline-danger">Nie</button>
            </Popup>   
                <div className={this.state.pytaniaVisable}>
                <h4>{this.state.nastepnePytanie}</h4>
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
                    
                    
                    <Popup trigger={this.state.popupNowaOdpowiedz} zamknijPopup={this.zamknijPopup}>
                        <h3>Nie można dodać pustej odpowiedzi</h3>
                        Odpowiedz do pytań może być pusta, wpisz treść pytania.
                    </Popup>
                    <Popup trigger={this.state.popupNowePytanieNiePuste} zamknijPopup={this.zamknijPopup}>
                        <h3>Błąd formularza</h3>
                        Nie możesz dodać pytanie bez nazwy lub bez odpowiedzi minimum dwóch odpowiedzi
                    </Popup>
                    <Popup trigger={this.state.popupCzyWyslacPytanieiOdpowiedzi} zamknijPopup={this.zamknijPopup}>
                        <h3>Czy na pewno chcesz dodać pytanie z takimi odpowiedziami?</h3>
                        <p>Nie będzie można tego zmienić...</p>
                        <button onClick={this.wyslijAnkiete} className="btn btn-outline-success">TAK</button>
                        <button onClick={this.zamknijPopup} class="btn btn-outline-danger">Nie</button>
                    </Popup>
                    <Popup trigger={this.state.popupCzyZakonczycWysylanieAnkiet} zamknijPopup={this.zamknijPopup}>
                        <h3>Czy na pewno chcesz dodać zakończyć?</h3>
                        <p>Nie będzie można tego zmienić, ankeita zostanie zapisana w systemie...</p>
                        <button onClick={this.zatwierdzCalaAnkiete} className="btn btn-outline-success">TAK</button>
                        <button onClick={this.zamknijPopup} class="btn btn-outline-danger">Nie</button>
                    </Popup>
                    <Popup trigger={this.state.popupZaMaloPytan} zamknijPopup={this.zamknijPopup}>
                        <h3>Niepoprawny formularz!</h3>
                        <p>Ankieta musi posiadać co najmniej dwa zatwierdzone pytania</p>
                    </Popup>
                    </div>
                </div>
                
                <button value="Dodaj" onClick={this.CzyWyslacPytanieiOdpowiedzi} className="btn btn-primary btn-xl">Zatwierdź pytanie i odpowiedzi</button>
                <br></br>
                <br></br>
                <button value="Dodaj" onClick={this.CzyZakonczycWysylanieAnkiet} className="btn btn-dark btn-sm">Zakończ i wyślij Ankiete</button>
                <br></br>
                <br></br>
                </div>
            
        </div>
        
    );
    }
}



export default NowaAnkieta;