<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
         <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script src="resources/app.js"></script>
    </head>
    <body>
        <h1>REST World!</h1>
        <p>Raamatud</p>
      <form>
      <input type=button value="Koik raamatud" onClick="javascript:get_books()">


      <div id="msg_text"></div>
      <div id="one_book"></div>

      <table bgcolor=eeeeee><tr><td>Uus auto</td></tr>
      <tr><td>Nimetus:</td><td><input type=text name=new_book_name value=''></td></tr>
      <tr><td>Autor:</td><td><input type=text name=new_book_author value=''></td></tr>
      <tr><td>Lehekülgi:</td><td><input type=text name=new_pages_total value=''></td></tr>
      <tr><td>Väljatrüki aasta:</td><td><input type=text name=new_print_out_year value=''></td></tr>
      <td><button type='button' class='btn'  onClick='javascript:add_book()'>Saada uus serverise.</button></td></tr>
      </table>


	  <div id="books_table"></div>

	  </form>

    </body>
</html>
