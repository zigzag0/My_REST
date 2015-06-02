package ttu.idu0080.rest.controller;

import java.io.IOException;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.ui.Model;

import ttu.idu0080.rest.service.*;
import ttu.idu0080.rest.data.*;


@Controller
public class RESTController {

	@Autowired
	private DataService dataService;
	@Autowired
	private RESTDataService restDataService;

	@RequestMapping(value="/service/books",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Book> getBooks() throws IOException{


		List<Book> books = dataService.getAllBooks(null);
		return books;
	}





	@RequestMapping(value="/service/books/{search}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Book> getBooks(@PathVariable String search) throws IOException{

		System.out.println(search);
		List<Book> books = dataService.getAllBooks(search);
		return books;
	}

	@RequestMapping(value="/service/book/{id}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Book getBook(@PathVariable int id) throws IOException{

		Book book = dataService.getBookById(id);
		return book;
	}
/*	Tagavara
	@Transactional
	@RequestMapping(value = "/service/book/{id}", method=RequestMethod.POST)
	public @ResponseBody void updateBook(@RequestBody Book book)
	{
		dataService.update(book);
*/
	@Transactional
	@RequestMapping(value="/service/book/{id}",method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody void deleteBook(@PathVariable int id) throws IOException{

		System.out.println("DELETEContr");
		dataService.delete(id);
	}

	@Transactional
	@RequestMapping(value="/service/book/",method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody void addBook(@RequestBody Book book) throws IOException{

		System.out.println("ADDController");
		dataService.save(book);
	}

	@Transactional
	@RequestMapping(value = "/service/book/{id}", method=RequestMethod.POST)
	public @ResponseBody void updateBook(@RequestBody Book book)
	{
		dataService.update(book);
	}


	@RequestMapping(value="/service/external/books",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Book> getExternalBooks(HttpServletResponse response) throws IOException{
		List<Book> books = restDataService.getAllBooks();
		return books;
	}

	@RequestMapping(value="/service/search/")
	public @ResponseBody List<Book> getSearchByAutorResult(@RequestParam("autor:") String book_author){
		List<Book> books = dataService.searchByBook_author(book_author);
		return books;
	}

}
