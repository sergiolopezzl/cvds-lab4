package hangman.model;

public class PowerScore implements GameScore{
    public int calculateScore(int correctCount, int incorrectCount) throws HangmanModelException{
            int resultadoFinal;
            if (correctCount < 0) throw new HangmanModelException(HangmanModelException.LETRAS_CORRECTAS_MENORES);
            if (incorrectCount < 0) throw new HangmanModelException(HangmanModelException.LETRAS_CORRECTAS_MENORES);
            int resMult = (int) Math.pow(5, correctCount);
            int resultado = resMult - (incorrectCount * 8);
            if(resultado >= 0){
                if(resultado <= 500 ){
                    resultadoFinal = resultado;
                }else{
                    resultadoFinal = 500;
                }
            }else{
                resultadoFinal = 0;
            }
		return resultadoFinal;
	}
}