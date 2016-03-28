<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TODO List Page</title>
</head>
<body>    
    <h1>TODO List</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>CONTENT</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td><c:out value="${todo.id}" /></td>
                    <td><c:out value="${todo.content}" /></td>
                    <td><a
                        href="todo?action=edit&id=<c:out value="${todo.id}" />">Update</a></td>
                    <td><a
                        href="todo?action=delete&id=<c:out value="${todo.id}" />">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>  
    <p>
        <a href="todo?action=insert">Add TODO</a>
    </p>   
</body>
</html>