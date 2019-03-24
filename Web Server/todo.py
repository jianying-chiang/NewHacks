from flask import Restful
import sqlite3

db = sqlite3.connect('data/ingredients.db')