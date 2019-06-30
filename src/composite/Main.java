package composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder users = new Folder("users");
        Folder etc = new Folder("etc");
        root.add(users, etc);

        Folder one = new Folder("one");
        Folder two = new Folder("two");
        Folder three = new Folder("three");
        Folder four = new Folder("four");
        users.add(one, two);
        etc.add(three, four);

        Folder a = new Folder("a");
        Folder b = new Folder("b");
        Folder c = new Folder("c");
        Folder d = new Folder("d");
        two.add(a,b);
        a.add(c, d);
        users.printFolders();
    }
}
class Folder {
    String name;

    public Folder(String name) {
        this.name = name;
    }

    List<Folder> folders = new ArrayList<>();
    public void add(Folder folder) {
        this.folders.add(folder);
    }
    public void add(Folder... folders) {
        this.folders.addAll(Arrays.asList(folders));
    }
    public void printFolders() {
        for (Folder folder : folders) {
            System.out.println(folder.name);
            folder.printFolders();
//            printFolderContent(folder);
        }
    }
//    private void printFolderContent(Folder folder) {
//        for (Folder f : folder.folders) {
//            System.out.println(f.name);
//            printFolderContent(f);
//        }
//    }
}