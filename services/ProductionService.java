package services;

import other.Finance;
import other.PaperMachine;
import other.PaintMachine;
import other.BanknoteMachine;

public class ProductionService {

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);

        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void productionPaper(final PaperMachine paperMachine) {
        if (Finance.getFund() >= paperMachine.getExpenses()) {
            System.out.printf("\n\nProduce paper...");
            pause(1000);
            paperMachine.addVolume(paperMachine.getProductionSpeed());
            Finance.subFund(paperMachine.getExpenses());
            System.out.printf("\nProduced %d papers. You spent $%d!", paperMachine.getProductionSpeed(),
                    paperMachine.getExpenses());
        } else
            System.out.printf("\nYou don't have enough funds!");
    }

    public void productionPaper(final PaperMachine paperMachine, final int volume) {
        final int expenses = paperMachine.getExpenses() * volume / paperMachine.getProductionSpeed();
        if (Finance.getFund() >= expenses) {
            System.out.printf("\n\nProduce paper...");
            pause(1000);
            paperMachine.addVolume(volume);
            Finance.subFund(expenses);
            System.out.printf("\nProduced %d papers. You spent $%d!", volume, expenses);
        } else
            System.out.printf("\nYou don't have enough funds!");
    }

    public void productionPaint(final PaintMachine paintMachine) {
        if (Finance.getFund() >= paintMachine.getExpenses()) {
            System.out.printf("\n\nProduce paint...");
            pause(1000);
            paintMachine.addVolume(paintMachine.getProductionSpeed());
            Finance.subFund(paintMachine.getExpenses());
            System.out.printf("\nProduced %d paints. You spent $%d!", paintMachine.getProductionSpeed(),
                    paintMachine.getExpenses());
        } else
            System.out.printf("\nYou don't have enough funds!");
    }

    public void productionPaint(PaintMachine paintMachine, final int volume) {
        final int expenses = paintMachine.getExpenses() * volume / paintMachine.getProductionSpeed();
        if (Finance.getFund() >= expenses) {
            System.out.printf("\n\nProduce paint...");
            pause(1000);
            paintMachine.addVolume(volume);
            Finance.subFund(expenses);
            System.out.printf("\nProduced %d paints. You spent $%d!", volume, expenses);
        } else
            System.out.printf("\nYou don't have enough funds!");
    }

    public void printBanknote(BanknoteMachine banknoteMachine) {
        if (banknoteMachine.getProductionSpeed() <= banknoteMachine.getAmountOfPaint()) {
            if (banknoteMachine.getProductionSpeed() <= banknoteMachine.getAmountOfPaper()) {
                if (banknoteMachine.getWorking() == true) {
                    System.out.printf("\n\nPrinting banknote...");
                    pause(1000);
                    banknoteMachine.addVolume(banknoteMachine.getProductionSpeed());
                    banknoteMachine.subPaint(banknoteMachine.getProductionSpeed());
                    banknoteMachine.subPaper(banknoteMachine.getProductionSpeed());
                    System.out.printf("\nProduced %d banknotes.", banknoteMachine.getProductionSpeed());
                } else
                    System.out.printf("\nOoops! It`s not working.");
            } else
                System.out.printf("\nYou don't have enough paper!");
        } else
            System.out.printf("\nYou don't have enough paint!");
    }

    public void printBanknote(BanknoteMachine banknoteMachine, int volume) {
        if (volume <= banknoteMachine.getAmountOfPaint()) {
            if (volume <= banknoteMachine.getAmountOfPaper()) {
                if (banknoteMachine.getWorking() == true) {
                    System.out.printf("\n\nPrinting banknote...");
                    pause(1000);
                    banknoteMachine.addVolume(volume);
                    System.out.printf("\nProduced %d banknotes.", volume);
                } else
                    System.out.printf("\nOoops! It`s not working.");
            } else
                System.out.printf("\nYou don't have enough paper!");
        } else
            System.out.printf("\nYou don't have enough paint!");
    }
}
