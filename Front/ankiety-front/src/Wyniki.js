import React, { Component } from 'react';
import "./style/Wyniki.css";

class Wyniki extends Component {
    constructor(props) {
        super(props);
        this.state = {
            wybranaAnkieta: "Brak",
            nazwyAnkiet: [],
            ListaAnkiety: []

    }

    }
    
    render() {
        
        return (
            <div>
                <h2>Ankietowani odpowiedzieli</h2>
                    <section>
                    <button onClick={this.getAnkiety} className="btn btn-dark" >Pobierz dane</button><br></br>
                    <select value={this.state.wybranaAnkieta} onChange={this.zmianaWybranejAnkiety}>

                    <option selected>Wybierz ankiete</option>
                        {this.state.nazwyAnkiet.map(wybranaAnkieta =>{
                            return(<option value={wybranaAnkieta} key={wybranaAnkieta} >{wybranaAnkieta}</option>)
                        })} 

                    </select>
                        <div >{this.state.wybranaAnkieta}</div>

                        {this.state.ListaAnkiety.map(ankiety =>{
                            return(
                                <>
                            <div>
                                <h5>{ankiety.pytanie} </h5>

                                <ul>
                                    {
                                    Object.keys(ankiety.odpowiedzIlosc).map((key, i) =>
                                    <p key={i}>
                                    <span>{key}: </span>
                                    <span>{ankiety.odpowiedzIlosc[key]}</span>
                                </p>)
                                    }
                                </ul>
                                
                    
                      
                            </div>
                            <br></br>
                            </>
                            )
                        })}
                        
                    </section>
            </div>
        );
    }
    componentDidMount() {
        fetch('http://localhost:8080/ankiety/ankietyNazwy')
        .then(response => response.json())
        .then((dane) => this.setState({
            nazwyAnkiet: dane
        }))
    }
    
    zmianaWybranejAnkiety = (event) =>{
        this.setState({
            wybranaAnkieta: event.target.value
        })        
    }
    getAnkiety = () =>{
        fetch('http://localhost:8080/odpowiedziOsob/'+this.state.wybranaAnkieta)
        .then(response => response.json())
        .then((dane) => this.setState({
            ListaAnkiety: dane
            
        }))
        console.log(this.state.ListaAnkiety)
    }
}

export default Wyniki;