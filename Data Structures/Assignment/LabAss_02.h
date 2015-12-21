/* ATTACHMENT 1: */ 

//#include <stdio>
#include <iostream>

using namespace std;

static const int n=1000;	/* vector size limit */ 


struct element {
     int x;    /* original index of non-zero array element */
     int val ; /* integer non-zero value at index x */
  } ;


int row[n] ;
int col[n] ;

int i;

void generate_row_and_col() {
 for (i=1; i<n/4; i++) row[i]=4*i;
 row[0]=1;
 row[n/4]=-1; 
 for (i=1; i<n/5; i++) col[i]=5*i;
 col[0]=1; 
 col[n/5]=-1; 
}

int agreement()
{
/* calculate the agreement for row and col;
   output the result    
*/ 
	int row_index=0;
	int col_index=0;
	int sum=0;

	int row_lim=0;
	int col_lim=0;

	for(int i=0;i<n-1;i++){
		if(row[i]==-1)
			break;
		row_lim++;
	}
	for(int j=0;j<n-1;j++){
		if(col[j]==-1)
			break;
		col_lim++;
	}


	cout<<"ROW LIM"<<row_lim<<endl;
	cout<<"COL LIM"<<col_lim<<endl;

	while(row_index<row_lim-1||col_index<col_lim-1){
		if(row[row_index]==col[col_index]){
			sum++;
			row_index++;
			col_index++;
		}
		if(row[row_index]<col[col_index]){
			row_index++;
		}
		if(row[row_index]>col[col_index]){
			col_index++;
		}
	}

	cout<<"SUM == : "<<sum<<endl;


	return sum;
}

int main()
{ 

  generate_row_and_col() ;
   
  agreement();

  system("pause");

  return 0;
}
