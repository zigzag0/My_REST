package ttu.idu0080.rest.service;

import ttu.idu0080.rest.data.*;

import java.util.*;
import java.text.*;
import java.util.List;

import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;;
@Service
public class RESTDataService  {



	
	
	public List<Book> getAllBooks()  {
		
		Book[] book_array = null;
		try
		{
			RestTemplate restTemplate = new RestTemplate();
		book_array = restTemplate.getForObject("http://localhost:8080/REST_service/service/books", Book[].class) ;
		System.out.println("Raamatuid REST-teenusest:" + book_array.length);
		}
		catch(Exception ex)
		{
			System.out.println("RESTDataService.getAllBooks():"+ ex.getMessage());
		}

		List<Book> book_list= Arrays.asList(book_array);
		return book_list;
	}

	
	
	
}
