package rpncalculator;

/**
 *
 * @author mathiasjepsen
 */
public class PathStack<T> {

    private Path<T> data = null;

    public PathStack() {
    }

    public PathStack(NumberPath path) {
        data = new NumberPath(path.getFirst(), path);
    }

    public void push(T element) {
        data = new NumberPath(element, data);
    }

    public T pop() {
        T element = data.getFirst();
        data = data.getRest();
        return element;
    }

    public boolean isEmpty() {
        return data.getFirst() == null;
    }

//    public int max(NumberPath path) {
//        int first = (int) path.getFirst();
//        if (path.getRest() == null) {
//            return first;
//        }
//        int maxOfRest = max((NumberPath) path.getRest());
//        return first > maxOfRest ? first : maxOfRest;
//    }
//
//    public int sum(NumberPath path) {
//        if (path.getRest() == null) {
//            return 0;
//        }
//        return (int) path.getFirst() + sum((NumberPath) path.getRest());
//    }

    public Path<T> getData() {
        return data;
    }

}
