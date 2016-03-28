package dao;
 
import java.util.List;
 
import model.Todo;
 
public interface TodoDao {
    public void add( Todo todo );
    public void delete( int todoId );
    public void update( Todo todo );
    public List<Todo> getAll();
    public Todo getById( int todoId );
}