const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let N = +input[0];
let bulb = [...input[1]];


function count_rgb(N, bulb, RGB) {
    let count = 0;
    let copy_bulb = JSON.parse(JSON.stringify(bulb));
    for (let i = 0; i < N - 2; i++) {
        while (copy_bulb[i] != RGB) {
            copy_bulb[i] = change_rgb(copy_bulb[i]);
            copy_bulb[i + 1] = change_rgb(copy_bulb[i + 1]);
            copy_bulb[i + 2] = change_rgb(copy_bulb[i + 2]);
            count++;
        }
    }
    if (copy_bulb[N - 1] == copy_bulb[N - 2] && copy_bulb[N - 2] == copy_bulb[N - 3]) {
        return count;
    } else {
        return -1;
    }
}

function change_rgb(color) {
    if (color == 'R') {
        return 'G';
    }
    if (color == 'G') {
        return 'B';
    }
    if (color == 'B') {
        return 'R';
    }
}

function solution(N, bulb) {
    let count_r = count_rgb(N, bulb, 'R');
    let count_g = count_rgb(N, bulb, 'G');
    let count_b = count_rgb(N, bulb, 'B');
    
    let ans = -1;
    let min = [count_r, count_g, count_b];
    min.sort((a, b) => a - b);
    for (let i = 0; i < 3; i++) {
        if (min[i] != -1) {
            ans = min[i];
            break;
        }
    }
    console.log(ans);
}

solution(N, bulb);
