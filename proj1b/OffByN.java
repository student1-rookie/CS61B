public class OffByN implements CharacterComparator{
    private int n;
    public OffByN(int n){
        this.n=n;
    }
    @Override
    public boolean equalChars(char x, char y){
        if((x>=97&&x<=122)&&(y>=65&&y<=90)){
            return (x-y-32)==n||(x-y-32)==-n;
        }
        if((y>=97&&y<=122)&&(x>=65&&x<=90)){
            return (y-x-32)==n||(y-x-32)==-n;
        }
        return (x-y)==n||(x-y)==-n;
    }
}
