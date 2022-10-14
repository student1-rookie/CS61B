public class LinkedListDeque<type> {
    private int size;
    private node first;
    private node last;
    public class node{
        public node prev;
        public type data;
        public node next;
        public node(type i){
            this.next=null;
            this.data=i;
            this.prev=null;
        }
    }
    public LinkedListDeque(){
        first=null;
        last=null;
        size=0;
    }
    public boolean isEmpty(){
        if(this.size==0){
            return true;
        }
        return false;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        node q=first;
        if(q==null){
            System.out.println("null");
            return ;
        }
        System.out.println(q.data);
        while(q.next!=null){
            q=q.next;
            System.out.println(q.data);
        }
    }
    public void addFirst(type i){
        if(first==null){
            size++;
            node p=new node(i);
            first=p;
            last=p;
        }else{
            size++;
            node q=first;
            node x=new node(i);
            x.next=q;
            q.prev=x;
            first=q.prev;
        }
    }
    public void addLast(type i){
        if(last==null){
            node p=new node(i);
            first=p;
            last=p;
            size++;
        }else{
            size++;
            node q=last;
            node x=new node(i);
            q.next=x;
            x.prev=q;
            last =q.next;
        }
    }
    public void removeFirst(){
        if(size==0){
            return ;
        }
        if(size==1){
            size--;
            first=null;
            last=null;
            return ;
        }
        node p=first;
        first=p.next;first.prev=null;p.next=null;
        size--;
    }
}
