package MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        try {

            System.out.println(list.get(120));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }


        System.out.println(list.toString());

        list.add(999, 50);
        System.out.println(list.toString());


        list.remove(10);
        System.out.println(list.toString());


        System.out.println("List contains 50: " + list.contains(50));
    }
}
