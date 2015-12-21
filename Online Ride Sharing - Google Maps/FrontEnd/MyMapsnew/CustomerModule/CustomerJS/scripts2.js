var routecount=0;
var wp=[];
var validresponse=[];
var validrequests=[];
var map;
var Cstart;
var Cend;
var customerSource; 
var customerDestination;
var Crequest; 
var r;

function loadMap() {
    loadEmail();
    //after loading from mapOptions.js
    map = new google.maps.Map(mapid, mapOptions);

    //GeoLocationAPI
    locate_(map);
    
    //ADD DIRECTION API CODE HERE
    var directionsDisplay = new google.maps.DirectionsRenderer();
	var directionsDisplay2 = new google.maps.DirectionsRenderer({
		polylineOptions: {
		  strokeColor: "red"
		}
	});
	
    var directionsService = new google.maps.DirectionsService();
    
	var routeBoxer = new RouteBoxer();
    var distance = 1;
    var routeBounds = [];
    
    directionsDisplay.setMap(map);
    customerSource = new google.maps.places.Autocomplete(document.getElementById('customerSource'));
    var infoWindow = new google.maps.InfoWindow();
    var marker_I = new google.maps.Marker({
        map: map
    });
    
    //customerSourceEvent
    google.maps.event.addListener(customerSource, 'place_changed', function() {
              infoWindow.close();
              var place = customerSource.getPlace();
              marker_I.setPosition(place.geometry.location);
              CsourceLat = marker_I.getPosition().lat();
              CsourceLng = marker_I.getPosition().lng();
              infoWindow.setContent('<div><strong>' + place.name + '</strong><br>');
    }); 
    
    customerDestination = new google.maps.places.Autocomplete(document.getElementById('customerDestination'));
    var infoWindow = new google.maps.InfoWindow();
    var marker_II = new google.maps.Marker({
        map: map
    });  
    
    //customerDestinationEvent
    google.maps.event.addListener(customerDestination, 'place_changed', function() {
            infoWindow.close();
            var place = customerDestination.getPlace();
            marker_II.setPosition(place.geometry.location);
            CDestinationLat = marker_II.getPosition().lat();
            CDestinationLng = marker_II.getPosition().lng();
            infoWindow.setContent('<div><strong>' + place.name + '</strong><br>');
			
			Cstart = new google.maps.LatLng(CsourceLat, CsourceLng);
            Cend = new google.maps.LatLng(CDestinationLat, CDestinationLng);
			
            Crequest = {
                    origin: Cstart,
                    destination: Cend,
                    travelMode: google.maps.TravelMode.DRIVING
            };
				
            directionsService.route(Crequest, function(response, status) {
                    if (status == google.maps.DirectionsStatus.OK) {
                        directionsDisplay2.setDirections(response);
                        directionsDisplay2.setMap(map);
                        
                        //start of change code
                        var distance=parseFloat(response.routes[0].legs[0].distance.value/1600).toFixed(2);
						var rate=parseFloat(response.routes[0].legs[0].distance.value/4000).toFixed(0);
						document.getElementById("Distance").contentEditable = true;
						document.getElementById('Distance').innerHTML = "Distance="+distance+" m";
						document.getElementById("Rate").contentEditable = true;
						document.getElementById('Rate').innerHTML = "Price will be $" + rate;
                        //end of change code
                        
                        // Box around the overview path of the first route
                        var path = response.routes[0].overview_path;
                        var boxes = routeBoxer.box(path, distance);
                        var pathsTemp = [];
                        for (var i = 0; i < boxes.length; i++) {
                            var bounds = boxes[i];
                            // Perform search over this bounds
                            pathsTemp.push(bounds.getCenter());
                            routeBounds.push(bounds);
                        }
                    } else {
                        alert("Directions Request from " + start.toUrlValue(6) + " to " + end.toUrlValue(6) + " failed: " + status);
                    }
            });
	}); 
    
}

//PlaceMarker OnClick
function placeMarker(location) {
    var marker = new google.maps.Marker({
        position: location, 
        map: map ,
        animation: google.maps.Animation.DROP, 
        
        clickable: true,
        draggable: true,
        opacity: 1,
    });
}
google.maps.event.addDomListener(window, 'load', loadMap());

/*google.maps.event.addListener(map, 'click', function(event) {
   placeMarker(event.latLng);
}); */

var routeBoxer=new RouteBoxer();
var distance=1;
var routeBounds=[];
var cascadiaFault;

