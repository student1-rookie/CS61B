public class ArrayDeque<type> {
    private type []items;
    private int nextFirst;
    private int nextLast;
    private int totalSize;
    private int size;
    public ArrayDeque(){
        size=0;
        nextFirst=0;
        nextLast=1;
        totalSize=8;
        items= (type[]) new Object[8];
    }

    public ArrayDeque(ArrayDeque other){
        this.items= (type[]) other.items;
        this.size=other.size;
        this.totalSize= other.totalSize;
        this.nextLast= other.nextLast;
        this.nextFirst= other.nextFirst;
    }

    private void expand(){
        totalSize*=2;
        type []newItems=(type[]) new Object[totalSize];
        if(nextLast==totalSize-1){
            nextLast=0;
        }
        for(int n=0;n<=nextFirst;n++){
            newItems[n]=items[n];
        }
        for(int n=nextLast;n<size;n++){
            newItems[totalSize-size+n]=items[n];
        }
        items=newItems;

        nextFirst=nextFirst+totalSize-size;
    }

    private void shrink(){
        type []p= (type[]) new Object[size];
        int i=0;
        for(int j=0;j<totalSize;j++){
            if(items[j]!=null){
                p[i]=items[j];
                i++;
            }
        }
        if(nextLast>size){
            nextLast=size;
        }
        nextFirst=nextFirst-totalSize+size;
        totalSize=totalSize/2;
        items=p;
    }

    public void addFirst(type i){
        if(size==totalSize){
            expand();
        }
        items[nextFirst] = i;
        size++;
        if(nextFirst==0){
            nextFirst=totalSize-1;
            while(items[nextFirst]!=null){
                nextFirst--;
            }
        }else{
            nextFirst--;
        }
    }

    public void addLast(type i){
        if(size==totalSize){
            expand();
        }
        items[nextLast]=i;
        size++;
        if(nextLast==totalSize-1){
            nextLast=0;
            while(items[nextLast]!=null){
                nextLast++;
            }
        }else {
            nextLast++;
        }
    }

    public type removeFirst(){
        type x=null;
        size--;
        if(nextFirst==totalSize-1){
            nextFirst=0;
        }else{
            nextFirst++;
        }
        x=items[nextFirst];
        items[nextFirst]=null;

        if(size==totalSize/2&&totalSize!=8){
            shrink();
        }
        return x;
    }

    public type removeLast(){
        type x=null;
        size--;
        if(nextLast==0){
            nextLast=totalSize-1;
        }else{
            nextLast--;
        }
        x=items[nextLast];
        items[nextLast]=null;

        if(size==totalSize/2&&totalSize!=8){
            shrink();
        }
        return x;
    }

    public void printDeque(){
        StringBuilder s= new StringBuilder();
        for(int i=0;i<totalSize;i++){
            s.append(items[i]).append(" ");
        }
        System.out.println(s);
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public type get(int index){
        if(index>=totalSize){
            return null;
        }
        return items[index];
    }

}
