
package hangman.model;


public interface GameScore {
    
    public abstract int calculateScore(int correctCount, int incorrectCount) throws HangmanModelException;
    
}