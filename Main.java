package com.company;

import java.util.Objects;

class Student
{
    private String name;
    private String lastname;
    private String code;

    //Constructores

    Student(String name, String lastname, String code)
    {
        this.name=name;
        this.lastname=lastname;
        this.code=code;
    }

    // Getters
    public String getLastname()
    {
        return lastname;
    }

    public String getName()
    {
        return name;
    }

    public String getCode()
    {
        return code;
    }
}

class Group
{
    private String code;
    private Student[] students;
    private int rejected;
    private int enrolled;

    public Group(String code, int capacity) {
        this.code = code;
        students = new Student[capacity];
    }

    public String getCode()
    {
        return code;
    }

    public boolean addStudent (Student student)
    {
        if(enrolled < students.length)
        {
            students[enrolled++] = student;//Ortogonalidad de los
            return true;
        }
        rejected++;
        return false;
    }

    public void removeStudent(String code){
        for (int i=0; i<enrolled; i++){
            if(Objects.equals(students[i].getCode(), code)){
                for (int j=i; j < enrolled-1 ;j++){
                    students[j]=students[j+1];
                }
                enrolled--;
                return;
            }
        }
    }

    public int getEnrolled()
    {
        return enrolled;
    }

    public int getRejected(){
        return rejected;
    }

    public Student getStudent(int index){
        return students[index];
    }
}

public class Main
{
    public static void main(String []args)
    {
        Student student1;
        Student student2 = new Student("Ivan","Uresti", "972196");
        student1 = new Student("Jose","Gonzales", "456789");

        Group group = new Group("230401", 8);
        Group group2 = new Group("230402", 6);

        if(!group.addStudent(student1))
        {
            System.out.println("Estudiante no fue añadido: " + student1.getName() + " " + student1.getLastname());
        }
        group.addStudent(student2);
        group.addStudent(new Student("Jorge", "Acosta","1"));
        group.addStudent(new Student("Arturo", "Aleman","2"));
        group.addStudent(new Student("Antonio", "Angel","3"));
        group.addStudent(new Student("Francisco", "Arreguin","4"));
        group2.addStudent(new Student("Misael", "Cabrera","5"));
        group2.addStudent(new Student("Roberto", "Cisneros","6"));
        group.addStudent(new Student("Juan", "Coronado","7"));
        group.addStudent(new Student("Miguel", "Gonzales","8"));
        group.addStudent(new Student("Jesus", "Lara","9"));
        group.addStudent(new Student("jose", "Limon","10"));

        System.out.println("Grupo: " + group.getCode() + ", Inscritos: " + group.getEnrolled() + " Rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, Inscritos: %d, Rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        group.removeStudent("4");
        group2.removeStudent("6");
        group2.removeStudent("12");

        System.out.println("Grupo: " + group.getCode() + ", Inscritos: " + group.getEnrolled() + "Rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, Inscritos: %d, Rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        System.out.println();
        System.out.println("Alumnos del grupo: " + group.getCode());

        for(int i=0; i<group.getEnrolled(); i++){
            Student student = group.getStudent(i);
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastname());
        }

        System.out.println();
        System.out.println();
        System.out.println("Alumnos del grupo: " + group2.getCode());

        for(int i=0; i<group2.getEnrolled(); i++){
            Student student = group2.getStudent(i);
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastname());
        }
    }
}