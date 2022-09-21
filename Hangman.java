package hangman;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman{
    public static void main(String[] args) {
        String word = getWord();
        System.out.println(word);
        String[] wordArray= word.split("");
        String[] gameWord = getBlanks(word);
        String guessedLetters = "";
        int wrongAnswers= 0;
        
        Scanner scanner = new Scanner(System.in);
        boolean gameIsOn=true;
    
        while(gameIsOn){
            boolean guessedCorrect = false;

            System.out.println(gallows[wrongAnswers]);
            System.out.println(Arrays.toString(gameWord));
            System.out.println("Guessed Letters: "+guessedLetters);
            System.out.print("Guess: ");
            String guess = scanner.nextLine();
            
            guessedLetters+=guess;

            guessedCorrect=checkGuess(wordArray, guess, gameWord, wrongAnswers);
            if(guessedCorrect==false){
                wrongAnswers++;
            }
           gameIsOn=CheckWinOrLose(gameWord, gameIsOn, wrongAnswers);
        
        } 
        scanner.close();
        
    }
    public static boolean checkGuess(String[] wordArray, String guess, String[] gameWord, int wrongAnswers) {
        boolean isCorrect = false;
        for(int i = 0; i<wordArray.length;i++){
            if(guess.equals(wordArray[i])){
                gameWord[i]=guess;
                isCorrect= true;
            }
        }
        return isCorrect;
        
    }
    public static boolean CheckWinOrLose(String[] gameWord, boolean gameIsOn, int wrongAnswers){
        if(!Arrays.stream(gameWord).anyMatch("_"::equals)){
            System.out.println(Arrays.toString(gameWord));
            System.out.println("You Won!");
            return false;
        }
        else if(wrongAnswers==6){
            System.out.println(gallows[wrongAnswers]);
            System.out.println("You Lose");
            return false;
        }else{
            return true;
        }
    }

    public static String[] getBlanks(String word){
        String [] gameWord = new String[word.length()];
        for(int i = 0;i<word.length();i++){
            gameWord[i]="_";
        }
        return gameWord;
    } 
    public static String getWord(){
        double randomDoubleNum = Math.floor(Math.random()*words.length);
        int randomNum = (int) Math.round(randomDoubleNum);
        String word = words[randomNum];
        return word;
    }
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear","beaver", "camel", "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat", "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose", "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal", "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout", "turkey","turtle", "weasel", "whale", "wolf", "wombat", "zebra"};
    public static String[] gallows = {
        "+---+\n" +
        "|   |\n" +
        "    |\n" +
        "    |\n" +   //if the user didn't miss any guesses.
        "    |\n" +
        "    |\n" +
        "=========\n",
    
        "+---+\n" +
        "|   |\n" +
        "O   |\n" +   //if the user missed one guess.
        "    |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n",
    
        "+---+\n" +
        "|   |\n" +
        "O   |\n" +    //if the user missed two guesses.
        "|   |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n",
    
        " +---+\n" +
        " |   |\n" +
        " O   |\n" +   //if the user missed three guesses.
        "/|   |\n" +
        "     |\n" +
        "     |\n" +
        " =========\n",
    
        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n"+   //if the user missed four guesses.
        "     |\n" +
        "     |\n" +
        " =========\n",
    
        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" +  //if the user missed five guesses.
        "/    |\n" +
        "     |\n" +
        " =========\n",
    
        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" +   //if the user missed six guesses.
        "/ \\  |\n" +
        "     |\n" +
        " =========\n"};
}