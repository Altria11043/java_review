package com.zca.myCollection;

/**
 * 自定义链表
 * @author Altria
 */
public class MyLinkedList<E> {
    private Node first;
    private Node last;

    private int size;

    // 添加
    public void add(E element){
        Node node = new Node(element);

        if (first == null){
            first = node;
            last = node;
        }else{
            node.previous = last;
            node.next = null;
            // 这个时候last还是是新元素的前一个元素，所以last.next等于新加入的元素
            last.next = node;
            // 这里在把last指向新加入的元素
            last = node;
        }
        size++;
    }

    // 插入
    public void add(int index, E element){
        checkRange(index);

        Node newNode = new Node(element);
        Node temp = getNode(index);

        if (temp != null){
            Node up = temp.previous;

            if (up != null){
                up.next = newNode;
                newNode.previous = up;
            }

            newNode.next = temp;
            temp.previous = newNode;

            if (index == 0){
                first = newNode;
            }
            if (index == size-1){
                last = newNode;
            }

            size++;
        }
    }

    // 查询
    public Object get(int index){

        checkRange(index);
        Node temp = getNode(index);
        return temp!=null?(E)temp.element:null;
    }

    // 删除
    public void remove(int index){

        checkRange(index);

        Node temp = getNode(index);
        if (temp != null){
            Node up = temp.previous;
            Node down = temp.next;
            if (up != null){
                up.next = down;
            }
            if (down != null){
                down.previous = up;
            }
            // 删除第一个值之后要将第一个值重置一下，否则程序保存的第一个值仍然是之前的第一个值
            if (index == 0){
                first = down;
            }
            // 与上同理
            if (index == size-1){
                last = up;
            }
            size--;
        }
    }

    // 将索引查询方法提取出来
    private Node getNode(int index){
        Node temp = null;
        if (index <= (size>>1)){
            temp = first;
            for (int i=0; i<index; i++){
                temp = temp.next;
            }
        }else{
            // 从后往前找
            temp = last;
            for (int i=size-1; i>index; i--){
                temp = temp.previous;
            }
        }
        return temp;
    }

    // 判断索引是否正确
    public void checkRange(int index){
        // 判断传进来的下标是否大于链表的最大长度
        if(index < 0 || index > size-1){
            throw new RuntimeException("索引错误：" + index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while(temp != null){
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<String> m = new MyLinkedList<>();
        m.add("a");
        m.add("b");
        m.add("c");
        m.add("d");
        m.add("e");
        m.add("f");
        m.add(5, "1");
        System.out.println(m);
        System.out.println(m.size);
    }
}
