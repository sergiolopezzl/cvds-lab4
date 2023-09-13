package hangman.model;

public  class OriginalScore implements GameScore {
    /**
	 * Calcula el puntaje del juego.
	 * @param correctCount letras correctas.
	 * @param incorrectCount letras incorrectas.
	 * @return resultado del puntaje.
	 * @pre calculo de letras correctas e incorrectas.
	 * @pos calculo del puntaje, formula de calculo: puntaje = 100 - (10*incorrectas).
     * @throws HangmanModelException
     **/
    public int calculateScore(int correctCount, int incorrectCount) throws HangmanModelException {
        int resultadoFinal;
		if (correctCount < 0) throw new HangmanModelException(HangmanModelException.LETRAS_CORRECTAS_MENORES);
		if (incorrectCount < 0) throw new HangmanModelException(HangmanModelException.LETRAS_INCORRECTAS_MENORES);
		int resultado = 100 - incorrectCount * 10;
        if(resultado > 0){
            resultadoFinal = resultado;
        }else{
            resultadoFinal = 0;
        }
        return resultadoFinal;
	}
}
