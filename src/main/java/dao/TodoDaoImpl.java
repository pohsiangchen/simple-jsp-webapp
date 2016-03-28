package dao;
 
import java.util.ArrayList;
import java.util.List;
 
import model.Todo;
 
public class TodoDaoImpl implements TodoDao {

    private static List<Todo> todos = new ArrayList<Todo>();
 
    public TodoDaoImpl() {            
         todos.add(new Todo(1, "first TODO content."));
         todos.add(new Todo(2, "second TODO content."));
         todos.add(new Todo(3, "third TODO content."));          
    }

    @Override
    public void add( Todo todo ) {
        Todo lastTodo = todos.get(todos.size() - 1);
        todo.setId(lastTodo.getId() + 1);   
        todos.add(todo);
    }
    @Override
    public void delete( int todoId ) {
        for (int i = 0; i < todos.size(); i++) {
            Todo todo = todos.get(i);
            if (todo.getId() == todoId) {
                todos.remove(i);
                break;
            }
        }
    }
    @Override
    public void update( Todo todo ) {
        for (int i = 0; i < todos.size(); i++) {
            Todo iTodo = todos.get(i);
            if (todo.getId() == iTodo.getId()) {
                todos.set(i, todo);
                break;
            }
        }
    }
    @Override
    public List<Todo> getAll() {        
        return todos;
    }
    @Override
    public Todo getById(int todoId) {
        Todo todo = null;
        for (int i = 0; i < todos.size(); i++) {
            todo = todos.get(i);
            if (todo.getId() == todoId) break;
        }
        return todo;
    }
 
}