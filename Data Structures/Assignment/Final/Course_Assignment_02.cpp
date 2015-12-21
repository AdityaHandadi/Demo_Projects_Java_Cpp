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
	element row_array[n/4];
	int col_index=0;
	element col_array[n/5];
	int sum=0;

	int row_lim=0;
	int col_lim=0;

	for(int i=0;i<n/4-1;i++){
		if(row[i]==-1)
			break;
		row_lim++;
		row_array[row_index].x=i;
		row_array[row_index].val=row[i];
		
		row_index++;
		
	}
	for(int j=0;j<n/5-1;j++){
		if(col[j]==-1)
			break;
		col_lim++;
		col_array[col_index].x=j;
		col_array[col_index].val=col[j];
		
		col_index++;
	}

	//POC used for debugging
	//cout<<"ROW LIM :"<<row_lim<<endl;
	//cout<<"COL LIM :"<<col_lim<<endl;
	
	//cout<<"COL ARAY"<<sizeof(row_array)/sizeof(*row_array)<<endl;
	//cout<<"COL ARAY"<<sizeof(col_array)/sizeof(*col_array)<<endl;
	
	int row_in=0;
	int col_in=0;

	
	while(row_in<row_lim-1||col_in<col_lim-1){
		if(row_array[row_in].val==col_array[col_in].val){
			sum++;
			row_in++;
			col_in++;
		}
		if(row_array[row_in].val<col_array[col_in].val){
			row_in++;
		}
		if(row_array[row_in].val>col_array[col_in].val){
			col_in++;
		}
	}

	cout<<"SUM == : "<<sum<<endl;
	
	return sum;
}

int main()
{ 

  generate_row_and_col() ;
   
  agreement();

  //system("pause");

  return 0;
}
