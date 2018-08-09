import java.io.File;
import java.util.*;

public class WordGame2 {

    int numOfChars;
    List<Set<String>> allMatches;
    List<String> narrowMatches;
    private List<String> words;

    WordGame2( int numOfChars){
        this.numOfChars = numOfChars;
        allMatches = new ArrayList<>();
        narrowMatches = new ArrayList<>();
        allValidWords();
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
    { 	words= new ArrayList<>();
        String file = "/Users/sanranganathan/Downloads/words.txt";
        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNext()) {
                String s = sc.next();
                if (isUnique(s) && s.length()== numOfChars) {
                    words.add(s);
                }
            }
        } catch (Exception e){
            System.out.println("Something is wrong");
        }
    }

    public Set<String> wordsSameCommon (String str, int com){
        Set<String> allCommonWords = new HashSet<>();

        for (String s: words){
            if (commonLetters(s, str) == com && !s.equals(str)){
                allCommonWords.add(s);
            }
        }
        return allCommonWords;
    }

    public int commonLetters(String guess, String actual){
        int ctr=0;
        for(int i=0;i<guess.length();i++)
        {
            char x=guess.charAt(i);
            if(actual.indexOf(x)>=0)
            {
                actual.replace(String.valueOf(x),"");
                ctr++;
            }
        }
        return ctr;
    }

    public String guess(String str, int n){
        if (!narrowMatches.isEmpty()){
            String nextGuess = narrowMatches.get(0);
            narrowMatches.remove(0);
            return nextGuess;
        }
        if (allMatches.isEmpty()){
            allMatches.add(wordsSameCommon(str, n));
            return null;
        } else {
            allMatches.add(wordsSameCommon(str, n));
            Set<String> first = new HashSet<>(allMatches.get(0));
            for(Set<String> setOfMatches : allMatches){
                first.retainAll(setOfMatches);
            }
            System.out.print("Set - "+String.valueOf(first.size())+" ");
            System.out.println(first);
            if (first.size() < 20){
                for (String s : first){
                    narrowMatches.add(s);
                }
            }
        }
        return null;
    }

    public String getRandom (){
        Random random = new Random();
        int index = random.nextInt(words.size());
        return words.get(index);
    }

    public static void main(String []args){
        WordGame2 w = new WordGame2(6);
//        System.out.println(w.words);
        Scanner scanner = new Scanner(System.in);
        String userString = "AGNIZE";
//        System.out.println(w.commonLetters(userString, "BROKE"));
        String compString = w.getRandom();

//        System.out.print("Your Secret String - ");
//        String userString = scanner.nextLine();

        String userInput = "User Input";
        String guessStr = "guess Str";
        String ranStr = "random String";

        int i=0;

        while (!(userInput.equals(compString) || ranStr.equals(userInput) || (guessStr != null && guessStr.equals(userString)))){

            System.out.println("\nIteration - "+String.valueOf(i++) + "\n");

//            System.out.print("Your guess word - ");
//            userInput = scanner.nextLine();
//
//            System.out.print("Number of Common Letters - ");
//            System.out.println(w.commonLetters(userInput, compString));

            ranStr = w.getRandom();
            int common = w.commonLetters(userString, ranStr);

            if (common > 0) {
                guessStr = w.guess(ranStr, common);
                if (guessStr != null){
                    System.out.println("Comp Guess -  "+guessStr);
                    System.out.print("Number of Common Letters - ");
                    System.out.println(w.commonLetters(guessStr, userString));
                    continue;
                }
            }
            System.out.println("Comp Guess -  "+ranStr);
            System.out.print("Number of Common Letters - ");
            System.out.println(common);
        }
    }
}
