function solution(people, limit) {
    let answer = 0;
    let left = 0
    let right = people.length-1;
    people.sort((a,b) => a-b);

    while(left < right){
        if(people[left] + people[right] > limit){
            answer++;
            right--;
        }else{
            answer++;
            left++;
            right --;
        }
    }
    if (right == left){
        answer++;
    }
    return answer;
}

console.log(solution([70,50,80,50],100));