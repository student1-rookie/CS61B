public class LinkedListDeque<type> {
    private int size;
    private node last;
    private node sentinel;
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
        sentinel=new node(null);
        last=null;
        size=0;
    }

    public LinkedListDeque(LinkedListDeque l){
        this.size=l.size;
        this.sentinel=l.sentinel;
        this.last=l.last;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(type i){
        size++;
        node p=new node(i);
        if(size==1){
            last=p;
            sentinel.next=p;
        }else{
            p.next=sentinel.next;
            sentinel.next.prev=p;
            sentinel.next=p;
        }
    }

    public  void addLast(type i){
        size++;
        node p=new node(i);
        if(size==1){
            sentinel.next=p;
            last=p;
            return;
        }
        last.next=p;
        p.prev=last;
        last=p;
    }

    public type removeFirst(){
        if(sentinel.next==null) return null;
        size--;
        type x=sentinel.next.data;
        sentinel.next=sentinel.next.next;
        if(size==0){
            last=null;
        }
        return x;
    }

    public type removeLast(){
        if(last==null) return null;
        size--;
        type x=last.data;
        if(size==0){
            sentinel.next=null;
            last=null;
        }else{
            last =last.prev;
            last.next=null;
        }
        return x;
    }

    public type get(int i){
        if(i>size) return null;
        node p=sentinel.next;
        int n=1;
        while(n!=i){
            p=p.next;
            n++;
        }
        return p.data;
    }

    public void printDeque(){
        node p=sentinel.next;
        StringBuilder s= new StringBuilder();
        while(p!=null){
            s.append(p.data).append(" ");
            p=p.next;
        }
        System.out.println(s);
    }

    public type help(node a,int i){
        if(i==0) return a.data;
        return help(a.next,--i);
    }

    public type getRecursive(int i){
        if(i>size) return null;

        return help(sentinel,i);
    }

}
