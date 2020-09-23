package services;

import other.Assistant;
import other.BanknoteMachine;
import other.Finance;
import other.PaintMachine;
import other.PaperMachine;

public class DeliveryService {

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);

        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void paperToBanknote(PaperMachine paperMachine, BanknoteMachine banknoteMachine, Assistant assistant) {
        if (paperMachine.getVolume() >= 0) {
            System.out.print("\n\nTransferring papers...");
            pause(1000);
            banknoteMachine.addPaper(paperMachine.getVolume());
            System.out.print("\n" + assistant.getName() + " " + assistant.getSurname() + " took "
                    + paperMachine.getVolume() + " papers to banknote machine.");
            paperMachine.subVolume();
        } else
            System.out.print("\nPaper machine is empty!");
    }

    public void paintToBanknote(PaintMachine paintMachine, BanknoteMachine banknoteMachine, Assistant assistant) {
        if (paintMachine.getVolume() >= 0) {
            System.out.print("\n\nTransferring paints...");
            pause(1000);
            banknoteMachine.addPaint(paintMachine.getVolume());
            System.out.print("\n" + assistant.getName() + " " + assistant.getSurname() + " took "
                    + paintMachine.getVolume() + " paints to banknote machine.");
            paintMachine.subVolume();
        } else
            System.out.print("\nPaint machine is empty!");
    }

    public void banknoteToSell(BanknoteMachine banknoteMachine, Assistant assistant) {
        if (banknoteMachine.getVolume() >= 0) {
            System.out.print("\n\nSells banknotes...");
            pause(1000);
            System.out.print("\n" + assistant.getName() + " " + assistant.getSurname() + " sold "
                    + banknoteMachine.getVolume() + " banknotes and earned $" + banknoteMachine.getEarnings()
                            * banknoteMachine.getVolume() / banknoteMachine.getProductionSpeed());
            Finance.addFund(
                    banknoteMachine.getEarnings() * banknoteMachine.getVolume() / banknoteMachine.getProductionSpeed());
            banknoteMachine.subVolume();
        } else
            System.out.print("\nBanknote machine is empty!");
    }
}
