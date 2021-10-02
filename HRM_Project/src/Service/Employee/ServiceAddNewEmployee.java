package Service.Employee;

import DAO.Employee.DAOAddNewEmployee;
import Model.Employee.MAddNewEmployee;

public class ServiceAddNewEmployee implements ICommon.ICommonService<MAddNewEmployee> {

    DAOAddNewEmployee dao = new DAOAddNewEmployee();

    @Override
    public int save(MAddNewEmployee t) {
        return dao.save(t);
    }

    @Override
    public int edit(MAddNewEmployee t) {
        
        return dao.edit(t);
    }

    @Override
    public int delete(String EmpCode) {
        return dao.delete(EmpCode);
    }

    @Override
    public MAddNewEmployee search(String EmpCode) {
      
        return dao.search(EmpCode);
        
    }

}
