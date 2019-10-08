package TestMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试map的常用方法
 * @author Altria
 */
public class test_Map_02 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1001, "周晨安", 4000);
        Employee e2 = new Employee(1002, "Saber", 6000);
        Employee e3 = new Employee(1003, "Altria", 8000);

        Map<Integer, Employee> map = new HashMap<>();

        map.put(1001, e1);
        map.put(1002, e2);
        map.put(1003, e3);
        System.out.println(map.get(1001).getEname());
        System.out.println(e1);
        System.out.println(e1.hashCode());
        System.out.println(map.hashCode());

    }
}
// 员工信息
class Employee{
    private int id;
    private String ename;
    private double salary;

    public Employee(){}

    public Employee(int id, String ename, double salary){
        super();
        this.id = id;
        this.ename = ename;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id:" + id + " ename:" + ename + " salary:" + salary;
    }
}

