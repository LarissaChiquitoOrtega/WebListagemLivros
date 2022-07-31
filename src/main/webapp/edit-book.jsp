<%--
  Created by IntelliJ IDEA.
  User: larissa
  Date: 31/07/2022
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
    <h1>Edit Book</h1>
    <fieldset>
        //chamo o editar cliente
      <form action="update-book" method="post">
        <div>
          // necessário identificar o registro que será alterado
          <input type="hidden" name="id" value="${book.id}">
        </div>
        <div>
          <label for="idTitle">Title:</label>
          <input type="text" id="idTitle" name="title" value="${book.title}">
        </div>
        <div>
          <label for="idAuthor">Author:</label>
          <input type="text" id="idAuthor" name="author" value="${book.author}">
        </div>
        <input type="submit" value="Enviar">
      </form>
    </fieldset>
</body>
</html>
