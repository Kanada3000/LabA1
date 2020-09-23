package other;

public class BanknoteMachine {
    private double breakingStat;
    private final int productionSpeed; // banknotes per second
    private boolean working;
    private final int earnings;
    private int amountOfPaint;
    private int amountOfPaper;
    private int volume; // amount of banknotes now
    private final int maxVolume; // max amount of banknotes
    private Worker worker;

    public BanknoteMachine(int productionSpeed, int maxVolume, int earnings, Worker worker) {
        this.breakingStat = 0;
        this.productionSpeed = productionSpeed;
        this.working = true;
        this.earnings = earnings;
        this.amountOfPaint = 0;
        this.amountOfPaper = 0;
        this.volume = 0;
        this.maxVolume = maxVolume;
        this.worker = worker;
        System.out.print("\nBanknote machine created!");
    }

    public void setBreaking(int volume) {
        if (volume == 0)
            breakingStat = 0;
        else {
            double breaking = 500 * volume / maxVolume;
            if (breakingStat + breaking < 100)
                breakingStat += breaking;
            else {
                breakingStat = 100;
                working = false;
                System.out.print("\nOoops! This machine is broken :(");
            }
        }
    }

    public int getEarnings() {
        return earnings;
    }

    public int getProductionSpeed() {
        return productionSpeed;
    }

    public int getAmountOfPaint() {
        return amountOfPaint;
    }

    public int getAmountOfPaper() {
        return amountOfPaper;
    }

    public boolean getWorking() {
        return working;
    }

    public int getVolume() {
        return volume;
    }

    public double getBreaking() {
        return breakingStat;
    }

    public void addVolume(int volume) {
        if (this.volume + volume <= maxVolume) {
            this.volume += volume;
            setBreaking(volume);
        } else
            this.working = false;
    }

    public void subVolume() {
        if (volume > 0)
            volume = 0;
        else
            System.out.print("\nBanknote machine is empty!");
    }

    public void addPaint(int paint) {
        this.amountOfPaint += paint;
    }

    public void addPaper(int paper) {
        this.amountOfPaper += paper;
    }

    public void subPaint(int paint) {
        this.amountOfPaint -= paint;
    }

    public void subPaper(int paper) {
        this.amountOfPaper -= paper;
    }

    public void displayInfo() {
        System.out.printf(
                "\n\nBanknote machine\nWorker: %s %s\nEarnings: %d\nBreaking: %.2f%%\nSpeed of printing: %d banknotes per second\nWorking: %b\nAmount of paint inside: %d\nAmount of paper inside: %d\nAmount of banknotes inside: %d/%d",
                worker.getName(), worker.getSurname(), earnings, breakingStat, productionSpeed, working, amountOfPaint,
                amountOfPaper, volume, maxVolume);
    }
}
