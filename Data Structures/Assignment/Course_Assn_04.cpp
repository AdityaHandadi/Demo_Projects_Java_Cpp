/*CWID: 50135734
  Aditya Prasanna Handadi */

#include<iostream>
#include<string>
#include<cstdlib>

using namespace std;

int a[100][1];
void append(int val);


void append(int val){
	int i=0;
	while(a[i][0]!=0){		
		i++;
	}
	if(a[i][0]==0){
		a[i-1][1]=i;
		a[i][0]=val;
		a[i][1]=0;
	}
}

void printAll(){
	int i=0;
	while(a[i][0]!=0){
		if(a[i][0]!=-1){
		  cout<<a[i][0]<<' ';
		}
	  i++;
	}
}

void insert(int val,int searchVal){
	int i=0;
	
	while(a[i][0]!=searchVal){
		i++;
		if(a[i][0]==0)
			break;
	}
	if(a[i][0]==0){
		cout<<"NO VALUE FOUND TO INSERT AFTER "<<searchVal<<endl;
	}
	else if(a[i][0]==searchVal){
		int j=i;
		while(a[j][0]!=0){
			j++;
		}
		//Shiting all the values to next element
		for(int k=j;k>i;k--){
			if(k+1>=100)
				break;
			
			a[k+1][0]=a[k][0];
			a[k+1][1]=a[k][1];
		}
		a[i][1]=i+1;
		a[i+1][0]=val;
		a[i+1][1]=i+2;
	}
}

void reverse(){
	int i=1,n=0;
	int temp=0;

	while(a[n][1]!=0){
			n++;
		}
	/* if(a[n][0]==-1)
		cout<<" NODE EMPTY, CANNOT REVERSE "<<endl;
	else{
		while(i!=n && i<n){
			//SWAP THE i and n values
			temp=a[i][0];
			a[i][0]=a[n][0];
			a[n][0]=temp;
		}
	}	*/
	while(i!=n && i<n){
			//SWAP THE i and n values
			temp=a[i][0];
			a[i][0]=a[n][0];
			a[n][0]=temp;
			i++;
			n--;
		}
}

void truncate(int searchVal){
	int i=0;
	
	while(a[i][0]!=searchVal){
		i++;
		if(a[i][0]==0)
			break;
	}

	a[i][1]=0;
	i++;
	while(a[i][0]!=0){
		a[i][0]=a[i][1]=0;
		i++;
	}
}

int main(){
   a[0][0]=-1;
   a[0][1]=-1;

   char ch;

   cout<<"Course Assignment 04:Stack pointer simulation using an array"<<endl;
   cout<<" This program assumes A for Append, R for POP and E for check Empty,K for Print ALL, Upper case only , input size 100 "<<endl;

   cin >> ch;

   while(ch == 'A' || ch == 'T' || ch == 'I' || ch == 'R'|| ch =='D')
   {
       if(ch == 'A')
       {
		 //Append
		 int val;
		 cin>>val;
		 append(val);
       }
       else if(ch == 'T'){
		 printAll();
	   }
       else if(ch=='I'){
		  int val,searchVal=0;
		  cin>>val>>searchVal;
		  insert(val,searchVal);
	   }
	   else if(ch=='R'){
		  //reverse the list
		   reverse();
	   }
	   else if(ch=='D'){
		   //truncate
		   int searchVal;
		   cin>>searchVal;
		   truncate(searchVal);
	   }
       cout << endl;
       cin >> ch;
   }

   cout << endl;
   system("pause");
   return 0;

}