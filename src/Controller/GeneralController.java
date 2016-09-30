package Controller;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by EliezerMdz on 12/09/2016.
 */

@ViewScoped
@ManagedBean(name = "GralCont")

public class GeneralController {
    private Part generalExcelFile;
    @ManagedProperty(value = "#{EmpCont}")
    private EmployeeController empController;
    @ManagedProperty(value = "#{PrzCont}")
    private PrizeController przController;
    @ManagedProperty(value = "#{WnrCont}")
    private WinnerController wnrController;
    @ManagedProperty(value = "#{Mailer}")
    private EmailSenderController emailSenderController;

    public void uploadExcelFile(ActionEvent event){
        try {
            FileInputStream fis = (FileInputStream) generalExcelFile.getInputStream();

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet employeeSheet = workbook.getSheet("Employees");
            empController.uploadEmpFile(employeeSheet);

            XSSFSheet prizeSheet = workbook.getSheet("Prizes");
            przController.uploadEmpFile(prizeSheet);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sort(){
        try {
            System.out.println("GeneralCOntMethod");
            wnrController.sortPrize();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void sendMail(){
        emailSenderController.sendMail();
    }

    public EmailSenderController getEmailSenderController() {
        return emailSenderController;
    }

    public void setEmailSenderController(EmailSenderController emailSenderController) {
        this.emailSenderController = emailSenderController;
    }

    public Part getGeneralExcelFile() {
        return generalExcelFile;
    }

    public void setGeneralExcelFile(Part generalExcelFile) {
        this.generalExcelFile = generalExcelFile;
    }

    public EmployeeController getEmpController() {
        return empController;
    }

    public void setEmpController(EmployeeController eController) {
        this.empController = eController;
    }

    public PrizeController getPrzController() {
        return przController;
    }

    public void setPrzController(PrizeController przController) {
        this.przController = przController;
    }

    public WinnerController getWnrController() {
        return wnrController;
    }

    public void setWnrController(WinnerController wnrController) {
        this.wnrController = wnrController;
    }
}
