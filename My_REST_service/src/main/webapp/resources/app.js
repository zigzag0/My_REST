var book_from_server;

function Book()
{
this.book_name;
this.book_author;
this.pages_total;
this.print_out_year;
}

function get_books()
{


$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/books' ,
    type: "GET",
    dataType: 'json',
    success: function(data) {
    	display_books(data);
        console.log(JSON.stringify(data));

    }
  });


}


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


function add_book()
{
	var car_to_server = new Book();
	car_to_server.book_name=document.forms[0].new_car_make.value;
	car_to_server.book_author=document.forms[0].new_car_model.value;
	car_to_server.pages_total=document.forms[0].new_car_series.value;
	car_to_server.print_out_year=document.forms[0].new_car_year.value;

var jsonData = JSON.stringify(car_to_server);
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

    }
  });


}

function display_book(book)
{
	 var out_data="";
	 out_data = out_data + "<table bgcolor=eeeeee><tr><td>Raamatu id: <b>" + book.id + "</b></td></tr>";

		out_data = out_data + "<tr><td>Nimetus:</td><td><input type=text name=book_name value='" + book.book_name + "'></td></tr>";
		out_data = out_data + "<tr><td>Autor:</td><td><input type=text name=book_author value='" + book.book_author + "'></td></tr>";
		out_data = out_data + "<tr><td>Lehekülgi:</td><td><input type=text name=pages_total value='" + book.pages_total + "'></td></tr>";
		out_data = out_data + "<tr><td>Väljatrüki aasta:</td><td><input type=text name=print_out_year value='" + book.print_out_year + "'></td></tr>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:save_book()'>Salvesta</button></td>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:delete_car()'>Kustuta</button></td></tr>";
		out_data = out_data + "</table>";




	 $("#one_book").html(out_data);
}




function display_books(data)
{
	var out_data="";
	 out_data = out_data + "<table bgcolor=eeeeee><tr><td>Autod, kokku: <b>" + data.length + "</b></td></tr>";
	 for(var  i in data) {
   	  var book = data[i];
		out_data = out_data + "<tr><td>Nimetus:</td><td>" + book.book_name + "</td><td>autor:</td><td>" + book.book_author + "</td>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:get_book(" + book.id + ")'>Vali</button></td></tr>";
		out_data = out_data + "</table>";

	 }



	 $("#books_table").html(out_data);
}


function show_message(message)
{

	 $("#msg_text").html(message);
}
