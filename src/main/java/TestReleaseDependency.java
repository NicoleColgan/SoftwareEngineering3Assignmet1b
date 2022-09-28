import org.joda.time.DateTime;

import java.util.ArrayList;

public class TestReleaseDependency {
    //this is where we will create mock data and hopefully it will
    //be able to use the dependency pulled down from github to use
    //my classes

    static Module linearAlgebra,geometry,informationRetrieval,networks;
    static DateTime startDate,endDate;
    static CourseProgram mathsCourse,computerScienceCourse;
    static ArrayList<Module> mathsModules,computerScienceModules,modulesStudent3;
    static ArrayList<CourseProgram> coursesStudent1,coursesStudent2,coursesStudent3,listMathsCourses,listComputerScienceCourses;
    static DateTime dob,dob2,dob3,dob4,dob5;
    static Student student1,student2,student3;
    static ArrayList<Student> allStudents,mathsStudents,computerScienceStudents,algebraStudents,geomStudents,netStudents,infoStudents;
    static Lecturer l1,l2;

    public static void main(String args[]){

        createTestCases();

        //create print outs
        //print out list of course
        System.out.println("----------------------------------------------\nModules\n----------------------------------------------\n");
        for(CourseProgram course: listComputerScienceCourses){
            System.out.println("-----------------------------------------------------------------");
            System.out.println("name: "+course.getCourseName()+"\nModules\n");
            for(Module module: course.getModules()){
                System.out.println(module.getName());
            }
        }
        for(CourseProgram course: listMathsCourses){
            System.out.println("name: "+course.getCourseName()+"\nModules\n");
            for(Module module: course.getModules()){
                System.out.println(module.getName());
            }
        }
        System.out.println("----------------------------------------------\nStudent\n----------------------------------------------\n");
        allStudents = new ArrayList<>();
        allStudents.add(student1);allStudents.add(student2);allStudents.add(student3);
        for(Student student: allStudents){
            System.out.println("-----------------------------------------------------------------");

            System.out.println("name: "+student.getName()+ " username: "+student.getUsername()+"\nModules assigned\n");
            for(Module module: student.getModules()){
                System.out.println(module.getName());
            }
            System.out.println("\nCourses\n");
            for(CourseProgram course: student.getCourses()){
                System.out.println(course.getCourseName());
            }
        }
    }
    public static void createTestCases(){
        //module and course creation
        linearAlgebra = new Module("Linear Algebra", "MA322");
        geometry = new Module("Geometry","MA320");
        informationRetrieval = new Module("Information retrieval", "CT456");
        networks = new Module("Networks", "CT765");
        startDate = new DateTime(2022,9,5,0,0);
        endDate = new DateTime(2022,12,15,0,0);
        mathsCourse = new CourseProgram("MA",startDate,endDate);
        computerScienceCourse = new CourseProgram("BCT",startDate,endDate);
        //link modules and courses
        mathsModules = new ArrayList<>();
        mathsModules.add(linearAlgebra);
        mathsModules.add(geometry);
        mathsCourse.setModules(mathsModules);

        computerScienceModules = new ArrayList<>();
        computerScienceModules.add(networks);
        computerScienceModules.add(informationRetrieval);
        computerScienceCourse.setModules(computerScienceModules);

        coursesStudent1 = new ArrayList<>();
        coursesStudent1.add(mathsCourse);
        ArrayList<Module> modulesStudent1 = new ArrayList<>();
        modulesStudent1.add(linearAlgebra);

        coursesStudent2 = new ArrayList<>();
        coursesStudent2.add(mathsCourse);
        ArrayList<Module> modulesStudent2 = new ArrayList<>();
        modulesStudent2.add(linearAlgebra);
        modulesStudent2.add(geometry);

        //computer science student
        coursesStudent3 = new ArrayList<>();
        coursesStudent3.add(computerScienceCourse);
        coursesStudent3.add(mathsCourse);
        modulesStudent3 = new ArrayList<>();
        modulesStudent3.add(linearAlgebra);
        modulesStudent3.add(networks);
        modulesStudent3.add(informationRetrieval);

        //add courses to a module
        listMathsCourses = new ArrayList<>();
        listMathsCourses.add(mathsCourse);
        linearAlgebra.setCourses(listMathsCourses);
        geometry.setCourses(listMathsCourses);
        listComputerScienceCourses =new ArrayList<>();
        networks.setCourses(listComputerScienceCourses);
        informationRetrieval.setCourses(listComputerScienceCourses);

        //student 1 - Maths student
        dob=new DateTime(1999,11,21,0,0);
        student1 = new Student("nicole",22,123341,dob,coursesStudent1,modulesStudent1);

        //student 2 - Maths student
        dob2=new DateTime(2000,11,1,0,0);
        student2 = new Student("Leah",22,1275681,dob2,coursesStudent2,modulesStudent2);

        //student 1 - Maths student
        dob3=new DateTime(1999,3,23,0,0);
        student3 = new Student("Peter",22,123333,dob3,coursesStudent3,modulesStudent3);

        //register students to courses
        mathsStudents = new ArrayList<>();
        mathsStudents.add(student1);mathsStudents.add(student2);
        mathsCourse.setStudents(mathsStudents);

        computerScienceStudents = new ArrayList<>();
        computerScienceStudents.add(student3);
        computerScienceCourse.setStudents(computerScienceStudents);

        //register students to modules
        //students taking linearAlgebra
        algebraStudents = new ArrayList<>();
        algebraStudents.add(student1);algebraStudents.add(student2);algebraStudents.add(student3);
        linearAlgebra.setStudents(algebraStudents);

        //students taking geometry
        geomStudents = new ArrayList<>();
        geomStudents.add(student2);
        geometry.setStudents(geomStudents);

        //students taking networks
        netStudents = new ArrayList<>();
        netStudents.add(student3);
        networks.setStudents(netStudents);

        //students taking information retrieval
        infoStudents = new ArrayList<>();
        infoStudents.add(student3);
        informationRetrieval.setStudents(infoStudents);

        //add and make lecturers
        dob4=new DateTime(1960,11,1,0,0);
        l1 = new Lecturer("John Daly",45,dob4,2243234,mathsModules);

        dob5=new DateTime(1970,11,2,0,0);
        l2 = new Lecturer("Marie Doyle",30,dob5,343543,computerScienceModules);

        //add lecturers to modules
        linearAlgebra.setLecturer(l1);
        geometry.setLecturer(l1);
        networks.setLecturer(l2);
        informationRetrieval.setLecturer(l2);
    }


}
