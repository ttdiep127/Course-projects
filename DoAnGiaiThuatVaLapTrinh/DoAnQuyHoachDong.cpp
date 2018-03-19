#include <stdio.h>
#include <conio.h>
#include <time.h>
#define MAX 1000
int main(){
	long F[MAX][MAX];
	int n, m, v;
	printf("nhap so can phan tich n = ");
	scanf("%d",&n);
	clock_t begin = clock();
	for(v = 0; v <= n; v++){
		F[0][v]=0;
	}	
	F[0][0]=1;
	for(m = 1; m <= n; m++){
		for(v = 0; v <= n; v++){
			if(v<m) {
				F[m][v] = F[m-1][v];
			}
			else {
				F[m][v] = F[m-1][v] + F[m][v-m];
			} 
		}	
	}
	printf("\n so cach phan tich so %d la: %d",n,F[n][n]);
	 clock_t end = clock();	
	 printf("\nThoi gian xu li : %.6f",(float)(end-begin)/CLOCKS_PER_SEC);
	getch();
}
