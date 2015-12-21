function checkroutejs(x){
	    map = new google.maps.Map(mapid, mapOptions);

		var directionsDisplay2 = new google.maps.DirectionsRenderer({
			polylineOptions: {
			  strokeColor: "red"
			}
		});
	
		var routeBoxer = new RouteBoxer();
		var distance = 1;
		var routeBounds = [];
		
		directionsDisplay2.setMap(map);

		var Rstart = new google.maps.LatLng(x[0].origin.G, x[0].origin.K);
		var Rend = new google.maps.LatLng(x[0].destination.G, x[0].destination.K);
		wp=[];
		for(var i in x[0].waypoints)
		{
			wp.push({
			location: x[0].waypoints[i].location,
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
				directionsDisplay2.setDirections(response);
                directionsDisplay2.setMap(map);
            } 
			else {
				alert("Directions Request from " + start.toUrlValue(6) + " to " + end.toUrlValue(6) + " failed: " + status);
			}
		});

}

