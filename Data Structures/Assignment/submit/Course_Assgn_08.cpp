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

class QUEUE
  {
    private:
      link *q; int N, head, tail;
    public:
      QUEUE(int maxN)
        { q = new link[maxN+1]; 
          N = maxN+1; head = N; tail = 0; }
      int empty() const
        { return head % N == tail; }
      void put(link item)
        { q[tail++] = item; tail = tail % N; }
      link get()
        { head = head % N; return q[head++]; }
  };

void traverse(link h)
  { 
	QUEUE q(100);
    q.put(h);
    while (!q.empty())
      {
        h = q.get(); cout << h ;
        if (h->l != 0) q.put(h->l); 
        if (h->r != 0) q.put(h->r); 
      }
  }

void print(link h)
  { 
	QUEUE q(100);
    q.put(h);
    while (!q.empty())
      {
		  h = q.get(); 
		  cout << h->item <<" ";
        if (h->l != 0) q.put(h->l); 
        if (h->r != 0) q.put(h->r); 
      }
  }

link createRoot(int val,link head){
	if(head==0){
		link newNode=new node(val);
		head=newNode;
	}
	return head;
}

void insertLeft(int val,int searchVal,link h){
	if(h==0)
		return;

	else{
		QUEUE q(100);
		q.put(h);
		while (!q.empty())
		  {
			 h = q.get(); 
			 //add logic here
			 if(h->item==searchVal){
				 link newNode=new node(val);
				 h->l=newNode;
				 cout<<"Node has been added"<<endl;
				return;
			 }
			 if (h->l != 0) q.put(h->l); 
			 if (h->r != 0) q.put(h->r); 
		  }
	}

}



void insertRight(int val,int searchVal,link h){
	if(h==0)
		return;

	else{
		QUEUE q(100);
		q.put(h);
		while (!q.empty())
		  {
			 h = q.get(); 
			 //add logic here
			 if(h->item==searchVal){
				 link newNode=new node(val);
				 h->r=newNode;
				 cout<<"Node has been added"<<endl;
				return;
			 }
			 if (h->l != 0) q.put(h->l); 
			 if (h->r != 0) q.put(h->r); 
		  }
		}
}

void printVal(link h,int val){
	if(h==0)
		return;

	else{
		QUEUE q(100);
		q.put(h);
		while (!q.empty())
		  {
			 h = q.get(); 
			 //add logic here
			 if(h->item==val){
				 print(h);
			 }
			 if (h->l != 0) q.put(h->l); 
			 if (h->r != 0) q.put(h->r); 
		  }
	}
}


int main()
{
 
   char ch;


   cout<<"Course Assignment 08:Binary Trees"<<endl;
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
		   print(head);
	   }
	   else if(ch=='S'){
		   //print after node S
		   //int val=0;
		   //cin>>val;
		   //printAfterNode(head,val);
		   int val;
		   cin>>val;
		   printVal(head,val);
	   }

	    cout << endl;
       cin >> ch;
   }

   cout << endl;
   system("pause");

}


