var pos;
var emergency_location;

function locate_(map){
    //GeoLocationAPI
    // Try HTML5 geolocation
      if(navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
          pos = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
            
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({ 'latLng': pos }, function (results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    if (results[1]) {
						emergency_location=	results[1].formatted_address;
						
                    }
                }
            });
            
           map.setCenter(pos);
			
           var marker = new google.maps.Marker({
               position: pos,
               map: map,
               animation: google.maps.Animation.DROP, 
			   zoom: 20,
               clickable: true,
               draggable: false,
               opacity: 1,
               //title: 'Hello World!'
           });
		   
		   var circleOptions={
			   strokeColor:"#0000FF",
			   strokeOpacity: 0.0,
			   strokeWeight: 1.5,
			   fillColor: "#0000FF",
			   fillOpacity: 0.35,
			   map:map,
			   center:pos,
			   radius:80
		   }
		   //map.fitBounds(pos);
		   var circle=new google.maps.Circle(circleOptions);
		   
        }, function() {
              handleNoGeolocation(true);
            });
          
      } 
      else {
        // Browser doesn't support Geolocation
        handleNoGeolocation(false);
      }
  }//end of locate_
//END OF GEOLOCATION

//function for handling if No Location found.
function handleNoGeolocation(errorFlag) {
  if (errorFlag) {
    var content = 'Error: The Geolocation service failed.';
  } else {
    var content = 'Error: Your browser doesn\'t support geolocation.';
  }

  var options = {
    map: map,
    position: new google.maps.LatLng(60, 105),
    content: content
  };

  var infowindow = new google.maps.InfoWindow(options);
  map.setCenter(options.position);
}

function emergency(){
	return emergency_location;
}