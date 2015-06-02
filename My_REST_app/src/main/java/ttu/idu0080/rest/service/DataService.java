package ttu.idu0080.rest.service;

import ttu.idu0080.rest.data.*;

import java.util.*;
import java.text.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.transaction.annotation.Propagation;

import javax.persistence.EntityTransaction;

@Repository
public class DataService {

	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Book getBookById(long id) {

		Book node = null;
		try {

			Query q = em.createQuery("select c from Book c where c.id = :id")
					.setParameter("id", id);
			node = (Book) q.getSingleResult();

		}

		catch (Exception ex) {
			System.out.println("DataService.getBookById():" + ex.getMessage());

		}

		return node;
	}
///////////////////////////////////////////
	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks() {

		List<Book> book_list = null;
		try {

			Query q = em.createQuery("select c from Book c ");
			book_list = (List<Book>) q.getResultList();

		}

		catch (Exception ex) {
			System.out.println("DataService.getAllBooks():" + ex.getMessage());
		}

		return book_list;
	}

	public Book update(Book book) {

		System.out.println("book update, book book_author: "
				+ book.getBook_author());
		try {

			em.merge(book);
			em.flush();

		}

		catch (Exception ex) {
			System.out.println("DataService.update():" + ex.getMessage());
		}

		return book;
	}

	public Book save(Book book) {

		System.out.println("new book insert , book book_author: "
				+ book.getBook_author());

		try {

			em.persist(book);

		}

		catch (Exception ex) {
			System.out.println("DataService.save():" + ex.getMessage());
		}

		return book;
	}

	public void delete(long id) {

		System.out.println("DELETE ");

		try {

			Book book = em.find(Book.class, id);
			em.remove(book);

		}

		catch (Exception ex) {
			System.out.println("DataService.delete():" + ex.getMessage());
		}

	}

	// //////////////////////////////////
	@SuppressWarnings("unchecked")
	public List<Book> searchByBook_author(String s_book_author) {
		List<Book> books = null;

		try {

			String sql = "from Book c where upper(c.book_author) like upper(:book_author) order by c.book_name";

			Query q = em.createQuery(sql);
			q.setParameter("book_author", s_book_author + "%");
			books = (List<Book>) q.getResultList();
			System.out.println("Otsingu tulemusi:" + books.size());

		}

		catch (Exception ex) {
			System.out.println("DataService.searchByBook_author():"
					+ ex.getMessage());

		}

		return books;
	}

}
