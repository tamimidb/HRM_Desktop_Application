package DAO;

import Controller.Employee.EmployeeJobDetails;
import ICommon.ICommonDAO;
import Model.Employee.MAddNewEmployee;
import Model.Employee.MEmployeeJobDetails;
import Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DAOEmployeeJobDetails implements ICommonDAO<MEmployeeJobDetails>{
    
    Connection con = DBConnector.getConnection();
    Statement stmt;
    ResultSet rs;
    PreparedStatement ps;
    int status;
    String sql;

    @Override
    public int save(MEmployeeJobDetails t) {
        try {
            con = DBConnector.getConnection();
            sql = "insert into employeejobdetails (emp_code, emp_name, emp_grade, typeofstaff, designation, typeofemployee, experience, catagoryofemployee, dateofconfirmation, dateofjoin, dateoflastpromotion, repotingboss, branch, department, cvuploaded, mobilenumber, emailaddress) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getmEmpCode());
            ps.setString(2, t.getmEmpName());
            ps.setString(3, t.getmEmpGrade());
            ps.setString(4, t.getmTypeOfStaff());
            ps.setString(5, t.getmDesignation());
            ps.setString(6, t.getmTypeOfEmployee());
            ps.setString(7, t.getmExperience());
            ps.setString(8, t.getmCatagoryOfEmployee());
            ps.setString(9, t.getmDateOfConfirmation());
            ps.setString(10, t.getmDateOfJoin());
            ps.setString(11, t.getmDateOfLastPromotion());
            ps.setString(12, t.getmReportinBoss());
            ps.setString(13, t.getmBranch());
            ps.setString(14, t.getmDepartment());
            ps.setString(15, t.getmCVUploaded());
            ps.setString(16, t.getmMobileNumber());
            ps.setString(17, t.getmEmailAddress());
           
//            ps.setByte(22, t.getmImage());

            status = ps.executeUpdate();
//            con.close();
            return status;

        } catch (Exception e) {

            return 0;
        }
    }

    @Override
    public int edit(MEmployeeJobDetails t) {
        System.out.println("edit");
        try {
            sql = "update employeejobdetails set  emp_code = ?, emp_name = ?, emp_f_name = ?, emp_m_name = ?, gender = ?, designation = ?, dateofbirth = ?, email = ?, maritalstatus = ?, mobilenumber = ?, religion = ?, nationality = ?, bloodgroup = ?, typeofemployee = ?, presentaddress = ?, parmanentaddress = ?, experience = ?, medicalfitness = ?, catagoryofemployee = ?, documents = ?, extracurriculam = ? where emp_code = ? ";
            
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getmEmpCode());
            ps.setString(2, t.getmEmpName());
            ps.setString(3, t.getmEmpGrade());
            ps.setString(4, t.getmTypeOfStaff());
            ps.setString(5, t.getmDesignation());
            ps.setString(6, t.getmTypeOfEmployee());
            ps.setString(7, t.getmExperience());
            ps.setString(8, t.getmCatagoryOfEmployee());
            ps.setString(9, t.getmDateOfConfirmation());
            ps.setString(10, t.getmDateOfJoin());
            ps.setString(11, t.getmDateOfLastPromotion());
            ps.setString(12, t.getmReportinBoss());
            ps.setString(13, t.getmBranch());
            ps.setString(14, t.getmDepartment());
            ps.setString(15, t.getmCVUploaded());
            ps.setString(16, t.getmMobileNumber());
            ps.setString(17, t.getmEmailAddress());
           
            

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
    public int delete(String mEmpCode) {
        try {

            String sql = "delete from employeejobdetails where emp_code = ?";
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
    public MEmployeeJobDetails search(String mEmpCode) {
         try {

            sql = "select * from employeejobdetails where emp_code = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, mEmpCode);
            rs = ps.executeQuery();
            MEmployeeJobDetails ane = new MEmployeeJobDetails();
            while (rs.next()) {
            ane.setmEmpCode(rs.getString("emp_code"));
                ane.setmEmpName(rs.getString("emp_name"));
                ane.setmEmpGrade(rs.getString("emp_grade"));
                ane.setmTypeOfStaff(rs.getString("typeofstaff"));
                ane.setmDesignation(rs.getString("designation"));
                ane.setmTypeOfEmployee(rs.getString("typeofemployee"));
                ane.setmExperience(rs.getString("experience"));
                ane.setmDateOfConfirmation(rs.getString("dateofconfirmation"));
                ane.setmDateOfJoin(rs.getString("dateofjoin"));
                ane.setmDateOfLastPromotion(rs.getString("dateoflastpromotion"));
                ane.setmReportinBoss(rs.getString("repotingboss"));
                ane.setmBranch(rs.getString("branch"));
                ane.setmDepartment(rs.getString("department"));
                ane.setmCVUploaded(rs.getString("cvuploaded"));
                ane.setmMobileNumber(rs.getString("mobilenumber"));
                ane.setmEmailAddress(rs.getString("emailaddress"));
                
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
