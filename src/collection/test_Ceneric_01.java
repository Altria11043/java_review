package collection;

/**
 * 泛型
 * @author Altria
 */
public class test_Ceneric_01 {
    public static void main(String[] args) {
        MyCollection<String> m = new MyCollection<>();

        m.setObjs("周晨安", 1);
        String s = m.getObjs(0);
    }
}

class MyCollection<E> {
    Object[] objs = new Object[5];

    public void setObjs(E e, int index){
        objs[index] = e;
    }

    public E getObjs(int index){
        return (E) objs[index];
    }
}
