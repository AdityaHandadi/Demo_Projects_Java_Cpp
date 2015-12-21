/*
50135734
Aditya Prasanna Handadi
*/

#include<iostream>
#include<string>
#include<cstdlib>
using namespace std;

/* node definitions for L */
struct node
{
   int index;
   int data;
   node* next;
   node(int idx,int val,node *nxt){
	   index=idx;
	   data=val;
	   next=nxt;
   }
};
typedef node* link;

int A[100];

link buildList();
void insert();
void printArray(link head);
void resetArray(link *head);




void insert(link *head, int index, int value)
{
   if(index < 0 || index >= 100)
   {
       cout << "The index is out of the range!" << endl;
       return;
   }

   // insert in to the array
   A[index] = value;

   //Create a buffer node
   link buffNode = new node(index,value,NULL);

   link dum_head = NULL;
   link dum_tail = *head;
   while(dum_tail != NULL && dum_tail->index < index)
   {
       dum_head = dum_tail;
       dum_tail = dum_tail->next;
   }

   if(dum_tail != NULL && dum_tail->index == index)
   {
       dum_tail->data = value;
   }
   else if(dum_head == NULL) // insert at first
   {
       buffNode->next = *head;
       *head = buffNode;
   }
   else if(dum_tail == NULL) // insert at last
   {
       dum_head->next = buffNode;
       buffNode->next = NULL;
   }
   else // insert at other location
   {
       dum_head->next = buffNode;
       buffNode->next = dum_tail;
   }
}



int main()
{
   // build an empty list
   link L = buildList();
   char ch;

   cout<<"Lab Assignment 04: Simulation of an array using linked list"<<endl;
   cout<<" This program assumes A for insert , T for print and R for reset, Upper case only , input size 100 "<<endl;
   cout << "A i x : Set A[i]=x" << endl;

   cin >> ch;

   while(ch == 'A' || ch == 'T' || ch == 'R')
   {
       if(ch == 'A')
       {
           int index, value;

           cin >> index >> value;

           insert(&L, index, value);
       }
       else if(ch == 'T')
           printArray(L);
       else
           resetArray(&L);

       cout << endl;
       cin >> ch;
   }

   cout << endl;
   system("pause");
   return 0;
}




link buildList()
{
    node* head = NULL;

   for(int i = 0; i < 100; i++)
       A[i] = NULL;

    return head;
}


void printArray(link head)
{
   if(head == NULL)
       cout << "No data in A now" << endl;
   else
   {
       link dum_tail = head;
       while(dum_tail != NULL)
       {
           cout << "index: " << dum_tail->index << " value: " << A[dum_tail->index] << endl;
           dum_tail = dum_tail->next;
       }
   }
}



void resetArray(link *head)
{
   *head = buildList();

   for(int i = 0; i < 100; i++)
       A[i] = NULL;

   cout << "A has been reset" << endl;
}
