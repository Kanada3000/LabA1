package entities;

public final class Finance {
    private int income;
    private int fund;
    private int expenses;

    public Finance() {
        fund = 2500;
    }

    public Finance (final int fund){
        this.fund = fund;
    }

    public int getFund() {
        return fund;
    }

    public void addFund(final int m_fund) {
        fund += m_fund;
        income += m_fund;
    }

    public void subFund(final int m_fund) {
        fund -= m_fund;
        expenses += m_fund;
    }

    public void displayInfo() {
        System.out.printf("\n\nFund: %d\nIncome: %d\nExpenses: %d", fund, income, expenses);
    }
}
