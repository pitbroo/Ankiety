import React from "react";
import "./style/Ankiety.css"



class NoweOdpowiedzi extends React.Component {
    state = {
      liczbaOdpowiedzi: 0,
      trescOdpowiedzi: null
      
    }
      render() {
        const odpowiedzi = [];

        for (var i = 0; i < this.state.liczbaOdpowiedzi; i += 1) {
          odpowiedzi.push(<Odpowiedz key={i+1} number={i} />);
        };

        return (
          <Odpowiedzi dodanieodpowiedzi={this.onDodanieodpowiedzi} usunOdpowiedzi={this.onUsunOdpowiedzi} odpowiedzi={odpowiedzi}>
            {odpowiedzi}
          </Odpowiedzi>
        );

        
      }
      onDodanieodpowiedzi = () =>{
        this.setState({
          liczbaOdpowiedzi: this.state.liczbaOdpowiedzi + 1
        });
      }
      onUsunOdpowiedzi = () =>{
        this.setState({
          liczbaOdpowiedzi: this.state.liczbaOdpowiedzi - 1 
        });
      }

}
const Odpowiedzi = props =>(
  <div>
    <div>
    {props.odpowiedzi}
    </div>
    <a type="button" className="btn btn-light" onClick={props.dodanieodpowiedzi}>Dodaj Odpowiedź</a>
    <a type="button" className="btn btn-light" onClick={props.usunOdpowiedzi}>Usuń odpowiedź</a> 
  </div>
);
const Odpowiedz = props => 
  <div>
    <label placeholder={props.number+1+". Możliwa odpowiedź"}></label> 
    <input  className="formOdp" placeholder={props.number+1+". Możliwa odpowiedź"}  type="text"   />
    <br></br>
  </div>

export default NoweOdpowiedzi;