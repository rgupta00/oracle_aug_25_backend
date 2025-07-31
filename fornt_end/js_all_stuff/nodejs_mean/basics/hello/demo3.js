//how to use existing modules nodejs file modules
// const fs = require('fs');
// const data = 'Hello World!';

// fs.writeFile('test.txt', data, function (err) {
//   if (err) return console.log(err);
//   console.log('Hello World > test.txt');
// });
// console.log('testing');

const http = require("http");
const srvr = http.createServer(function (req, res) {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Hello World\n');
});

srvr.listen(8081);
console.log('Server running at http://127.0.0.1:8081/');