package myCollection;

/**
 * 自定义实现一个ArrayList，体会底层原理
 * @author Altria
 */
public class MyArrayList<E> {
    private Object[] elementData;
    private int size;

    // 定义一个常量
    private static final int DEFALT_CAPACITY = 10;

    public MyArrayList(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public MyArrayList(int capacity){
        // 如果创建的数组小于10则默认为10
        if (capacity < DEFALT_CAPACITY)
            capacity = DEFALT_CAPACITY;

        // 进行判断，传入进来的capacity是否正确
        if(capacity < 0)
            throw new RuntimeException("容器长度不能为负数");
        elementData = new Object[capacity];
    }

    public void add(E element){
        // 如果添加的元素超过了数组最初定义的长度，就需要扩容
        if(size == elementData.length){
            Object[] newArray = new Object[elementData.length + (elementData.length>>1)];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
        elementData[size++] = element;
    }

    // 添加get和set方法
    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }

    public void set(E element, int index){
        checkRange(index);
        elementData[index] = element;
    }

    // 写一个方法用来检测索引是否合法
    public void checkRange(int index){
        // 判断手动添加的索引是否正确
        if (index < 0 | index > size-1){
            throw new RuntimeException("索引不合法：" + index);
        }
    }

    // 移除对象：传进对象，并将其移除
    public void remove(E element){
        // element，将它和所有元素挨个比较，将第一个比较为true的索引返回
        for (int i=0; i<size; i++){
            if (element.equals(get(i))){    // 容器中所有的比较操作，都是用equals而不是==
                // 将改元素从此处移除
                remove(i);
            }
        }
    }

    // 移除对象，传进索引，并将其移除
    public void remove(int index){
        int num = elementData.length-index-1;
        if (num > 0){
            System.arraycopy(elementData, index+1, elementData, index, num);
        }
        elementData[--size] = null;
    }

    // 获得容器大小
    public int size(){
        return size;
    }

    // 判断容器是否为空
    public boolean isEmpty(){
        return size == 0? true:false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        // 下面的方法会导致把多于的长度内容打印出来
//        for (Object obj:elementData){
//            sb.append(obj + ",");
//        }

        for (int i=0; i<size; i++){
            // 判断是否是第一个元素，如果是就不加逗号
//            if (i != 0)
//                sb.append(",");
            sb.append(elementData[i] + ",");
        }

        // 替换掉最后一个字符
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }

    public static void main(String[] args){
        MyArrayList<String> m1 = new MyArrayList(1);
        for (int i=0; i<20; i++){
            m1.add("加" + i);
        }
        m1.set("Altria", 1);
        System.out.println(m1.size);
        System.out.println(m1);
        System.out.println(m1.get(1));
        m1.remove(3);
        System.out.println(m1);
        m1.remove("加4");
        System.out.println(m1);
    }

}
