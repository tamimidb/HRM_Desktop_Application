package DAO;

import ICommon.ICommonDAO;
import Model.Employee.MEmployeeJobDetails;
import Model.Employee.MEmployeeSalaryDetails;
import Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DAOEmployeeSalaryDetails implements ICommonDAO<MEmployeeSalaryDetails> {

    Connection con = DBConnector.getConnection();
    Statement stmt;
    ResultSet rs;
    PreparedStatement ps;
    int status;
    String sql;

    @Override
    public int save(MEmployeeSalaryDetails t) {
        try {
            con = DBConnector.getConnection();
            sql = "insert into employeesalarydetails (emp_code, emp_name, designation, emp_grade, typeofemployee, typeofstaff, catagoryofemployee, bankaccountnum, basicsalary, salaryperday, department, branch) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getmEmpCode());
            ps.setString(2, t.getmEmpName());
            ps.setString(3, t.getmDesignation());
            ps.setString(4, t.getmEmpGrade());
            ps.setString(5, t.getmTypeOfEmployee());
            ps.setString(6, t.getmTypeOfStaff());
            ps.setString(7, t.getmCatagoryOfEmployee());
            ps.setString(8, t.getmBankAccountNumber());
            ps.setString(9, String.valueOf(t.getmBasicSalary()));
            ps.setString(10, String.valueOf(t.getmSalaryPerDay()));
            ps.setString(11, t.getmBranch());
            ps.setString(12, t.getmDepartment());

//            ps.setByte(22, t.getmImage());
            status = ps.executeUpdate();
//            con.close();
            return status;

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int edit(MEmployeeSalaryDetails t) {
        try {
            sql = "update employeesalarydetails set  emp_code = ?, emp_name = ?, designation = ?, emp_grade = ?, typeofemployee = ?, typeofstaff = ?, catagoryofemployee = ?, bankaccountnum = ?, basicsalary = ?, salaryperday = ?, department = ?, branch = ?  where id = ? ";
            ps = con.prepareStatement(sql);

            ps = con.prepareStatement(sql);
            ps.setString(1, t.getmEmpCode());
            ps.setString(2, t.getmEmpName());
            ps.setString(3, t.getmEmpGrade());
            ps.setString(4, t.getmTypeOfStaff());
            ps.setString(5, t.getmDesignation());
            ps.setString(6, t.getmTypeOfEmployee());
          
            ps.setString(13, t.getmBranch());
            ps.setString(14, t.getmDepartment());
         
//            ps.setByte(22, t.getmImage());
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

            String sql = "delete from employeesalarydetails where emp_code = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(mEmpCode));
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
    public MEmployeeSalaryDetails search(String mEmpCode) {
        try {

            sql = "select * from employeesalarydetails where emp_code = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, mEmpCode);
            rs = ps.executeQuery();
            MEmployeeSalaryDetails ane = new MEmployeeSalaryDetails();
            while (rs.next()) {
                ane.setmEmpCode(rs.getString("emp_code"));
                ane.setmEmpName(rs.getString("emp_name"));
                ane.setmDesignation(rs.getString("designation"));
                ane.setmEmpGrade(rs.getString("emp_grade"));
                ane.setmTypeOfEmployee(rs.getString("typeofemployee"));
                ane.setmTypeOfStaff(rs.getString("typeofstaff"));
                ane.setmCatagoryOfEmployee(rs.getString("catagoryofemployee"));
               ane.setmBasicSalary(rs.getDouble("branch"));
               ane.setmSalaryPerDay(rs.getDouble("branch"));
               ane.setmBranch(rs.getString("branch"));
                ane.setmDepartment(rs.getString("department"));
               

//                ane.setmImage(rs.getByte("image"));
            }
//            con.close(); //after completing task close the popup window
            return ane;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

}
