#include<iostream>
#include<fstream>

using namespace std;

//create datatype for the vertex Node.
struct NodeList
{
	int Info;
	NodeList* Node;
	struct EdgeList* Edge;
};
typedef NodeList* L_Node;

//create datatype for the Edge Node.
struct EdgeList
{
	NodeList *Node;
	EdgeList *Edge;
};
typedef EdgeList* E_Node;

NodeList *Start;

//Create Node List.
void createNodeList(int n)
{
	NodeList* nNode;
	NodeList* Temp = NULL;
	int i;
	//if number of vertex is zero, the graph is empty.
	if (n == 0)
	{
		cout << "Graph is empty";
	}
	else
	{
		for (i = 1; i <= n; i++)
		{
			//create Vertex Node.
			nNode = (NodeList *)malloc(sizeof(NodeList));
			//set the value of the node
			nNode->Info = i;
			nNode->Edge = NULL;

			//insert the node at the appropriate position
			nNode->Node = NULL;
			// if it is the first vertex node to be inserted.
			// start will point to the node.
			//Temp will always point to the last inserted node.
			if (i == 1)
			{
				Temp = nNode;
				Start = nNode;
			}
			//else the node is inserted at the end of the vertex list.
			else
			{
				Temp->Node = nNode;
				Temp = nNode;
			}
		}
	}
}

void insertEdge(int firstVertex, int secondVertex)
{
	NodeList* Temp = Start;
	EdgeList* Temp2;
	// create the edge node.
	EdgeList* nNode = (EdgeList *)malloc(sizeof(EdgeList));
	nNode->Edge = NULL;
	nNode->Node = NULL;

	//Temp will traverse the vertex node for which edge to be added.
	while (Temp->Info != firstVertex)
	{
		Temp = Temp->Node;
	}
	// if it is first edge for the node then the edge portion of the vertex node will point to the new edge node.
	if (Temp->Edge == NULL)
	{
		Temp->Edge = nNode;
	}
	else
	{
		// else the edge node will be added to the end of the edge list.
		Temp2 = Temp->Edge;
		while (Temp2->Edge != NULL)
		{
			Temp2 = Temp2->Edge;
		}
		Temp2->Edge = nNode;
	}
	// now the edge node will point the adjacent vertex node for the vertex node for which the edge is to be added.
	Temp = Start;
	while (Temp->Info != secondVertex)
	{
		Temp = Temp->Node;

	}

	nNode->Node = Temp;
}


void reachableVertex(int B[], int firstVertex, int count)
{
	// if there is still no path between the node or the previous path is longer than the current one, start the loop.
	if (B[firstVertex - 1]<0 || B[firstVertex - 1]>count)
	{
		// set the count value to be the no of steps to reach the node.
		B[firstVertex - 1] = count;
		NodeList *Temp = Start;

		// start from the starting vertex and add the no of steps to each adjacent node. 
		while (Temp->Info != firstVertex)
		{
			Temp = Temp->Node;
		}
		EdgeList *Temp2 = Temp->Edge;
		// for each adjacent node repeat the process.
		while (Temp2 != NULL)
		{
			reachableVertex(B, Temp2->Node->Info, count + 1);
			Temp2 = Temp2->Edge;
		}
	}

}

void main()

{
	ifstream myFile;
	myFile.open("inputFile.txt");

	int n, B[50];

	int firstVertex, secondVertex, count;

	int steps = 0;

	myFile >> n;

	// create the Node List.
	createNodeList(n);


	while (!myFile.eof())
	{
		// read the edges from the file.
		myFile >> firstVertex >> secondVertex;
		// insert the edge into the graph.
		insertEdge(firstVertex, secondVertex);
	}



	cout << "\nGraph G is constructed\n" << endl;


	while (true)
	{
		count = 0;

		cout << "Enter the number of vertices and steps: " << endl;
		cin >> firstVertex >> secondVertex >> steps;

		// B will contain the no of steps to reach each node from the starting vertex.
		// for starting we assume that the no node is reachable from the starting vertex
		for (int i = 0; i<n; i++)
		{
			B[i] = -100;
		}
		//now we calculate the no. of steps to reach each node from starting vertex.
		reachableVertex(B, firstVertex, count);
		// find out the no. of steps to reach the second vertex.
		count = B[secondVertex - 1];


		if (count == steps && count > 0)
		{
			cout << "Reachable within " << count << " steps\n" << endl;
		}
		else if (count < steps && count > 0)
		{
			cout << "Reachable within " << steps << " steps (actually " << count << ")\n" << endl;
		}

		else if (firstVertex == secondVertex)
		{
			cout << "Reachable within " << count << " steps\n" << endl;
		}
		else
		{
			cout << "Not Reachable within " << steps << " steps\n" << endl;
		}
	}
	system("pause");
}