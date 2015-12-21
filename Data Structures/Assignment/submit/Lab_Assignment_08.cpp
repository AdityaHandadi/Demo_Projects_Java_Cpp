#include<iostream>

using namespace std;

struct node 
  { int item; node *l, *r; 
    node(int x)
      { item = x; l = 0; r = 0; }
  };
typedef node* link;

link head=0;
link temp=head;
node *nodeLocation = 0;


void inordertraverse(link h)
  { 
    if (h == 0) return;
    inordertraverse(h->l);
    cout << h->item <<" "; 
    inordertraverse(h->r);
  }

link createRoot(int val,link head){
	if(head==0){
		link newNode=new node(val);
		
		head=newNode;
	}
	
	return head;
}

void search(link head, int item)
{
	if(head == 0) return;
	if(head->item == item)
	{
		nodeLocation = head;
		temp=head;
		return;
	}

	search(head ->l, item);
	search(head ->r, item);
}


void insertLeft(int val,int searchVal,link root){
	nodeLocation = 0;
	search(root, searchVal);

	
	if(root==0)
		return ;
	
	if(root->item==searchVal){
		if(root->l==0 && root->item==searchVal){
				link newNode=new node(val);
				newNode->l=0;
				newNode->r=0;
				root->l=newNode;
				cout<<"Node has been added"<<endl;
				return;
			}
			else{
				cout<<"Error: Tree not empty"<<endl;
			}
	}

	insertLeft(val,searchVal,root->l);
	insertLeft(val,searchVal,root->r); 
}


void insertRight(int val,int searchVal,link root){
	nodeLocation = 0;
	search(root, searchVal);
	
	if(root==0)
		return ;
	

	if(root->item==searchVal){
		if(root->r==0 && root->item==searchVal){
			link newNode=new node(val);
			newNode->l=0;
			newNode->r=0;
			root->r=newNode;
			cout<<"Node has been added "<<endl;
			return ;
		}
		else{
			cout<<"Error: Tree not empty"<<endl;
		}
	}
	insertRight(val,searchVal,root->l);
	insertRight(val,searchVal,root->r);
}

void printNodes(link root){
	if(root==0)
		return;
	if(root->l==0 && root->r==0)
		return;
	cout<<root->item<<" ";

	printNodes(root->l);
	printNodes(root->r);
}

void printAfterNode(link root,int val){
	if(root==0)
		return ;
	if(root->l==0 && root->r==0)
		return;

	if(root->item==val){
		inordertraverse(root);
	}

	printAfterNode(root->l,val);
	printAfterNode(root->r,val);
}

int main()
{
 
   char ch;


   cout<<"Lab Assignment 08:Binary Trees"<<endl;
   cout<<" This program assumes inputs C for creating root,L for adding node on left, R for adding root on right,S for printing node after value in input <x> "<<endl;

   cin >> ch;

   while(ch == 'C' || ch == 'L' || ch == 'R' || ch == 'P'|| ch=='S')
   {

	   if(ch=='C'){
		    //create root node if root does not exists.
		    int val=0;
		    cin>>val;
			if(head==0){
				head=createRoot(val,head);
			}
			else{
				cout<<"Error: Tree is not empty"<<endl;
			}
	   }
	   else if(ch=='L'){
			//insert new node on the LEFT of given node
		   int val=0;
		   int searchVal=0;
		   cin>>searchVal>>val;

		   insertLeft(val,searchVal,head);
		   
	   }
	   else if(ch=='R'){
			//insert new node on the RIGHT of given node
		    int val=0;
		   int searchVal=0;
		   cin>>searchVal>>val;

		   insertRight(val,searchVal,head);
	   }
	   else if(ch=='P'){
		   //print All nodes
		   //printNodes(head);
		   inordertraverse(head);
	   }
	   else if(ch=='S'){
		   //print after node S
		   int val=0;
		   cin>>val;
		   printAfterNode(head,val);
	   }

	    cout << endl;
       cin >> ch;
   }

   cout << endl;
   system("pause");

}