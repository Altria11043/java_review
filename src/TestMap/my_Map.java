package TestMap;

/**
 * 自定义Map
 * @author Altria
 */
public class my_Map<K,V> {

    Node[] table;
    int size;

    public my_Map(){
        table = new Node[16];   // 长度一般定义为2的整数幂
    }

    // 添加
    // 没有进行数组扩容
    public void put(K key, V value){
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        // 创建一个变量，记录链表最后的一个值
        Node iteNode = null;



        Node temp = table[newNode.hash];
        if (temp == null){
            // 如果数组元素为空，则直接将新节点放进去
            table[newNode.hash] = newNode;
        }else{
            while(temp != null){
                if (temp.key.equals(key)){

                    // 如果key相同，则直接替换掉value
                    temp.value = value;
                    return;
                }else{
                    iteNode = temp;
                    temp = temp.next;
                }
            }
            iteNode.next = newNode;
        }

        size++;
    }

    // get
    public V get(K key){
        int hash = myHash(key.hashCode(), table.length);
        if (table[hash] != null){
             Node temp = table[hash];
             while (temp != null){
                 if (temp.key.equals(key)){
                     return (V) temp.value;
                 }else{
                     temp = temp.next;
                 }
             }
        }
        return null;
    }


    // 计算hash的值
    public int myHash(int v, int length){
        return v&(length-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i=0; i<table.length; i++){
            Node temp = table[i];
            while(temp != null){
                sb.append("[" + temp.hash + ":" + temp.key + ":" + temp.value + "],");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-1, '}');
        return sb.toString();
    }

    public static void main(String[] args) {
        my_Map<Integer, String> m1 = new my_Map<>();
        m1.put(0, "a");
        m1.put(16, "b");
        m1.put(32, "c");
        m1.put(48, "aaa");
        System.out.println(m1);
        System.out.println(m1.get(1));
        System.out.println(m1.size);
    }
}
