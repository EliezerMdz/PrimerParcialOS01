package Controller;

import entity.Prize;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by EliezerMdz on 09/09/2016.
 */

@RequestScoped
@ManagedBean(name = "PrzCont")

public class PrizeController {
    ArrayList<Prize> prizes;

    public ArrayList getPrizes(){

        return prizes;
    }
}
