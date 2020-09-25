package entities;

public final class Repairer {
    private final String name;
    private final String surname;
    private final int salary;

    public Repairer() {
        name = "Kate";
        surname = "Miller";
        salary = 2;
        System.out.print("\nKate Miller is hired as an repairer.");
    }

    public Repairer(final String name, final String surname, final int salary, final Finance finance) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        finance.subFund(salary);
        System.out.print("\n" + name + " " + surname + " is hired as a repairer.");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    void displayInfo() {
        System.out.printf("\n\nRepairer\nName: %s\nSurname: %s\nSalary: $%d\n", name, surname, salary);
    }
}
