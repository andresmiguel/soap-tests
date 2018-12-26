package com.ambh.soap.config;

import com.ambh.soap.ws.CustomerOrdersWSImpl;
import com.ambh.soap.ws.handlers.SiteHandler;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;
import java.util.ArrayList;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new CustomerOrdersWSImpl());
		endpoint.publish("/customerOrdersService");

		SOAPBinding binding = (SOAPBinding) endpoint.getBinding();

		ArrayList<Handler> handlerChain = new ArrayList<>();
		handlerChain.add(new SiteHandler());

		binding.setHandlerChain(handlerChain);

		return endpoint;
	}
	
}
