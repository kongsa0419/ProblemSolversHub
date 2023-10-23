const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let [N, D] = input[0].split(' ').map(x => +x);
D = D - 1
var strArr = [];

let d = ['q', 'b']
let b = ['p', 'd']
let q = ['d', 'p']
let p = ['b', 'q']

for(let i = 1; i < input.length; i++){
    strArr.push([...input[i]]);   
}

for (let i = 0; i < N; i++){
    for (let j = 0; j < N; j++){
        switch(strArr[i][j]){
            case 'd' : strArr[i][j] = d[D]; break;
            case 'b' : strArr[i][j] = b[D]; break;
            case 'q' : strArr[i][j] = q[D]; break;
            case 'p' : strArr[i][j] = p[D]; break;
        }
    }
}
for (let i = 0; i < N; i++){
    for (let j = 0; j < N; j++){
        process.stdout.write(strArr[i][j])
    }
    console.log()
}