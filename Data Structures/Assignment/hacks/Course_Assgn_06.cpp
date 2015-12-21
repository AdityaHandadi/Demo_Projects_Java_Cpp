#include<iostream>

using namespace std;

class STACK 
  {
    private:
      struct node 
        { int item; node* next; 
          node(int x, node* t) 
            { item = x; next = t; } 
        };
      typedef node *link;
      link head;
    public:
      STACK(int)
        { head = 0; }
      int empty() const
        { return head == 0; }
      void push(int x)
        { head = new node(x, head); }
      int pop()
        { int v = head->item; link t = head->next;
          delete head; head = t; return v; }
      void peekAll()
      { 
          /* implement this part */
		  link temp=head;
		  while(temp!=0){
			  cout<<temp->item<<' ';
			  temp=temp->next;
		  }
      } 
  };



/* LIST OF VARIABLES FOR THE STACK */
STACK* stPtr=new STACK(100);

int main()
{
 
   char ch;

   cout<<"Course Assignment 06:Stack pointer simulation using linked list"<<endl;
   cout<<" This program assumes P for PUSH , R for POP and E for check Empty,K for Print ALL, Upper case only , input size 100 "<<endl;

   cin >> ch;

   while(ch == 'P' || ch == 'R' || ch == 'E' || ch == 'K')
   {
       if(ch == 'P')
       {
		   //push into stack
		   int val;
		   cin>>val;
		   stPtr->push(val);
       }
       else if(ch == 'R'){
		  //pop from stack
		   int ret=stPtr->pop();
		   if(ret!=0)
		    cout<<"POP from stack :"<<ret<<endl;
		   else
			cout<<"STACK IS EMPTY"<<endl;
	   }
       else if(ch=='E'){
		  //check if stack is empty
		   int checkEmpty=stPtr->empty();
		   if(checkEmpty)
			   cout<<"STACK IS EMPTY"<<endl;
		   else
			   cout<<"STACK NOT EMPTY"<<endl;
	   }
	   else if(ch=='K'){
		  //print all values from stack
		   stPtr->peekAll();
	   }
       cout << endl;
       cin >> ch;
   }

   cout << endl;
   system("pause");
   return 0;
}



