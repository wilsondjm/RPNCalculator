import me.vincent.rpncalculator.CalculationService;
import me.vincent.rpncalculator.RPNCalculationServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Vincent.Huang on 2018/9/17.
 * @Author Vincent.Huang
 */
public class StandAloneOperationTestCase {

    private CalculationService calculationService;


    public StandAloneOperationTestCase(){
    }

    @Before
    public void setUpBefore(){
        calculationService = new RPNCalculationServiceImpl();
    }

    @After
    public void clearAfter(){
        calculationService.execute("clear");
        calculationService = null;
    }

    @Test
    public void TestPutOperation(){
        String command = "5 2";
        String expected = "5 2";

        calculationService.execute(command);
        String result = calculationService.getStackAsString();

        Assert.assertTrue(result.equalsIgnoreCase(expected));
    }

    @Test
    public void TestClearOperation(){
        String command = "2 sqrt 1 2 3 clear 1 2";
        String expected = "1 2";

        calculationService.execute(command);
        String result = calculationService.getStackAsString();

        Assert.assertTrue(result.equalsIgnoreCase(expected));
    }

    @Test
    public void TestSqrtOperation(){
        String command = "2 sqrt";
        String expected = "1.4142135624";

        calculationService.execute(command);
        String result = calculationService.getStackAsString();

        Assert.assertTrue(result.equalsIgnoreCase(expected));
    }

    @Test
    public void TestUndoOperation(){
        String command = "1 2 3 + - 2 undo undo clear undo";
        String expected = "1 5";

        calculationService.execute(command);
        String result = calculationService.getStackAsString();

        Assert.assertTrue(result.equalsIgnoreCase(expected));
    }

    @Test
    public void TestAddOperation(){
        String command = "1 2 3 + +";
        String expected = "6";

        calculationService.execute(command);
        String result = calculationService.getStackAsString();

        Assert.assertTrue(result.equalsIgnoreCase(expected));
    }

    @Test
    public void TestSubOperation(){
        String command = "1 2 3 - -";
        String expected = "2";

        calculationService.execute(command);
        String result = calculationService.getStackAsString();

        Assert.assertTrue(result.equalsIgnoreCase(expected));
    }

    @Test
    public void TestMultipOperation(){
        String command = "1 2.5 3 * *";
        String expected = "7.5";

        calculationService.execute(command);
        String result = calculationService.getStackAsString();

        Assert.assertTrue(result.equalsIgnoreCase(expected));
    }

    @Test
    public void TestDiviOperation(){
        String command = "1 8 / 4 * 8 /";
        String expected = "0.0625";

        calculationService.execute(command);
        String result = calculationService.getStackAsString();

        Assert.assertTrue(result.equalsIgnoreCase(expected));
    }
}
