import services.*;
import entities.*;

public class Main {
    public static void main(final String[] args) throws InterruptedException {

        final Finance finance = new Finance(3000);
        finance.displayInfo();
        System.out.print("\n");

        final Worker worker1 = new Worker("James", "Sullivan", 3, finance); // 3rd place - salary
        final Worker worker2 = new Worker("Katty", "Perry", 4, finance);
        final Worker worker3 = new Worker("Jensen", "Ackles", 5, finance);
        final Assistant assistant = new Assistant("Mike", "Wazowski", 2, finance);
        final Repairer repairer = new Repairer("Randall", "Boggs", 3, finance);
        final PaintMachine paintMachine = new PaintMachine(2, 5, 450, worker1); // (int expenses, int productionSpeed,
                                                                                // int maxVolume, Worker worker)
        final PaperMachine paperMachine = new PaperMachine(1, 5, 300, worker2); // (int expenses, int productionSpeed,
                                                                                // int maxVolume)
        final BanknoteMachine banknoteMachine = new BanknoteMachine(10, 500, 5, worker3); // (int printSpeed, int
                                                                                          // maxVolume, int earnings)
                                                                                          
        final ProductionService product = new ProductionService();
        final DeliveryService delivery = new DeliveryService();
        final RepairService repair = new RepairService();

        finance.displayInfo();

        product.productionPaper(paperMachine, 20, finance);
        product.productionPaint(paintMachine, 15, finance);

        delivery.paperToBanknote(paperMachine, banknoteMachine, assistant);
        delivery.paintToBanknote(paintMachine, banknoteMachine, assistant);

        paperMachine.displayInfo();
        paintMachine.displayInfo();
        banknoteMachine.displayInfo();

        product.printBanknote(banknoteMachine, finance);

        finance.displayInfo();

        delivery.banknoteToSell(banknoteMachine, assistant, finance);

        finance.displayInfo();

        banknoteMachine.displayInfo();

        repair.repairBanknoteMachine(banknoteMachine, repairer);
        repair.repairPaperMachine(paperMachine, repairer);
        repair.repairPaintMachine(paintMachine, repairer);

        banknoteMachine.displayInfo();
        paperMachine.displayInfo();
        paintMachine.displayInfo();
    }
}
