import me.vincent.rpncalculator.CalculationService;
import me.vincent.rpncalculator.RPNCalculationServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by 011291
 *
 * @Author Vincent.Huang
 */
public class CombineTestCases {

    private CalculationService calculationService;

    @Before
    public void setUpBefore() {
        calculationService = new RPNCalculationServiceImpl();
    }

    @After
    public void clearAfter() {
        calculationService.execute("clear");
        calculationService = null;
    }

    @Test
    public void TestCase1() {
        String command = "3 4 12312312312312312 3 5 2 + 3 * 7 / clear undo 3 undo";
        String expected = "3 4 12312312312312312 3 3";

        calculationService.execute(command);
        String result = calculationService.getStackAsString();

        Assert.assertTrue(result.equalsIgnoreCase(expected));
    }

    @Test
    public void TestCase2() {
        String command = "3 4 aabbddee unsupported sdfe@#$@#$@#% *";
        String expected = "12";

        calculationService.execute(command);
        String result = calculationService.getStackAsString();

        Assert.assertTrue(result.equalsIgnoreCase(expected));
    }

    @Test
    public void TestCase3() {
        String command = "                 3 4                                      *           ";
        String expected = "12";

        calculationService.execute(command);
        String result = calculationService.getStackAsString();

        Assert.assertTrue(result.equalsIgnoreCase(expected));
    }

    @Test
    public void TestCase4() {
        String command = "1 2 3 * 5 + * * 6 5";
        String expected = "11";

        calculationService.execute(command);
        String result = calculationService.getStackAsString();

        Assert.assertTrue(result.equalsIgnoreCase(expected));
    }
}
