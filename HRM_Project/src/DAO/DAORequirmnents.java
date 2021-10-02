package DAO;

import ICommon.ICommonDAO;
import Model.Leaves.MLeaves;
import Model.Recuitments.MRecruitments;
import Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DAORequirmnents implements ICommonDAO<MRecruitments>{
  Connection con = DBConnector.getConnection();
    Statement stmt;
    ResultSet rs;
    PreparedStatement ps;
    int status;
    String sql;
    @Override
    public int save(MRecruitments t) {
      try {
            con = DBConnector.getConnection();
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
            sql = "insert into requitments (code, first_name, middle_name, last_name, email_id, gender, phone_number, date_of_birth, education, specialization, experience, keywords, current_company, designation, current_salary, referred_by, employee_id, employee_name, upload_cv) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getmSriealNumber());
            ps.setString(2, t.getmFirstName());
            ps.setString(3, t.getmMiddleName());
            ps.setString(4, t.getmLastName());
            ps.setString(5, t.getmEmailID());
            ps.setString(6, t.getmGender());
            ps.setString(7, t.getmPhoneNumber());
            ps.setString(8, t.getmDateOfBirth());
            ps.setString(9, t.getmEducation());
            ps.setString(10, t.getmSpecialization());
            ps.setString(11, t.getmExperience());
            ps.setString(12, t.getmKeywords());
            ps.setString(13, t.getmCurrentCompany());
            ps.setString(14, t.getmDesignation());
            ps.setDouble(15, Double.parseDouble(t.getmCurrentSalary()));
            ps.setString(16, t.getmReferredBy());
            ps.setString(17, t.getmEmployeeID());
            ps.setString(18, t.getmEmployeeName());
            ps.setString(19, t.getmUploadedCV());
           
          

            status = ps.executeUpdate();
//            con.close();
            return status;

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }  
    }

    @Override
    public int edit(MRecruitments t) {
        System.out.println("hi");
        try {
            sql = "update requitments set   first_name = ?, middle_name= ? , upload_cv = ?   last_name = ?, email_id = ? , gender = ?, phone_number = ? , date_of_birth = ?, education = ? , specialization  = ?, experience = ? , keywords = ?, current_company = ? , designation = ?, current_salary = ? , referred_by = ?, employee_id = ? , employee_name = ?, where code = ?";
            ps = con.prepareStatement(sql);

           ps.setString(1, t.getmFirstName());
            ps.setString(2, t.getmMiddleName());
            ps.setString(3, t.getmLastName());
            ps.setString(4, t.getmEmailID());
            ps.setString(5, t.getmGender());
            ps.setString(6, t.getmPhoneNumber());
            ps.setString(7, t.getmDateOfBirth());
            ps.setString(8, t.getmEducation());
            ps.setString(9, t.getmSpecialization());
            ps.setString(10, t.getmExperience());
            ps.setString(11, t.getmKeywords());
            ps.setString(12, t.getmCurrentCompany());
            ps.setString(13, t.getmDesignation());
            ps.setString(14, t.getmCurrentSalary());
            ps.setString(15, t.getmReferredBy());
            ps.setString(16, t.getmEmployeeID());
            ps.setString(17, t.getmEmployeeName());
            ps.setString(18, t.getmUploadedCV());
            ps.setString(19, t.getmSriealNumber());
           
            
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

            String sql = "delete from requitments where code = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, mEmpCode);
            status = ps.executeUpdate();
//            con.close();
            return status;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Invalid Deletion");
            return 0;
        }    }

    @Override
    public MRecruitments search(String mEmpCode) {
        try {

            sql = "select * from requitments where code = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, mEmpCode);
            rs = ps.executeQuery();
            MRecruitments ane = new MRecruitments();
            while (rs.next()) {

                ane.setmSriealNumber(rs.getString("code"));
                ane.setmFirstName(rs.getString("first_name"));
                ane.setmMiddleName(rs.getString("middle_name"));
                ane.setmLastName(rs.getString("last_name"));
                ane.setmEmailID(rs.getString("email_id"));
                ane.setmDateOfBirth(rs.getString("date_of_birth"));
                ane.setmGender(rs.getString("gender"));
                ane.setmEducation(rs.getString("education"));
                ane.setmSpecialization(rs.getString("specialization"));
                ane.setmKeywords(rs.getString("keywords"));
                ane.setmCurrentCompany(rs.getString("current_company"));
                ane.setmDesignation(rs.getString("designation"));
                ane.setmCurrentSalary(rs.getString("current_salary"));
                ane.setmDesignation(rs.getString("designation"));
                ane.setmReferredBy(rs.getString("referred_by"));
                ane.setmEmployeeID(rs.getString("employee_id"));
                ane.setmEmployeeName(rs.getString("employee_name"));
                ane.setmPhoneNumber(rs.getString("phone_number"));
                ane.setmUploadedCV(rs.getString("upload_cv"));
                
           
            }
//            con.close(); //after completing task close the popup window
            return ane;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

}
    


