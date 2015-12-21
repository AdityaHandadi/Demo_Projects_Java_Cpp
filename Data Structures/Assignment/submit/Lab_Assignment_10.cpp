#include<iostream>
using namespace std;


int arr[28]={28,14,5,19,23,6,29,4,13,18,22,10,16,21,3,5,7,26,18,20,11,25,17,27,9,30,24,8};

static int const maxN=100;

int merge(int a[], int l, int m, int r)
  { int i, j;
	int count=0;
    static int aux[maxN];
    for (i = m+1; i > l; i--) aux[i-1] = a[i-1];
    for (j = m; j < r; j++) aux[r+m-j] = a[j+1];
    for (int k = l; k <= r; k++){
	   count++;
       if (aux[j] < aux[i]) 
          a[k] = aux[j--]; 
	   else a[k] = aux[i++];
	}
	return count;
  }

int mergesort(int a[], int l, int r)
  { if (r <= l) return 0;
	int i=0;
    int m = (r+l)/2;
    int one=mergesort(a, l, m);  
    int two=mergesort(a, m+1, r);
    int three=merge(a, l, m, r);

	return one+two+three;
  }

int main(){
	int A[28],count=0,i,j;
	
	cout<<"Given Array"<<endl;
	for(i=0;i<28;i++)
	{
		cout<<arr[i]<<" ";
		A[i]=arr[i];
	}
	cout<<endl;
	cout<<"MERGE SORT:"<<endl;

	count=mergesort(A,0,27);
	cout<<"The Sorted Array is ";
	j=0;

	for(j=1;j<28;j++){cout<<A[j]<<" ";}
	cout<<endl<<endl;

	cout<<"The Number of Comparisions made: "<<count<<endl;

	system("pause");
}