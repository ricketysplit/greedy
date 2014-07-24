import com.ricketysplit.CoinCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:28 AM
 */
public class CoinCalculatorTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

    @Test
    public void zeroChangeMeansYouGetZeroCoins() {
        CoinCalculator coinCalculator = (CoinCalculator) context.getBean("coinCalculator");

        String coinMessage = coinCalculator.calculateChange("$0.00");

        assertEquals("No coins returned", coinMessage);
    }

    @Test
    public void oneCentShouldGiveYouOnePenny() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.01");

        assertEquals("1 penny", coinMessage);
    }

    @Test
    public void tenCentsShouldGiveYouOneDime() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.10");

        assertEquals("1 dime", coinMessage);
    }

    @Test
    public void twentyFiveCentsShouldGiveYouOneQuarter(){
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.25");

        assertEquals("1 quarter", coinMessage);
    }

    @Test
    public void sixDollarsAndThirtyUScents(){
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$6.30");

        assertEquals("6 dollar coins\n1 quarter\n1 nickel", coinMessage);
    }

    @Test
    public void sevenDollarsAndFortyThreeUScents(){
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$7.43");

        assertEquals("7 dollar coins\n1 quarter\n1 dime\n1 nickel\n3 pennies", coinMessage);
    }

    @Test
     public void seventynineUScents(){
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.79");

        assertEquals("3 quarters\n4 pennies", coinMessage);
    }

    @Test
    public void oneEUcent(){
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("€0.01");

        assertEquals("1 €0.01 coin", coinMessage);
    }

    @Test
    public void sixEurosAndTenEUcents(){
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("€6.10");

        assertEquals("3 two euro coins\n1 €0.10 coin", coinMessage);
    }

    @Test
    public void fiftyEUcents(){
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("€0.50");

        assertEquals("1 €0.50 coin", coinMessage);
    }


}
