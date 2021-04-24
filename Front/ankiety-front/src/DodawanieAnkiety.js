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
                <button type="submit" className="submitBtn">Wyślij Ankietę</button>
            </form> 
            </>
        )
    }
}


export default DodawanieAnkiety;