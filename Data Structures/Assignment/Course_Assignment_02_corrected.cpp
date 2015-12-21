
#include<iostream>

using namespace std;

static const int n = 1000;	/* Given Vector Limit  */

struct element
{
	int x;    /* Original Element  */
	int val;
	element *next;
};


int sum = 0;


element *row = new element;
element *column = new element;

void generate_row_and_column()
{
	int y;

	//POINT THE TEMP NODE TO ROW FIRST
	element *temp = row;

	temp->x = 0;
	temp->val = 1;

	for (y = 1; y <= n / 4; y++)
	{
		temp->next = new element;
		temp->next->x = 4 * y;
		temp->next->val = 1;
		temp = temp->next;
	}

	//POINT THE TEMP NODE TO COLUMN NOW
	temp->next = 0;
	temp = column;
	column->x = 0;
	column->val = 1;

	for (y = 1; y <= n / 5; y++)
	{
		temp->next = new element;
		temp->next->x = 5 * y;
		temp->next->val = 1;
		temp = temp->next;
	}

	temp->next = 0;

}

int agreement()
{
	while (row->next != 0 && column->next != 0)
	{
		if (row->x == column->x)
		{
			sum++;
			row = row->next;
			column = column->next;
		}

		if(row->x < column->x)
			row = row->next;
		if(row->x > column->x)
			column = column->next;
	}
	return 0;

}
int main()
{

	generate_row_and_column();

	agreement();
	cout << "SUM IS:"<<sum<<endl;
	system("\n pause");
	return 0;
}