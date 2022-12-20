import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Scrabble {

    private boolean doubleWordScore;
    private boolean tripleWordScore;
    private String word;
    private HashMap<Character, Integer> scoreMap = new HashMap<>();

    private ArrayList<Character> lettersWithDoubleScore = new ArrayList<>();
    private ArrayList<Character> lettersWithTripleScore = new ArrayList<>();

    public Scrabble(String word) {
        this.word = word;
        setScoreMap();

    }

    public Scrabble(String word, Character[] lettersWithDoubleScore, Character[] lettersWithTripleScore, boolean doubleWordScore, boolean tripleWordScore) {
        this.setScoreMap();
        this.word = word;
        this.lettersWithDoubleScore.addAll(Arrays.asList(lettersWithDoubleScore));
        this.lettersWithTripleScore.addAll(Arrays.asList(lettersWithTripleScore));
        this.doubleWordScore = doubleWordScore;
        this.tripleWordScore = tripleWordScore;
    }

    public int score() {
        if (this.word == null) {
            return 0;
        }
        int score = scoreLetters(this.word);
        score = applyDoubleLetterScores(lettersWithDoubleScore, score);
        score = applyTripleLetterScores(lettersWithTripleScore, score);
        score = doubleWord(score);
        score = tripleWord(score);
        return score;
    }


    private int scoreLetters(String str) {
        int score = 0;
        for (int i = 0, n = str.length(); i < n; i++) {
            score += getScoreForLetter(str.charAt(i));
        }
        return score;
    }

    private int getScoreForLetter(Character letter) {

        return scoreMap.get(Character.toUpperCase(letter));
    }

    private int getScoreForLetter(char letter) {

        return scoreMap.get(Character.toUpperCase(new Character(letter)));
    }

    private int doubleWord(int score) {
        if (this.doubleWordScore == true) {
            score *= 2;
        }
        return score;
    }

    private int tripleWord(int score) {
        if (this.tripleWordScore == true) {
            score *= 3;
        }
        return score;
    }

    private int applyDoubleLetterScores(ArrayList<Character> letters, int score) {
        for (Character letter : letters) {
            score += getScoreForLetter(letter);
        }
        return score;
    }

    private int applyTripleLetterScores(ArrayList<Character> letters, int score) {
        for (Character letter : letters) {
            score += (getScoreForLetter(letter) * 2);
        }
        return score;
    }

    private void setScoreMap() {
        this.scoreMap.put('A', 1);
        this.scoreMap.put('E', 1);
        this.scoreMap.put('I', 1);
        this.scoreMap.put('O', 1);
        this.scoreMap.put('U', 1);
        this.scoreMap.put('L', 1);
        this.scoreMap.put('N', 1);
        this.scoreMap.put('R', 1);
        this.scoreMap.put('S', 1);
        this.scoreMap.put('T', 1);
        this.scoreMap.put('D', 2);
        this.scoreMap.put('G', 2);
        this.scoreMap.put('B', 3);
        this.scoreMap.put('C', 3);
        this.scoreMap.put('M', 3);
        this.scoreMap.put('P', 3);
        this.scoreMap.put('F', 4);
        this.scoreMap.put('H', 4);
        this.scoreMap.put('V', 4);
        this.scoreMap.put('W', 4);
        this.scoreMap.put('Y', 4);
        this.scoreMap.put('K', 5);
        this.scoreMap.put('J', 8);
        this.scoreMap.put('X', 8);
        this.scoreMap.put('Q', 10);
        this.scoreMap.put('Z', 10);
    }


}
