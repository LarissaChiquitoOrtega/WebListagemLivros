<%--
  Created by IntelliJ IDEA.
  User: larissa
  Date: 30/07/2022
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Book</title>
</head>
<body>
  <h1>Register Book</h1>
  <fieldset>
    <legend>Enter information about the book</legend>
    <form action="book-servlet/register-book" method="post">
      <div>
        <label for="idTitle">Title:</label>
        <input type="text" id="idTitle" name="title" required>
      </div>
      <div>
        <label for="idAuthor">Author:</label>
        <input type="text" id="idAuthor" name="author">
      </div>
      <input type="submit" value="Enviar">
    </form>
  </fieldset>
</body>
</html>
