package DAO;

import Model.Leaves.MLeaves;
import Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DAOLeaves implements ICommon.ICommonDAO<MLeaves>{
    Connection con = DBConnector.getConnection();
    Statement stmt;
    ResultSet rs;
    PreparedStatement ps;
    int status;
    String sql;
    @Override
    public int save(MLeaves t) {
  try {
            con = DBConnector.getConnection();
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
            sql = "insert into leaves (emp_code, emp_name, designation, typeofemployee, department, leavetype, month, fromdate, numofdays, enddate, leaveperiod, reason, emailid, phonenumber, addressonleave) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getmEmpCode());
            ps.setString(2, t.getmEmpName());
            ps.setString(3, t.getmDesignation());
            ps.setString(4, t.getmTypeOfEmployee());
            ps.setString(5, t.getmDepartment());
            ps.setString(6, t.getmLeaveType());
            ps.setString(7, t.getmMonth());
            ps.setString(8, t.getmFromDate());
            ps.setString(9, t.getmNumberOfDays());
            ps.setString(10, t.getmEndDate());
            ps.setString(11, t.getmLeavePeriod());
            ps.setString(12, t.getmReason());
            ps.setString(13, t.getmEmailID());
            ps.setString(14, t.getmPhoneNumber());
            ps.setString(15, t.getmAddressOnLeave());
            
          

            status = ps.executeUpdate();
//            con.close();
            return status;

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }    
    }

    @Override
    public int edit(MLeaves t) {
         System.out.println("hi");
        try {
            sql = "update leaves set   emp_name = ?, designation = ?, typeofemployee = ?, department = ?, leavetype = ?, month = ?, fromdate = ?, numofdays = ?, enddate = ?, leaveperiod = ?, reason = ?, emailid = ?, phonenumber = ?, addressonleave = ? where emp_code = ? ";
            ps = con.prepareStatement(sql);

            ps.setString(1, t.getmEmpName());
            ps.setString(2, t.getmDesignation());
            ps.setString(3, t.getmTypeOfEmployee());
            ps.setString(4, t.getmDepartment());
            ps.setString(5, t.getmLeaveType());
            ps.setString(6, t.getmMonth());
            ps.setString(7, t.getmFromDate());
            ps.setString(8, t.getmNumberOfDays());
            ps.setString(9, t.getmEndDate());
            ps.setString(10, t.getmLeaveType());
            ps.setString(11, t.getmReason());
            ps.setString(12, t.getmEmailID());
            ps.setString(13, t.getmPhoneNumber());
            ps.setString(14, t.getmAddressOnLeave());
           ps.setString(15, t.getmEmpCode());
    
            status = ps.executeUpdate();
           con.close();
            return status;
        } catch (Exception e) {
            System.out.println(e);
            
            return 0;
        }
    }

    @Override
    public int delete(String mEmpCode) {
         try {

            String sql = "delete from leaves where emp_code = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, mEmpCode);
            status = ps.executeUpdate();
//            con.close();
            return status;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Invalid Deletion");
            return 0;
        }
    }

    @Override
    public MLeaves search(String mEmpCode) {
         try {

            sql = "select * from leaves where emp_code = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, mEmpCode);
            rs = ps.executeQuery();
            MLeaves ane = new MLeaves();
            while (rs.next()) {

                ane.setmEmpCode(rs.getString("emp_code"));
                ane.setmEmpName(rs.getString("emp_name"));
                ane.setmDesignation(rs.getString("designation"));
                ane.setmTypeOfEmployee(rs.getString("typeofemployee"));
                ane.setmDepartment(rs.getString("department"));
                ane.setmLeaveType(rs.getString("leavetype"));
                ane.setmMonth(rs.getString("month"));
                ane.setmFromDate(rs.getString("fromdate"));
                ane.setmNumberOfDays(rs.getString("numofdays"));
                ane.setmEndDate(rs.getString("enddate"));
                ane.setmLeavePeriod(rs.getString("leaveperiod"));
                ane.setmReason(rs.getString("reason"));
                ane.setmEmailID(rs.getString("emailid"));
                ane.setmPhoneNumber(rs.getString("phonenumber"));
                ane.setmAddressOnLeave(rs.getString("addressonleave"));
                
                
            }
//            con.close(); //after completing task close the popup window
            return ane;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

}
