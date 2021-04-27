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

                    <option selected>Wybierz ankiete</option>
                        {this.state.nazwyAnkiet.map(wybranaAnkieta =>{
                            return(<option value={wybranaAnkieta} key={wybranaAnkieta}>{wybranaAnkieta}</option>)
                        })} 

                    </select>

                </div>
                
                <Pytania pytania={this.state.ListaAnkiety} nazwaAnkiety={this.state.nazwaAnkiety} wybranaAnkieta={this.state.wybranaAnkieta} />
                
            
            </div>
        )
    }

}

export default Ankiety;