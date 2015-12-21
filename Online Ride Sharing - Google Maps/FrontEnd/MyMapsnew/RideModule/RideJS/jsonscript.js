
		var jsonData;
		function sendRideJson(){
						
			
			//var formData = JSON.stringify($("#myForm").serializeArray());
/*
			var request = $.ajax({
			  url: 'http://localhost:8080/TestWs1/rest/regservice/register',
			  type: 'POST',
			  data:jsonData,
			  headers: { 
				'Accept': 'application/json',
				'Content-Type': 'application/json' 
			  },
			  dataType: 'json'
			}); 
			
			alert("Your registration is successful");
	*/		 return jsonData;
		}
		function setjson(){
			
			var regData = {
				"Rstart": start,
				"Rend": end,
			}
			
			jsonData = JSON.stringify(regData);
			console.log(jsonData);
			
		}


