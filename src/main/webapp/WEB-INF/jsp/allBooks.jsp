<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang pl-PL>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <title>List</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>All books</h1>
                    <a href="/books/addNew">Add new book</a>

                    <table class="table table-hover">
                        <thread>
                            <tr>
                                <th>Title</th>
                                <th>Price</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                        </thread>
                        <tbody>                       
                            <c:forEach items="${books}" var="book">
                                <tr>
                                    <td>${book.title}</td>
                                    <td>${book.price}</td>
                                    <td><a href="/books/edit/${book.id}">Edit</a></td>
                                    <td><a href="/books/delete/${book.id}">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
    </body>
</html>