//search available routes
function availableroutes(x,idx){
			var Rstart = new google.maps.LatLng(x[idx].origin.G, x[idx].origin.K);
            var Rend = new google.maps.LatLng(x[idx].destination.G, x[idx].destination.K);
            wp=[];
			for(var i in x[idx].waypoints)
			{
				wp.push({
				location: x[idx].waypoints[i].location,
				stopover: true});
			}
			var Rrequest = {
                origin: Rstart,
                destination: Rend,
				waypoints: wp,
				optimizeWaypoints: true,
				travelMode: google.maps.TravelMode.DRIVING
            };		
			var directionsService2 = new google.maps.DirectionsService();
				
			directionsService2.route(Rrequest, function(response, status) {
                if (status == google.maps.DirectionsStatus.OK) {
					   
                        // Box around the overview path of the first route
                    var path = response.routes[0].overview_path;
                    var boxes = routeBoxer.box(path, distance);
                    var pathsTemp = [];
                    for (var i = 0; i < boxes.length; i++) {
                        var bounds = boxes[i];
                        // Perform search over this bounds
                        pathsTemp.push(bounds.getCenter());
                        routeBounds.push(bounds);
                    }
					cascadiaFault=new google.maps.Polyline({
						path:pathsTemp
					});
							
					if(google.maps.geometry.poly.isLocationOnEdge(Cstart,cascadiaFault,0.105) && google.maps.geometry.poly.isLocationOnEdge(Cend,cascadiaFault,0.105)) { 
                        routecount++;
						validresponse.push(response);
						validrequests.push(x[idx]);
						r="#"+routecount;
						$(r).show();
						
						//return true;
					}
					else{
						//return false;
					}
                    if(idx == x.length - 1){
                            if(validresponse.length == 0){
                                //alert("No rides found for your route NNNN");
                                loadMsg();
                            }
                        }
                } 
				else {
                    alert("Directions Request from " + start.toUrlValue(6) + " to " + end.toUrlValue(6) + " failed: " + status);
                }
            });
    
}

var routeid;
var rideremail;
var directionsDisplay3 = new google.maps.DirectionsRenderer({
				polylineOptions: {
					strokeColor: "darkblue"	,
                    strokeWeight: 2
                }
			});

function routemap(id){
			directionsDisplay3.setDirections(validresponse[id-1]);
			directionsDisplay3.setMap(map);
			document.getElementById("Email").contentEditable = true;
			document.getElementById("Name").contentEditable = true;
			document.getElementById("DateTime").contentEditable = true;
            document.getElementById("Seat").contentEditable = true;
			
	        document.getElementById('Email').innerHTML = "Rider Email:"+validrequests[id-1]['email'];
		    document.getElementById('Name').innerHTML = "Rider Name:"+validrequests[id-1]['fname']+" "+validrequests[id-1]['lname'];
            document.getElementById('DateTime').innerHTML = "Rider Dept :"+validrequests[id-1]['dateTime'];
            document.getElementById('Seat').innerHTML = "Seats Remaining:"+validrequests[id-1]['seatLimit'];
            
            routeid = validrequests[id-1]['routeId'];
            rideremail = validrequests[id-1]['email'];
}	


function sendCustJson(){
    if(routeid == null){
        alert(' Please select a ride ');
    }
                
    var email_ = localStorage.custEmail;
    var datetime = document.getElementById('datetime').value;
    var csource = document.getElementById('customerSource').value;
    var cdistance = document.getElementById('customerDestination').value;
    var cstData = {
     "email": email_,
     "routeId":routeid,
     "sourceLoc": csource,
     "destLoc":cdistance,
     "rideDate": datetime
    }
            
    var jsonD = JSON.stringify(cstData);
    console.log(jsonD);
            
    var request = $.ajax({
      url: 'http://localhost:8080/TestWs1/rest/custservice/save',
      type: 'POST',
      data:jsonD,
      headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
      },
      dataType: 'json',
      complete: function (response) {
      if(response.responseText == 'success'){
         sendbookingEmail(email_,datetime,csource,cdistance);
         sendbookingEmailToRider(rideremail,datetime,csource,cdistance);
		 alert('booking success, email confirmation sent');
       }
      else
         alert('booking failed');
      }
    }); 
}


function sendCustJson2(){
    routeid = 1;
    
    var email_ = localStorage.custEmail;
    var datetime = document.getElementById('datetime').value;
    var csource = document.getElementById('customerSource').value;
    var cdistance = document.getElementById('customerDestination').value;
    var cstData = {
     "email": email_,
     "routeId":routeid,
     "sourceLoc": csource,
     "destLoc":cdistance,
     "rideDate": datetime
    }
            
    var jsonD = JSON.stringify(cstData);
    console.log(jsonD);
            
    var request = $.ajax({
      url: 'http://localhost:8080/TestWs1/rest/custservice/book',
      type: 'POST',
      data:jsonD,
      headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
      },
      dataType: 'json',
      complete: function (response) {
      if(response.responseText == 'success'){
         alert('booking success');
       }
      else
         alert('booking failed');
      }
    }); 
}
