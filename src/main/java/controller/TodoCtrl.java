package controller;
 
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.*;
import model.*;
 
@WebServlet(urlPatterns={"/todo"})
public class TodoCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String LIST = "/todo-list.jsp";
    public static final String INSERT_OR_EDIT = "/todo.jsp";
	private TodoDao todoDao;

	public TodoCtrl() {
		todoDao = new TodoDaoImpl();
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" ) == null? "" : request.getParameter( "action" );
 
        if( action.equalsIgnoreCase( "delete" ) ) {
        	forward = LIST;            
            int todoId = Integer.parseInt( request.getParameter("id") );
            todoDao.delete(todoId);
            request.setAttribute("todos", todoDao.getAll() );
        } else if( action.equalsIgnoreCase( "edit" ) ) {            
        	forward = INSERT_OR_EDIT;            
            int id = Integer.parseInt( request.getParameter("id") );            
            Todo todo = todoDao.getById(id);                  
            request.setAttribute("todo", todo );
        } else if( action.equalsIgnoreCase( "insert" ) ) {            
        	forward = INSERT_OR_EDIT;
        } else {     
        	forward = LIST;        
            request.setAttribute("todos", todoDao.getAll() );
        }
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Todo todo = new Todo();
        todo.setContent( request.getParameter( "content" ) );        
        String todoId = request.getParameter("id");
 
        if( todoId == null || todoId.isEmpty() ) {
        	todoDao.add(todo);
        } else {
            todo.setId( Integer.parseInt(todoId) );
            todoDao.update(todo);
        }

        RequestDispatcher view = request.getRequestDispatcher( LIST );
        request.setAttribute("todos", todoDao.getAll());
        view.forward(request, response);
    }
}