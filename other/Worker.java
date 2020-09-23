package other;

public class Worker {
    private final String name;
    private final String surname;
    private int salary;

    public Worker(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        Finance.subFund(salary);
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
