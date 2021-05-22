import React from "react";
import NoweOdpowiedzi from './NoweOdpowiedzi.js'



class NowePytanie extends React.Component {
  constructor(props){
    super(props);

    this.state = {
      liczbaPytan: 0,
      NowePytanie: null,
      listaPytan: []
    }
  }
 
      render() {
        const pytania = [];

        for (var i = 0; i < this.state.liczbaPytan; i += 1) {
          pytania.push(<Pytanie key={i+1} number={i} handleChange={this.onhandleChange} listaPytan={this.state.listaPytan}
          thisNowepytanie={this.state.NowePytanie} nowypytanie={this.state.NowePytanie}/>);
        };

        return (
          <Pytania dodaniePytania={this.onDodaniePytania} usuwaniePytania={this.onUsunPytania}
           onChange={this.handleChange} pytania={pytania} handleChange={this.handleChange}>
            {pytania}

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
      onhandleChange = (e) => {
        if (e.target.value == null) {
            console.log("state is null!")
        } else {
          this.setState({listaPytan: this.state.listaPytan.concat(e.target.value)});
        console.log("Lista pytan"+this.state.listaPytan+", ")
        console.log("Nowe pytanie"+this.state.NowePytanie)
        
       
        }
        
      }
      
}

const Pytania = props =>(
  <div>
    
    <div>
    {props.pytania}
    </div>
    <a type="button" className="btn btn-primary btn-sm"  onClick={props.dodaniePytania}>Dodaj pytanie</a>
    <a type="button" className="btn btn-primary btn-sm" onClick={props.usuwaniePytania}>Usuń pytanie</a>
    <br></br>
    <button type="submit" className="submitBtn" 
    onClick={props.handleChange}
                 >Wyślij Ankietę</button>
  </div>
);
const Pytanie = props => 
  <div>
      <h3>{props.number+1}. Pytanie:</h3> 
      <input  type="text"  className="formPyt" name="trescPytania"
      value={props.NowePytanie}
      
     />
    <br></br>
    <NoweOdpowiedzi pytanieNumer={props.number+1}/>
    <br></br>
    {props.listaPytan}

  </div>

export default NowePytanie;