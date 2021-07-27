package class05;

import java.util.HashMap;

public class Code04_LeastRecentlyUsedCache {
    public static class Node<K,V>{
        public K key;
        public V value;
        Node<K,V> last;
        Node<K,V> next;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    public static class NodeDoubleLinedList<K,V>{
        Node<K,V> head;
        Node<K,V> tail;
        public NodeDoubleLinedList(){
            head = null;
            tail = null;
        }

        public void add(Node<K,V> newNode){
            if(newNode == null){
                return;
            }
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                newNode.last = tail;
                tail = newNode;
            }
        }

        public void moveNodeToTail(Node<K,V> node){
            if(tail == node){
                return;
            }
            if(head == node){
                head = head.next;
                head.last = null;
                node.next = null;
            }else{
                node.next.last = node.last;
                node.last.next = node.next;
                node.next = null;
                node.last = null;
            }
            this.tail.next = node;
            node.last = tail;
            tail = node;
        }

        public Node<K,V> removeHead(){
            if(head==null){
                return null;
            }
            Node<K,V> res = head;
            if(head == tail){
                head = null;
                tail = null;
                return res;
            }else{
                this.head = res.next;
                head.last = null;
                res.next = null;
                return res;
            }
        }
    }

    public static class MyCache<K,V>{
        public HashMap<K,Node<K,V>> kNodeMap;
        public NodeDoubleLinedList<K,V> nodeList;
        public int capacity;
        public MyCache(int cap){
            kNodeMap = new HashMap<>();
            nodeList = new NodeDoubleLinedList<>();
            capacity = cap;
        }
        public V get(K key){
            if(kNodeMap.containsKey(key)){
                Node<K,V> res = kNodeMap.get(key);
                nodeList.moveNodeToTail(res);
                return res.value;
            }
            return null;
        }
        public void put(K key,V value){
            if(kNodeMap.containsKey(key)){
                Node<K,V> res = kNodeMap.get(key);
                res.value = value;
                nodeList.moveNodeToTail(res);
            }else{
                Node<K,V> res = new Node<>(key,value);
                kNodeMap.put(key,res);
                nodeList.add(res);
                if(kNodeMap.size() == capacity+1){
                    removeMostUnusedCache();
                }
            }
        }
        public void removeMostUnusedCache(){
            Node<K,V> node = nodeList.removeHead();
            kNodeMap.remove(node.key);
        }
    }
}
