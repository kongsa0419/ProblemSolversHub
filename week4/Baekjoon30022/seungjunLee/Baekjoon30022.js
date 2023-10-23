const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let [N, A, B] = input[0].split(' ').map(x => +x);
let NList = [];
let sub = [];

for(let i = 1; i < input.length; i++){
    NList.push(input[i].split(' ').map(x => +x));
    sub.push([Math.abs(NList[i-1][0]-NList[i-1][1]), i-1]);
}
sub.sort((a, b) => b[0] - a[0]);

console.log(solution(N, A, B, NList, sub));

function solution(N, A, B, NList, sub){
    let ans = 0;

    for(let i = 0; i < N; i++){
        let [a, b] = NList[sub[i][1]];
        if (A != 0 && B != 0){
            if (a > b){
                ans += b;
                B--;
            }
            else{
                ans += a;
                A--;
            }
        } 
        else{
            if(A == 0){ ans += NList[sub[i][1]][1];}
            else{ans += NList[sub[i][1]][0];}
        }
    }
    return ans;
}