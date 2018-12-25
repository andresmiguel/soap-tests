package com.ambh.ws.soap.mtom.config;

import com.ambh.ws.soap.mtom.ws.FileWsImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint(@Value("${upload.folder}") String uploadFolder) {
		EndpointImpl endpoint = new EndpointImpl(bus, new FileWsImpl(uploadFolder));
		endpoint.publish("/fileWs");
		SOAPBinding binding = (SOAPBinding) endpoint.getBinding();
		binding.setMTOMEnabled(true);

		return endpoint;
	}
	
}
