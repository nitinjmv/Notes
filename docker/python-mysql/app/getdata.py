from typing import List, Dict 
from flask import Flask 
import mysql.connector 
import json 

app = Flask(__name__) 

def getData() -> List[Dict]: 
  config = { 
      'user': 'root', 
      'password':'root', 
      'host': 'db', 
      'port': '3306', 
      'database' : 'Stock' 
  } 
  connection = mysql.connector.connect(**config) 
  cursor = connection.cursor() 
  cursor.execute('Select * from Categories') 
  results = [{name:displayorder} for (name, displayorder) in cursor] 
  cursor.close() 
  connection.close() 

  return results 


@app.route('/') 

def index() -> str: 
    return json.dumps({'Categories':getData()}) 


if __name__ == '__main__': 
  app.run(host='0.0.0.0') 