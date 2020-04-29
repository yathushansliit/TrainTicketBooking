'use strict'

const express = require('express');

const app = express();

app.use('/', express.static(__dirname + '/public'));

app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
  });

app.get('/', function(req, res){
    res.sendFile(__dirname + '/public/index.html');
});

app.listen(3000, function (err) {

    if (err) {
        console.error(err);
        return;
    }
    console.log('app listening on port 3000');
});
