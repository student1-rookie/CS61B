public class LinkedListDeque<T> implements Deque<T> {
    private int size;
    private node last;
    private node sentinel;
    private class node {
        public node prev;
        public T data;
        public node next;
        public node(T i){
            this.next = null;
            this.data = i;
            this.prev = null;
        }
    }
    public LinkedListDeque() {
        sentinel = new node(null);
        last = null;
        size = 0;
    }


    public int size() {
        return size;
    }
    public void addFirst(T i) {
        size++;
        node p = new node(i);
        if(size == 1) {
            last = p;
            sentinel.next = p;
        } else {
            p.next = sentinel.next;
            sentinel.next.prev = p;
            sentinel.next = p;
        }
    }
    public  void addLast(T i) {
        size++;
        node p = new node(i);
        if(size == 1) {
            sentinel.next = p;
            last = p;
            return;
        }
        last.next = p;
        p.prev = last;
        last = p;
    }
    public T removeFirst() {
        if(sentinel.next == null) {
            return null;
        }
        size--;
        node q = sentinel.next;
        T x = sentinel.next.data;
        sentinel.next = sentinel.next.next;
        if(sentinel.next != null) {
            sentinel.next.prev = null;
        }
        if(size == 0) {
            last = null;
        }
        q.next = null;
        return x;
    }
    public T removeLast() {
        if(last == null) {
            return null;
        }
        size--;
        node q = last;
        T x = last.data;
        if(size == 0) {
            sentinel.next = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
            q.prev = null;
        }

        q.next = null;
        return x;
    }
    public T get(int i) {
        if(i > size) {
            return null;
        }
        node p = sentinel.next;
        int n = 0;
        while(n != i) {
            p = p.next;
            n++;
        }
        return p.data;
    }
    public void printDeque() {
        node p = sentinel.next;
        StringBuilder s = new StringBuilder();
        while(p != null) {
            s.append(p.data).append(" ");
            p = p.next;
        }
        System.out.println(s);
    }
    private T help(node a,int i) {
        if(i == -1) {
            return a.data;
        }
        return help(a.next,--i);
    }
    public T getRecursive(int i) {
        if(i > size) {
            return null;
        }
        return help(sentinel,i);
    }
    public T getFirst(){
        if(size==0) return null;
        return sentinel.next.data;
    }
    public T getLast(){
        if(size==0) return null;
        return last.data;
    }
}
