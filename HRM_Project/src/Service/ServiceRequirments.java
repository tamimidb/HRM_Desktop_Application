package Service;

import DAO.DAORequirmnents;
import ICommon.ICommonService;
import Model.Recuitments.MRecruitments;

public class ServiceRequirments implements ICommonService<MRecruitments> {

    DAORequirmnents dao = new DAORequirmnents();

    @Override
    public int save(MRecruitments t) {
        return dao.save(t);
    }

    @Override
    public int edit(MRecruitments t) {
        return dao.edit(t);
    }

    @Override
    public int delete(String mEmpCode) {
        return dao.delete(mEmpCode);
    }

    @Override
    public MRecruitments search(String mEmpCode) {
        return dao.search(mEmpCode);
    }

}
