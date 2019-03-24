from pymongo import MongoClient
from pprint import pprint

client = MongoClient("mongodb://ahmadtc1:Jaboo2000@feed-me-shard-00-00-4erv9.mongodb.net:27017,feed-me-shard-00-01-4erv9.mongodb.net:27017,feed-me-shard-00-02-4erv9.mongodb.net:27017/test?ssl=true&replicaSet=feed-me-shard-0&authSource=admin&retryWrites=true")

db = client.admin

serverStatusResult = db.command("serverStatus")
print(serverStatusResult)
