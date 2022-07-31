<%--
  Created by IntelliJ IDEA.
  User: larissa
  Date: 30/07/2022
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Book list</title>
</head>
<body>
    <h1>Registered books</h1>

    <table border="solid">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
        </tr>
        <c:forEach var="book" items="${books}" varStatus="id">
            <tr>
                <td>${id.count}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/book-servlet/read-to-edit?id=<c:out value='${book.id}' />">Edit</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/book-servlet/delete?id=<c:out value='${book.id}' />">Delete</a>
                </td>
            <tr>
        </c:forEach>
    </table>
    <br/>
    <a href="${pageContext.request.contextPath}/register-book.jsp">Register a new Book</a>
    <br/>
    <a href="${pageContext.request.contextPath}/index.jsp">Return to Home Page</a>
</body>
</html>
