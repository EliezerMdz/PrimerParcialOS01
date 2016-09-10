package entity;

/**
 * Created by EliezerMdz on 09/09/2016.
 */
public class Winner {
    Employee employee;
    Prize prize;

    public Winner() {
    }

    public Winner(Employee employee, Prize prize) {
        this.employee = employee;
        this.prize = prize;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }
}
