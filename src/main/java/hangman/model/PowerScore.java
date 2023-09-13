package hangman.model;

public class PowerScore implements GameScore{
    public int calculateScore(int correctCount, int incorrectCount) throws HangmanModelException{
            int resultadoFinal;
            int resMult;
            if (correctCount < 0) throw new HangmanModelException(HangmanModelException.LETRAS_CORRECTAS_MENORES);
            if (incorrectCount < 0) throw new HangmanModelException(HangmanModelException.LETRAS_INCORRECTAS_MENORES);

            if(correctCount < 1 ){
                resMult = 0;
            }else{
                resMult = (int) Math.pow(5, correctCount);
            }

            
            int resultado = resMult - incorrectCount * 8;
            if(resultado > 0){
                if(resultado > 500 ){
                    resultadoFinal = 500;
                }else{
                    resultadoFinal = resultado;
                }
            }else{
                resultadoFinal = 0;
            }
		return resultadoFinal;
	}
}