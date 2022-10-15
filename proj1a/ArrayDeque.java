public class ArrayDeque<T> {
    private T []items;
    private int nextFirst;
    private int nextLast;
    private int totalSize;
    private int size;
    public ArrayDeque(){
        size=0;
        totalSize=8;
        nextFirst=totalSize-1;
        nextLast=0;
        items=(T[]) new Object[8];
    }
    private void reSize(int x){
        T []newItems=(T[]) new Object[x];
        for(int i=1;i<size;i++){
            nextFirst++;
            newItems[i]=items[nextFirst%totalSize];
        }
        totalSize=size+1;
        nextFirst=0;
        nextLast=size;
        items=newItems;
    }
    public void addFirst(T i){
        if(size==totalSize){
            reSize(totalSize*2);
        }
        items[nextFirst]=i;
        size++;
        if(nextFirst==0){
            nextFirst=totalSize-1;
        }else{
            nextFirst--;
        }
    }
    public T removeFirst(){
        if(size==0){
            return null;
        }
        nextFirst=(nextFirst+1)%totalSize;
        T x=items[nextFirst];
        items[nextFirst]=null;
        size--;
        if(size<totalSize/4&&size>=16){
            reSize(totalSize/2);
        }
        return x;
    }
    public void addLast(T i){
        if(size==totalSize){
            reSize(totalSize*2);
        }
        items[nextLast]=i;
        size++;
        nextLast=(++nextLast)%totalSize;
    }
    public T removeLast(){
        if(size==0){
            return null;
        }
        if(nextLast==0){
            nextLast=totalSize-1;
        }else{
            nextLast--;
        }
        T x=items[nextLast];
        items[nextLast]=null;
        size--;
        if(size<totalSize/4&&totalSize>=16){
            reSize(totalSize/2);
        }
        return x;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public T get(int index){
        if(index>=size){
            return null;
        }
        return items[(nextFirst+1+index)%totalSize];
    }
    public void printDeque(){
        for(int i=(nextFirst+1)%totalSize;i!=nextLast-1;i=(i+1)%totalSize){
            System.out.print(items[i]+" ");
        }
        System.out.print(items[nextLast-1]);
    }
}
