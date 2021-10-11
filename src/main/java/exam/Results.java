package exam;

import java.math.BigDecimal;

public class Results {
    private BigDecimal totalIncome;
    private BigDecimal totalExpenses;
    private BigDecimal totalSavings;
    private BigDecimal topExpenseCategory;

    public Results(BigDecimal totalIncome, BigDecimal totalExpenses, BigDecimal totalSavings, BigDecimal topExpenseCategory) {
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.totalSavings = totalSavings;
        this.topExpenseCategory = topExpenseCategory;
    }

    public Results() {
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public BigDecimal getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(BigDecimal totalSavings) {
        this.totalSavings = totalSavings;
    }

    public BigDecimal getTopExpenseCategory() {
        return topExpenseCategory;
    }

    public void setTopExpenseCategory(BigDecimal topExpenseCategory) {
        this.topExpenseCategory = topExpenseCategory;
    }
}
