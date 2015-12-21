function drawRoute(map){
              var directionsDisplay = new google.maps.DirectionsRenderer();
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
                        var start = new google.maps.LatLng(sourceLat, sourceLng);
                        var end = new google.maps.LatLng(destinationLat, destinationLng);
                        var request = {
                            origin: start,
                            destination: end,
                            travelMode: google.maps.TravelMode.DRIVING
                        };
                        directionsService.route(request, function(response, status) {
                            if (status == google.maps.DirectionsStatus.OK) {
                                directionsDisplay.setDirections(response);
                                directionsDisplay.setMap(map);

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
                                var temp = {}
                                cascadiaFault = new google.maps.Polyline({
                                    path: pathsTemp
                                 });
                                //alert(pathsTemp);
                                //alert(cascadiaFault.getPath());
                            } else {
                                alert("Directions Request from " + start.toUrlValue(6) + " to " + end.toUrlValue(6) + " failed: " + status);
                            }
                        });
                    });
            //end of source destination


}