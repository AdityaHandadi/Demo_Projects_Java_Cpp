#include<iostream>
using namespace std;

struct link
{
     int x;    
     link *next ; 
};

int caclulateAvg(link *head)
{
int count=1,sum=0,i=0;
int num;
cout<<"Enter new number"<<endl;
link *t=head;
link *temp=new link;
while(true)
{
	cout<<"Course Assignment #03 : Circular Linked List average calculation" <<endl;
    cout<<"Enter numbers with last number 0" <<endl;
    cin>>num;
    if(num!=0)
    {
    		//If the head next is the last element
            if(head->next==0)      
            {
                head->x=num;
                head->next=head;
                t=head;
                sum=num;
                cout<<"Average:"<<sum<<endl;
                i++;
            }
			//If the head next is not the last element
            else    
            {
				/* Assuming the size of circular list is 10*/
                if(i<10)    
                {
                    i++;
                    temp=new link;
                    temp->x=num;
                    temp->next=0;
                    t->next=temp;
                    t=t->next;
                    sum=sum+num;
                    cout<<"Average is "<<sum/i<<endl;
                }
				//If 10th element then put in first as indexing
                if(i==10)
                {
                    t->next=head;
                    t=t->next;
                    sum=sum-(t->x);
                    t->x=num;
                    sum=sum+num;
                    cout<<"Average is "<<sum/10<<endl;
                    i++;                    
                }
				
                if(i>10)
                {
                    t=t->next;
                    sum=sum-(t->x);
                    t->x=num;
                    sum=sum+num;
                    cout<<"Average is "<<sum/10<<endl;
                    i++;
                }
            }
    }
    else if (num==0)
    return 0;
    }    
}

int main()
{ 
int avg;
link *head=new link;                //Creating head node for linked list array1;
head->next=0;
avg=caclulateAvg(head);
//system("pause");
}