package com.mobi.test.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mobi.test.json.RootList;

@RestController
public class MobiQuityController {

	
	@GetMapping(path = "/listatms")
	@ResponseBody
	public RootList getAll() {
		
		
		return  getAtms();
		
	}
	
	@GetMapping("/listatms/{cityid}")
	public String getAll(@PathVariable String cityid) {
		
		
		return  getCity().getRoot().
				   stream().
				   filter(root-> root.address.city.equals(cityid)).collect(Collectors.toList()).toString();
				
	}
	
	
	private static RootList getAtms()
	{
		
//		https://gist.githubusercontent.com/HariKrishnaE-1288/f94a1f9d42cc9cdcff109a37ea73eda8/raw/3effc6666115385d01b4b1c5801bf034e0cbd300/mobi.test.29.05.2021.json
	    final String uri = "https://gist.githubusercontent.com/HariKrishnaE-1288/f94a1f9d42cc9cdcff109a37ea73eda8/raw/3effc6666115385d01b4b1c5801bf034e0cbd300/mobi.test.29.05.2021.json";
	 
	    RestTemplate restTemplate = new RestTemplate();
	    System.out.println("=============================================");
        
	    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
	    mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON,MediaType.APPLICATION_OCTET_STREAM));
	    restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

	    ResponseEntity<RootList> result = restTemplate.getForEntity(uri, RootList.class);
	    System.out.println(result.getBody()+"=============================================");
		return result.getBody();
	}
	
	
	private static RootList getCity()
	{
		
//		https://gist.githubusercontent.com/HariKrishnaE-1288/f94a1f9d42cc9cdcff109a37ea73eda8/raw/3effc6666115385d01b4b1c5801bf034e0cbd300/mobi.test.29.05.2021.json
	    final String uri = "https://gist.githubusercontent.com/HariKrishnaE-1288/f94a1f9d42cc9cdcff109a37ea73eda8/raw/3effc6666115385d01b4b1c5801bf034e0cbd300/mobi.test.29.05.2021.json";
	 
	    RestTemplate restTemplate = new RestTemplate();
	    System.out.println("=============================================");
	    
	    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
	    mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON,MediaType.APPLICATION_OCTET_STREAM));
	    restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);


	    ResponseEntity<RootList> result = restTemplate.getForEntity(uri, RootList.class);
	    System.out.println(result.getBody()+"=============================================");
		return result.getBody();
	}
}
