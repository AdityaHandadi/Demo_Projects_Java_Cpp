#include<iostream>
using namespace std;

int arr[28]={14,5,19,23,6,29,4,30,18,22,10,16,21,3,5,7,26,18,20,11,25,17,27,9,13,24,8,28};


void selectionSort(int A[],int l,int r)
{
	int c=0;
	for(int i=0;i<r;i++)
	{
		int min=i,temp;
		for(int j=i+1;j<r;j++)
		{
			c++;
			if(A[j]<A[min])
				min=j;
		}
		temp=A[i];
		A[i]=A[min];
		A[min]=temp;
	}	
	cout<<"Number of iterations in selection sort: "<<c<<endl;
}


void insertionSort(int A[],int l,int r)
{
	int j,k,i,temp=0,c=0;
	for(i=0;i<r-1;i++)
	{
		j=i+1;
		k=j;
		temp=A[j];
			while(temp<A[k-1] && k>0)
			{
				A[k]=A[k-1];
				k--;
				c++;
			}
			A[k]=temp;
		
	}
	cout<<"Number of iterations in insertion sort: "<<c<<endl;
}


void bubbleSort(int A[],int l,int r)
{
	int i,j,temp=0,k=0,q=0,c=0,count=0;
	for(i=0;i<r;i++)
	{
		count=0;
		for(j=1;j<r;j++)
		{
			if(A[j]<A[j-1])
			{
				temp=A[j];
				A[j]=A[j-1];
				A[j-1]=temp;
				q=1;
				count++;
			}
			c++;
		}
		if(count==0)
			break;
	}
	cout<<"Number of iteration in Bubble sort: "<<c<<endl;
}

int main()
{

	int A[28],count=0,i;
	
	//selection sort logic
	for(i=0;i<28;i++)
	{
		A[i]=arr[i];
	}
	cout<<endl;
	cout<<endl;
	cout<<"SELECTION SORT:"<<endl;
	selectionSort(A,0,28);

	for(i=0;i<28;i++){cout<<A[i]<<" ";}
	cout<<endl;cout<<endl;
	
	//insertion sort logic
	for(i=0;i<28;i++)
	{
		A[i]=arr[i];
	}
	cout<<"INSERTION SORT:"<<endl;
	insertionSort(A,0,28);
	for(i=0;i<28;i++){cout<<A[i]<<" ";}
	cout<<endl;cout<<endl;
	
	//bubblesort
	for(i=0;i<28;i++)
	{
		A[i]=arr[i];
	}
	cout<<"BUBBLE SORT:"<<endl;
	bubbleSort(A,0,28);
	for(i=0;i<28;i++){cout<<A[i]<<" ";}
	cout<<endl;cout<<endl;
	
system("pause");
}

