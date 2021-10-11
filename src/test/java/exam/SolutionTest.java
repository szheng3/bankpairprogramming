package exam;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void processing() {
        ArrayList<InputAmount> inputAmounts = new ArrayList<>();
        InputAmount data1 = new InputAmount("30/11/2019", new BigDecimal("-3200.5"), "FoodPanda");
        InputAmount data2 = new InputAmount("28/11/2019", new BigDecimal("-1740.6"), "Stationary");
        InputAmount data3 = new InputAmount("28/11/2019", new BigDecimal("-2600.60"), "Grocery");
        InputAmount data4 = new InputAmount("28/11/2019", new BigDecimal("-1500.99"), "Grocery");
        InputAmount data9 = new InputAmount("05/11/2019", new BigDecimal("20000"), "Salary");


        inputAmounts.add(data1);
        inputAmounts.add(data2);
        inputAmounts.add(data3);
        inputAmounts.add(data4);
        inputAmounts.add(data9);
        Solution solution = new Solution();
        Results results = solution.processing(inputAmounts);

        assertEquals(results.getTotalIncome(),new BigDecimal("20000"));
        assertEquals(results.getTotalExpenses(),new BigDecimal("9042.69"));
        assertEquals(results.getTotalSavings(),new BigDecimal("10957.31"));
        assertEquals(results.getTopExpenseCategory(),new BigDecimal("4101.59"));
    }


    @Test
    public void processingTotalIncome() {
        ArrayList<InputAmount> inputAmounts = new ArrayList<>();
        InputAmount data1 = new InputAmount("30/11/2019", new BigDecimal(-3200.5), "FoodPanda");
        InputAmount data8 = new InputAmount("20/11/2019", new BigDecimal(1200), "Royalty");
        InputAmount data9 = new InputAmount("05/11/2019", new BigDecimal(20000), "Salary");

        inputAmounts.add(data1);
        inputAmounts.add(data8);
        inputAmounts.add(data9);
        Solution solution = new Solution();
        assertEquals(solution.processingTotalIncome(inputAmounts), Optional.of(new BigDecimal(21200)));


    }

    @Test
    public void processingTotalExpenses() {
        ArrayList<InputAmount> inputAmounts = new ArrayList<>();
        InputAmount data1 = new InputAmount("30/11/2019", new BigDecimal(-3200.5), "FoodPanda");
        InputAmount data2 = new InputAmount("28/11/2019", new BigDecimal(-1740.6), "Stationary");
        InputAmount data9 = new InputAmount("05/11/2019", new BigDecimal(20000), "Salary");

        inputAmounts.add(data1);
        inputAmounts.add(data2);
        inputAmounts.add(data9);
        Solution solution = new Solution();
        BigDecimal result = solution.processingTotalExpenses(inputAmounts)
                .map(bigDecimal -> bigDecimal.subtract(new BigDecimal(4941.1)))
                .orElse(null);

        assertTrue(result.abs().longValue()<=0.001);

    }

    @Test
    public void processingTotalSavings() {
        ArrayList<InputAmount> inputAmounts = new ArrayList<>();
        InputAmount data1 = new InputAmount("30/11/2019", new BigDecimal(-3200.5), "FoodPanda");
        InputAmount data2 = new InputAmount("28/11/2019", new BigDecimal(-1740.6), "Stationary");
        InputAmount data9 = new InputAmount("05/11/2019", new BigDecimal(20000), "Salary");

        inputAmounts.add(data1);
        inputAmounts.add(data2);
        inputAmounts.add(data9);
        Solution solution = new Solution();

        BigDecimal result = solution.processingTotalSavings(inputAmounts)
                .map(bigDecimal -> bigDecimal.subtract(new BigDecimal(15058.9)))
                .orElse(null);
        assertTrue(result.abs().longValue()<=0.001);
    }

    @Test
    public void processingTopExpenseCategory() {
        ArrayList<InputAmount> inputAmounts = new ArrayList<>();
        InputAmount data1 = new InputAmount("30/11/2019", new BigDecimal(-3200.5), "FoodPanda");
        InputAmount data2 = new InputAmount("28/11/2019", new BigDecimal(-1740.6), "Stationary");
        InputAmount data3 = new InputAmount("28/11/2019", new BigDecimal(-2600.60), "Grocery");
        InputAmount data4 = new InputAmount("28/11/2019", new BigDecimal(-1500.99), "Grocery");

        InputAmount data9 = new InputAmount("05/11/2019", new BigDecimal(20000), "Salary");

        inputAmounts.add(data1);
        inputAmounts.add(data2);
        inputAmounts.add(data3);
        inputAmounts.add(data4);
        inputAmounts.add(data9);
        Solution solution = new Solution();

        BigDecimal result = solution.processingTopExpenseCategory(inputAmounts)
                .map(bigDecimal -> bigDecimal.subtract(new BigDecimal(4101.59)))
                .orElse(null);
        assertTrue(result.abs().longValue()<=0.001);
    }
    @Test
    public void testCompareTo() {

        assertEquals(new BigDecimal(1).compareTo(new BigDecimal(1)), 0);

    }

    @Test
    public void testBigDecimal() {

        assertEquals(new BigDecimal(-10).compareTo(new BigDecimal(10)), -1);

    }


}