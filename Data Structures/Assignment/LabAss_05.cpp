#include <iostream>
#include <fstream>

std::ifstream infile("thefile.txt");

using namespace std;


int** adjacencyMatrix;
int vertex;


void createGraph(int vertex){
 adjacencyMatrix = new int*[vertex];
     for (int i = 0; i < vertex; i++) {
        adjacencyMatrix[i] = new int[vertex];
         for (int j = 0; j < vertex; j++){
            adjacencyMatrix[i][j] = 0;
		 }
     }
}

void addEdge(int i, int j,int vertex) {
       if (i >= 0 && i < vertex && j > 0 && j < vertex) {
             adjacencyMatrix[i][j] = true;
             adjacencyMatrix[j][i] = true;
       }
  }


int main(){

int a=0, b=0;
	while (infile>>a>>b||infile>>a)
	{
		if(a!=0&&b==0){
			vertex=a;
			createGraph(vertex);
		}
		else if(a!=0 && b!=0){
			addEdge(a,b,vertex);
		}
		else{
			cout<<"FILE READ ERROR"<<endl;
			break;
		}
		
	}
	
	cout<<"GRAPH G CREATED"<<endl;
	
	a=0,b=0,int k=0;

	
	
}