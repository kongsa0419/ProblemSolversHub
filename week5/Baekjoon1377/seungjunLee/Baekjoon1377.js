const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
N = +input[0];
A = [];
for(let i = 0; i < N; i++){
    A.push([+input[i+1], i]);
}

bubbleSort(N, A);

function bubbleSort(N, A) {
    A.sort((a,b) => a[0] - b[0]);

    max = 0;
    for(let i = 0; i < N; i++){
        if(max < A[i][1] - i){
            max = A[i][1] - i;
        }
    }
    console.log(max+1);
}
