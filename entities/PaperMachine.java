package entities;

public final class PaperMachine {
    private double breakingStat = 0;
    private final int expenses; // cost of materials of a unit of paper production
    private final int productionSpeed; // number of production at a time
    private boolean working = true;
    private int volume = 0;
    private final int maxVolume;
    private final Worker worker;

    public PaperMachine() {
        breakingStat = 0;
        expenses = 4;
        productionSpeed = 6;
        working = true;
        volume = 0;
        maxVolume = 20;
        worker = null;
        System.out.print("\nPaper machine created!");
    }

    public PaperMachine(final int expenses, final int productionSpeed, final int maxVolume, final Worker worker) {
        this.expenses = expenses;
        this.productionSpeed = productionSpeed;
        this.maxVolume = maxVolume;
        this.worker = worker;
        System.out.print("\nPaper machine created!");
    }

    public int getExpenses() {
        return expenses;
    }

    public int getVolume() {
        return volume;
    }

    public int getProductionSpeed() {
        return productionSpeed;
    }

    public double getBreaking() {
        return breakingStat;
    }

    public void setBreaking(final int volume) {
        if (volume == 0)
            breakingStat = 0;
        else {
            final double breaking = 400 * volume / maxVolume;
            if (breakingStat + breaking < 100)
                breakingStat += breaking;
            else {
                breakingStat = 100;
                working = false;
                System.out.print("\nOoops! This machine is broken :(");
            }
        }
    }

    public void addVolume(final int volume) {
        if (this.volume + volume <= maxVolume) {
            this.volume += volume;
            setBreaking(volume);
        } else
            System.out.print("\nPaper machine is full!");
    }

    public void subVolume() {
        if (volume > 0)
            volume = 0;
        else
            System.out.print("\nPaper machine is empty!");
    }

    public void displayInfo() {
        System.out.printf(
                "\n\nPaper machine\nWorker: " + worker.getName() + " " + worker.getSurname() + 
                "\nBreaking: " + breakingStat + "%%" +
                "\nCost of materials for paper production: " + expenses +
                "\nSpeed of production: " + productionSpeed + " papers per second" +
                "\nWorking: " + working +
                "\nAmount of paper inside: " + volume + "/" + maxVolume
                );
    }

}
