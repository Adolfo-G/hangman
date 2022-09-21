package hangman;

import java.lang.reflect.Array;
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

            System.out.println(Arrays.toString(gameWord));
            System.out.println("Guessed Letters: "+guessedLetters);
            System.out.print("Guess: ");
            String guess = scanner.nextLine();
            
            guessedLetters+=guess;

            for(int i = 0; i<wordArray.length;i++){
                if(guess.equals(wordArray[i])){
                    gameWord[i]=guess;
                    guessedCorrect=true;
                }
            }

            if(guessedCorrect==false){
                wrongAnswers++;
            }

           gameIsOn=CheckWinOrLose(gameWord, gameIsOn, wrongAnswers);
        
        } 
        
    }
    public static boolean CheckWinOrLose(String[] gameWord, boolean gameIsOn, int wrongAnswers){
        if(!Arrays.stream(gameWord).anyMatch("_"::equals)){
            System.out.println(Arrays.toString(gameWord));
            System.out.println("You Won!");
            return false;
        }
        else if(wrongAnswers==5){
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

}