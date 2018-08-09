import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordGame {


    int numOfLetter;
    Map<String, List<String>> possibleWords;
    List<String> possibleSubString;
    int difficulty;

    WordGame(int numOfLetter){
        this.numOfLetter = numOfLetter;
        possibleSubString = new ArrayList<>();
    }

    public void generateMap(){
        //change the class variable "possibleWords"
//        possibleWords = new HashMap<>();
//        possibleWords.put("")
    }

    public String nextGuess(){

    }

    public int commonLetters(String guess, String actual){

    }

    public static void main(String[] args){
        //loop till win here
    }

}
