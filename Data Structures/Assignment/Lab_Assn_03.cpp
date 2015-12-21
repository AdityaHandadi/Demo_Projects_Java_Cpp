/* ATTACHMENT 1: */ 

#include <iostream>

using namespace std;

/*
This program segment was written for CSCI 520L Lab and CSCI 520.001 Course Assignment #3

Problem AV10: Return the average of the last 10 input numbers 
Input: Positive real numbers (entered one at a time)
Output: After every new input, the new average of the last 10 numbers entered will be printed
								
You are asked to write a C++ program for Problem AV10. You are required to use a circular array to create a circular list with which you keep track of the last 10 inputs. 

*/

static const int n=10;	/* circular list size limit */ 

int cArray[10];
int size;

int * createCircularArray()
{
	cout<<"LAB ASSIGNMENT 03 : PROGRAM TO CALCULATE AVG OF LAST 10 ELEMENTS OF AN ARRAY"<<endl;

	cout<<"Enter the no of elements you are going to enter"<<endl;;

	cin>>size;
	
	int *inArray = new int[size];

	int temp=1;
	int index=0;
	
	cout<<"Enter Integers :";
	int inpIndex=0;

	for(int index=0;index<size;index++){
		cin>>inArray[inpIndex];
		inpIndex++;

		if(inpIndex==10)
			inpIndex=0;
	}

	return inArray;
}

//This function assumes minimum number of elements entered is 10
int calculateAverage(int * inArray){

	int avgSize=10;

	int index=0;
	int sum=0;

	while(index<10 ){
		sum=sum+inArray[index];
		index++;
	}

	int average=sum/avgSize;

	return average;
}

int main()
{ 
	
	//Call the function to create the circular ArrayList;
	int *inArray=createCircularArray();

	for(int i=0;i<10;i++){
		cout<<"VALUES : "<<inArray[i]<<endl;
	}

	//Function that calculates the average of last 10 elements
	int average=calculateAverage(inArray);

	cout<<"Average of last 10 numbers is : "<<average<<endl;

	system("pause");

  return 0;
}


