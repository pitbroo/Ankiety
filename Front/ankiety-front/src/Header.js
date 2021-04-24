import React from 'react';
import "./style/Header.css";
import {BrowserRouter as Router, Link } from 'react-router-dom';

class Header extends React.Component {
    render() {
        return (
            <div>
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
                    <div class="container">
                        <a class="navbar-brand" href="#">
                            <img target='_blank' src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQky9_US9i2NxXJLO6YO1WVP6W926bGQky5-Q&usqp=CAU" height="40px"
                             alt="Vistula University"></img> Vistula University</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarResponsive">
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item active">
                                    <Link to="/">
                                    <a class="nav-link" >Strona Głowna
                                    <span class="sr-only">(current)</span>
                                    </a>
                                    </Link>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" target="blank" href="https://www.vistula.edu.pl/en">Vistula</a>
                                </li>
                                <li class="nav-item">
                                    <Link to="/Ankiety">
                                    <a class="nav-link" href="/Ankiety">Ankiety</a>
                                    </Link>
                                </li>
                                <li class="nav-item">
                                    <Link to="/DodajAnkiete">
                                    <a class="nav-link">Dodaj Ankietę</a>
                                    </Link>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                
                <header>
                    <div id="carouselExampleIndicators" className="carousel slide" data-ride="carousel">
                 
                        <div className="carousel-inner" role="listbox">

                            <div className="carousel-item active" >
                                <div className="carousel-caption d-none d-md-block">
                                    <h3 className="display-4">Wolne Ankiety</h3>
                                    <p className="lead">Ta strona pozwala tworzyć i wypełniać darmowe ankiety</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </header>
            </div>
        )
    }
}

export default Header;