import jp.co.mimaze.lesson.latest.component.Employee;

import java.sql.ResultSet;
import java.util.*;

public class Memo {

    public static void main(String[] args) {
        String[] names = {"みけ", "たま", "しろ"};
        int[] pointsOfKokugo = {80, 90, 70};
        int[] pointsOfSansu = {65, 55, 85};
        // みけ => 0番目 index(指標)
        Memo memo = new Memo();
        memo.execute();
    }

    public void execute() {
        Student mike = new Student("みけ",80,65);
        // みけ => 変数名:mikeのインスタンス
        Student tama = new Student("たま",90,55);
        Student siro = new Student("しろ",70,85);
        //
        Student[] students = { mike, tama, siro };
    }

    public void execute2() {
        Map<String,Object> mike = new HashMap<>();
        mike.put("name", "みけ");
        mike.put("pointOfKokugo", 80);
        mike.put("pointOfSansu", 65);
        // みけ => 変数名:mikeのMapのインスタンス
        Map<String,Object> tama = new HashMap<>();
        tama.put("name", "たま");
        tama.put("pointOfKokugo", 90);
        tama.put("pointOfSansu", 55);
        tama.get("name"); // -> "たま"
        //
        List<Map<String,Object>> students = new ArrayList<>();
        students.add(mike);
        students.add(tama);
    }

    public void execute3() {
        //データベース
        //Table - Student
        // Column   Name VARCHAR(100)
        // Column   PointOfKokugo INT(INTEGER)
        // Column   PointOfSansu INT(INTEGER)
        // INSERT INTO(Name, PointOfKokugo, PointOfSansu) VALUES('みけ',80,65);
        // INSERT INTO(Name, PointOfKokugo, PointOfSansu) VALUES('たま',90,55);
        // | Name | PointOfKokugo | PointOfSansu |
        // | みけ  | 80            | 65           | <- Record(レコード)
        // | たま  | 90            | 55           |
    }

    public void execute4() {
        // ここから
        //SELECT * FROM Student;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();
        while(rs.next() == true) {
            String name = rs.getString("Name");
            int pointOfKokugo = rs.getInt("PointOfKokugo");
            int pointOfSansu = rs.getInt("PointOfSansu");
            Student student = new Student(name, pointOfKokugo, pointOfSansu);
            students.add(student);
        }
        //　ここまで <- データベースから持ってくる(SELECT)
    }

    private void execute5() {
        int count = 0;
        List<Student> students;
        for(Student student : students) {
            String name = findStudentName(student);
            System.out.println(name);
            count = count + 1;
        }
       List<Optional<Student>> students;
        long count2 = students
                .stream()
                .flatMap(Optional::stream)
                .count();
        students
                .stream()
                .flatMap(Optional::stream)
                .map(Student::getName)
                .forEach(System.out::println);
        students
                .stream()
                .flatMap(Optional::stream)
                .map(e->e.getName())
                .forEach(System.out::println);
    }

    private String findStudentName(Student student) {
        if(student == null) {
            return "";
        }
        String name = student.getName();
        return name;
    }

    public class Student {
        private String name;
        private int pointOfKokugo;
        private int pointOfSansu;
        public Student(String name, int pointOfKokugo, int pointOfSansu) {
            this.name = name;
            this.pointOfKokugo = pointOfKokugo;
            this.pointOfSansu  = pointOfSansu;
        }
        public String getName() { return this.name; }
        public int getPointOfKokugo() { return this.pointOfKokugo; }
        public int getPointOfSansu() { return this.pointOfSansu; }
    }




}
