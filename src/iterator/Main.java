package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyIterator myIterator = new Menu().getMyIterator();
        while(myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
        Iterator iterator = new Menu().getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        new Menu().forEach(System.out::println);
    }
}
class Menu implements Iterable {
//    String[] arr = {"one", "two"};
    List<String> list = new ArrayList<>();
    Menu() {
        list.add("three");
        list.add("four");
    }
    MyIterator<String> getMyIterator() {
        return new MyIterator<>() {
            int i;
            @Override
            public boolean hasNext() {
//                return i < arr.length;
                return i < list.size();
            }

            @Override
            public String next() {
//                return arr[i++];
                return list.get(i++);
            }
        };
    }
    Iterator<String> getIterator() {
        return list.iterator();
//        return new Iterator<>() {
//            int i;
//            @Override
//            public boolean hasNext() {
//                return i < list.size();
//            }
//
//            @Override
//            public String next() {
//                return list.get(i++);
//            }
//        };
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }
}
interface MyIterator <T> {
    boolean hasNext();
    T next();
}