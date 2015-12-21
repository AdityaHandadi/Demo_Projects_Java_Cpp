
#include<iostream>

using namespace std;
int A[28] = {3, 4, 5, 5, 6, 7, 9, 8, 10, 11, 13, 14, 17, 16, 18, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
int B[28] = {14, 5, 19, 23, 6, 29, 4, 30, 18, 22, 10, 16, 21, 3, 5, 7, 26, 18, 20, 11, 25, 17, 27, 9, 13, 24, 8, 28};
float count_a = 0, count_b = 0, count_c = 0;
bool flag;
void exch(int C[], int i, int j)
{
	int temp = C[j];
	C[j] = C[i];
	C[i] = temp;
}
void compexch_ins(int C[], int i, int j)
{
	int temp = C[j];
	count_b++;
	if(C[i] > temp)
	{
		C[j] = C[i];
		C[j] = temp;
	}
}
void compexch_bub(int C[], int i, int j)
{
	int temp = C[j];
	count_c++;
	if(C[a] > temp)
	{
		C[j] = C[i];
		C[i] = temp;
		flag = false;
	}
}
void selection(int a[], int l, int r)
{ 
	for (int i = l; i < r; i++)
    { 
		int min = i;
        for (int j = i+1; j <= r; j++) 
		{
			count_a++;
			if (a[j] < a[min]) 
			{
				min = j;
			}
	}
	exch(a, i, min);
	} 
}

void insertion(int a[], int l, int r)
{ 
	int i;
	for (i = r; i > l; i--) 
	compexch_ins(a, i-1, i);
	for (i = l+2; i <= r; i++)
	{
		int j = i; int v = a[i]; 
		while (v < a[j-1])
		{
			count_b++;
			a[j] = a[j-1]; 
			j--; 
		}
		count_b++;
		a[j] = v; 
	} 
}

void bubble(int a[], int l, int r)
{
	for (int i = l; i < r; i++)
	{
		flag = true;
		for (int j = r; j > i; j--)
		{
			compexch_bub(a, j-1, j);
		}
		if(flag)
     		break;
	}
}

int main()
{

	char chIn;
	cout << "Enter your Choice A / B / C / D / E / F  "<<"\n";
	cout<<"  A	A=Selection Sort, B=Insertion Sort"<<"\n";
	cout<<"  B	A=Selection Sort, B=Bubble Sort"<<"\n";
	cout<<"  C	A=Insertion Sort, B=Selection Sort"<<"\n";
	cout<<"  D	A=Insertion Sort, B=Bubble Sort"<<"\n";
	cout<<"  E	A=Bubble Sort, B=Insertion Sort"<<"\n";
	cout<<"  F	A=Bubble Sort, B=Selection Sort"<<"\n";

	cin >> chIn;
	if (chIn=='A')
	{

	    selection(A, 0, 27);

		insertion(B, 0, 27);

		cout << "Sorted arrays: " << endl;

		for(int i = 0; i < 28; i++)

			cout << A[i] << " ";

		cout << "\n";;

		for(int i = 0; i < 28; i++)

			cout << B[i] << " ";

		cout << endl;

		cout << "Number of comparisons for Selection Sort: " << count_a << endl;

		cout << "Number of comparisons for Insertion Sort: " << count_b << endl;

		cout << "The ratio of the number of Comparisons is: " << count_a/count_b << endl;

		}
		else if (chIn =='b' || chIn=='B')
		{

	      selection(A, 0, 27);

		  bubble(B, 0, 27);

		  cout << "Sorted Arrays :  " << endl;

		  for(int i = 0; i < 28; i++)
					cout << A[i] << " ";

		  cout << endl;

		  for(int i = 0; i < 28; i++)
					cout << B[i] << " ";

		  cout << endl;

		 cout << "Number of comparisons for Selection Sort: " << count_a <<endl;
		 cout << "Number of comparisons for Bubble Sort: " << count_c << endl;
		 cout << "The ratio of the number of Comparisons is: " << count_a/count_c << endl;

		}
		else if (chIn=='C')
		{

	     insertion(A, 0, 27);

		 selection(B, 0, 27);

		 cout << "Sorted Arrays :  " << endl;

		 for(int i = 0; i < 28; i++)
			cout << A[i] << " ";

		 cout << endl;

		 for(int i = 0; i < 28; i++)
			cout << B[i] << " ";

		 cout <<endl;
	     cout << "Number of comparisons for Insertion Sort: " << count_b <<endl;
		 cout << "Number of comparisons for Selection Sort: " << count_a << endl;
		 cout << "The ratio of the number of Comparisons is: " << count_b/count_a <<endl;

		}
		else if (chIn=='D')

		{
	      insertion(A, 0, 27);
		  bubble(B, 0, 27);

		  cout << "Sorted arrays: " <<endl;

		   for(int i = 0; i < 28; i++)
				cout << A[i] << " ";

		  cout <<endl;

		  for(int i = 0; i < 28; i++)
			cout << B[i] << " ";

		  cout <<endl;

		  cout << "Number of comparisons for Insertion sort: " << count_b <<endl;
		  cout << "Number of comparisons for Bubble sort: " << count_c <<endl;
		  cout << "The ratio of the number of Comparisons is: " << count_b/count_c <<endl;

		}
		else if ( chIn=='E')
		{

	      insertion(B, 0, 27);

		  bubble(A, 0, 27);

		  cout << "Sorted arrays: " <<endl;

		  for(int i = 0; i < 28; i++)

			cout << A[i] << " ";

		  cout<<endl;

		  for(int i = 0; i < 28; i++)

			cout << B[i] << " ";

		  cout << endl;

		  cout << "Number of comparisons for Bubble sort: " << count_c << endl;
		  cout << "Number of comparisons for Insertion sort: " << count_b << endl;
		  cout << "The ratio of the number of Comparisons is: " << count_c/count_b << endl;

		}
		else if (chIn=='F')

		{
          selection(B, 0, 27);
		  bubble(A, 0, 27);

		  cout << "Sorted arrays: " <<endl;

		  for(int i = 0; i < 28; i++)
					cout << A[i] << " ";

		  cout << endl;

		  for(int i = 0; i < 28; i++)
				cout << B[i] << " ";

		  cout << endl;	
		  cout << "Number of comparisons for Bubble sort: " << count_c << endl;
		  cout << "Number of comparisons for Selection sort: " << count_a << endl;
		  cout << "The ratio of the number of Comparisons is: " << count_c/count_a << endl;

		}
		else
		{
			exit(0);
		}
		
	system("pause");
	return 0;

}