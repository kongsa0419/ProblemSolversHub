const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
let N = +input[0];
let ans = 0;

for(let i = 1; i <= N; i++){
    num = input[i].split(" ");
    switch(num[0]){
        case "136": ans+=1000; break;
        case "142": ans+=5000; break;
        case "148": ans+=10000; break;
        case "154": ans+=50000; break;
    }
}
console.log(ans);