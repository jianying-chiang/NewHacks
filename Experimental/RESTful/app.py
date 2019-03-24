from flask import Flask
from flask_restful import Api

from todo import GetIngredients
from todo import InsertIngredients

app = Flask(__name__)
api = Api(app)

api.add_resource(GetIngredients, "/get/")
api.add_resource(InsertIngredients, "/post/<ingredient>")

if __name__ == "__main__":
    app.run()
