package ru.job4j.pojo;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullname("Dmitry Pervushin");
        student.setGroup("MT-1");
        student.setAdmission(new Date());

        System.out.println(student.getFullname() + "\n" + student.getGroup() + "\n" + student.getAdmission());
    }

}
