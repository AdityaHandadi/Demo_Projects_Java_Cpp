#include<iostream>
using namespace std;

int svalue;
struct node 
{ 
	int item; 
	node *l, *r; 
	node(int x)
	{ 
	  item = x; 
	  l = 0; 
	  r = 0; 
	}
};

typedef node* link;

node* h;

node* temp;	

node *root = NULL;

node *nodeLocation = 0;

void inordertraverse(link h)
{ 
    if (h == 0) return;
    inordertraverse(h->l);
    cout << h->item<<"\t"; 
    inordertraverse(h->r);
}

void subordertraverse(link h)
{  

    if (h == 0) return;
	if(h != 0)
	{
	  subordertraverse(h->l);
	  cout << h->item<<"\t"; 
	  subordertraverse(h->r);
	}
}

void search(node *h, int item)
{
	if(h == 0) return;
	if(h->item == item)
	{
		nodeLocation = h;
		temp=h;
		return;
	}

	search(h ->l, item);
	search(h ->r, item);
}

int main()
{
	char choice;
	int val1, val2;
	
	while(1)
	{
		cout << "Enter 'C' to create root ,'L' to create left node,'R' to create right node,'P' to traverse,'S' to traverse through subtree, 'E' to exit : " << endl;
		cin >> choice;
		if (choice=='C' || choice=='c')
		{
			cout<<"\n Enter root value";
			cin >> val1;
			if(root == NULL)
			{
				root = new node(val1);
				cout<<"Root node has been created with value "<< val1 << endl;
			}

			else
				cout<<"Error: Tree is not empty"<<endl;

		}

		else if (choice=='L' || choice=='l')
		{

			cout<<"\n Enter root value and the value to be added in left node"<<endl;
			cin >> val1;
			cin >> val2;
			nodeLocation = 0;
			search(root, val1);
			if(nodeLocation != 0)
			{
				node *t = nodeLocation;
				nodeLocation = 0;
				search(root, val2);
				if(nodeLocation == 0 && t ->l == 0)
				{
					t ->l =  new node(val2);
					cout << "Node has been created with the value: " << val2 << endl;

				}
				else
					cout << "Node already exists" << endl;

			}

			else
				cout << "Node does not exist" << endl;

		}

		else if (choice=='R' || choice=='r')
		{
			cout<<"\n Enter two input values,root value and new value"<<endl;
			cin >> val1;
			cin >> val2;
			nodeLocation = 0;
			search(root, val1);
			if(nodeLocation != 0)
			{
				node *t = nodeLocation;
				nodeLocation = 0;
				search(root, val2);

				if(nodeLocation == 0 && t ->r == 0)
				{					
					t ->r =  new node(val2);
					cout << "Node has been created with the value: " << val2 << endl;

				}

				else
					cout << "Node already exists" << endl;

			}

			else

				cout << "Node does not exist" << endl;

		}

		else if (choice=='P' || choice=='p')

		{ 

			cout<<"\n Values in the trees : ";

			inordertraverse(root);

		}

		else if (choice=='S' || choice=='s')
		{
			cout<<"\n enter subtree value :";
			cin>>svalue;
            search(root,svalue);		
			cout<<"\n Values in the subtree : ";
			subordertraverse(temp);
		}
		else if (choice=='E' || choice=='e')
		{
			break;
		}
		else
		{
			return 0;
		}
		cout<<"\n";

	}

system("pause");

return 0;

}



