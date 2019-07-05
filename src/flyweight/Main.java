package flyweight;

import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
        PersonCache personCache = new PersonCache();
        String name = "Mike";
        Person person = personCache.getByName(name);
        Person person2 = personCache.getByName(name);
        System.out.println(person == person2);

        StudentCache studentCache = new StudentCache();
        String faculty = "information systems";
        StudentUnivercityInfo student = studentCache.getByFaculty(faculty);
        StudentUnivercityInfo student2 = studentCache.getByFaculty(faculty);
        System.out.println(student == student2);
    }
}
class Person {
//    int id;
    String name;
//    int age;

    public Person(String name) {
        this.name = name;
    }
}
class PersonCache {
    private static final WeakHashMap<String, Person> cache = new WeakHashMap<>();

    public static Person getByName(String name) {
        Person person = cache.get(name);
        if(person == null) {
            person = new Person(name);
            cache.put(name, person);
        }
        return person;
    }
}

class Student {
    String name;
    int age;
    String faculty;
    String universityCity;
    String homeAddress;
    String hostelAddress;
    String cource;
    double averageMark;
}
class StudentPersonalInfo {
    String name;
    int age;
    String homeAddress;
    String cource;
    double averageMark;
}
class StudentUnivercityInfo {
    String faculty;
    String universityCity;
    String hostelAddress;

    public StudentUnivercityInfo(String faculty, String universityCity, String hostelAddress) {
        this.faculty = faculty;
        this.universityCity = universityCity;
        this.hostelAddress = hostelAddress;
    }
}
class StudentCache {
    private static final WeakHashMap<String, StudentUnivercityInfo> cache = new WeakHashMap<>();

    public static StudentUnivercityInfo getByFaculty(String facultyName) {
        StudentUnivercityInfo student = cache.get(facultyName);
        if(student == null) {
            student = getStudentInfo(facultyName);
            cache.put(facultyName, student);
        }
        return student;
    }

    private static StudentUnivercityInfo getStudentInfo(String facultyName) {
        switch(facultyName) {
            case "information systems":
                return new StudentUnivercityInfo("information systems", "New York", "1st st 50");
            case "security systems":
                return new StudentUnivercityInfo("security systems", "Los Adgeles", "10st st 75");
            default:
                throw new IllegalArgumentException("Some wrong faculty name");
        }
    }
}