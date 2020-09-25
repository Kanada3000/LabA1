package services;

import java.util.concurrent.TimeUnit;

import entities.Assistant;
import entities.BanknoteMachine;
import entities.Finance;
import entities.PaintMachine;
import entities.PaperMachine;

public final class DeliveryService {

    public void paperToBanknote(final PaperMachine paperMachine, final BanknoteMachine banknoteMachine,
            final Assistant assistant) 
            throws InterruptedException {
        if (paperMachine.getVolume() >= 0) {
            System.out.print("\n\nTransferring papers...");
            TimeUnit.SECONDS.sleep(1);
            banknoteMachine.addPaper(paperMachine.getVolume());
            System.out.print("\n" + assistant.getName() + " " + assistant.getSurname() + " took "
                    + paperMachine.getVolume() + " papers to banknote machine.");
            paperMachine.subVolume();
        } else
            System.out.print("\nPaper machine is empty!");
    }

    public void paintToBanknote(final PaintMachine paintMachine, final BanknoteMachine banknoteMachine,
            final Assistant assistant) 
            throws InterruptedException {
        if (paintMachine.getVolume() >= 0) {
            System.out.print("\n\nTransferring paints...");
            TimeUnit.SECONDS.sleep(1);
            banknoteMachine.addPaint(paintMachine.getVolume());
            System.out.print("\n" + assistant.getName() + " " + assistant.getSurname() + " took "
                    + paintMachine.getVolume() + " paints to banknote machine.");
            paintMachine.subVolume();
        } else
            System.out.print("\nPaint machine is empty!");
    }

    public void banknoteToSell(final BanknoteMachine banknoteMachine, final Assistant assistant, final Finance finance)
            throws InterruptedException {
        if (banknoteMachine.getVolume() >= 0) {
            System.out.print("\n\nSells banknotes...");
            TimeUnit.SECONDS.sleep(1);
            final int earned = banknoteMachine.getEarnings() * banknoteMachine.getVolume()
                    / banknoteMachine.getProductionSpeed();
            System.out.print("\n" + assistant.getName() + " " + assistant.getSurname() + " sold "
                    + banknoteMachine.getVolume() + " banknotes and earned $" + earned);
            finance.addFund(earned);
            banknoteMachine.subVolume();
        } else
            System.out.print("\nBanknote machine is empty!");
    }
}
