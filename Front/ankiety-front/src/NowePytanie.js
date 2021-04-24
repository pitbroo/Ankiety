import React from "react";
import NoweOdpowiedzi from './NoweOdpowiedzi.js'

// {
//   "nazwaAnkiety": "Sport2",
//   "pytanie": "Jaka jest Twoja ulubiona dyscyplina2?",
//   "tresciOdpowiedzi": [
//       {
//           "idTresciOdpowiedzi": 1212,
//           "trescOdpowiedzi": "Szachy"
//       },
//       {
//           "idTresciOdpowiedzi": 1213,
//           "trescOdpowiedzi": "Nie"
//       }
//   ]
// }

class NowePytanie extends React.Component {
  constructor(props){
    super(props);
    // this.handleChange = this.handleChange.bind(this);
    this.state = {
      liczbaPytan: 0,
      listaPytan: [],
      ankieta: {
        nazwaAnkiety: null,
        pytanie: null,
        tresciOdpowiedzi: []
      }
      // pytanie: null

    }
  }
 
      render() {
        const pytania = [];

        for (var i = 0; i < this.state.liczbaPytan; i += 1) {
          pytania.push(<Pytanie key={i+1} number={i} />);
        };

        return (
          <Pytania dodaniePytania={this.onDodaniePytania} usuwaniePytania={this.onUsunPytania} onChange={this.handleChange} pytania={pytania}>
            {pytania}
            {console.log(this.state.ankieta)}
          </Pytania>
        );

        
      }
      onDodaniePytania = () =>{
        this.setState({
          liczbaPytan: this.state.liczbaPytan + 1
        });
      }
      onUsunPytania = () =>{
        this.setState({
          liczbaPytan: this.state.liczbaPytan - 1 
        });
      }
      // handleChange = (e) =>{
      //   this.setState(this.ankieta.pytanie: e.target.value)
      // }
      
}
const Pytania = props =>(
  <div>
    <div>
    {props.pytania}
    </div>
    <a type="button" class="btn btn-primary btn-sm" onClick={props.dodaniePytania}>Dodaj pytanie</a>
    <a type="button" class="btn btn-primary btn-sm" onClick={props.usuwaniePytania}>Usuń pytanie</a>
  </div>
);
const Pytanie = props => 
  <div>
    <h3>{props.number+1}. Pytanie:</h3> 
    <input  type="text"  className="formPyt" name="trescPytania"
    value="pytanie" onChange="{this.handleChange}"/>
    <br></br>
    <NoweOdpowiedzi pytanieNumer={props.number+1}/>
    <br></br>
  </div>

export default NowePytanie;