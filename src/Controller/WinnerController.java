package Controller;

import entity.Winner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;

/**
 * Created by EliezerMdz on 09/09/2016.
 */

@RequestScoped
@ManagedBean(name = "WnrCont")

public class WinnerController {
    ArrayList<Winner> winners;

    public ArrayList getWinners(){

        return winners;
    }
}
