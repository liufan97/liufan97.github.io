#include <stdio.h>
int main(){
	printf("��ֵ����\n");
	int sum,a,b,c,d,sum2=30;
	for(a=1;a<=9;a++){
		for(b=1;b<=21;b++){
			for(c=1;c<=42;c++){
				for(d=1;d<=83;d++){
					sum=a*50+b*20+c*10+d*5;
					sum2=a+b+c+d;
					if(sum<=500&&sum2==30){
						printf("50Ԫ��%d�ţ�20Ԫ��%d�ţ�10Ԫ��%d�ţ�5Ԫ��%d�ţ���ֵ%dԪ\n",a,b,c,d,sum);
						
					}
				}
			}
		} 
	} 
	return 0;
}
