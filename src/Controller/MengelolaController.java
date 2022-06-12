package Controller;

import Entity.MengelolaEntity;
import Model.MengelolaModel;

import java.util.ArrayList;
import java.util.Date;

public class MengelolaController {
    public static MengelolaModel mengelolaModel = new MengelolaModel();
    public boolean insertMengelola(ArrayList<MengelolaEntity> mengelolaEntity){
        MengelolaModel mengelolaModel = new MengelolaModel();
        return mengelolaModel.insertMengelola(mengelolaEntity);
    }
    public ArrayList<MengelolaEntity> getMengelola(){
        return new MengelolaModel().getMengelola();
    }

    public ArrayList<MengelolaEntity> getDetail(){
        return mengelolaModel.getDetail();
    }
}
