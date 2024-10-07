class Node{
    int key;     
    int value;
    Node prev;
    Node next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
}
class LRUCache {
    Node head;
    Node tail;
    HashMap<Integer,Node>map;
    int size;
    int count;
    public LRUCache(int capacity) {
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
        count=0;
        size=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            movetohead(node);
            return node.value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            movetohead(node);
        }
        else{
            Node node = new Node(key, value);
            map.put(key, node);
            addnode(node);       
            count++;

            if (count > size) {
                popTail();      
                count--;        
            }
        }
    }
    public void movetohead(Node node){
        deletenode(node);
        addnode(node);
    }
    public void deletenode(Node node){
        Node before=node.prev;
        Node after=node.next;
        before.next=after;
        after.prev=before;
    }
    public void addnode(Node node){
        Node afterhead=head.next;
        head.next=node;
        afterhead.prev=node;
        node.next=afterhead;
        node.prev=head;
    }
    public void popTail(){
        Node beforetail=tail.prev;
        map.remove(beforetail.key);
        deletenode(beforetail);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */