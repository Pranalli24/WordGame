import java.util.*;

public class WordGame {


    int numOfLetter;
    int difficulty;
    int index;
    int commonLetters = 0;

    String ourString;
    String usersString;
    Map<String, List<String>> possibleWords;
    List<String> possibleSubString;

    WordGame(int numOfLetter, String usersString){
        this.numOfLetter = numOfLetter;
        this.usersString = usersString;
        this.possibleSubString = new ArrayList<String>();
    }

    public void generateMap(){
        //change the class variable "possibleWords"
//        possibleWords = new HashMap<>();
//        possibleWords.put("")
    }

    public boolean isSubSequence(String str1, String str2, int m, int n)
    {
        if (m == 0) return true;
        if (n == 0) return false;

        if (str1.charAt(m-1) == str2.charAt(n-1))
            return isSubSequence(str1, str2, m-1, n-1);

        return isSubSequence(str1, str2, m, n-1);
    }


    public String nextGuess(){

        String guessString = "";
        if (possibleSubString.isEmpty()){
            index = 1;
            int i = 0;
            for (Map.Entry<String, List<String>> t : possibleWords.entrySet()>){
                if (i++ == index){
                    guessString = t.getValue().get(0);
                }
            }
            //int common = commonLetters(guessString, usersString);
        } else {
            String guessSeq =  possibleSubString.get(0);
            for (Map.Entry<String, List<String>> t : possibleWords.entrySet()){
                if(isSubSequence(t.getKey(), guessSeq, t.getKey().length(), guessSeq.length())){
                    for (String s : t.getValue()){
                        guessString = s;
                    }
                }
            }
        }
        return guessString;

    }

    public void updateGuessParam (String lastGuess,int common){
        if (common>commonLetters){
            possibleSubString = new ArrayList<String>();
            SubSeq.subsequence(lastGuess);
            HashSet<String> allSeq = SubSeq.st;
            for (String s: allSeq){
                if (s.length() == common){
                    possibleSubString.add(s);
                }
            }
        }
    }

    public int commonLetters(String guess, String actual){
        int ctr=0;
        for(int i=0;i<guess.length();i++)
        {
            char x=guess.charAt(i);
            if(actual.indexOf(x)>=1)
            {
                actual.replace(String.valueOf(x),"");
                ctr++;
            }

        }
        return ctr;
    }

    public static void main(String[] args){
        //loop till win here
    }

}
