package MyLinkedList;

interface MyList<T> {
    void add(T data);
    T get(int index);
    void add(T data, int index);
    void remove(int index);
    void remove(T data);
}

class MyLinkedList<T> implements MyList<T> {
    private int size;
    private Node head; //node it is a representation of each element in linked list, it contains value and next, head = first element

    private class Node {
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public MyLinkedList() {
        size = 0;
        head = null;
    }


    public void push_back(T data) {
        size++;

        if (head == null) {
            head = new Node(data, null);
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = new Node(data, null);
    }


    public void push_front(T data) {
        size++;
        if (head == null) {
            head = new Node(data, null);
            return;
        }

        Node temp = new Node(data, head);
        head = temp;
    }


    public void pop_back() {

        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = null;
        size--;
    }

    public void pop_front() {
        if (head == null) {
            return;
        }

        head = head.next;
        size--;
    }


    @Override
    public void add(T data) {
        push_back(data);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("out of bounds");

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    @Override
    public void add(T data, int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("out of bounds");
        }

        if (index == 0) {
            head = new Node(data, null);
        }

        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        Node newNode = new Node(data, null);
        cur.next = newNode;
    }


    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("out of bounds");
        }

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node cur = head;

       for (int i = 0; i < index; i++) {
        cur = cur.next;
       }

       cur.next = cur.next.next;
       size--;
    }


   @Override
    public void remove(T data) {

        if (head == null) {
            return;
        }

        if (head.value.equals(data)) {
            head = head.next;
            size--;
            return;
        }

        Node cur = head;

        while (cur.next != null) {
            if (cur.next.value.equals(data)) {
                cur = cur.next.next;
                size--;
                return;
            }
            cur = cur.next;
        }
   }
}

class DoubleLinkedList<T> implements MyList<T> {
    private int size;
    private Node head;
    private Node tail;

    public DoubleLinkedList() {
        size = 0;
        head = tail = null;
    }

    public T size() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    private class Node {
        T value;
        Node prev;
        Node next;

        public Node(T value, Node prev, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void push_back(T data) {
        if (tail == null) {
            tail = new Node(data, null, null);
            head = tail;
        } else {
            Node temp = new Node(data, tail, null);
            tail.next = temp;
            tail = temp;
        }
        size++; // Увеличиваем size
    }

    public void push_front(T data) {
        if (tail == null) {
            tail = new Node(data, null, null);
            head = tail;
        } else {
            Node temp = new Node(data, null, head);
            head.prev = temp;
            head = temp;
        }
        size++;
    }

    public void pop_back() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        }

        Node temp = tail;
        tail = tail.prev;
        temp = null;
        size--;
    }

    public void pop_front() {
        if (head == null) {
            return; // The list is empty, nothing to remove
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }

    @Override
    public void add(T data) {
        push_back(data);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node cur;
        if (index < size / 2) {
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = size - 1; i > index; i--) {
                cur = cur.prev;
            }
        }

        return cur.value;
    }

    @Override
    public void add(T data, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            head = new Node(data, head, null);
            return;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node newNode = new Node(data, head, cur);
        cur.next = newNode;
        head = newNode;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }

    @Override
    public void remove(T data) {

        if (head.value.equals(data)) {
            head = head.next;
            size--;
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            if (cur.next.value.equals(data)) {
                cur = cur.next;
                size--;
                return;
            }
            cur = cur.next;
        }
    }
}

public class Lab2 {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

        // Используем add() для добавления элементов в конец
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Выводим элемент по индексу
        System.out.println("Элемент с индексом 3: " + list.get(3)); // Ожидаемый результат: 4

        // Используем add(T data, int index) для вставки элемента
        list.add(10, 2);
        System.out.println("Элемент с индексом 2 после вставки: " + list.get(2)); // Ожидаемый результат: 10

        // Используем push_front() для добавления элемента в начало
        list.push_front(0);
        System.out.println("Элемент с индексом 0 после push_front: " + list.get(0)); // Ожидаемый результат: 0

        // Используем push_back() для добавления элемента в конец
        list.push_back(6);
        System.out.println("Элемент с индексом " + (list.size() - 1) + " после push_back: " + list.get(list.size() - 1)); // Ожидаемый результат: 6

        // Используем remove(int index) для удаления элемента по индексу
        list.remove(2);
        System.out.println("Элемент с индексом 2 после удаления: " + list.get(2)); // Ожидаемый результат: 3

        // Используем remove(T data) для удаления элемента по значению
        list.remove(Integer.valueOf(4));
        System.out.println("Элемент с индексом 3 после удаления элемента 4: " + list.get(3)); // Ожидаемый результат: 5

        // Используем pop_front() для удаления первого элемента
        list.pop_front();
        System.out.println("Элемент с индексом 0 после pop_front: " + list.get(0)); // Ожидаемый результат: 1

        // Используем pop_back() для удаления последнего элемента
        list.pop_back();
        System.out.println("Элемент с последним индексом после pop_back: " + list.get(list.size() - 1)); // Ожидаемый результат: 5

        // Проверяем все элементы в списке
        System.out.println("Оставшиеся элементы в списке:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Элемент с индексом " + i + ": " + list.get(i));
        }
    }
}
