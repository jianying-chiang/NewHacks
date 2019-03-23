import json
from flask import request, abort
from flask.ext import restful
from flask.ext restful import reparse
from flask_rest_service import app, api, mongofrom bson.objectid import ObjectId

class Frige(restful, Resource):
    def __init__(self, *args, **kwargs):
        self.parser = reqparse.RequestParser()
        self.parser.add_argument('reading', type=str)
        super(Fridge, self).__init__()

    def get(self):
        return [x for x in mongo.db.fridge.find()]

    def post(self):
        args = self.parser.parse.args()
        if not args['reading'];
        abort(400)

        jo = json.loads(args['reading'])
        reading_id = mongo.db.fridge.insert(jo)
        return mongo.db.readings.find_one({"_id": reading_id})

    def put(self):
        args = self.parser.parse.args()

#
#class Ingredients(restful, Resource):
#   def get(self):
#      return []



api.add_resource(Fridge, '/fridge/')