package services;

import entities.Repairer;

import java.util.concurrent.TimeUnit;

import entities.BanknoteMachine;
import entities.PaintMachine;
import entities.PaperMachine;

public final class RepairService {

    public void repairPaperMachine(final PaperMachine paperMachine, final Repairer repairer)
            throws InterruptedException {

        if (paperMachine.getBreaking() > 0) {
            System.out.print("\n\nRepairing machine...");
            TimeUnit.SECONDS.sleep(1);
            paperMachine.setBreaking(0);
            System.out.print("\nPaper machine repaired by " + repairer.getName() + " " + repairer.getSurname());
        } else
            System.out.print("\n\nThe machine has already been repaired!");

    }

    public void repairPaintMachine(final PaintMachine paintMachine, final Repairer repairer)
            throws InterruptedException {

        if (paintMachine.getBreaking() > 0) {
            System.out.print("\n\nRepairing machine...");
            TimeUnit.SECONDS.sleep(1);
            paintMachine.setBreaking(0);
            System.out.print("\nPaint machine repaired by " + repairer.getName() + " " + repairer.getSurname());
        } else
            System.out.print("\n\nThe machine has already been repaired!");

    }

    public void repairBanknoteMachine(final BanknoteMachine banknoteMachine, final Repairer repairer)
            throws InterruptedException {

        if (banknoteMachine.getBreaking() > 0) {
            System.out.print("\n\nRepairing machine...");
            TimeUnit.SECONDS.sleep(1);
            banknoteMachine.setBreaking(0);
            System.out.print("\nBanknote machine repaired by " + repairer.getName() + " " + repairer.getSurname());
        } else
            System.out.print("\n\nThe machine has already been repaired!");
            
    }
}
