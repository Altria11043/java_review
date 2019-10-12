package com.zca.Javassist;

/**
 * @author Altria
 * Date: 12/10/2019 上午 1:08
 */
@Author(name="zhou", year=2019)
public class Emp {
    private int empno;
    private String ename;

    public Emp() {
    }

    public Emp(int empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void sayHello(int a){
        System.out.println(a);
    }
}
