#include <stdio.h>
#include <conio.h>
#include <math.h>
#define MAX 100
long f(int m, int v){
	if(m==0){
		if(v==0) return 1;
		else return 0;
	}else{
		if(m>v) return f(m-1,v);
		else return (f(m-1,v)+f(m,v-m));
	}
}
main(){
	int  n;
	do{
		printf("Nhap n = ");
		scanf("%d",&n);
	}while(n>800);
	printf("\n so cach phan tich la : %ld",f(n,n));
	getch();
}
