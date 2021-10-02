package Service;

import DAO.DAOEmployeeSalaryDetails;
import ICommon.ICommonService;
import Model.Employee.MEmployeeSalaryDetails;

public class ServiceEmployeeSalaryDetails implements  ICommonService<MEmployeeSalaryDetails>{
    DAOEmployeeSalaryDetails  dao = new DAOEmployeeSalaryDetails();
    
    
    @Override
    public int save(MEmployeeSalaryDetails t) {
        return dao.save(t);
 }

    @Override
    public int edit(MEmployeeSalaryDetails t) {
        return dao.edit(t);
    }

    @Override
    public int delete(String mEmpCode) {
        return dao.delete(mEmpCode);   
    
    }

    @Override
    public MEmployeeSalaryDetails search(String mEmpCode) {
        return dao.search(mEmpCode);   
    
    }

}
