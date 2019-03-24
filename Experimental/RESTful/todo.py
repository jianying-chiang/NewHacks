from flask_restful import Resource
import sqlite3

#For accessing the file in a folder contained in the current folder

# Creates or opens a file called uToronto with a SQLite3 DB
db = sqlite3.connect('data/uToronto.db')
cursor = db.cursor()

class GetIngredients(Resource):
    # def get(self, id):
    #     for todo in todos:
    #         if(id == todo["id"]):
    #             return todo, 200
    #     return "Item not found for the id: {}".format(id), 404
    def get(self):
        # try:
        cursor.execute('''SELECT ingredient from fridge_items''')
        course = cursor.fetchall()
        return course, 200

        # except Exception as e:
        #     # Roll back any change if something goes wrong
        #     db.rollback()
        #     return "Item not found for the course code: {}".format(code), 404

class InsertIngredients(Resource):
    def insert_ingredient(self, ingredient):
        DATABASE = '/data/ingredients.db'
        with sqlite3.connect(DATABASE) as con:
            cur = con.cursor
            cur.execute('INSERT INTO fridge_items(ingredient) VALUES (?)', (ingredient))
            con.commit()