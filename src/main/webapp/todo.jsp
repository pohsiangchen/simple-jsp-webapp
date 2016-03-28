<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TODO Edit/Add Page</title>
</head>
<body>
	<h1>TODO Edit/Add</h1>
    <form action="todo" method="POST">
    	<fieldset>
            <c:if test="${todo.id != null}">
                <div>
                    <label for="todoId">TODO ID</label> <input type="text"
                        name="id" value="<c:out value="${todo.id}" />"
                        readonly="readonly" placeholder="TODO ID" />
                </div>
            </c:if>            
            <div>
                <label for="content">Content</label> <input type="text"
                    name="content" value="<c:out value="${todo.content}" />"
                    placeholder="Content" />
            </div>            
            <div>
                <input type="submit" value="Submit" />
            </div>
        </fieldset>
    </form>    
</body>
</html>