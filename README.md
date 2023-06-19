﻿# ListadorDeChamados


<h3>Esse projeto conta com duas APIs, uma em Python e outra com SpringBoot.</h1>

Os seguintes comandos foram usados para lidar com as dependências do front end
      
      npm install
      npm install axios @mui/material react-router-dom date-fns
      
Os seguintes comandos foram usados para lidar com as dependências do código em python

      pip install pandas flask flask_cors chardet
  
 Para fazer o projeto funcionar, é necessário que você crie um projeto no excel com os dados desejados e substitua os atribútos da Classe Chamado com os nomes de cada coluna presente em sua planilha (Você pode criar uma planílha com os mesmos atributos da classe Chamado para testar).
 Exemplo de JSON
      
      {
		"Atribuído - Grupo técnico": "2 NIVEL",
		"Atribuído - Técnico": "Willian ",
		"Categoria": "Impressora com problema",
		"Data da solução": "",
		"Data de abertura": "19-05-2023 15:50",
		"Descrição": "Boa tarde",
		"ID": "80 061",
		"Impacto": "Médio",
		"Localização": "LESTE",
		"Prioridade": "Média",
		"Requerente - Requerente": "algum lugar",
		"Solução - Solução": "",
		"Status": "Em atendimento (atribuído)",
		"Tempo para atendimento + Progresso": "19-05-2023 16:50",
		"Tempo para solução + Progresso": "19-05-2023 17:50\n\n100%",
		"Título": "impressora",
		"Unnamed: 18": "",
		"Urgência": "Média",
		"Última atualização": "29-05-2023 08:24"
	}
  
O código Python irá ler a planilha e trafegar os dados em formato JSON através da URL http://localhost:5000/dados, use o Postman/Insomnia para fazer o teste de requisição GET e identificar o retorno.
Digite o comando abaixo no terminal dentro da pasta do projeto para iniciar a API  

       python main.py

O front end foi desenvolvido usando REACT e possui 2 components, um componente lista os meus objetos por localização e o outro por data de abertura (Altere a regra para os campos que deseja ordenar).
Digite o comando abaixo no terminal dentro da pasta do projeto front end para iniciar o serviço.

       npm run dev
  
O end-point em Java captura o mesmo JSON enviado pela API em Python e foi criado pois tenho mais familiaridade com a linguagem.

Execute a aplicação SpringBoot para que possa ser feito a segunda listagem ou apenas altere a URL para o endereço da API em Python
