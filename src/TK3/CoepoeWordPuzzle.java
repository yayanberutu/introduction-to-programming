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

    /** panjang minimal kata yang valid yang di input */
    public static final int minInputWordLength = 3;

    /** panjang maksimal kata valid yang di input */
    public static final int maxInputWordLength = 6;

    /** passing grade setiap level */
    public static final int passingGradeEachLevel = 70;

    /** list huruf setiap level */
    public static Map<Integer, List<String>> characterListEachLevel;

    /** Map yang berisi List of kata-kata yang valid */
    public static Map<Integer, List<String>> validWordsMap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: print rule pada game word puzzle
        printRule();

        // inisiasi charace
        initiateCharactersEachLevel();

        // inisiasi kata-kata yang valid
        initiateValidWords();

        int level = 1;
        int totalScore = 0;
        do {
            // menampilkan level
            System.out.println("Level " + level);
            System.out.println("=============");

            // print huruf yang tersedia
            for(String str : characterListEachLevel.get(level)){
                System.out.print(str + " ");
            }
            System.out.println();

            // looping chance nya
            int scoreEachLevel = 0;

            Map<String, String> inputWords = new HashMap<>();

            for(int i=1; i <= maxChancePerLevel; i++){
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
        } while(level <= maxLevel);

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

    /**
     * This method is to check is the input word is correct
     * There are 3 steps to check:
     *  Step 1 : Check if the word is in correct length.
     *           For now the minimum length is 3 and the maximum length is 6.
     *  Step 2 : Check if the input word is constructed by the given character each level.
     *           This is the optional checking since the third step ensure the step 2 is true.
     *  Step 3 : Check if the word is valid in english
     * @param inputWord
     * @param level
     * @return
     */
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
        return isValidWordInEnglish(inputWord, level);
    }

    /**
     * This method is to check if the input word is valid in English.
     * For now, we hardcoded the valid words in english (See {@link #initiateValidWords()} method)
     * But we can use another method such using the API of dictionary to check if the input word is valid
     * @param inputWord
     * @param level
     * @return
     */
    private static boolean isValidWordInEnglish(String inputWord, int level) {
        return validWordsMap.get(level).contains(inputWord);
    }

    /**
     * Method to check if a given input word is a correct combination of characters for the given level
     * @param inputWord
     * @param level
     * @return
     */
    private static boolean isCorrectCombination(String inputWord, int level) {
        Set<String> providedWords = new HashSet<>(characterListEachLevel.get(level));
        List<String> inputCharacters = Arrays.asList(inputWord.split(""));

        return providedWords.containsAll(inputCharacters);
    }

    /**
     * This method is to initiate characters each level that want to construct
     *  characters on level 1 = d, e, t, t, l ,i
     *  characters on level 2 = s, e, c, a, e, n
     *  characters on level 3 = h, k, r, n, e, o
     */
    private static void initiateCharactersEachLevel() {
        characterListEachLevel = new HashMap<>();
        characterListEachLevel.put(1, new ArrayList<>(Arrays.asList("d", "e", "t", "t", "l", "i")));
        characterListEachLevel.put(2, new ArrayList<>(Arrays.asList("s", "e", "c", "a", "e", "n")));
        characterListEachLevel.put(3, new ArrayList<>(Arrays.asList("h", "k", "r", "n", "e", "o")));

    }

    /**
     * This method is to print the rule of the game
     */
    private static void printRule() {
        System.out.println("Coepe World Puzzle");
        System.out.println("===================\n");

        System.out.println("Rules :");
        System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters.");
        System.out.println("2. Each level, you have 10 chances to answer correctly.");
        System.out.println("3. To get through to next level, you have to score 70 points each level.");

    }

    /**
     * This method is to initiate valid words that can be constructed from character given in each level
     *  characters on level 1 = d, e, t, t, l ,i
     *  characters on level 2 = s, e, c, a, e, n
     *  characters on level 3 = h, k, r, n, e, o
     * The list of words is hardcoded and got from <a href="https://wordfind.com/">https://wordfind.com/</a>
     */
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
