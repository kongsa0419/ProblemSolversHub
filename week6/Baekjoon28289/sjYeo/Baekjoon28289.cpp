#include<stdio.h>

// if(1학년이면) 아무런 과에 속하지 않음
// else {분반만 체크해서 count해줌}
// *학생이 겹치지 않기때문에 이정도만 해줘도 괜찮음
int main(void){
    int p, g,c,n,i;
    int sw, embed, ai, fresh;
    sw = embed = ai = fresh = 0;
    scanf("%d", &p);
    for(i=0; i<p; i++){
        scanf("%d %d %d", &g, &c, &n);
        if(g==1) fresh++;
        else{
            switch(c){
                case 1: // case 2와 한꺼번에 처리
                case 2: {sw++; break;}
                case 3: {embed++; break;}
                case 4: {ai++; break;}
            }
        }
    }
    printf("%d\n%d\n%d\n%d\n", sw, embed, ai, fresh);
    return 0;
}