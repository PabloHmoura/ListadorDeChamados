import React, { useState, useEffect } from 'react';
import { TableContainer, TableHead, TableRow, TableCell, Table, Paper, TableBody } from '@mui/material';
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import "./styleDataComponent.css"
import TecnicoComponent from './TecnicoComponents/TecnicoComponent';


const DataComponent = () => {
  const [sortedData, setSortedData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:5000/dados');
        const sortedData = response.data.sort((a, b) => a.Localização.localeCompare(b.Localização));
        setSortedData(sortedData);
        console.log(sortedData);
      } catch (error) {
        console.error(error);
      }
    };

    fetchData();
  }, []);

  function handleClick () {
    window.location.href = '/tecnico';
  };

  return (
    <>
    
    <button onClick={handleClick}>Data de abertura</button>
      <h1>Chamados PMD</h1>
      <TableContainer id="tableContent" component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
            <TableCell>ID</TableCell>
            <TableCell>Título</TableCell>
            <TableCell></TableCell>
            <TableCell>Localização</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {sortedData.length > 0 ? sortedData.map(item => (
              <TableRow key={item.id}>
                <TableCell className="tableCell" component="th" scope="row">{item.ID}</TableCell>
                <TableCell className="tableCell">{item.Título}</TableCell>
                <TableCell className="tableCell"></TableCell>
                <TableCell className="tableCell">{item.Localização}</TableCell>
              </TableRow>
            )) : null}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};

export default DataComponent;