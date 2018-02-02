package rpncalculator;

/**
 *
 * @author mathiasjepsen
 */
public interface Path<T> {
    
    T getFirst();
    Path<T> getRest();
    
}
