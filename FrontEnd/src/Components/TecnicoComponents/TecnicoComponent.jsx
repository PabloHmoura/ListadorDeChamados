import React, { useState, useEffect } from 'react';
import { TableContainer, TableHead, TableRow, TableCell, Table, Paper, TableBody } from '@mui/material';
import axios from 'axios';
import '../styleDataComponent.css';
import DataComponent from '../DataComponent';
import { useNavigate } from 'react-router-dom';
import { parse, compareAsc, compareDesc } from 'date-fns';

const TecnicoComponent = () => {
  const [sortedData, setSortedData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/chamado');
        const sortedData = response.data.sort((a, b) => {
          const dateA = parse(a.dataAbertura, 'dd-MM-yyyy HH:mm', new Date()); // Converte a string de data para um objeto Date
          const dateB = parse(b.dataAbertura, 'dd-MM-yyyy HH:mm', new Date());
          return compareAsc(dateA, dateB); // Ordena os objetos Date
        });
        setSortedData(sortedData);
        console.log(sortedData);
      } catch (error) {
        console.error(error);
      }
    };

    fetchData();
  }, []);

  function handleClick () {
    window.location.href = '/main';
  };

  return (
    <>
    <button onClick={handleClick}>Listar por localidade</button>
      <h1>Chamados PMD</h1>
      
      <TableContainer id="tableContent" component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
            <TableCell>ID</TableCell>
            <TableCell>Título</TableCell>
            <TableCell>Data de abertura</TableCell>
            <TableCell>Categoria</TableCell>
            <TableCell>Localização</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {sortedData.length > 0 ? sortedData.map(item => (
              <TableRow key={item.id}>
                <TableCell className="tableCell"> {item.id}</TableCell>
                <TableCell className="tableCell">{item.titulo}</TableCell>
                <TableCell className="tableCell">{item.dataAbertura}</TableCell>
                <TableCell className="tableCell">{item.categoria}</TableCell>
                <TableCell className="tableCell">{item.localizacao}</TableCell>
              </TableRow>
            )) : null}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};

export default TecnicoComponent;