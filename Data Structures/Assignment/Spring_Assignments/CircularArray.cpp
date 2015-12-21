#include <iostream>

using namespace std;

int * leftshift(int*,int*);
int * rightshift(int*,int*);
void printArray(int* , int* , int );

void main(){
	//..........0 1 2 3 4 5  6  7 th element
	int a[8] = {1,3,5,7,9,11,13,15};
	
	//Store the head pointer
	int* head =  a;
	
	cout<<"Program for shifting an array left or right ,L:left shift R:Right Shift"<< endl;
	cout<<"Given Array :"<<endl;

	for(int i=0;i<8;i++){
		cout << a[i] << " " ;
	}

	cout << endl;

	char input;

	while (true){
		cin >> input;

		if(input == 'l' || input == 'L'){
			head = leftshift(head,a);
		}
		else if(input == 'r' || input == 'R'){
			head = rightshift(head,a);
		}

		printArray(head,a,8);

	}

	system("pause");
}

int * leftshift(int* head,int *a){
	if(head == a+7){
		head = a ;
	}
	else{
		head = head+1 ;
	}

	return head;
}

int * rightshift(int* head,int* a){
	if(head == a){
		head = a+7 ;
	}
	else{
		head = head-1 ;
	}

	return head;
}

void printArray(int * head, int * a, int size){
	int * printHeader = head;//assign another pointer to print

	for(int i=0,count=0;count<size;count++,i++){ 
		cout << *(printHeader+i) << " ";
		if(printHeader+i == a+7){
			printHeader = a;
			i = -1; // because end of the loop i will be i=0; if i=0, i=1 at the start of the loop
		}
	}


}