package ttu.idu0080.rest.data;
import java.util.*;
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.JoinTable;  
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Digits;
import javax.validation.Valid;  
import javax.validation.constraints.Size;


@Entity
@Table(name="BOOK")
public class Book implements java.io.Serializable  {
	@Id  
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	private String book_name ;
	private String book_author ;
	private int pages_total ;
	private int print_out_year ;


	public Book() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getBook_name() {
		return book_name;
	}


	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}


	public String getBook_author() {
		return book_author;
	}


	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}


	public int getPages_total() {
		return pages_total;
	}


	public void setPages_total(int pages_total) {
		this.pages_total = pages_total;
	}


	public int getPrint_out_year() {
		return print_out_year;
	}


	public void setPrint_out_year(int print_out_year) {
		this.print_out_year = print_out_year;
	}



}
