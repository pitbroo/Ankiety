import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import "./style/Ankiety.css";
// import { BoxLoading } from 'react-loadingg';


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


        //wysyłamnie
        // fetch('http://localhost:8080/odpowiedziOsob/test', {
        //     method: 'POST',
        //     headers : {
        //         "Content-Type": "application/json"
        //     },
        //     body: JSON.stringify(odpowiedzKlienta)
        // })  
        //     .then( resp =>  resp.json())
        //     .then( data => console.log(data))
    }
      
    render(){
        return(
            <div className="buttonContainer">                
                      {/* { this.state.ipKlienta.map((ipv4, index)=>{
                          return(<div>{ipv4.ip}</div>)
                      })}  */}
                      {this.state.odpowiedzKlienta}
                <div className="buttonContainer">
                    <p>{this.state.ipKlienta==="" ? "Pobieranie adresu IP..." : "Twoje IP: "+this.state.ipKlienta}</p>
                    <button onClick={this.czysc} className="btn btn-dark">Czyść</button>
               
                    <button onClick={this.getAnkiety} className="btn btn-dark" >Pobierz dane</button>
                    <br></br>

                    <h3>wybrana ankieta: {this.state.wybranaAnkieta}</h3>

                    <select value={this.state.wybranaAnkieta}  onChange={this.zmianaWybranejAnkiety}>

                    <option selected>Wybierz ankiete</option>
                        {this.state.nazwyAnkiet.map(wybranaAnkieta =>{
                            return(<option value={wybranaAnkieta} key={wybranaAnkieta} >{wybranaAnkieta}</option>)
                        })} 

                    </select>

                </div>
                
                <Pytania pytania={this.state.ListaAnkiety} nazwaAnkiety={this.state.nazwaAnkiety}
                wybranaAnkieta={this.state.wybranaAnkieta} zaznaczonaAnkieta={this.zaznaczonaAnkieta}
                wyslijJednaAnkiete={this.wyslijJednaAnkiete} pytanieZaznaczone={this.pytanieZaznaczone}/>
                
            
            </div>
        )
    }
    
}
const Pytania = ({pytania, nazwaAnkiety, wybranaAnkieta, zaznaczonaAnkieta, wyslijJednaAnkiete, }) => {

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



export default Ankiety;