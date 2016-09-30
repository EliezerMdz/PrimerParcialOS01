package Controller;

import entity.Employee;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by EliezerMdz on 09/09/2016.
 */

@ViewScoped
@ManagedBean(name = "EmpCont")

public class EmployeeController {

    private ArrayList<Employee> employees;

    public void uploadEmpFile(XSSFSheet employeeSheet){
        try {
            Iterator<Row> rowIt = employeeSheet.rowIterator();
            rowIt.next();
            employees = new ArrayList<Employee>();

            while (rowIt.hasNext()){

                XSSFRow row = (XSSFRow) rowIt.next();
                String id = row.getCell(0).getStringCellValue();
                String name = row.getCell(1).getStringCellValue();
                String lastName = row.getCell(2).getStringCellValue();
                String phoneNumber = row.getCell(3).getStringCellValue();
                String email = row.getCell(4).getStringCellValue();

                Employee employee = new Employee(id, name, lastName, phoneNumber, email);
                employees.add(employee);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

}
