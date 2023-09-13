package hangman.model;

public interface GameScore {
/**
	 * Calcula el puntaje del juego.
	 * @param correctCount letras correctas.
	 * @param incorrectCount letras incorrectas.
	 * @return resultado del puntaje.
	 * @pre calculo de letras correctas e incorrectas.
	 * @pos calculo del puntaje.
     * @throws HangmanModelException
     **/
    public abstract int calculateScore(int correctCount, int incorrectCount) throws HangmanModelException;
    
}