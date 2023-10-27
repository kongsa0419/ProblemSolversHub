const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();
const B = input;
console.log(B - B/11);