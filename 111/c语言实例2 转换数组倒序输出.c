#include <stdio.h>
int main(){
	printf("����5�������������\n");
	int a[5],b[5],i,j;
	for(i=0;i<5;i++){
		scanf("%d",&a[i]);
	}
	for(i=0;i<5;i++){
		b[j]=a[4-i];
		printf("%d\t",b[j]);
	}
	return 0;
}
