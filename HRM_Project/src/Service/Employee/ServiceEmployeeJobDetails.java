package Service.Employee;

import DAO.DAOEmployeeJobDetails;
import ICommon.ICommonService;
import Model.Employee.MEmployeeJobDetails;

public class ServiceEmployeeJobDetails implements ICommonService<MEmployeeJobDetails>{
    DAO.DAOEmployeeJobDetails dao = new DAOEmployeeJobDetails();
    @Override
    public int save(MEmployeeJobDetails t) {
        return dao.save(t);
    }

    @Override
    public int edit(MEmployeeJobDetails t) {
        return dao.edit(t);
    }

    @Override
    public int delete(String mEmpCode) {
        return dao.delete(mEmpCode) ;
    }

    @Override
    public MEmployeeJobDetails search(String mEmpCode) {
        return dao.search(mEmpCode);
    }

   
}
