package DAO;

import ICommon.ICommonDAO;
import Model.Attendance.MAttendence;
import Util.DBConnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class DAOAttendence implements ICommonDAO<MAttendence> {

    Connection con = DBConnector.getConnection();
    Statement stmt;
    ResultSet rs;
    PreparedStatement ps;
    int status;
    String sql;

    @Override
    public int save(MAttendence t) {
        try {
            con = DBConnector.getConnection();
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
            sql = "insert into addnewemployee (emp_code,emp_name,attendence) values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getmEmp_code());
            ps.setString(2, t.getmEmp_name());
//            ps.setTimestamp(3,sqlTime);
            ps.setString(3, t.getmAttendance());

            status = ps.executeUpdate();
//            con.close();
            return status;

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
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
