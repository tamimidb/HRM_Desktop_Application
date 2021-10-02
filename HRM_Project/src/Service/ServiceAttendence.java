package Service;

import ICommon.ICommonService;
import Model.Attendance.MAttendence;

public class ServiceAttendence implements ICommonService<MAttendence>{
    DAO.DAOAttendence dao = new DAO.DAOAttendence();
    @Override
    public int save(MAttendence t) {
        return dao.save(t);
    
    }

    @Override
    public int edit(MAttendence t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String mEmpCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MAttendence search(String mEmpCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
