function selectroutes(x,y,z,i)
{
	var table = document.getElementById("routes");

// Create an empty <tr> element and add it to the 1st position of the table:
var row = table.insertRow(i);

// Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
var cell1 = row.insertCell(0);
var cell2 = row.insertCell(1);
var cell3 = row.insertCell(2);
// Add some text to the new cells:
cell1.innerText=z;
cell2.innerText=x;
cell3.innerText=y;
}



	
