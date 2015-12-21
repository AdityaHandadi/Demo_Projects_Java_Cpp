/* 50135734 
Aditya Prasanna Handadi */

#include<iostream>
#include<fstream>

using namespace std;

void main()

{
	ifstream myFile;
	myFile.open("graph.txt");

	int n;
	int firstVtx, secVtx;
	int count = 0;
	int steps = 0;

	int B[5];

	myFile >> n;


	int **A = new int*[n];

	for (int x = 0; x <= n; x++)
	{
		A[x] = new int[n];
	}

	for (int x = 0; x <= n; x++)
	{
		for (int y = 0; y <= n; y++)
		{
			if (x == y)
			{
				A[x][y] = 1;
			}
			else
			{
				A[x][y] = 0;
			}
		}
	}

	while (!myFile.eof())
	{
		// read the edges from an input file
		myFile >> firstVtx >> secVtx;
		// insert the edge into the graph.
		A[firstVtx - 1][secVtx - 1] = 1;
	}

	cout << "Graph G is constructed\n" << endl;


	while (true)
	{
		count = 0;
		cout << "Enter the number of vertices and steps: " << endl;
		cin >> firstVtx >> secVtx >> steps;

	
		for (int i = 0; i<n; i++)
		{
			B[i] = A[firstVtx - 1][i];
		}

		for (int i = 0; i<n; i++)
		{


			if (B[i] == 1)
			{
				for (int j = 0; j<n; j++)
				{
					if (A[i][j] == 1)
					{
						B[j] = 1;
					}
				}
			}
			count++;
			if (B[secVtx - 1] == 1)
			{
				break;
			}


		}

		if (count == steps && B[secVtx - 1] == 1)
		{
			cout << "Reachable in " << steps << " steps\n" << endl;
		}
		else if (count < steps && B[secVtx - 1] == 1)
		{
			cout << "Reachable in " << steps << " steps (Actually " << count << ")" << endl;
		}

		else if (firstVtx == secVtx)
		{
			cout << "Reachable in " << steps << " steps\n" << endl;
		}
		else
		{
			cout << "Not Reachable in " << steps << " steps\n" << endl;
		}
	}
	system("pause");
}