package hangman;
import static org.junit.Assert.*;
import org.junit.Test;
import hangman.model.HangmanModelException;
import hangman.model.OriginalScore;
import hangman.model.BonusScore;
import hangman.model.PowerScore;

/**
 * 
 * Clase de test para las implementaciones de GameScore (PowerScore, OriginalScore, BonusScore).
 * Clases de equivalencia y condiciones de frontera:
 * PowerScore: formula de calculo: puntaje = (5^correctas) - (8*incorrectas).
    Clases de equivalencia:
        Puntaje minimo (Caso valido):
            Numero de correctCount >= 0.
            Numero de incorrectCount >= 100.
            Resultado = 0.

        Puntaje maximo (Caso valido):
            Numero de correctCount >= 4.
            Numero de incorrectCount >= 0.
            Resultado = 500.

        Letras correctas mayores que cero e incorrectas iguales a cero:
            Numero de letras correctas > 0.
            Numero de letras incorrectas = 0.

        Letras incorrectas mayores que cero e incorrectas iguales a cero:
            Numero de letras correctas = 0.
            Numero de letras incorrectas > 0.

        Letras correctas negativas (Caso invalido):
            Numero de letras correctas < 0.

        Letras incorrectas negativas (Caso invalido):
            Numero de letras incorrectas < 0.

    Condiciones de frontera para PowerScore:
        Superior para correctCount: No hay una condicion de frontera superior especifica.

        Inferior para correctCount: correctCount > 0.

        Superior para incorrectCount: No hay una condicion de frontera superior especifica.

        Inferior para incorrectCount: incorrectCount > 0.

        Superior para el resultado : resultadoFinal = 500.

        Inferior para el resultado : resultadoFinal = 0

 * OriginalScore: formula de calculo: puntaje = (correctas * 10) - (incorrectas * 5).
    Clases de equivalencia:
        Puntaje minimo (Caso valido):
            Numero de letras correctas >= 0.
            Numero de letras incorrectas >= 10.
            Resultado = 0.

        Puntaje inicial (Caso valido):
            Numero de letras correctas = 0.
            Numero de letras incorrectas = 0.
            Resultado = 100.

        Letras correctas mayores que cero e incorrectas iguales a cero:
            Numero de letras correctas > 0.
            Numero de letras incorrectas = 0.

        Letras incorrectas mayores que cero e incorrectas iguales a cero:
            Numero de letras correctas = 0.
            Numero de letras incorrectas > 0.

        Letras correctas negativas (Caso invalido):
            Numero de letras correctas < 0.

        Letras incorrectas negativas (Caso invalido):
            Numero de letras incorrectas < 0.


    Condiciones de frontera para OriginalScore:
        Superior para correctCount: No hay una condicion de frontera superior especifica.

        Inferior para correctCount: correctCount > 0.

        Superior para incorrectCount: No hay una condicion de frontera superior especifica.

        Inferior para incorrectCount: incorrectCount > 0.

        Superior para el resultado : resultadoFinal = No hay una condicion de frontera superior especifica.

        Inferior para el resultado : resultadoFinal = 0



 * BonusScore: formula de calculo: puntaje = (correctas * 5) - (incorrectas * 10).
    Clases de equivalencia:
        Puntaje minimo (Caso valido):
            Numero de letras correctas >= 0.
            Numero de letras incorrectas >= 10.
            Resultado = 0.

        Puntaje inicial (Caso valido):
            Numero de letras correctas = 0.
            Numero de letras incorrectas = 0.
            Resultado = 0.

        Letras correctas mayores que cero e incorrectas iguales a cero:
            Numero de letras correctas > 0.
            Numero de letras incorrectas = 0.

        Letras incorrectas mayores que cero e incorrectas iguales a cero:
            Numero de letras correctas = 0.
            Numero de letras incorrectas > 0.

        Letras correctas negativas (Caso invalido):
            Numero de letras correctas < 0.

        Letras incorrectas negativas (Caso invalido):
            Numero de letras incorrectas < 0.
 

Condiciones de frontera para BonusScore:
    Condiciones de frontera:
        Superior para correctCount: No hay una condicion de frontera superior especifica.

        Inferior para correctCount: correctCount > 0.

        Superior para incorrectCount: No hay una condicion de frontera superior especifica.

        Inferior para incorrectCount: incorrectCount > 0.

        Superior para el resultado : resultadoFinal = No hay una condicion de frontera superior especifica.

        Inferior para el resultado : resultadoFinal = 0

 */
public class GameScoreTest {

    @Test
    public void testOriginalScoreValidInput() throws HangmanModelException {
        OriginalScore originalScore = new OriginalScore();
        assertEquals(100, originalScore.calculateScore(0, 0));
        assertEquals(90, originalScore.calculateScore(0, 1));
        assertEquals(90, originalScore.calculateScore(1, 1));
        assertEquals(50, originalScore.calculateScore(5, 5));
    }

    @Test(expected = HangmanModelException.class)
    public void testOriginalScoreNegativeCorrectCou8nt() throws HangmanModelException {
        OriginalScore originalScore = new OriginalScore();
        originalScore.calculateScore(-1, 0);
    }

    @Test(expected = HangmanModelException.class)
    public void testOriginalScoreNegativeInceorrectCount() throws HangmanModelException {
        OriginalScore originalScore = new OriginalScore();
        originalScore.calculateScore(0, -1);
    }

    @Test
    public void testBonusScoreValidInput() throws HangmanModelException {
        BonusScore bonusScore = new BonusScore();
        assertEquals(0, bonusScore.calculateScore(0, 0));
        assertEquals(10, bonusScore.calculateScore(1, 0));
        assertEquals(10, bonusScore.calculateScore(2, 2));
        assertEquals(25, bonusScore.calculateScore(5, 5));
    }

    @Test(expected = HangmanModelException.class)
    public void testBonusScoreNegativeCorreectCount() throws HangmanModelException {
        BonusScore bonusScore = new BonusScore();
        bonusScore.calculateScore(-1, 0);
    }

    @Test(expected = HangmanModelException.class)
    public void testBonusScoreNegativeIncorerectCount() throws HangmanModelException {
        BonusScore bonusScore = new BonusScore();
        bonusScore.calculateScore(0, -1);
    }

    @Test
    public void testPowerScoreValidInput() throws HangmanModelException {
        PowerScore powerScore = new PowerScore();
        assertEquals(0, powerScore.calculateScore(0, 0));
        assertEquals(0, powerScore.calculateScore(1, 1));
        assertEquals(9, powerScore.calculateScore(2, 2));
        assertEquals(500, powerScore.calculateScore(5, 5));
    }

    @Test(expected = HangmanModelException.class)
    public void testPowerScoreNegativeCorrecetCount() throws HangmanModelException {
        PowerScore powerScore = new PowerScore();
        powerScore.calculateScore(-1, 0);
    }

    @Test(expected = HangmanModelException.class)
    public void testPowerScoreNegativeIncorreectCount() throws HangmanModelException {
        PowerScore powerScore = new PowerScore();
        powerScore.calculateScore(0, -1);
    }

















    
}

