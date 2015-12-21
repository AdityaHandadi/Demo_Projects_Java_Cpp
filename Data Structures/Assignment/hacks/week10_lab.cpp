/* Murali  Krishna Reddy Vangala
   CWID : 50125414 */
#include<iostream>



using namespace std;



int merge(int a[], int l, int m, int r)

{ 

	int count = 0;

	int i, j;

    static int aux[100];

    for (i = m+1; i > l; i--) aux[i-1] = a[i-1];

    for (j = m; j < r; j++) aux[r+m-j] = a[j+1];

    for (int k = l; k <= r; k++)

	{

		count++;

		if (aux[j] < aux[i]) 

			a[k] = aux[j--]; 

		else a[k] = aux[i++];

	}

	return count;

}



int mergesort(int a[], int l, int r)

{ 

	int count1 = 0;

	if (r <= l) return 0;

    int m = (r+l)/2;

    count1+= mergesort(a, l, m);  

    count1+= mergesort(a, m+1, r);

    count1+= merge(a, l, m, r);

	return count1;

}



int main()

{

	int arrayA[28] = { 28, 14, 5, 19, 23, 6, 29, 4, 30, 18, 22, 10, 16, 21, 3, 5, 7, 26, 18, 20, 11, 25, 17, 27, 9, 13, 24, 8 };

	int count = 0;



	count = mergesort(arrayA, 0, 27);

	
    for (int s=0;s<=27;s++)
    cout<<" "<<arrayA[s];
	
	cout << "\n \n Number of comparisions : " << count << endl;



	system("pause");

}