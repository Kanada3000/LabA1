sistant1);
        delivery.paintToBanknote(paintMachine1, banknoteMachine1, assistant1);

        product.printBanknote(banknoteMachine1);

        Finance.displayInfo();
        delivery.banknoteToSell(banknoteMachine1, assistant1);
        Finance.displayInfo();
        banknoteMachine1.displayInfo();

        repair.repairBanknoteMachine(banknoteMachine1, repairer1);

        banknoteMachine1.displayInfo();
    }
}

