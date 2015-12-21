var map;
var start;
var end;

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
    var cascadiaFault;
    var routeBounds = [];
    
    directionsDisplay.setMap(map);
    
    var source = new google.maps.places.Autocomplete(document.getElementById('source'));
    var infoWindow = new google.maps.InfoWindow();
    var marker_s = new google.maps.Marker({
      map: map
    });
    
    //listener to locate source
    google.maps.event.addListener(source, 'place_changed', function() {
              infoWindow.close();
              var place = source.getPlace();
              marker_s.setPosition(place.geometry.location);
              sourceLat = marker_s.getPosition().lat();
              sourceLng = marker_s.getPosition().lng();
              infoWindow.setContent('<div><strong>' + place.name + '</strong><br>');
    });
    
    var destination = new google.maps.places.Autocomplete(document.getElementById('destination'));
    var infoWindow = new google.maps.InfoWindow();
    var marker_d = new google.maps.Marker({
        map: map
    });
    
    //listener for destination
    google.maps.event.addListener(destination, 'place_changed', function() {
              infoWindow.close();
              var place = destination.getPlace();
              marker_d.setPosition(place.geometry.location);
              destinationLat = marker_d.getPosition().lat();
              destinationLng = marker_d.getPosition().lng();
              infoWindow.setContent('<div><strong>' + place.name + '</strong><br>');

			  //Same event, draw route
                start = new google.maps.LatLng(sourceLat, sourceLng);
                end = new google.maps.LatLng(destinationLat, destinationLng);
                var request = {
                    origin: start,
                    destination: end,
					waypoints: wp,
					optimizeWaypoints: true,
					travelMode: google.maps.TravelMode.DRIVING
                };
                drawroute(request); 
	
	
    
    });

    //end of source destination
    function drawroute(request)
	{
           //console.log(JSON.stringify(request));
			directionsService.route(request, function(response, status) {
                    if (status == google.maps.DirectionsStatus.OK) {
                        directionsDisplay.setDirections(response);
                        directionsDisplay.setMap(map);
    
					  var totalDist = 0;
					  var totalTime = 0;
					  var myroute = response.routes[0];
					  for (i = 0; i < myroute.legs.length; i++) {
						totalDist += myroute.legs[i].distance.value;
						totalTime += myroute.legs[i].duration.value;
					  }
					  totalDist = ((totalDist / 1000)*.625).toFixed(2);
					  alert(totalDist);
					
					} else {
                        alert("Directions Request from " + start.toUrlValue(6) + " to " + end.toUrlValue(6) + " failed: " + status);
                    }
	
            });
	}
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

function saveRide(){
    var email = localStorage.rideEmail;
    var source = start;
    var destination = end;
    var seatLimit = document.getElementById("seatlimit").value;
    var dateTime = document.getElementById("datetime").value;
    var sourceStr = document.getElementById("source").value;
    var destStr = document.getElementById("destination").value;
    
    var rideElements = {
            "email":email,
            "source":source,
            "destination":destination,
            "waypoints":wp,
            "seatLimit":seatLimit,
            "dateTime":dateTime,
            "sourceStr":sourceStr,
            "destStr":destStr
        }
    var jsonData = JSON.stringify(rideElements);
    console.log(jsonData);
    
    var request = $.ajax({
          url: 'http://localhost:8080/TestWs1/rest/riderservice/saveAll',
          type: 'POST',
          data:jsonData,
          headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
          },
          dataType: 'json',
          complete: function (response) {
              if(response.responseText == 'success'){
                sendbookingEmail(email,source,destination,dateTime);
				alert('registration success, booking details mailed');
                  //notify existing customers
                  notifyBookedCustomers();
              }
              else
                alert('registration failed');
          }
            
    }); 
}

function notifyBookedCustomers(){
    var src = document.getElementById('source').value;
    var dest = document.getElementById('destination').value;
    var datetime = document.getElementById("datetime").value;
    
    var jData = {
      "source": src,
      "destination":dest,
      "dateTime":datetime
    }
    
    var jsonData = JSON.stringify(jData);
    console.log(jsonData);
    var request = $.ajax({
          url: 'http://localhost:8080/TestWs1/rest/custservice/notify',
          type: 'POST',
          data:jsonData,
          headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
          },
          dataType: 'json',
          success: function (response) {
             //console.log(response.responseText);
             //console.log(JSON.stringify(response[0]));
             for(var index in response){
                 console.log(response[index].email);
                 sendNotifyEmail(response[index].email,src,dest,datetime);
             }
          }
            
    }); 
    
     
}

google.maps.event.addDomListener(window, 'load', loadMap());

/*google.maps.event.addListener(map, 'click', function(event) {
   placeMarker(event.latLng);
}); */