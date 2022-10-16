public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y){
        if((x>=97&&x<=122)&&(y>=65&&y<=90)){
            return (x-y-32)==1||(x-y-32)==-1;
        }
        if((y>=97&&y<=122)&&(x>=65&&x<=90)){
            return (y-x-32)==1||(y-x-32)==-1;
        }
        return (x-y)==1||(x-y)==-1;
    }
}
