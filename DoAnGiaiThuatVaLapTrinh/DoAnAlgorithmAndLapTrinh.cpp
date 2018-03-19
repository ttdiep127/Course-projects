#include <stdio.h>
#include <conio.h>
#include <time.h> 
#include <math.h>
#include <iostream>
#include <Windows.h>
#define MAX 100

int n,a[MAX],t[MAX];
long count;
void PPQuayLui();
void PrintResult(int k,int a);
void Attempt(int i);

void PPDeQuy();
long f(int m,int v);

void PPQuyHoachDong();

double getTime();
void compareExeTime();

int main(){
	int chon;
	boolean check = true;
	//int n;
	do{
		printf("Nhap so nguyen n :\n");
		scanf("%d",&n);
		do{	
			system("cls");
			printf("----------------MENU---------------\n");
			printf("Chon 1: Su dung 'phuong phap quay lui'.\n");
			printf("Chon 2: Su dung 'phuong phap de quy'.\n");
			printf("Chon 3: Su dung 'phuong phap quy hoach dong'.\n");
			printf("Chon 4: Nhap mot so n khac.\n");
			printf("Chon 5: Thoat chuong trinh.\n");
			printf("-----------------\n");
			printf("Moi ban chon chuc nang:\n");
			scanf("%d",&chon);
			if(chon<1||chon>6){
				printf("lua chon khong dung!\n");
				printf("Nhan phim bat ki de tro ve MENU\n");
				getch();
			}
			else{
				switch(chon){
					case 1: {
						PPQuayLui();
						break;
					}
					case 2:{
						PPDeQuy();
						break;
					}
					case 3:{
						PPQuyHoachDong();
						break;
					}
					case 4:{
						check = false;
						break;
					}
					case 5:{
						return 0;
					}
					case 6:{
						compareExeTime();
						break;
					}						
				}
			}
		}while(check);		
	}while(true);
}

//----------------------------//
void PPQuayLui(){
	count = 1;
	
	if(n>40){
	printf("so %d lon hay dung phuong phap khac.",n);
	printf("\n\nNhan phim bat ki de tro ve MENU\n");
	getch();
	}
	else{
		printf("phuong phap quay lui su dung de in ra cac cach bieu dien\n");
		a[0]=1;
		t[0]=0;
		Attempt(1);
		printf("\nNhan phim bat ki de tro ve MENU\n");
		getTime();
		getch();		
		}	
}
void PrintResult(int k){
	int i;
	printf("\n cach %ld : %d = ",count++,n);
	for( i=1; i<k; i++) printf(" %d +",a[i]);
	printf(" %d",a[k]);
}
void Attempt(int i){
	int j;
	for(j=a[i-1];j<=(n-t[i-1])/2;j++){
		a[i]=j;
		t[i]=t[i-1]+j;
		Attempt(i+1);
	}
	a[i]=n-t[i-1];
	PrintResult(i);
}
//----------------------------//
void PPDeQuy(){
	printf("Phuong phap de dui dung de in ra cac cach phan tich.\n");
	if(n>800){
		printf("So %d kha lon, Hay su dung phuong phap quy hoach dong de nhanh hon.\n");
		printf("\n\nNhan phim bat ki de tro ve MENU\n");
		getch();
	}
	double starTime = getTime();
	clock_t begin = clock();
	printf("so cach phan tich so %d thanh tong cac so be hon no la: %ld",n,f(n,n));
	clock_t end = clock();
	double finallTime = getTime();
		
	printf("\nThoi gian xu li cua phuong phap nay : %.fs",(finallTime-starTime));
	 printf("\nThoi gian xu li : %f",(float)(end-begin)/CLOCKS_PER_SEC);
	printf("\n\nNhan phim bat ki de tro ve MENU\n");
	getch();
}
long f(int m, int v){
	if(m==0){
		if(v==0) return 1;
		else return 0;
	}else{
		if(m>v) return f(m-1,v);
		else return (f(m-1,v)+f(m,v-m));
	}
}
//-----------------------------//
void PPQuyHoachDong(){
	printf("phuong phap quy hoach dong su dung de in ra cac cach bieu dien\n");
	double F[MAX][MAX];
	int m, v;
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
	printf("so cach phan tich so %d thanh tong cac so be hon no la: %ld",n,F[n][n]);
	printf("\n\nNhan phim bat ki de tro ve MENU\n");	
	getch();
}
//------------------------------//
double getTime(){
	  time_t timer;
	  struct tm y2k = {0};
	  double seconds;	
	  y2k.tm_hour = 0;   y2k.tm_min = 0; y2k.tm_sec = 0;
	  y2k.tm_year = 100; y2k.tm_mon = 0; y2k.tm_mday = 1;	
	  time(&timer);  /* get current time; same as: timer = time(NULL)  */	
	  seconds = difftime(timer,mktime(&y2k));
	  return seconds;
}
//-------------------------------//
void compareExeTime(){
	
	
	if(n>800){
		printf("So %d kha lon, Hay su dung phuong phap quy hoach dong de nhanh hon.\n");
		printf("\n\nNhan phim bat ki de tro ve MENU\n");
		getch();
	}
	double starTimeDQ = getTime();
	printf("so cach phan tich so %d thanh tong cac so be hon no la: %ld",n,f(n,n));
	double finallTimeDQ = getTime();
	printf("\nThoi gian xu li cua phuong phap De Quy: %.fs",(finallTimeDQ-starTimeDQ));
	
	
	int m , v;
	int F[MAX][MAX];
	double starTimeQHD = getTime();
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
	printf("\nso cach phan tich so %d thanh tong cac so be hon no la: %d",n,F[n][n]);
	double finallTimeQHD = getTime();
	printf("\nThoi gian xu li cua phuong phap Quy Hoach Dong: %.fs",(finallTimeQHD-starTimeQHD));
	printf("\n\nNhan phim bat ki de tro ve MENU\n");	
	getch();
}
	
	
	
