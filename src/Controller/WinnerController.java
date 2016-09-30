package Controller;

import entity.Employee;
import entity.Prize;
import entity.Winner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by EliezerMdz on 09/09/2016.
 */

@ViewScoped
@ManagedBean(name = "WnrCont")

public class WinnerController {

    ArrayList<Winner> winners;
    ArrayList<Employee> employees;
    ArrayList<Prize> prizes;

    @ManagedProperty(value ="#{EmpCont}")
    private EmployeeController employeeController;
    @ManagedProperty(value = "#{PrzCont}")
    private PrizeController prizeController;

    public void sortPrize(){
        System.out.println("Dentro");
        try {
            employees = employeeController.getEmployees();
            prizes = prizeController.getPrizes();
            winners = new ArrayList<Winner>();

            while (!prizes.isEmpty()) {

                if (prizes.get(0).getQuantity() > 0) {

                    int newQuantity = (prizes.get(0).getQuantity() - 1);
                    prizes.get(0).setQuantity(newQuantity);

                    int winnerIndex = (int) (Math.random() * (employees.size() - 1));
                    Winner winner = new Winner(employees.get(winnerIndex), prizes.get(0));

                    winners.add(winner);
                    employees.remove(winnerIndex);
                } else {
                    prizes.remove(0);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Termine");
    }
    public ArrayList<Winner> getWinners() {
        return winners;
    }

    public void setWinners(ArrayList<Winner> winners) {
        this.winners = winners;
    }

    public EmployeeController getEmployeeController() {
        return employeeController;
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public PrizeController getPrizeController() {
        return prizeController;
    }

    public void setPrizeController(PrizeController prizeController) {
        this.prizeController = prizeController;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(ArrayList<Prize> prizes) {
        this.prizes = prizes;
    }
}
