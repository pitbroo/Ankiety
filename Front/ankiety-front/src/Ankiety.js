import React from 'react';

const statycznaLista = [
    {
    "idPytania": 1,
    "nazwaAnkiety": "Szkola",
    "pytanie": "Czy lubisz chodzic do szkoly?",
    "tresciOdpowiedzi": [
    {
    "idTresciOdpowiedzi": 1,
    "trescOdpowiedzi": "Tak"
    },
    {
    "idTresciOdpowiedzi": 2,
    "trescOdpowiedzi": "Nie"
    }
    ]
    },
    {
    "idPytania": 2,
    "nazwaAnkiety": "Szkola",
    "pytanie": "Czy Tomek zda egzamin?",
    "tresciOdpowiedzi": [
    {
    "idTresciOdpowiedzi": 1,
    "trescOdpowiedzi": "Tak"
    },
    {
    "idTresciOdpowiedzi": 2,
    "trescOdpowiedzi": "Nie"
    }
    ]
    },
    {
    "idPytania": 3,
    "nazwaAnkiety": "Szkola",
    "pytanie": "Jaki przedmiot lubisz najbardziej?",
    "tresciOdpowiedzi": [
    {
    "idTresciOdpowiedzi": 3,
    "trescOdpowiedzi": "Matematyka"
    },
    {
    "idTresciOdpowiedzi": 4,
    "trescOdpowiedzi": "Polski"
    },
    {
    "idTresciOdpowiedzi": 5,
    "trescOdpowiedzi": "Informatyka"
    }
    ]
    },
    {
    "idPytania": 4,
    "nazwaAnkiety": "Praca",
    "pytanie": "Ile godzin dziennie pracujesz?",
    "tresciOdpowiedzi": [
    {
    "idTresciOdpowiedzi": 6,
    "trescOdpowiedzi": "od 2 do 4 godziny"
    },
    {
    "idTresciOdpowiedzi": 11,
    "trescOdpowiedzi": "od 4 do 6 godzin"
    },
    {
    "idTresciOdpowiedzi": 12,
    "trescOdpowiedzi": "od 6 do 8 godzin"
    },
    {
    "idTresciOdpowiedzi": 13,
    "trescOdpowiedzi": "wiecej niz 8 godzi"
    }
    ]
    },
    {
    "idPytania": 5,
    "nazwaAnkiety": "Praca",
    "pytanie": "Ile zarabiasz?",
    "tresciOdpowiedzi": [
    {
    "idTresciOdpowiedzi": 14,
    "trescOdpowiedzi": "nie pracuje"
    },
    {
    "idTresciOdpowiedzi": 15,
    "trescOdpowiedzi": "od 3 do 6k"
    },
    {
    "idTresciOdpowiedzi": 16,
    "trescOdpowiedzi": "od 6 do 8k"
    },
    {
    "idTresciOdpowiedzi": 17,
    "trescOdpowiedzi": "od 8 do 16k"
    }
    ]
    },
    {
    "idPytania": 6,
    "nazwaAnkiety": "Praca",
    "pytanie": "Czy chcesz zmienic swoja prace?",
    "tresciOdpowiedzi": [
    {
    "idTresciOdpowiedzi": 1,
    "trescOdpowiedzi": "Tak"
    },
    {
    "idTresciOdpowiedzi": 2,
    "trescOdpowiedzi": "Nie"
    }
    ]
    },
    {
    "idPytania": 7,
    "nazwaAnkiety": "Praca",
    "pytanie": "Jaki zawod wykonujesz?",
    "tresciOdpowiedzi": [
    {
    "idTresciOdpowiedzi": 18,
    "trescOdpowiedzi": "Ksiegowy"
    },
    {
    "idTresciOdpowiedzi": 19,
    "trescOdpowiedzi": "Informatyk"
    },
    {
    "idTresciOdpowiedzi": 20,
    "trescOdpowiedzi": "Lekarz"
    },
    {
    "idTresciOdpowiedzi": 21,
    "trescOdpowiedzi": "Nauczyciel"
    }
    ]
    },
    {
    "idPytania": 8,
    "nazwaAnkiety": "Szkola",
    "pytanie": "Chodzisz na korepetycje?",
    "tresciOdpowiedzi": [
    {
    "idTresciOdpowiedzi": 1,
    "trescOdpowiedzi": "Tak"
    },
    {
    "idTresciOdpowiedzi": 2,
    "trescOdpowiedzi": "Nie"
    }
    ]
    }
    ]

class Ankiety extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            ListaAnkiety: []
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
            <div>
                <br></br>
                <button onClick={this.czysc} >Czyść</button>
                <br></br>
                <button onClick={this.getData} >Pobierz dane</button>
                <br></br>
                <Pytanie pytania={this.state.ListaAnkiety}/>
            
            </div>
        )
    }

}

const Pytanie = ({pytania}) => {
    return(
        <ul>
            {pytania.map(pytanie => 
                <li key={pytanie.idPytania}>
                    <b>{pytanie.idPytania}. {pytanie.pytanie}</b>
                    <br></br>
                    
                    {pytanie.tresciOdpowiedzi.map(odpowiedzi => 
                        <li>- {odpowiedzi.trescOdpowiedzi}</li>)}
                </li>

                )}
        </ul>
    );
}



export default Ankiety;