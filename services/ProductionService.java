package services;

import entities.Finance;
import entities.PaperMachine;
import entities.PaintMachine;

import java.util.concurrent.TimeUnit;

import entities.BanknoteMachine;

public final class ProductionService {

    public void productionPaper(final PaperMachine paperMachine, final Finance finance) throws InterruptedException {
        if (finance.getFund() >= paperMachine.getExpenses()) {
            System.out.printf("\n\nProduce paper...");
            TimeUnit.SECONDS.sleep(1);
            paperMachine.addVolume(paperMachine.getProductionSpeed());
            finance.subFund(paperMachine.getExpenses());
            System.out.printf("\nProduced %d papers. You spent $%d!", paperMachine.getProductionSpeed(),
                    paperMachine.getExpenses());
        } else
            System.out.printf("\nYou don't have enough funds!");
    }

    public void productionPaper(final PaperMachine paperMachine, final int volume, final Finance finance)
            throws InterruptedException {
        final int expenses = paperMachine.getExpenses() * volume / paperMachine.getProductionSpeed();
        if (finance.getFund() >= expenses) {
            System.out.printf("\n\nProduce paper...");
            TimeUnit.SECONDS.sleep(1);
            paperMachine.addVolume(volume);
            finance.subFund(expenses);
            System.out.printf("\nProduced %d papers. You spent $%d!", volume, expenses);
        } else
            System.out.printf("\nYou don't have enough funds!");
    }

    public void productionPaint(final PaintMachine paintMachine, final Finance finance) throws InterruptedException {
        if (finance.getFund() >= paintMachine.getExpenses()) {
            System.out.printf("\n\nProduce paint...");
            TimeUnit.SECONDS.sleep(1);
            paintMachine.addVolume(paintMachine.getProductionSpeed());
            finance.subFund(paintMachine.getExpenses());
            System.out.printf("\nProduced %d paints. You spent $%d!", paintMachine.getProductionSpeed(),
                    paintMachine.getExpenses());
        } else
            System.out.printf("\nYou don't have enough funds!");
    }

    public void productionPaint(final PaintMachine paintMachine, final int volume, final Finance finance)
            throws InterruptedException {
        final int expenses = paintMachine.getExpenses() * volume / paintMachine.getProductionSpeed();
        if (finance.getFund() >= expenses) {
            System.out.printf("\n\nProduce paint...");
            TimeUnit.SECONDS.sleep(1);
            paintMachine.addVolume(volume);
            finance.subFund(expenses);
            System.out.printf("\nProduced %d paints. You spent $%d!", volume, expenses);
        } else
            System.out.printf("\nYou don't have enough funds!");
    }

    public void printBanknote(final BanknoteMachine banknoteMachine, final Finance finance)
            throws InterruptedException {
        if (banknoteMachine.getProductionSpeed() <= banknoteMachine.getAmountOfPaint()) {
            if (banknoteMachine.getProductionSpeed() <= banknoteMachine.getAmountOfPaper()) {
                if (banknoteMachine.getWorking() == true) {
                    System.out.printf("\n\nPrinting banknote...");
                    TimeUnit.SECONDS.sleep(1);
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

    public void printBanknote(final BanknoteMachine banknoteMachine, final int volume, final Finance finance)
            throws InterruptedException {
        if (volume <= banknoteMachine.getAmountOfPaint()) {
            if (volume <= banknoteMachine.getAmountOfPaper()) {
                if (banknoteMachine.getWorking() == true) {
                    System.out.printf("\n\nPrinting banknote...");
                    TimeUnit.SECONDS.sleep(1);
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
