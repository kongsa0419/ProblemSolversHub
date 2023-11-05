const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let nm = input[0].split(' ').map(x => +x);
let robot = input[1].split(' ').map(x => +x);
let mapArr = Array(nm[0]);
for (let i = 2; i < nm[0]+2; i++){
    mapArr[i-2] = input[i].split(' ').map(x => +x);
}

if (robot[2] === 1){
    robot[2] = 3;
}else if(robot[2] === 3){
    robot[2] = 1;
}

console.log(solution(nm, mapArr, robot))

function solution(nm, mapArr, robot) {
    let count = cleanCurrent(mapArr, robot, 0);
    let checkX = [];
    let checkY = [];

    while(true){
        checkX = [robot[1], robot[1]-1, robot[1], robot[1]+1];
        checkY = [robot[0]-1, robot[0], robot[0]+1, robot[0]];

        if (checkAround(nm,mapArr,robot, checkX, checkY)){
            robot[0] = checkY[robot[2]];
            robot[1] = checkX[robot[2]];
            count = cleanCurrent(mapArr, robot, count);
        }
        else{
            if(mapArr[checkY[(robot[2]+2)%4]][checkX[(robot[2]+2)%4]] == 1){
                return count;
            }
            robot[0] = checkY[(robot[2]+2)%4];
            robot[1] = checkX[(robot[2]+2)%4];
        }
    }
}

function cleanCurrent(mapArr, robot, count){
    mapArr[robot[0]][robot[1]] = 2;
    return count+1;
}

function checkAround(nm, mapArr, robot, checkX, checkY){
    let see = robot[2]    
    for (let i = 0; i < 4; i++) {
        see = (1+see) % 4;
        
        if (mapArr[checkY[see]][checkX[see]] == 0) {
            robot[2] = see;
            return true;
        }
    }
    return false;
}