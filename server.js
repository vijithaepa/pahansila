/**
 * Created by vepa on 10/10/17.
 */
var express = require('express');
var faker = require('faker');
var cors = require('cors');
var bodyparser = require('body-parser');

var app = express();
app.use(cors());
app.use(bodyparser.json())

var user = {
    username: 'vijitha',
    password: 'abc'
}

app.get('/random-user', function (req, res) {
    var user = faker.Helpers.userCard();
    user.avatar = faker.Image.avatar();
    res.json(user);
});

app.listen(3000, function () {
    console.log('App listening on 3000');
});

app.post('/login', authenticate, function (req, res) {
    
});


//Util methods
function authenticate(req, res, next) {
    var body = rey.body;
    if(!body.username || !body.password) {
        res.status(400).end('Must have user/pass');
    }
    if(body.username != user.username || body.password != user.password) {
        res.status(401).end('incorrect user/pass');
    }
    next();
}