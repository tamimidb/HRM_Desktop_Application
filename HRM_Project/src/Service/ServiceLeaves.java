package Service;

import DAO.DAOLeaves;
import Model.Leaves.MLeaves;

public class ServiceLeaves implements ICommon.ICommonService<MLeaves>{
    DAOLeaves dao = new DAOLeaves();
    @Override
    public int save(MLeaves t) {
        return dao.save(t);
    }

    @Override
    public int edit(MLeaves t) {
        return dao.edit(t);
    }

    @Override
    public int delete(String mEmpCode) {
        return dao.delete(mEmpCode);
    }

    @Override
    public MLeaves search(String mEmpCode) {
        return dao.search(mEmpCode);
    }

}
