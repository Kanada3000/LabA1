package entities;

public final class BanknoteMachine {
    private double breakingStat;
    private final int productionSpeed; // banknotes per second
    private boolean working;
    private final int earnings;
    private int amountOfPaint;
    private int amountOfPaper;
    private int volume; // amount of banknotes now
    private final int maxVolume; // max amount of banknotes
    private final Worker worker;

    public BanknoteMachine() {
        breakingStat = 0;
        productionSpeed = 3;
        working = true;
        earnings = 20;
        amountOfPaint = 0;
        amountOfPaper = 0;
        volume = 0;
        maxVolume = 300;
        worker = null;
        System.out.print("\nBanknote machine created!");
    }

    public BanknoteMachine(final int productionSpeed, final int maxVolume, final int earnings, final Worker worker) {
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

    public void setBreaking(final int volume) {
        if (volume == 0)
            breakingStat = 0;
        else {
            final double breaking = 500 * volume / maxVolume;
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

    public void addVolume(final int volume) {
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

    public void addPaint(final int paint) {
        this.amountOfPaint += paint;
    }

    public void addPaper(final int paper) {
        this.amountOfPaper += paper;
    }

    public void subPaint(final int paint) {
        this.amountOfPaint -= paint;
    }

    public void subPaper(final int paper) {
        this.amountOfPaper -= paper;
    }

    public void displayInfo() {
        System.out.printf(
                "\n\nBanknote machine\nWorker: " + worker.getName() + " " + worker.getSurname() +
                "\nEarnings: " + earnings +
                "\nBreaking: " + breakingStat + "%%" +
                "\nSpeed of printing: " + productionSpeed + " banknotes per second" +
                "\nWorking: " + working +
                "\nAmount of paint inside: " + amountOfPaint +
                "\nAmount of paper inside: " + amountOfPaper +
                "\nAmount of banknotes inside: " + volume + "/" + maxVolume
                );
    }
}
