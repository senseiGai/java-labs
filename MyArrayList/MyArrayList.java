package MyArrayList;
import java.util.Arrays;



class MyArrayList<T> implements MyList<T> {
    private int size;
    private int capacity;
    private Object[] elementData;

    public MyArrayList() {
        size = 0;
        capacity = 10;
        elementData = new Object[capacity];
    }

    @Override
    public String toString() {
       var elements = Arrays.copyOf(elementData, size);
        return Arrays.toString(elements);
    }

    @Override
    public void add(T data) {
        if(size == capacity)
            grow();
        elementData[size++] = data;
    }

    private void grow() {
        capacity *= 2;
        elementData = Arrays.copyOf(elementData, capacity);
    }

    @Override
    public T get(int index) {
        if(index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException("");
        return (T) elementData[index];
    }

    @Override
    public void add(T data, int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("");
        }

        if (size == capacity) {
            grow();
        }

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }

        elementData[index] = data;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("");
        }

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = null;
    }

    @Override
    public void remove(T data) {
        for (int i = 0; i < size; i++) {
            if (data.equals(elementData[i])) {
                remove(i);
                return;
            }
        }
    }

    @Override
    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (data.equals(elementData[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(MyArrayList another) {
        if (this.size != another.size) return false;

        for (int i = 0; i < size; i++) {
            if (this.elementData[i] != another.elementData[i]) return false;
        }
        return true;
    }
}



