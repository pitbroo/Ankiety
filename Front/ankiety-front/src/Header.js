import React from 'react';
import "./style/Header.css";
import {Link } from 'react-router-dom';

class Header extends React.Component {
    render() {
        return (
            <div>
                <nav className="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
                    <div className="container">
                        <a className="navbar-brand" href="#">
                            <img target='_blank' src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQky9_US9i2NxXJLO6YO1WVP6W926bGQky5-Q&usqp=CAU" height="40px"
                             alt="Vistula University"></img> Vistula University</a>
                        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarResponsive">
                            <ul className="navbar-nav ml-auto">
                                <li className="nav-item active">
                                    <Link to="/">
                                    <a type="button" className="nav-link" >Strona Głowna
                                    <span className="sr-only">(current)</span>
                                    </a>
                                    </Link>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" target="blank" href="https://www.vistula.edu.pl/en">Vistula</a>
                                </li>
                                <li className="nav-item">
                                    <Link to="/Ankiety">
                                    <a className="nav-link" href="/Ankiety">Ankiety</a>
                                    </Link>
                                </li>
                                <li className="nav-item">
                                    <Link to= "/NowaAnkieta">
                                    <a className="nav-link">NowaAnkieta</a>
                                    </Link>
                                </li>
                                <li className="nav-item">
                                    <Link to="/Wyniki">
                                    <a className="nav-link">Wyniki Ankiet</a>
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