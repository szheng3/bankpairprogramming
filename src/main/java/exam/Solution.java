package exam;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Solution implements BankStatement {

    @Override
    public Results processing(List<InputAmount> inputAmounts) {

        BigDecimal totalIncome = processingTotalIncome(inputAmounts).orElse(BigDecimal.ZERO);
        BigDecimal totalExpenses = processingTotalExpenses(inputAmounts).orElse(BigDecimal.ZERO);
        BigDecimal totalSavings = processingTotalSavings(inputAmounts).orElse(BigDecimal.ZERO);
        BigDecimal totalCategory = processingTopExpenseCategory(inputAmounts).orElse(BigDecimal.ZERO);


        return new Results(totalIncome, totalExpenses, totalSavings, totalCategory);
    }

    @Override
    public Optional<BigDecimal> processingTotalIncome(List<InputAmount> inputAmounts) {

        return inputAmounts
                .stream()
                .map(InputAmount::getAmount)
                .filter(bigDecimal -> bigDecimal.compareTo(new BigDecimal(0)) > 0)
                .reduce(BigDecimal::add);
    }

    @Override
    public Optional<BigDecimal> processingTotalExpenses(List<InputAmount> inputAmounts) {
        return inputAmounts
                .stream()
                .map(InputAmount::getAmount)
                .filter(bigDecimal -> bigDecimal.compareTo(new BigDecimal(0)) < 0)
                .map(BigDecimal::abs)
                .reduce(BigDecimal::add);
    }

    @Override
    public Optional<BigDecimal> processingTotalSavings(List<InputAmount> inputAmounts) {


        return processingTotalIncome(inputAmounts).map(totalIncome -> {
            BigDecimal totalExpense = processingTotalExpenses(inputAmounts).orElse(new BigDecimal(0));
            return totalIncome.subtract(totalExpense);


        });

    }

    @Override
    public Optional<BigDecimal> processingTopExpenseCategory(List<InputAmount> inputAmounts) {
        Map<String, List<InputAmount>> inputGroupByMap = inputAmounts
                .stream()
                .filter(input -> input.getAmount().compareTo(new BigDecimal(0)) < 0)
                .collect(Collectors.groupingBy(InputAmount::getCatagory));

        return inputGroupByMap
                .entrySet()
                .stream()
                .map(set -> processingTotalExpenses(set.getValue()).orElse(new BigDecimal(0)))
                .max(BigDecimal::compareTo);

    }


}
