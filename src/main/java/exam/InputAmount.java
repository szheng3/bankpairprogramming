package exam;


import java.math.BigDecimal;

public class InputAmount {
    private String date;
    private BigDecimal amount;
    private String Catagory;

    public InputAmount(String date, BigDecimal amount, String catagory) {
        this.date = date;
        this.amount = amount;
        Catagory = catagory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCatagory() {
        return Catagory;
    }

    public void setCatagory(String catagory) {
        Catagory = catagory;
    }
}
