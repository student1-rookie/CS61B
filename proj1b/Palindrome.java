public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> lld =new LinkedListDeque<Character>();
        for(int i=0;i<word.length();i++){
            lld.addLast(word.charAt(i));
        }
        return lld;
    }
    public boolean isPalindrome(String word,CharacterComparator cc){
        String s="";
        int size=word.length();
        int mid=0;
        if(size%2!=0){
            mid=size/2;
        }
        if(size<=1) return true;
        for(int i=size-1;i>=0;i--){
            s+=word.charAt(i);
        }
        for(int i=0;i<size;i++){
            if(mid!=0&&i==mid) i++;
            boolean b=cc.equalChars(s.charAt(i),word.charAt(i));
            if(!b) return false;
        }
        return true;
    }
}
