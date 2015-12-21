#include<iostream>

using namespace std;

struct retStr
{
	int i;
	int count;

	retStr(int a , int b)
	{
		i = a;
		count = b;
	}
};

typedef retStr* ret;

void exch(int &a, int &b)
{
	int temp;
	temp = a;
	a = b;
	b = temp;
}



ret partition(int a[], int l, int r)
{
	ret count = new retStr(0,0);
	count->i = l-1;
	int j = r; 
	int v = a[r];

	for (;;)
	{ 
		count->count++;	
		while (a[++count->i] < v){
			count->count++;
		}			

		count->count++;	
		while (v < a[--j])
		{
			count->count++;
			if (j == l)break;
		}

		if (count->i >= j) 
			break;

		exch(a[count->i], a[j]);
	}
	exch(a[count->i], a[r]);

	return count;	
}



int quicksort(int a[], int l, int r)
{
	ret cnt;
	int count=0;
	if (r <= l) 
		return 0;

	cnt = partition(a, l, r);

	count+= quicksort(a, l, cnt->i-1);
	count+= quicksort(a, cnt->i+1, r);

	return count+cnt->count;

}



int main()
{

	//int arrayA[28] = { 28, 14, 5, 19, 23, 6, 29, 4, 30, 18, 22, 10, 16, 21, 3, 5, 7, 26, 18, 20, 11, 25, 17, 27, 9, 13, 24, 8 };
	int arrayA[28] = {28, 14, 5, 19, 23, 6, 29, 4, 13, 18, 22, 10, 16, 21, 3, 5, 7, 26, 18, 20, 11, 25, 17, 27, 9, 30, 24, 8}; 
	int count = 0;

	count = quicksort(arrayA, 0, 27);
	for(int i = 0 ; i < 28 ; i++)
		cout<<" "<<arrayA[i];
		
	cout<<endl;
	cout<< "number of Iterations :" <<count;
	cout<<endl;

	system("pause");

	return 0;
}