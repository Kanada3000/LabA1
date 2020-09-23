package other;

public class PaintMachine {
    private double breakingStat;
    private final int expenses; // cost of materials of a unit of paint production
    private final int productionSpeed; // number of production at a time
    private boolean working;
    private int volume;
    private final int maxVolume;
    private final Worker worker;

    public PaintMachine(int expenses, int productionSpeed, int maxVolume, Worker worker) {
        this.breakingStat = 0;
        this.expenses = expenses;
        this.productionSpeed = productionSpeed;
        this.working = true;
        this.volume = 0;
        this.maxVolume = maxVolume;
        this.worker = worker;
        System.out.print("\nPaint machine created!");
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

    public void addVolume(int volume) {
        if (this.volume + volume <= maxVolume) {
            this.volume += volume;
            setBreaking(volume);
        } else
            System.out.print("\nPaint machine is full!");
    }

    public void subVolume() {
        if (volume > 0)
            volume = 0;
        else
            System.out.print("\nPaint machine is empty!");
    }

    public void displayInfo() {
        System.out.printf(
                "\n\nPaint machine\nWorker: %s %s\nBreaking: %.2f%%\nCost of materials for paint production: %d\nSpeed of production: %d paints per second\nWorking: %b\nAmount of paper inside: %d/%d",
                worker.getName(), worker.getSurname(), breakingStat, expenses, productionSpeed, working, volume,
                maxVolume);
    }
}
