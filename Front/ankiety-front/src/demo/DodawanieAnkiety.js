// import React from 'react';
// import "./style/Header.css";
// import NowePytanie from './NowePytanie.js';


// class DodawanieAnkiety extends React.Component{
//     state = {
//         liczbaPytan: 0,
//         listaPytan: [],
//         val: ""
//     }

//     wyslijAnkiete = () => {
//         fetch('http://localhost:8080/ankiety', {
//             method: 'POST',
//             headers : {
//                 "Content-Type": "application/json"
//             },
//             body: JSON.stringify(this.state.ankieta)
//         })
//             .then( resp =>  resp.json())
//             .then( data => console.log(data))
//     }
//     clear = () =>{
//         this.setState({
//             val: ""
//         })
//     }
//     changeValue = (e) =>{
//         this.setState({
//             val: e.target.value
//         })
//     }
//     render() {
   
//         return (
//             <>
            
//             <input type="text" onFocus={this.clear} value={this.state.val} onChange={this.changeValue} />
//                 <h2>Nazwa ankiety:</h2> 
//                 <input type="text"/>
//                 <br></br>
//                 <br></br>
//                 <NowePytanie />
//                 {/* <submit type="submit" className="submitBtn"
//                  >Wyślij Ankietę</submit> */}
            
//             </>
//         )
//     }
// }


// export default DodawanieAnkiety;