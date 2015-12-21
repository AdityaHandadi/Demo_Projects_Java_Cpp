/* Program to find repeated value in an integer array of size 20 */

#include<iostream>

using namespace std; 

/* Function that performs the main logic */
int findRepVal(int arr[20],int noOfEle);

int main(){

	/* Initialising the array of integer,size 20*/
	int inArr[20]={};

	cout<<"This program will find one of the most repeated value of integers"<<endl;
	cout<<"Enter 20 Integers :";

	for(int index=0;index<20;index++){
		cin>>inArr[index];
	}

	//Calculates the size of the entered array
	int noOfElm=sizeof(inArr)/sizeof(*inArr);

	int elVal=0;

	cout<<"The length of entered array is: "<<noOfElm<<endl;

	//Call the funcion to find the repeated values
	elVal=findRepVal(inArr,noOfElm);

	cout<<"The Repeated Value is "<<elVal<<endl;

	system("pause");

	return 0;

}

/* This function checks one of the most repeated values
    in the given array of integer */
int findRepVal(int arr[20],int noOfEle){
	int count=1;
	int maxCnt=0;
	int elVal=0;

	 for(int i=0;i<noOfEle;i++){
		for(int j=i+1;j<noOfEle;j++){
			if(arr[i]==arr[j])
				count++;
			if(count>maxCnt){
				maxCnt=count;
				elVal=arr[i];
			}

		}
	}

	 return elVal;
}
