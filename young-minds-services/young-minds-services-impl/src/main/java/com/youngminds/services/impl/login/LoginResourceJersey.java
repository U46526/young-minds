package com.youngminds.services.impl.login;

import javax.ws.rs.core.Response;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.youngminds.services.api.LoginResource;

@Component
public class LoginResourceJersey implements LoginResource{

	private static final Logger LOGGER=Logger.getLogger(LoginResourceJersey.class);
	@Autowired
	private ProducerTemplate template;
	public  LoginResourceJersey() {
		LOGGER.info("*******  login resource jersey constructor");
	}
	@Override
	public Response userLogin(String userId) {
		try{
			String data = template.requestBody("direct:testLoginRoute",userId, String.class);
			return Response.ok(data).build();
		}catch (CamelExecutionException cee){
			//we can handle exception here
			return Response.noContent().build();
		}
		
	}

}
