package services;

import other.Repairer;
import other.BanknoteMachine;
import other.PaintMachine;
import other.PaperMachine;

public class RepairService {

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);

        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void repairPaperMachine(PaperMachine paperMachine, Repairer repairer) {
        if (paperMachine.getBreaking() > 0) {
            System.out.print("\n\nRepairing machine...");
            pause(1000);
            paperMachine.setBreaking(0);
            System.out.print("\nPaper machine repaired by " + repairer.getName() + " " + repairer.getSurname());
        } else
            System.out.print("\n\nThe machine has already been repaired!");
    }

    public void repairPaintMachine(PaintMachine paintMachine, Repairer repairer) {
        if (paintMachine.getBreaking() > 0) {
            System.out.print("\n\nRepairing machine...");
            pause(1000);
            paintMachine.setBreaking(0);
            System.out.print("\nPaint machine repaired by " + repairer.getName() + " " + repairer.getSurname());
        } else
            System.out.print("\n\nThe machine has already been repaired!");
    }

    public void repairBanknoteMachine(BanknoteMachine banknoteMachine, Repairer repairer) {
        if (banknoteMachine.getBreaking() > 0) {
            System.out.print("\n\nRepairing machine...");
            pause(1000);
            banknoteMachine.setBreaking(0);
            System.out.print("\nBanknote machine repaired by " + repairer.getName() + " " + repairer.getSurname());
        } else
            System.out.print("\n\nThe machine has already been repaired!");
    }
}
