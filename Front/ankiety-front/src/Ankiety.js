import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import "./style/Ankiety.css";
// import { BoxLoading } from 'react-loadingg';
import AnkietyPytania from './AnkietyPytania.js'
import ReactTooltip from 'react-tooltip';


class Ankiety extends React.Component{

    constructor(props){
        super(props);
        this.state = {
                ListaAnkiety: [],
                nazwyAnkiet: [],
                wybranaAnkieta: "Brak",
                ipKlienta: "",
                pytanie: null,
                odp: null,
                kometarz: null,
                odpowiedzKlienta: null,
                odpowiedziKlienta: []
            }
        this.zmianaWybranejAnkiety = this.zmianaWybranejAnkiety.bind(this);
        this.zaznaczonaAnkieta = this.zaznaczonaAnkieta.bind(this);

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
        fetch('https://api.ipify.org/?format=json')
        .then(response => response.json())
        .then((ip) => this.setState({
            ipKlienta: ip.ip
            
        }))
    }
    getAnkiety = () =>{
        fetch('http://localhost:8080/ankiety/'+this.state.wybranaAnkieta)
        .then(response => response.json())
        .then((dane) => this.setState({
            ListaAnkiety: dane
            
        }))
        
    }
    zmianaWybranejAnkiety(event) {
        
        this.setState({
            wybranaAnkieta: event.target.value
        })
        
    }
    zaznaczonaAnkieta = (e) =>{
        this.setState({
            odp: e.target.value,
            pytanie: e.target.name2,
            kometarz: e.target.id
        })
        console.log("+")
    }
    pytanieZaznaczone = (pytanie) => {
        this.setState({
            pytanie: pytanie
        })
    }
    wyslijJednaAnkiete = () =>{
        const nazwaAnkiety = this.state.wybranaAnkieta;
        const pytanie = this.state.pytanie;
        const trescOdpowiedzi = this.state.odp;
        const ipv4 = this.state.ipKlienta;
        const kometarz = this.state.kometarz;
        const odpowiedzKlienta = {
            ipv4,
            nazwaAnkiety,
            pytanie,
            trescOdpowiedzi,
            kometarz
        }

        this.setState({
            odpowiedzKlienta: this.odpowiedzKlienta
        })
       console.log(odpowiedzKlienta)

    }
      
    render(){
        return(
            <div className="buttonContainer">                
                      {this.state.odpowiedzKlienta}
                <div className="buttonContainer">
                    
                      <div data-tip="Ankieta jest w pełni anonimowa. Pobieramy IP, ponieważ tylko raz możesz wypełnić jedną ankiete." className="TwojeIp">
                        {this.state.ipKlienta==="" ? "Pobieranie adresu IP..." : "Twoje IP: "+this.state.ipKlienta}
                        <div className="OpisIP">Możesz tylko taz wypełnić<br></br> jedną ankietę   </div> 
                    </div>
                    <ReactTooltip place="top" type="dark" effect="float"/>
                    <button onClick={this.czysc} className="btn btn-dark">Czyść</button>
               
                    <button onClick={this.getAnkiety} className="btn btn-dark" >Pobierz dane</button>
                    <br></br>

                    <h3>wybrana ankieta: {this.state.wybranaAnkieta}</h3>

                    <select value={this.state.wybranaAnkieta} onChange={this.zmianaWybranejAnkiety}>

                    <option selected>Wybierz ankiete</option>
                        {this.state.nazwyAnkiet.map(wybranaAnkieta =>{
                            return(<option value={wybranaAnkieta} key={wybranaAnkieta} >{wybranaAnkieta}</option>)
                        })} 

                    </select>

                </div>
                
                <AnkietyPytania pytania={this.state.ListaAnkiety} nazwaWybranejAnkiety={this.state.wybranaAnkieta}
                wybranaAnkieta={this.state.wybranaAnkieta} wyslijJednaAnkiete={this.wyslijJednaAnkiete} ip={this.state.ipKlienta}/>
                
            
            </div>
        )
    }
    
}

export default Ankiety;