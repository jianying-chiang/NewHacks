const express = require('express')


const port = process.env.PORT || 3000;

const app = express();

app.set('views', './src/views');
app.set('view engine', 'ejs');

const nav = [
    {link: "/admin", title: "Fridge"},
]

const adminRouter = require('./src/routes/adminRoutes')(nav);

app.use('/admin', adminRouter);

app.get('/', (req, res) => {
    res.render(
      'index',
      {
        nav: [{link: "/admin", title: "Fridge"}],
      }
    );
});

app.listen(port, () => {
    console.log("Server is running on ", port);
})