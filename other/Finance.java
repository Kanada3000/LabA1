package other;

public class Finance {
    static int income;
    static int fund;
    static int expenses;

    public static void setFund(final int m_fund) {
        fund = m_fund;
    }

    public static int getFund() {
        return fund;
    }

    public static void addFund(final int m_fund) {
        fund += m_fund;
        income += m_fund;
    }

    public static void subFund(final int m_fund) {
        fund -= m_fund;
        expenses += m_fund;
    }

    public static void displayInfo() {
        System.out.printf("\n\nFund: %d\nIncome: %d\nExpenses: %d", fund, income, expenses);
    }
}
