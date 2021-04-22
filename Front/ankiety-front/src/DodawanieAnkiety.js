import React from 'react';
import "./style/Header.css"

class DodawanieAnkiety extends React.Component {
    constructor(props) {
        super(props);
        this.state = { 
            name: '' 
        };
      }
    
      handleChange = (event) => {
        this.setState({[event.target.name]: event.target.value});
      }
    
      handleSubmit = (event) => {
        alert('A form was submitted: ' + this.state);
    
        fetch('http://localhost:8080/ankiety/', {
            method: 'POST',
            // We convert the React state to JSON and send it as the POST body
            body: JSON.stringify(this.state)
          }).then(function(response) {
            console.log(response)
            return response.json();
          });
    
        event.preventDefault();
    }
    
      render() {
        return (
          <form onSubmit={this.handleSubmit}>
            <label>
              Ankieta:
              <input type="text" value={this.state.value} name="nazwaAnkiety" onChange={this.handleChange} />
            </label>
            <input type="submit" value="Submit" />
          </form>
        );
      }
}

export default DodawanieAnkiety;