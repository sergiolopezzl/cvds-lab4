package hangman.model;

public class HangmanModelException extends Exception{
    public static final String LETRAS_CORRECTAS_MENORES = "Letras correctas deben (letras >= 0).";
    public static final String LETRAS_INCORRECTAS_MENORES = "Letras incorrectas deben ser (letras >= 0).";

    public HangmanModelException(String message) {
        super(message);
    }
}
