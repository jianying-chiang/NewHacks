"""This module is to configure app to connect with database."""

import os
from pymongo import MongoClient
DEBUG = False
MONGO_URL = "mongodb://admin:admin@cluster0-zus9j.mongodb.net:27017/ingredients"
client = MongoClient(MONGO_URL)
print("got client")
