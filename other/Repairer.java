package other;

public class Repairer {
    String name;
    String surname;
    int salary;

    public Repairer(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        Finance.subFund(salary);
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
