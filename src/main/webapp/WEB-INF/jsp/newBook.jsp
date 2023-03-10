<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang pl-PL>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <title>New Book</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Add New Book</h1>

                    <form:form modelAttribute="form" action="/books/save">
                        <form:errors path="" element="div" />
                            <div>
                                <form:label path="title">Title</form:label>
                                <form:input path="title" />
                                <form:errors path="title" />
                
                                <form:label path="price">Price</form:label>
                                <form:input path="price" />
                                <form:errors path="price" />
                            </div>
                            <div>
                                <input type="submit" />
                            </div>
                    </form:form>
                </div>
            </div>
        </section>
    </body>
</html>
