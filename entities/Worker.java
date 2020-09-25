package entities;

public final class Worker {
    private final String name;
    private final String surname;
    private final int salary;

    public Worker() {
        name = "Sam";
        surname = "Pepe";
        salary = 4;
        System.out.print("\nSam Pepe is hired as an worker.");
    }

    public Worker(final String name, final String surname, final int salary, final Finance finance) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        finance.subFund(salary);
        System.out.print("\n" + name + " " + surname + " is hired as a worker.");
    };

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void displayInfo() {
        System.out.printf("\n\nWorker\nName: %s\nSurname: %s\nSalary: $%d\n", name, surname, salary);
    }
}
