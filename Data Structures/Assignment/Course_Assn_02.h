/* Program to find repeated value in an integer array of size 20 */

#include<iostream>

using namespace std; 

/* Function that performs the main logic */
int findRepVal(int arr[20],int noOfEle);

int main(){

	/* Initialising the array of integer,size 20*/
	//for input
	int inArr[20]={};
	//for output
	int outArr[20]={};

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
	findRepVal(inArr,noOfElm,outArr);
	
	noOfElm=sizeof(outArr)/sizeof(*outArr);
	
	cout<<"The length of output array is: "<<noOfElm<<endl;
	cout<<"Elements are "<<endl;
	
	for(int index_2=0;index_2<noOfElm;index_2++){
		cout<<outArr[index_2];
	}

	system("pause");

	return 0;

}

/* This function checks one of the most repeated values
    in the given array of integer */
void findRepVal(int arr[20],int noOfEle,int outArr[20]){
	int count=1;
	int maxCnt=0;
	int elVal=0;
	int index=0;

	 for(int i=0;i<noOfEle;i++){
		for(int j=i+1;j<noOfEle;j++){
			if(arr[i]!=arr[j]){
				outArr[index]=arr[i];
				index++;
				}
			if(count>maxCnt){
				maxCnt=count;
				elVal=arr[i];
			}

		}
	}
}
