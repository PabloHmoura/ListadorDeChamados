import pandas as pd
import json
from flask import Flask, jsonify
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

import chardet

# Detectar a codificação do arquivo CSV
with open(r'C:\glpi.csv', 'rb') as f:
    result = chardet.detect(f.read())


@app.route('/dados', methods=['GET'])
def obter_dados():
    # Ler o arquivo CSV
    dados_csv = pd.read_csv(r'C:\glpi.csv', sep=';', encoding='utf-8', quotechar='"')

    # Remover valores NaN
    dados_csv = dados_csv.fillna('')  # Substituir valores NaN por uma string vazia

    # Converter para lista de dicionários
    lista_objetos = dados_csv.to_dict(orient='records')

    # Retornar os dados como JSON
    return jsonify(lista_objetos)


if __name__ == '__main__':
    app.run()
