import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordGame {


    int numOfLetter;
    int difficulty;
    String ourString;
    String usersString;
    Map<String, List<String>> possibleWords;
    List<String> possibleSubString;

    WordGame(int numOfLetter, String usersString){
        this.numOfLetter = numOfLetter;
        this.usersString = usersString;
        this.possibleSubString = new ArrayList<>();
    }

    public void generateMap(){
        //change the class variable "possibleWords"
//        possibleWords = new HashMap<>();
//        possibleWords.put("")
    }

    public String nextGuess(){
        if (possibleSubString.isEmpty()){
            int lettersCommon = commonLetters(possibleWords.get)
        }
    }

    public int commonLetters(String guess, String actual){

    }

    public static void main(String[] args){
        //loop till win here
    }

}
