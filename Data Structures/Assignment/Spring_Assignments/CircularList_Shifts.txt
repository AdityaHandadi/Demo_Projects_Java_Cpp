#include <iostream>

using namespace std;

struct node{
	int val;
	node * next;
	node(int x){
		val=x;
	}
};

typedef node* link;

//creates a linked list from an array
link createCircularList(int*,int);
void printCircularList(link head);
link leftShift(link head);
link rightShift(link head,int size);

int main(){
	int a[8] = {1,1,1,1,0,0,0,0};

	link head = createCircularList(a,8);
	printCircularList(head);
	cout << " Circular Linked List Created " << endl;

	cout << " L: left shift, R: right shift " << endl;
	char input;
	while(true){
		cin >> input;
		if(input == 'L' || input =='l'){
			head = leftShift(head);
		}
		if(input == 'R' || input == 'r'){
			head = rightShift(head,8);
		}

		printCircularList(head);
	}
	

	system("pause");
	return 0;
}

/* This function creates a circular list given an integer array and its size
 @param a, size
*/
link createCircularList(int a[],int size){
	link head = NULL;
	link temp = head;
	for(int i=0;i<size;i++){
		if(head == NULL){
			head = new node(a[i]);
			head->next = NULL;
			temp = head;
		}
		else{
			link nnode = new node(a[i]);
			temp->next=nnode;
			temp = temp->next;
			nnode->next = NULL;
		}
	}
	//Making the linked list circular
	temp->next = head;

	return head;
}

void printCircularList(link head){
	link temp = head;
	while(temp->next != head){
		cout << temp->val << " " ;
		temp = temp->next;
	} 
	if(temp->next == head)
		cout << temp->val << " " ;

	cout << endl;
}

link leftShift(link head){
	return head->next;
}

link rightShift(link head,int size){
	//link temp = head;
	for(int i=0;i<size-1;i++){
		head = head->next;
	}

	return head;
}