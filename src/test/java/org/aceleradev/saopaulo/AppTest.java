package org.aceleradev.saopaulo;

import org.aceleradev.saopaulo.MathOperations.Addition;
import org.aceleradev.saopaulo.MathOperations.Division;
import org.aceleradev.saopaulo.MathOperations.Interface.Operator;
import org.aceleradev.saopaulo.MathOperations.Subtraction;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testAddition()
    {
        Operator add = new Addition();

        assertEquals(add.opera(1, 1), 2);

        assertEquals(add.opera(0, 0), 0);

        assertEquals(add.opera(0, -5), -5);

    }

    @Test
    public void testSubtration()
    {
        Operator rem = new Subtraction();

        assertEquals(rem.opera(5, 20), -15);

        assertEquals(rem.opera(-5, -5), 0);

    }

    @Test
    public void testDivision()
    {

        Operator div = new Division();
        //<div> HTML kkkk </div>

        assertEquals(div.opera(2, 2), 1);

        try {
            div.opera(5, 0);
        }catch (ArithmeticException ex){
            assertThat(ex.getMessage(), is("Não é possível realizar a operação. \n Motivo: Você está dividindo por zero"));
        }

    }


    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
