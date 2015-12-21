#include <iostream>
#include <fstream>
#include <string>
using namespace std;
　
struct node
{
int val;
node * next;
};
node *adjlist[5];
int count1;
void buildadjlist(node* adjlist[],int i,int j)
{
	node* temp= new node;
	node* t=new node;
	t=adjlist[i];
	temp->next=0;
	temp->val=j;
	if(adjlist[i]->next==0)
	{
		adjlist[i]->next=temp;
	}
	else
	{
		while(t->next!=0)
		{
			t=t->next;
		}
	t->next=temp;
	}
}
　
　
bool checkvertex(int i,int j,int k)
{
	node* t= new node;
	int i2;
	bool flag=false;
	if(i==j)
		{
		flag= true;
		return flag;
		}
		else
		{
		t=adjlist[i];
			if(k==1)
			{
				while(t->next!=0)
				{
				t=t->next;
				if(t->val==j)
				{
				flag= true;
				return flag;
				}
				//t=t->next;
				}
			flag=false;
			return flag;
			}
		}		
		else
		{
		while(k-1>0)
		{
			t=adjlist[i];
			while(t->next!=0)
			{
			i2=t->next->val;
			count1=count1+1;
			flag=checkvertex(i2,j,k-1);
			if(flag==true)
			return flag;
			t=t->next;
		}
		k=k-1;
		}
		return flag;
	     }
		}
}
void printadjlist()
{
	node* t= new node;
		for(int i=1;i<=5;i++)
		{
			t=adjlist[i];
			cout<< "AdjList["<<i<<"] ->";
				while(t->next!=0)
				{
				t=t->next;
				cout<<t->val<<" ";
				}
		cout<<endl;
		}
}
　
int main()
{
int nodes,i,j,k,n;
bool flag=false;
cout<<"enter number of nodes"<<endl;
cin>>n;
	for(i=1;i<=n;i++)
	{
	adjlist[i]=new node;
	adjlist[i]->next=0;
	}
cout<<"Enter the edges"<<endl;
cin>>i>>j;
	while(i!=-1&&j!=-1)
	{
	buildadjlist(adjlist,i,j);
	cin>>i>>j;
	}
cout<<"Adjacency List has been developed and adjacency List is"<<endl;
printadjlist();
cout<<"Enter the vertices and number of steps to reach"<<endl;
cin>>i>>j>>k;
count1=0;
while(i!=-1&&j!=-1)
	{
	flag=false;
	flag=checkvertex(i,j,k);
	if(flag)
	{
		if(k=count)
			cout<<	"Vertex :"<<i<<" to vertex :"<<j<<" can be reached in "<<k<<" steps "<<endl;
		else
			cout<<"Vertex :"<<i<<" to vertex :"<<j<<" can be reached in "<<k<<" steps "<<"actually "<<count1<<endl;
	}
else
	cout<<"Vertex :"<<i<<" to vertex :"<<j<<" cannot be reached in "<<k<<" steps "<<endl;
	cout<<endl<<"Enter the vertices and number of steps to reach"<<endl;
	cin>>i>>j>>k;
}

system("pause");
}
