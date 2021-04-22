import React from 'react';
import "./style/Header.css"

class StronaGlowna extends React.Component {
    render() {
        return (
            <div>
                <h1>Witamy na naszej stronie z darmowymi ankietami</h1>
                <img src="https://super-monitoring.com/blogpl/wp-content/uploads/2020/12/social-polls.png" width="800"></img>
                <h3>Tutaj możesz dodawać ankiety zupełnie za darmo oraz wypełniać istniejące ankiety.</h3>
                <div className="AnkietyWiki">
                    <h3>Czym jest ankietowanie?</h3>
                    Jedna z metod badań społecznych, w której do zbierania informacji od respondentów wykorzystuje się wystandaryzowany kwestionariusz. Dla ustalenia badanej populacji konsumentów stosuje się dobór losowy, gdy niewielka jest ich liczba i nieznana ich struktura, dobór losowy systematyczny, gdy dostępna jest lista całej populacji oraz dobór losowy warstwowy dla uzyskania bardziej dokładnych wyników charakteryzujących badanych.W socjologii polega na rozdawaniu respondentom kwestionariuszy z pytaniami, z prośbą o ich wypełnienie. Wyróżnia się różne techniki ankietowe, m.in. są to ankieta pocztowa, ankieta audytoryjna. Mniej precyzyjne, często używane przez osoby nie prowadzące badań, są ankiety prasowe. Ankieta w odróżnieniu od kwestionariusza jest anonimowa i zawiera m.in. pytania otwarte.
                </div>
            </div>
        )
    }
}

export default StronaGlowna;