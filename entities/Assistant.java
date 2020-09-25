package entities;

public final class Assistant {
    private final String name;
    private final String surname;
    private final int salary;

    public Assistant() {
        name = "Vova";
        surname = "Ivanov";
        salary = 5;
        System.out.print("\nVova Ivanov is hired as an assistant.");
    }

    public Assistant(final String name, final String surname, final int salary, final Finance finance) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        finance.subFund(salary);
        System.out.print("\n" + name + " " + surname + " is hired as an assistant.");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    void displayInfo() {
        System.out.printf("\n\nAssistant\nName: %s \nSurname: %s\nSalary: %d\n", name, surname, salary);
    }
}
