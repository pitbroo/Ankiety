import React from 'react';
import "./style/Header.css";
import {useState} from 'react';
import NowePytanie from './NowePytanie.js';

class DodawanieAnkiety extends React.Component {
    
    state = {
        liczbaPytan: 0,
        listaPytan: []
    }
    
    
    render() {
   
        return (
            <>
            <form>
                <h2>Nazwa ankiety:</h2> 
                <input type="text"/>
                <br></br>
                <br></br>
                <NowePytanie />
                <div>
                    <input type="text" name="IPv4" placeholder="IPv4" id="IPv4"/>
                </div>
                <button type="submit" className="submitBtn" id="button">Wyślij Ankietę</button>
            </form> 
            </>
        )
    }
}


export default DodawanieAnkiety;