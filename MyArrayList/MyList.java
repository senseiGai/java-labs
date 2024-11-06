package MyArrayList;

public interface MyList<T> {
    void add(T data);
    T get(int index);
    void add(T data, int index);
    void remove(int index);
    void remove(T data);
    boolean contains(T data);
}
