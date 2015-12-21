/* Program to find repeated value in an integer array of size 20 */

#include<iostream>

using namespace std; 

/* Function that performs the main logic */
void findRepVal(int arr[20],int noOfEle,int outArr[20]);
void sort(int arr[20]);

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
	
	//cout<<"The length of output array is: "<<noOfElm<<endl;
	//cout<<"Elements are "<<endl;
	
	/*for(int index_2=0;index_2<noOfElm;index_2++){
		cout<<outArr[index_2]<<endl;
	}*/

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
	int temp;

	//Sort the array-- Bubble SOrt
	for(int a = 0; a < noOfEle; a++)
	{
		for (int b = 0; b < noOfEle-1; b++)
        {
            if (arr[b] > arr[b+1])
			{
				temp = arr[b];
				arr[b] = arr[b+1];
				arr[b+1] = temp;
			}
        }/*End inner for loop*/
	}/*End outer for loop*/


	 for(int i=0;i<noOfEle;i++){
		 bool flag=true;
		for(int j=i+1;j<noOfEle;j++){
			if(arr[i]==arr[j]){
				//outArr[index]=arr[i];
				//index++;
				flag=false;
				break;
				}
		}
		if(flag==true){
			//outArr[index]=arr[i];
			//index++;
			cout<<"Unique Elements are " << arr[i]<<endl;
		}

	}

}





