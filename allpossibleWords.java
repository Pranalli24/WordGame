static List<String> wordsWithLen;

public List<String> allPossibleWords(String str, int n) {
		List<String> tmp = new ArrayList<>();
		for(int i=0; i<wordsWithLen.size(); i++) {
			if(commonletters(str, wordsWithLen.get(i))tmp.add(wordsWithLen.get(i))
		}
		return tmp;
	}
