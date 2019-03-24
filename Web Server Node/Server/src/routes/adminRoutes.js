const express = require('express');
const adminRouter = express.Router();
const { MongoClient } = require('mongodb');
const debug = require('debug')('app:adminRoutes');

const ingredients = [
    {
        "Ingredient": "Mushrooms",
        "Qty": 15
    },
    {
        "Ingredient": "Apples",
        "Qty": 5
    },
    {
        "Ingredient": "Spinach",
        "Qty": 7
    },
    {
        "Ingredient": "Kale",
        "Qty": 3
    },
    {
        "Ingredient": "Oranges",
        "Qty": 10
    },
    {
        "Ingredient": "Brussel Sprouts",
        "Qty": 30
    },
    {
        "Ingredient": "Potatoes",
        "Qty": 20
    }
]

const nav = [
    { link: '/books', title: 'Book' },
    { link: '/authors', title: 'Author' }
  ];

function router(nav) {
    adminRouter.route('/')
      .get((req, res) => {
        const url = 'mongodb://localhost:27017';
        const dbName = 'libraryApp';
  
        (async function mongo() {
          let client;
          try {
            client = await MongoClient.connect(url);
            debug('Connected correctly to server');
  
            const db = client.db(dbName);
  
            const response = await db.collection('books').insertMany(books);
            res.json(response);
          } catch (err) {
            debug(err.stack);
          }
  
          client.close();
        }());
      });
    return adminRouter;
  }

module.exports = router;