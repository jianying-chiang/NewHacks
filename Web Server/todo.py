from flask_restful import Resource
import sqlite3

db = sqlite3.connect('data/ingredients.db')

class Todo(Resource):

    def get(self):
        cursor.execute('''SELECT ingredients from fridge_items''')
        ingredients = course.fetchAll()
        return ingredients, 200


    #def insert_ingredient(self, ingredient):
        DATABASE = '/data/ingredients.db'
        with sql.connect(DATABASE) as con:
            cur = con.cursor
            cur.execute('INSERT INTO fridge_items(ingredient) VALUES (?)', (ingredient))
            con.commit()