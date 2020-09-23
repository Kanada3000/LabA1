import services.*;
import other.*;

public class Main {
    public static void main(String[] args) {

        Finance.setFund(3000);
        Finance.displayInfo();
        System.out.print("\n");

        Worker worker1 = new Worker("James", "Sullivan", 3); // 3rd place - salary
        Worker worker2 = new Worker("Katty", "Perry", 4);
        Worker worker3 = new Worker("Jensen", "Ackles", 5);
        Assistant assistant = new Assistant("Mike", "Wazowski", 2);
        Repairer repairer = new Repairer("Randall", "Boggs", 3);

        PaintMachine paintMachine = new PaintMachine(2, 5, 450, worker1); // (int expenses, int productionSpeed, int
                                                                          // maxVolume, Worker worker)
        PaperMachine paperMachine = new PaperMachine(1, 5, 300, worker2); // (int expenses, int productionSpeed, int
                                                                          // maxVolume)
        BanknoteMachine banknoteMachine = new BanknoteMachine(10, 500, 5, worker3); // (int printSpeed, int maxVolume,
                                                                                    // int earnings)

        ProductionService product = new ProductionService();
        DeliveryService delivery = new DeliveryService();
        RepairService repair = new RepairService();

        Finance.displayInfo();

        product.productionPaper(paperMachine, 20);
        product.productionPaint(paintMachine, 15);

        delivery.paperToBanknote(paperMachine, banknoteMachine, assistant);
        delivery.paintToBanknote(paintMachine, banknoteMachine, assistant);

        paperMachine.displayInfo();
        paintMachine.displayInfo();
        banknoteMachine.displayInfo();

        product.printBanknote(banknoteMachine);

        Finance.displayInfo();

        delivery.banknoteToSell(banknoteMachine, assistant);

        Finance.displayInfo();

        banknoteMachine.displayInfo();

        repair.repairBanknoteMachine(banknoteMachine, repairer);
        repair.repairPaperMachine(paperMachine, repairer);
        repair.repairPaintMachine(paintMachine, repairer);

        banknoteMachine.displayInfo();
        paperMachine.displayInfo();
        paintMachine.displayInfo();
    }
}
