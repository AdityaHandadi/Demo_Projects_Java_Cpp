var i=1;
var wp=[];
function add(){
 
    if(i<9){
        
    //Creates text dynamically.
    var element = document.createElement('input');
	element.setAttribute('type','text');
	document.body.appendChild(element);
	var id=i;
	element.setAttribute('id',id);

	// 'foobar' is the div id, where new fields are to be added
	var foo = document.getElementById("fooBar");

	//Append the element in page (in span).
	foo.appendChild(element);
    //foo.appendChild('&nbsp;');
	
	//http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_node_insertbefore
	foo.insertBefore(element, foo.childNodes[0]);
    
	
	var waypoint='waypoint'+i;
	waypoint = new google.maps.places.Autocomplete(document.getElementById(i));
	var infoWindow = new google.maps.InfoWindow();
    var marker_w = new google.maps.Marker({
      map: map
    });
    
	google.maps.event.addListener(waypoint, 'place_changed', function() {
              infoWindow.close();
              var place = waypoint.getPlace();
              marker_w.setPosition(place.geometry.location);
              wLat = marker_w.getPosition().lat();
              wLng = marker_w.getPosition().lng();
              infoWindow.setContent('<div><strong>' + place.name + '</strong><br>');
			  //alert(place.formatted_address);
			  wp.push({
						location: place.formatted_address,
						stopover: true});
					
    });
    
    }//eo if
	
	i++;	
	
}
//End of Waypoints on dynamic textboxes