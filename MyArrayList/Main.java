package MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        System.out.println("After adding elements: " + list);

        System.out.println("Element at index 10: " + list.get(10));

        try {
            System.out.println("Element at index 120: " + list.get(120));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception for invalid index in get(): " + e.getMessage());
        }

        list.add(999, 5);
        System.out.println("After adding 999 at index 5: " + list);

        list.remove(10);
        System.out.println("After removing element at index 10: " + list);

        list.remove((Integer) 999);
        System.out.println("After removing element with value 999: " + list);

        System.out.println("List contains 15: " + list.contains(15));
        System.out.println("List contains 999: " + list.contains(999));

        MyArrayList<Integer> list2 = new MyArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            list2.add(i);
        }
        System.out.println("List equals list2: " + list.equals(list2));

        list2.add(21);
        System.out.println("After adding extra element to list2, List equals list2: " + list.equals(list2));

        System.out.println("Final list: " + list);
    }
}