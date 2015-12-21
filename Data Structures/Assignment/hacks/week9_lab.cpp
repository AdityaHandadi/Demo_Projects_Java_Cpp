#include<iostream>
using namespace std;

int arr[28]={14,5,19,23,6,29,4,30,18,22,10,16,21,3,5,7,26,18,20,11,25,17,27,9,13,24,8,28};

void selectionSort(int a[],int l,int r);
void insertionSort(int a[],int l,int r);
void bubbleSort(int a[],int l,int r);

int main()
{
//consider default array
	int b[28],count=0,i;
//selection sort
	for(i=0;i<28;i++)
	{
		b[i]=arr[i];
	}
	cout<<endl;
	cout<<endl;
	cout<<"SELECTION SORT:"<<endl;
	selectionSort(b,0,28);

	for(i=0;i<28;i++){cout<<b[i]<<" ";}
	cout<<endl;cout<<endl;
	
//insertion sort
	for(i=0;i<28;i++)
	{
		b[i]=arr[i];
	}
	cout<<"INSERTION SORT:"<<endl;
	insertionSort(b,0,28);
	for(i=0;i<28;i++){cout<<b[i]<<" ";}
	cout<<endl;cout<<endl;
	
//bubblesort
	for(i=0;i<28;i++)
	{
		b[i]=arr[i];
	}
	cout<<"BUBBLE SORT:"<<endl;
	bubbleSort(b,0,28);
	for(i=0;i<28;i++){cout<<b[i]<<" ";}
	cout<<endl;cout<<endl;
system("pause");
}

//functions
void selectionSort(int b[],int l,int r)
{
	int c=0;
	for(int i=0;i<r;i++)
	{
		int min=i,temp;
		for(int j=i+1;j<r;j++)
		{
			c++;
			if(b[j]<b[min])
				min=j;
		}
		temp=b[i];
		b[i]=b[min];
		b[min]=temp;
	}	
	cout<<"Number of iterations in selection sort: "<<c<<endl;
}


void insertionSort(int b[],int l,int r)
{
	int j,k,i,temp=0,c=0;
	for(i=0;i<r-1;i++)
	{
		j=i+1;
		k=j;
		temp=b[j];
			while(temp<b[k-1] && k>0)
			{
				b[k]=b[k-1];
				k--;
				c++;
			}
			b[k]=temp;
		
	}
	cout<<"Number of iterations in insertion sort: "<<c<<endl;
}


void bubbleSort(int b[],int l,int r)
{
	int i,j,temp=0,k=0,q=0,c=0,count=0;
	for(i=0;i<r;i++)
	{
		count=0;
		for(j=1;j<r;j++)
		{
			if(b[j]<b[j-1])
			{
				temp=b[j];
				b[j]=b[j-1];
				b[j-1]=temp;
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