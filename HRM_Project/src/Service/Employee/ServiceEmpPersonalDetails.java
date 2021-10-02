package Service.Employee;

import DAO.Employee.DAOEmpPersonalDetails;
import ICommon.ICommonService;
import Model.Employee.MEmployeePersonalDetails;

public class ServiceEmpPersonalDetails implements ICommonService<MEmployeePersonalDetails> {

    DAOEmpPersonalDetails dao = new DAOEmpPersonalDetails();

    @Override
    public int save(MEmployeePersonalDetails t) {
        return dao.save(t);
    }

    @Override
    public int edit(MEmployeePersonalDetails t) {
        return dao.edit(t);
    }

    @Override
    public int delete(String mEmpCode) {
        return dao.delete(mEmpCode);
    }

    @Override
    public MEmployeePersonalDetails search(String mEmpCode) {
        return dao.search(mEmpCode);
    }

}
