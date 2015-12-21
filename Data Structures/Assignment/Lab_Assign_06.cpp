/*CWID: 50135734
  Aditya Prasanna Handadi */

#include<iostream>
#include<string>
#include<cstdlib>

using namespace std;

class STACK 
  {
    private:
      int *s; int N;
    public:
      STACK(int maxN)
        { 
		  s = new int[maxN]; 
		  N = 0;
		}
      int empty() const
        { 
		  return N == 0;
	    }
      void push(int item)
        { 
		  s[N++] = item;
	    }
       int peekAll() 
      {
         /* implement this part */
		  int idx=N;
		  if(idx==0){
			  cout<<"STACK IS EMPTY"<<endl;
		  }
		  while(idx!=0){
			  cout<<s[--idx]<<' '<<endl;
		  }
		  return N;
       }
      int pop()
        {
			if(N>0)
			  return s[--N];
			else if(N<=0)//tells if stack is empty and restricts any more POP
			  return 0;
	    }
  };

/* LIST OF VARIABLES FOR THE STACK */
STACK* stPtr=new STACK(100);

int main()
{
 
   char ch;

   cout<<"Lab Assignment 06:Stack pointer simulation using an array"<<endl;
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
