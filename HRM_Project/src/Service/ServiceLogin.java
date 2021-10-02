package Service;

import DAO.DAOLogin;
import ICommon.ICommonLogin;
import Model.Login.MLogin;

public class ServiceLogin implements ICommonLogin<MLogin>{
    DAOLogin dao = new DAOLogin();
   
  @Override
    public int login(MLogin t) {
        return dao.login(t);
    }

    @Override
    public int registation(MLogin t) {
        return dao.registation(t);
            
    }

}
