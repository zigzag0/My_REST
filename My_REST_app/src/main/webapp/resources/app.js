var book_from_server;

function Book()
{
this.book_name;
this.book_author;
this.pages_total;
this.print_out_year;
}


function search_books(){
	get_books(document.forms[0].search.value);

}

function get_books(search)
{

if (!search)
	search="";

$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/books/'+search ,
    type: "GET",
    dataType: 'json',
    success: function(data) {
    	display_books(data);
        console.log(JSON.stringify(data));

    }
  });


}

//GET-imine
function get_book(id)
{


$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/book/' + id ,
    type: "GET",
    dataType: 'json',
    success: function(data) {
    	book_from_server = data;
    	display_book(data);
        console.log(JSON.stringify(data));

    }
  });


}


//salvestamine
function save_book()
{

	book_from_server.book_name=document.forms[0].book_name.value;
	book_from_server.book_author=document.forms[0].book_author.value;
	book_from_server.pages_total=document.forms[0].pages_total.value;
	book_from_server.print_out_year=document.forms[0].print_out_year.value;

var jsonData = JSON.stringify(book_from_server);
$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/book/' + book_from_server.id ,
    type: "POST",
    data: jsonData,
    dataType: 'json',
    contentType : 'application/json',
    success: function(data) {
    	show_message("Salvestatud");
        console.log(JSON.stringify(data));

    }
  });


}
//Kustutamine:
function delete_book(id)
{


$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/book/' + id ,
    type: "DELETE",
    contentType : 'application/json',
    success: function(data) {
    	show_message("Kustutatud");
    	get_books();
        console.log(JSON.stringify(data));

    }
  });

}


//Lisamine
function add_book()
{
	var book_to_server = new Book();
	book_to_server.book_name=document.forms[0].new_book_name.value;
	book_to_server.book_author=document.forms[0].new_book_author.value;
	book_to_server.pages_total=document.forms[0].new_pages_total.value;
	book_to_server.print_out_year=document.forms[0].new_print_out_year.value;

var jsonData = JSON.stringify(book_to_server);
alert(jsonData);

$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/book/' ,
    type: "PUT",
    data: jsonData,
    dataType: 'json',
    contentType : 'application/json',
    success: function(data) {
    	show_message("Sisestatud");
        console.log(JSON.stringify(data));
       	get_books();

    }
  });


}


//Näitamine
function display_book(book)
{
	 var out_data="";
	 out_data = out_data + "<table bgcolor=eeeeee><tr><td>Muutmine. Raamatu id: <b>" + book.id + "</b></td></tr>";

		out_data = out_data + "<tr><td>Pealkiri:</td><td><input type=text name=book_name value='" + book.book_name + "'></td></tr>";
		out_data = out_data + "<tr><td>Autor:</td><td><input type=text name=book_author value='" + book.book_author + "'></td></tr>";
		out_data = out_data + "<tr><td>Lehekülgi:</td><td><input type=text name=pages_total value='" + book.pages_total + "'></td></tr>";
		out_data = out_data + "<tr><td>Väljatrüki aasta:</td><td><input type=text name=print_out_year value='" + book.print_out_year + "'></td></tr>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:save_book()'>Salvesta</button></td>";
		out_data = out_data + "</table>";




	 $("#one_book").html(out_data);
}




function display_books(data)
{
	var out_data="";
	 out_data = out_data + "<table bgcolor=eeeeee><tr><td colspan=4>Raamatuid kokku: <b>" + data.length + "</b></td></tr>";
	 for(var  i in data) {
   	  var book = data[i];
		out_data = out_data + "<tr><td>Pealkiri:</td><td bgcolor=ffffff>" + book.book_name + "</td><td>Autor:</td><td bgcolor=ffffff>" + book.book_author + "</td>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:get_book(" + book.id + ")'>Vali</button></td>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:delete_book(" + book.id + ")'>DELETE</button></td>";


	 }
	 out_data = out_data + "</table>";


	 $("#books_table").html(out_data);
}


function show_message(message)
{

	 $("#msg_text").html(message);
}
