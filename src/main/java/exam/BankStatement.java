package exam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BankStatement {

    Results processing(List<InputAmount> inputAmounts);

    Optional<BigDecimal> processingTotalIncome(List<InputAmount> inputAmounts);
    Optional<BigDecimal> processingTotalExpenses(List<InputAmount> inputAmounts);
    Optional<BigDecimal> processingTotalSavings(List<InputAmount> inputAmounts);
    Optional<BigDecimal> processingTopExpenseCategory(List<InputAmount> inputAmounts);


}
