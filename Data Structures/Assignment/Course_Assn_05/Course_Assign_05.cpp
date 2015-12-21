#include<iostream>
#include<fstream>
#include<iomanip>
#include<stdio.h>
using namespace std;

struct node
{
	int val;
	node *next;
};

node *arrayA[25];

int main()
{

	ifstream myfile;
	int i, noOfNodes, ver1, ver2, result = -1,steps,temp=0;

	node *head = 0,*t=0,*t2=0;

	myfile.open("graph.txt");

	short n = 0, x = 0,dist;
	int s=0;

	myfile >> noOfNodes;
	n=noOfNodes;
	for(i = 1; i <= noOfNodes; i++)
	{
		node *node1 = new node();
		node1->val = i;
		node1->next = NULL ;
		arrayA[i] = node1;
	}


	while(myfile >> ver1 >> ver2)
	{

		node* node2 = new node(); 
		node2->val = ver2; 
		node2->next = arrayA[ver1]->next; 
		arrayA[ver1]->next = node2; 
	}

	while(true)
	{	
	const int m =50;
		int A[m];
		for(int i=0;i<m;i++)
			A[i]=0;
		cout << "Enter the vertices to check for reachability: " << endl;

		cin >> ver1 >> ver2>>steps;
		dist=steps;
		int count=0;
		if(dist==0)
		{
			if(ver1==ver2)
			{
				cout<<"REACHABLE IN 0 STEPS"<<endl;
			}
			else
			{
				cout<<"NOT REACHABLE IN 0 STEPS"<<endl;
			}
		}
		if(dist!=0)
		{
		if(ver1 == -1 || ver2 == -1)
			return 0;
		for (short j=1;j<=n;j++)
		{
			t=arrayA[j];
			int temp2=t->val;
		if(ver1==temp2)
		{
			short k;
			for( k=1;t->next!=0;t=t->next,k++)
			{
				A[k]=t->val;
			s++;
			}
			k++;
		A[k]=t->val;
		s++;
		}
		}
		dist--;
		count=1;
		while(dist!=0)
		{

			int b3=1;
			for(short i=1;i<=s;i++)
				{
				if(A[i] == ver2)
					b3=0;
				
				}
			if(b3==1)
				count++;
			int s1=s;
		for(short j=1;j<=s1;j++)
		{
			temp=A[j];
			if(temp<0)
				break;
			node *t3=arrayA[temp];
			while(t3!=0)
			{
				int o=1,b1=1;
				while(o<s)
				{	
					if(A[o]==t3->val)
						{
							o=s;
							b1=0;
						}
				
					else
						{
							o++;
						b1=1;
					}
				}
				if(b1==1)
				{
					A[s]=t3->val;
				s++;
				}
				t3=t3->next;
				}
		
		}
		dist--;
		}
		int b4=0;
		for(short i=1;i<=s;i++)
		{

		if(A[i] == ver2)
		{
			cout << "REACHABLE IN "<<steps<<" steps ,ACTUALLY " <<count<<"  steps "<< endl;
			b4=1;
		break;
		}
		}
		if(b4==0)
		{
		cout << "NOT REACHABLE IN " <<steps<<" STEPS "<< endl;
		}
		}
	}
	
	system("pause");
	return 0;
}

