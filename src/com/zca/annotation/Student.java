package com.zca.annotation;

/**
 * @author Altria
 * Date: 10/10/2019 上午 7:44
 */
@Table("tb_student")
public class Student {
    @MyField(columnName = "id", type = "int", length = 10)
    private int id;
    @MyField(columnName = "sname", type = "varchar", length = 20)
    private String sname;
    @MyField(columnName = "afe", type = "int", length = 3)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
