package Service;

import DAO.DAOEmployeeTraining;
import Model.Training.MTraining;

public class ServiceTraining implements ICommon.ICommonService<MTraining>{
    DAOEmployeeTraining dao = new DAOEmployeeTraining();
    @Override
    public int save(MTraining t) {
        return dao.save(t);
    }

    @Override
    public int edit(MTraining t) {
        return dao.edit(t);
        
    }

    @Override
    public int delete(String mEmpCode) {
        return dao.delete(mEmpCode);
    }

    @Override
    public MTraining search(String mEmpCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
