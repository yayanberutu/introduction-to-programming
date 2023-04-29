package TK3;

import java.util.*;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: CoepoeWordPuzzle.java , v 0.1 2023-04-27 16.44 Yosepri Disyandro Berutu Exp $$
 */
public class CoepoeWordPuzzle {

    /** jumlah level */
    public static final int maxLevel = 3;

    /** kesempatan maksimal dalam setiap level */
    public static final int maxChancePerLevel = 10;

    public static final int minInputWordLength = 3;

    public static final int maxInputWordLength = 6;

    public static final int passingGradeEachLevel = 70;

    public static Map<Integer, List<String>> wordLevel;

    public static Map<Integer, List<String>> validWordsMap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printRule();
        initiateCoepoeWordWithMap();
        initiateValidWords();

        //level 1 = d, e, t, t, l ,i
        //level 2 = s, e, c, a, e, n
        //level 3 = h, k, r, n, e, o

        int level = 1;
        int totalScore = 0;
        do {
            // menampilkan level
            System.out.println("Level " + level);
            System.out.println("=============");

            // print huruf yang tersedia
            for(String str : wordLevel.get(level)){
                System.out.print(str + " ");
            }
            System.out.println();

            // looping chance nya
            int scoreEachLevel = 0;

            Map<String, String> inputWords = new HashMap<>();

            for(int i=1; i<=10; i++){
                System.out.printf("%d) Your Answer : ", i);
                String inputWord = scanner.nextLine();

                //apakah kata yang input sudah dinput sebelumnya
                if(inputWords.containsKey(inputWord)){
                    System.out.println("You had already type this word before..");
                }
                else if(isCorrectInputWord(inputWord, level)){
                    // tambahi score nya
                    scoreEachLevel += 10;
                    System.out.println("#Right. Score : " + scoreEachLevel);
                }
                inputWords.put(inputWord, inputWord);

            }

            System.out.printf("You had answered %d times with %d right answers..\n\n", maxChancePerLevel, scoreEachLevel/10);


            // kalau mencapai passing grade, maka level akan dinaikkan
            // tetapi kalau tidak, maka tidak dinaikkan
            if(scoreEachLevel < passingGradeEachLevel){
                System.out.println("You Loss!! Try Again..");
                System.out.print("Do you want to retry[y/t] ? ");
                char retry = scanner.next().charAt(0);
                scanner.nextLine();

                // kalau tidak mau retry,
                if(retry == 't') {
                    break;
                }
            } else {
                printValidWords(level);
                level++;
            }

            totalScore += scoreEachLevel;
        } while(level <= 3);

        System.out.println("Overall score : " + totalScore);
        System.out.println("You Win!!");
        System.out.println("Press Enter to exit..");
        scanner.nextLine();
    }

    private static void printValidWords(int level) {
        System.out.println("Correct Answer: ");
        int i = 1;
        for(String str : validWordsMap.get(level)){
            System.out.print(str + " ");
            if(i % 10 == 0){
                System.out.println();
            }
            i++;
        }
        System.out.println("\n\n");
    }

    private static boolean isCorrectInputWord(String inputWord, int level) {
        // cek length
        if(inputWord.length() < minInputWordLength || inputWord.length() > maxInputWordLength){
            return false;
        }

        // cek apakah kata yang dicek merupakan kombinasi yang benar (merupakan bagian dari kata yang dikasih)
        if(!isCorrectCombination(inputWord, level)){
            return false;
        }

        // is valid word in english
        if(!isValidWordInEnglish(inputWord, level)){
            return false;
        }

        return true;
    }

    /**
     *
     * @param inputWord
     * @return
     */
    private static boolean isValidWordInEnglish(String inputWord, int level) {
        return validWordsMap.get(level).contains(inputWord);
    }

    private static boolean isCorrectCombination(String inputWord, int level) {
        List<String> providedWords = wordLevel.get(level);
        for(int i=0; i<inputWord.length(); i++){
            if(!providedWords.contains(String.valueOf(inputWord.charAt(i)))){
                return false;
            }
        }

        return true;
    }


    private static void initiateCoepoeWordWithMap() {
        wordLevel = new HashMap<>();
        wordLevel.put(1, new ArrayList<>(Arrays.asList("d", "e", "t", "t", "l", "i")));
        wordLevel.put(2, new ArrayList<>(Arrays.asList("s", "e", "c", "a", "e", "n")));
        wordLevel.put(3, new ArrayList<>(Arrays.asList("h", "k", "r", "n", "e", "o")));

    }

    /**
     * Method ini digunakan untuk mencetak rule game.
     */
    private static void printRule() {
        System.out.println("Coepe World Puzzle");
        System.out.println("===================\n");

        System.out.println("Rules :");
        System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters.");
        System.out.println("2. Each level, you have 10 chances to answer correctly.");
        System.out.println("3. To get through to next level, you have to score 70 points each level.");

    }

    private static void initiateValidWords(){
        validWordsMap = new HashMap<>();

        // For Level 1, below are the valid words:
        // tilted, titled
        // tilde, tiled, title
        // deil, deli, delt, diel, diet, dite, edit, idle, lied, lite, tide, tied, tile, tilt
        // del, die, dit, eld, led, lei, let, lid, lie, lit, ted, tel, tet, tie, til, tit
        validWordsMap.put(1, new ArrayList<>(Arrays.asList("del","die","dit","eld","led","lei","let","lid","lie",
                "lit","ted","tel","tet","tie","til","tit",
                "deil","deli","delt","diel","diet","dite","edit","idle", "lied","lite","tide","tied","tile","tilt",
                "tilde","tiled","title",
                "tilted","titled")));

        // For Level 2, below are the valid words:
        // encase, seance, seneca
        // acnes, canes, cease, cense, scena, scene
        // aces, acne, anes, cane, cans, case, cees, ease, esne, sane, scan, seen, sene
        // ace, ane, can, cee, ens, nae, nee, sac, sae, sea, sec, see, sen
        validWordsMap.put(2, new ArrayList<>(Arrays.asList("ace","ane","can","cee","ens","nae","nee","sac","sae","sea","sec","see","sen",
                "aces","acne","anes","cane","cans","case","caes","ease","esne","sane","scan","seen","sene",
                "acnes","canes","cease","cense","scena","scene",
                "encase", "seance","seneca")));

        // For Level 3, below are the valid words:
        // heron, honer, krone
        // hern, hero, hoer, hoke, hone, horn, keno, kern, kore, okeh
        // eon, ern, hen, her, hoe, hon, ken, kor, noh, nor, oke, one, ore, rho, roe
        validWordsMap.put(3, new ArrayList<>(Arrays.asList("eon","ern","her","hoe","hon","ken","kor","noh","nor","oke","one","ore","rho","roe",
                "hern","hero","hoer","hoke","hone","horn","keno","kern","kore","okeh",
                "heron","honer","krone")));

    }
}
