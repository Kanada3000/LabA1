package other;

public class Assistant {
    String name;
    String surname;
    int salary;

    public Assistant(final String name, final String surname, final int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        Finance.subFund(salary);
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
