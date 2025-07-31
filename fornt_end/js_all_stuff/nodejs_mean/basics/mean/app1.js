//expres is very similer to spring rest routes
const express = require('express');
const app = express();

app.get('/', function(req, res){
    res.send('express js working!!')
}).listen(4000);

//Middleware (servlet filter) & Route Handlers

app.get('/customers/:custId/orders/:orderId', (req, res) => {
    res.send(req.params);
});

// URL: /user/000000?gender=male
app.get('/user/:id', (req, res) => {
    const query = req.query;   // { gender: "male" }
    const params = req.params; // { id: "000000" }
    console.log(query)
    console.log(params)
});

console.log('server is running');