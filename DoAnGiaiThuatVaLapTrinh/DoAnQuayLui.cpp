#include <stdio.h>
#include <conio.h>
#define MAX 100
int n,count;
void PrintResult(int k,int* a){
	int i;
	printf("\n cach %d : %d = ",count++,n);
	for( i=1; i<k; i++) printf(" %d +",a[i]);
	printf(" %d",a[k]);	
}
void Attempt(int i, int* a,int* t){
	int j;
	for(j=a[i-1];j<=(n-t[i-1])/2;j++){
		a[i]=j;
		t[i]=t[i-1]+j;
		Attempt(i+1,a,t);
	}
	a[i]=n-t[i-1];
	PrintResult(i,a);
}
int main(){
	count = 1;
	int a[MAX],t[MAX];
	do{
		printf("\nnhap n = ");
		scanf("%d",&n);
	}while (n>40);
	a[0]=1;
	t[0]=0;
	Attempt(1,a,t);
	getch();
}
