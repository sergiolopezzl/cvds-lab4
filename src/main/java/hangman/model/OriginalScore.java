package hangman.model;

public  class OriginalScore implements GameScore {
    public int calculateScore(int correctCount, int incorrectCount) throws HangmanModelException {
        int resultadoFinal;
		if (correctCount < 0) throw new HangmanModelException(HangmanModelException.LETRAS_CORRECTAS_MENORES);
		if (incorrectCount < 0) throw new HangmanModelException(HangmanModelException.LETRAS_INCORRECTAS_MENORES);
		int resultado = 100 - incorrectCount * 10;
        if(resultado >= 0){
            resultadoFinal = resultado;
        }else{
            resultadoFinal = 0;
        }
        return resultadoFinal;
	}
}
