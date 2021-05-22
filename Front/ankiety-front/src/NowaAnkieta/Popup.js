import React, { useState } from 'react';

const Popup = (props) => {

    return (props.trigger) ? (
        <div className="popup">
            <div className="popup-inner">
                <div className="close-button"><button className="btn btn-dark" onClick={props.zamknijPopup}>Zamknij</button></div>

                {props.children}
            </div>
        </div>
    ) : "";
}

export default Popup;