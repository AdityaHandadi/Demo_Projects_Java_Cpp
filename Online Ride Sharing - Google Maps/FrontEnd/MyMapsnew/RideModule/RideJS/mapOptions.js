var mapid = document.getElementById('map');
var mapOptions = {
        zoom: 17, 
        
        mapTypeControl: true,
        mapTypeControlOptions: {
           style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR,
           mapTypeIds: [google.maps.MapTypeId.ROADMAP,
                       google.maps.MapTypeId.SATELLITE, 
                       google.maps.MapTypeId.HYBRID, 
                       google.maps.MapTypeId.TERRAIN ],
            position: google.maps.ControlPosition.TOP_RIGHT
        },
        
        //default layout for a map
        mapTypeId :google.maps.MapTypeId.ROADMAP,
       
        
        //zoomControls
        zoomControl: true,
        zoomControlOptions: {
         style: google.maps.ZoomControlStyle.MEDIUM,
         position: google.maps.ControlPosition.RIGHT_BOTTOM
        },
        
        //panControl
        panControl: true,
        panControlOptions: {
            position: google.maps.ControlPosition.LEFT_BOTTOM
        },
        
        //streetViewControl for toggling on/off the streetview
        streetViewControl: true,
        
        overViewMapControl: true,
        overViewMapControlOptions: {
          opened: true   
        },
        
        //THEME OF THE MAP FROM MAPSTYLE.JS
       // styles: midnightMapStyle
        //styles: blackWhiteMapStyle
    };