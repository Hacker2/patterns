package iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        //main code
        MyIterator<String> myIterator = new Menu().getMyIterator();
        while(myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
        Iterator<String> iterator = new Menu().getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for(Object item : new Menu()) {
            System.out.println(item);
        }
        new Menu().forEach(System.out::println);

        //fail fast list
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.forEach(x -> {
            System.out.println(x);
//            list.remove(x);
//            list.add(x);
        });
        Iterator<String> listIterator = list.iterator();
        Iterator<String> listIterator2 = list.iterator();
        System.out.println(listIterator == listIterator2);
        while(listIterator.hasNext()) {
            String next = listIterator.next();
            System.out.println(next);
//            list.remove(next);
//            list.add(next);
        }
        for(Object item : list) {
            System.out.println(item);
//            list.remove(item);
//            list.add(item.toString());
        }

        //fail safe list
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(new Integer[] { 1, 2, 3 });
        Iterator itr = copyOnWriteArrayList.iterator();
        while (itr.hasNext()) {
            Integer no = (Integer)itr.next();
            System.out.println(no);
            copyOnWriteArrayList.add(no);
        }
        System.out.println(copyOnWriteArrayList);

        HashMap hashMap = new HashMap();
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        hashMap.put("First", 10);
        hashMap.put("Second", 20);
        hashMap.put("Third", 30);

        concurrentHashMap.put("First", 10);
        concurrentHashMap.put("Second", 20);
        concurrentHashMap.put("Third", 30);

        Iterator<String> hashMapIterator = hashMap.keySet().iterator();
        Iterator<String> concurrentHashMapIterator = concurrentHashMap.keySet().iterator();

        while (hashMapIterator.hasNext()) {
            System.out.println(hashMapIterator.next());
//            hashMap.put("Fourth", 40);
        }
        while (concurrentHashMapIterator.hasNext()) {
            System.out.println(concurrentHashMap.size());
            System.out.println(concurrentHashMapIterator.next());
            concurrentHashMap.put("Fourth", 40);
        }
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