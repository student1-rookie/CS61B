public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> lld =new LinkedListDeque<Character>();
        for(int i=0;i<word.length();i++){
            lld.addLast(word.charAt(i));
        }
        return lld;
    }
    public boolean isPalindrome(String word,CharacterComparator cc){
        Deque<Character> d=wordToDeque(word);
        while (d.size()>1){
            if(!cc.equalChars(d.getFirst(),d.getLast())) return false;
            d.removeFirst();
            d.removeLast();
        }
        return true;
    }
    public boolean isPalindrome(String word){
        Deque<Character> d=wordToDeque(word);
        while (d.size()>1){
            if(d.getFirst()!=d.getLast()) return false;
            d.removeFirst();
            d.removeLast();
        }
        return true;
    }
}
