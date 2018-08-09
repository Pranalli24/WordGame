import sun.misc.InnocuousThread;

import java.io.File;
import java.util.*;

public class WordGame {


    int numOfLetter;
    int difficulty;
    int index;
    int commonLetters = 0;

    String ourString;
    String usersString;
    Map<String, List<String>> possibleWords;
    Map <Integer, String> allValidOnes;
    List<String> possibleSubString;

    WordGame(int numOfLetter, String usersString){
        index = 1;
        this.numOfLetter = numOfLetter;
        this.usersString = usersString;
        this.possibleSubString = new ArrayList<String>();
    }

    public void generateMap(){
        //change the class variable "possibleWords"
//        possibleWords = new HashMap<>();
//        possibleWords.put("")
    }

    public boolean isSubSequence(String str1, String str2)
    {
        for(int i=0;i<str2.length();i++){
            if (!str1.contains(String.valueOf(str2.charAt(i)))){
                return false;
            }
        }
        return true;
    }

    public boolean isUnique(String s){
        for(int i=0;i<s.length()-1;i++)
        {
            char t=s.charAt(i);
            for(int j=i+1;j<s.length();j++)
            {
                if(t == s.charAt(j))
                    return  false;
            }
        }
        return true;
    }

    public void allValidWords()
    { 	allValidOnes= new HashMap<Integer, String>();
        String file = "/Users/sanranganathan/Downloads/words.txt";
        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNext()) {
                String s = sc.next();
                if (isUnique(s)) {
                    allValidOnes.put(s.length(), s);

                }
            }
        } catch (Exception e){
            System.out.println("Something is wrong");
        }
    }

    public String nextGuess(){

        String guessString = "";
        if (possibleSubString.isEmpty()){
            int i = 0;
            for (Map.Entry<String, List<String>> t : possibleWords.entrySet()){
                if (i++ == index){
                    guessString = t.getValue().get(0);
                }
            }
            index++;
            //int common = commonLetters(guessString, usersString);
        } else {
           List<String> removeString = new ArrayList<>();
            for (String s : possibleSubString) {
                String guessSeq = s;
                for (Map.Entry<String, List<String>> t : possibleWords.entrySet()) {
                    if (isSubSequence(t.getKey(), guessSeq)) {
                        for (String validWords : t.getValue()) {
                            guessString = validWords;
                        }
                    }
                }
                removeString.add(s);
                if (!guessString.equals("")){
                    return guessString;
                }
            }
            for (String s: removeString){
                possibleSubString.remove(s);
            }
        }
        return guessString;

    }

    public void updateGuessParam (String lastGuess,int common){
        if (common>=commonLetters){
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
        WordGame w = new WordGame(4, "WORD");
        w.allValidWords();
        WordGuess wg = new WordGuess(4,"dog");
        wg.generateMap(4);
//        System.out.print(wg.possibleWords);
        w.possibleWords = wg.possibleWords;
        String word = "word";
        String guess = w.nextGuess();
        do {
            int common = w.commonLetters(guess, word);
            guess = w.nextGuess();
            w.updateGuessParam(guess, common);
            System.out.println(guess);
        }while(!guess.equals(word));
    }

}
