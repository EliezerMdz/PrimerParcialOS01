package Controller;

import entity.Prize;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by EliezerMdz on 09/09/2016.
 */

@ViewScoped
@ManagedBean(name = "PrzCont")

public class PrizeController {

    private ArrayList<Prize> prizes;

    public void uploadEmpFile(XSSFSheet prizeSheet){
        try {
            Iterator<Row> rowIt = prizeSheet.rowIterator();
            rowIt.next();
            prizes = new ArrayList<Prize>();

            while (rowIt.hasNext()){

                XSSFRow row = (XSSFRow) rowIt.next();

                String description = row.getCell(0).getStringCellValue();
                String brand = row.getCell(1).getStringCellValue();
                double quantity = row.getCell(2).getNumericCellValue();

                Prize prize = new Prize(description, brand,(int)quantity);

                if (prize.getQuantity() > 0) {
                    prizes.add(prize);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<Prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(ArrayList<Prize> prizes) {
        this.prizes = prizes;
    }

}
