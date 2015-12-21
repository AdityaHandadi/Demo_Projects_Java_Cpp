#include<iostream>

using namespace std;

class QUEUE
  {
    private:
      int *q; int N, head, tail;
    public:
      QUEUE(int maxN)
        { q = new int[maxN+1]; 
          N = maxN+1; head = N; tail = 0; }
      int empty() const
        { return head % N == tail; }
      void put(int item)
        { q[tail++] = item; tail = tail % N; }
      int get()
        { head = head % N; return q[head++]; }
     void peekAll() 
       { /* implement this part */
			for(int i=head;i<tail;i++){
				cout<<q[i]<<" ";
			}
       } 
  };

/* LIST OF VARIABLES FOR THE QUEUE */
QUEUE* qPtr=new QUEUE(100);

int main()
{
 
   char ch;

   cout<<"Course Assignment 07:QUEUE simulation using linked list"<<endl;
   cout<<" This program assumes P for put , R for get and E for check Empty,K for Print ALL, Upper case only , input size 100 "<<endl;

   cin >> ch;

   while(ch == 'P' || ch == 'R' || ch == 'E' || ch == 'K')
   {
       if(ch == 'P')
       {
		   //put into QUEUE
		   int val;
		   cin>>val;
		   qPtr->put(val);
       }
       else if(ch == 'R'){
		  //get from QUEUE
		   int ret=qPtr->get();
		   if(ret!=0)
		    cout<<"get from QUEUE :"<<ret<<endl;
		   else
			cout<<"QUEUE IS EMPTY"<<endl;
	   }
       else if(ch=='E'){
		  //check if QUEUE is empty
		   int checkEmpty=qPtr->empty();
		   if(checkEmpty)
			   cout<<"QUEUE IS EMPTY"<<endl;
		   else
			   cout<<"QUEUE NOT EMPTY"<<endl;
	   }
	   else if(ch=='K'){
		  //print all values from QUEUE
		   qPtr->peekAll();
	   }
       cout << endl;
       cin >> ch;
   }

   cout << endl;
   system("pause");
   return 0;
}

