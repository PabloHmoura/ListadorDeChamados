import React from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import DataComponent from '../Components/DataComponent';

function MainRoutes(props) {
    return (
        <BrowserRouter>
           <Route exact path="/" element={DataComponent}/>
        </BrowserRouter>
     );
}

export default MainRoutes;