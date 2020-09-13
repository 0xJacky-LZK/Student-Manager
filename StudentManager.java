package Practice;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            System.out.println("--------欢迎使用学生管理系统--------");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 修改学生");
            System.out.println("4. 查看学生");
            System.out.println("5. 退出系统");

            System.out.print("请输入你的选择：");
            Scanner in = new Scanner(System.in);
            String select = in.nextLine();
            switch (select) {
                case "1":
                    addStudent(array);
                    break;
                case "2":
                    deleteStudent(array);
                    break;
                case "3":
                    updateStudent(array);
                    break;
                case "4":
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("【Student Manager】 Version - 1.0");
                    System.exit(0);
            }
        }
    }

    public static void addStudent(ArrayList<Student> array) {
        Scanner in = new Scanner(System.in);
        String sid;
        while(true) {
            System.out.print("请输入添加学生的学号：");
            sid = in.nextLine();
            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("抱歉，该学号已被占用请重新输入！");
            } else {
                break;
            }
        }
        System.out.print("请输入添加学生的姓名：");
        String name = in.nextLine();
        System.out.print("请输入添加学生的年龄：");
        String age = in.nextLine();
        System.out.print("请输入添加学生的地址：");
        String address = in.nextLine();

        Student student = new Student(sid, name, age, address);

        array.add(student);
        System.out.println("添加成功！");
    }

    public static void deleteStudent(ArrayList<Student> array) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入修改学生的学号：");
        String sid = in.nextLine();

        for(int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if(s.getSid().equals(sid)) {
                array.remove(i);
                System.out.println("删除成功！");
                break;
            } else {
                System.out.println("抱歉，该信息不存在请重新输入！");
            }
        }
    }

    public static void updateStudent(ArrayList<Student> array) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入修改学生的学号：");
        String sid = in.nextLine();
        System.out.print("请输入修改学生的姓名：");
        String name = in.nextLine();
        System.out.print("请输入修改学生的年龄：");
        String age = in.nextLine();
        System.out.print("请输入修改学生的地址：");
        String address = in.nextLine();

        Student s = new Student(sid, name, age, address);

        for(int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            if(student.getSid().equals(sid)) {
                array.set(i, s);
                System.out.println("修改成功！");
                break;
            }
        }
    }

    public static void findAllStudent(ArrayList<Student> array) {
        if(array.size() == 0) {
            System.out.println("抱歉，该列表无信息请先添加添加学生！");
            return;
        }
        System.out.println("学号\t\t姓名\t\t年龄\t\t地址");

        for(int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "\t\t" + s.getAddress());
        }
    }

    public static boolean isUsed(ArrayList<Student> array, String sid) {
        boolean flag = false;

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
