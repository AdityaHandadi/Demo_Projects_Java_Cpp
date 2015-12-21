package com.testing;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UserServiceClientCreate {
	
	public static void main(String[] args) {
		try {
			Client client = Client.create();
			WebResource webResource = client
					.resource("http://localhost:8081/EgenLevel2/rest/user/create");

			String input = "{\"uuid\":2,\"firstName\":\"David\",\"middleName\":\"R\",\"lastName\":\"Moyes\","
					+ "\"age\":24,\"gender\":\"M\",\"phoneNumber\":1231231234}";
			
			System.out.println("JSON Request :\n"+input);

			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, input);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			System.out.println("Server Response");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
