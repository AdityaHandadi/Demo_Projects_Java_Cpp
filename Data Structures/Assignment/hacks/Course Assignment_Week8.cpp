//Kambam Sumanth
//CWID: 50131405
#include<iostream>
using namespace std;
int svalue;
struct node

{

	int item; node *l, *r;

	node(int x)

	{
		item = x; l = 0; r = 0;
	}

};

typedef node* link;
node* stree;
link nodeLocation = 0;
class QUEUE

{

private:

	link *q; int N, head, tail;

public:

	QUEUE(int maxN)

	{
		q = new link[maxN + 1];

		N = maxN + 1; head = N; tail = 0;
	}

	int empty() const

	{
		return head % N == tail;
	}

	void put(link item)

	{
		q[tail++] = item; tail = tail % N;
	}

	link get()

	{
		head = head % N; return q[head++];
	}

};



link temp, temp_root, a[100];

char ch;

int iVar = 0;



void traverse(link h)

{

	QUEUE q(100);

	q.put(h);

	while (!q.empty())

	{

		h = q.get();

		cout << h->item << " ";

		if (h->l != 0) q.put(h->l);

		if (h->r != 0) q.put(h->r);

	}

}





void search(link h, int ival)

{

	QUEUE q(100);

	q.put(h);



	while (!q.empty())

	{

		h = q.get();

		if (h->item == ival)

		{

			temp = h;

			stree = h;

		}

		if (h->l != 0)

			q.put(h->l);

		if (h->r != 0)

			q.put(h->r);

	}

}



void search_h_root(link h, int ival)

{

	QUEUE q(100);

	q.put(h);



	while (!q.empty())

	{

		h = q.get();



		if (h->l)

		{

			if (h->l->item == ival)

			{

				temp_root = h;

				ch = 'l';

			}

		}

		else if (h->r)

		{

			if (h->r->item == ival)

			{

				temp_root = h;

				ch = 'r';

			}

		}



		if (h->l != 0)

			q.put(h->l);

		if (h->r != 0)

			q.put(h->r);
			}
	}

void levelordertraverse(link h)

{

	if (h == 0)

		return;
		cout << h->item << " ";
		a[iVar++] = h;

	levelordertraverse(h->l);
	levelordertraverse(h->r);
}

void subordertraverse(link h)
{
	if (h == 0)
		return;
	cout << h->item << " ";
	a[iVar++] = h;
	levelordertraverse(h->l);
	levelordertraverse(h->r);
}

void delete_levelordertraverse(link h, int ival)

{

	QUEUE q(100);
	search(h, ival);
	search_h_root(h, ival);
	int i = 0;
	levelordertraverse(temp);
	for (int j = 0; j<iVar; j++)
		delete a[j];
	switch (ch)
	{

	case 'l':

		temp_root->l = NULL;

		break;

	case 'r':

		temp_root->r = NULL;

		break;
	default:
		break;

	}

}



int main()

{

	char userChoice;

	int userInput1, userInput2;

	link root = NULL;
	cout << "Enter your desired values: " << endl;
	cout << "\n Type C to create the root node";
	cout << "\n Type L to add nodes to the left of root ";
	cout << "\n Type R to add nodes to the right of root ";
	cout << "\n Type P to traverse the entire tree inorder";
	cout << "\n Type S to trverse the subtree fron the desired node";
	while (true)

	{

		cin >> userChoice;

		switch (userChoice)

		{

		case 'C': cin >> userInput1;

			if (root == NULL)

			{

				root = new node(userInput1);

				cout << "Root node has been created with value " << userInput1 << endl;

			}

			else

				cout << "Error: Tree is not empty" << endl;

			break;

		case 'L': cin >> userInput1;

			cin >> userInput2;

			search(root, userInput1);

			if (temp->l == NULL)

			{
				temp->l = new node(userInput2);
			}

			else
			{

				cout << "Already exists" << endl;

			}

			break;

		case 'R': cin >> userInput1;

			cin >> userInput2;

			search(root, userInput1);

			if (temp->r == NULL)

			{

				temp->r = new node(userInput2);

			}

			else

			{

				cout << "Already exists" << endl;

			}

			break;

		case 'D': cin >> userInput1;

			iVar = 0;

			cout << "Nodes ";

			delete_levelordertraverse(root, userInput1);

			cout << " have been deleted." << endl;

			break;

		case 'P': cout << "Level order traversal: ";

			traverse(root);

			break;

		case 'S': cout << "\n enter subtree value :";
			cin >> svalue;
			search(root, svalue);

			cout << "\n Values in the subtree : ";

			subordertraverse(stree);
		}

	}

}