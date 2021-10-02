package DAO.Employee;

import Controller.Employee.AddNewEmployee;
import Model.Employee.MAddNewEmployee;
import Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;

public class DAOAddNewEmployee implements ICommon.ICommonDAO<MAddNewEmployee> {

    Connection con = DBConnector.getConnection();
    Statement stmt;
    ResultSet rs;
    PreparedStatement ps;
    int status;
    String sql;

    @Override
    public int save(MAddNewEmployee t) {
        try {
            con = DBConnector.getConnection();
            sql = "insert into addnewemployee (empcode,empname, f_name, m_name, gender, maritalstatus, dob, religion, bloodgroup, nationality, presentadderss, parmanentaddress, doj, documents, designation, typeofemployee, experience, catagoryofemployee, medicalfitness, extracurriculam, email, mobilenumber) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getmEmpCode());
            ps.setString(2, t.getmEmpName());
            ps.setString(3, t.getmEmpFName());
            ps.setString(4, t.getmEmpMName());
            ps.setString(5, t.getmGender());
            ps.setString(6, t.getmMaritalStatus());
            ps.setString(7, t.getmDateOfBirth());
            ps.setString(8, t.getmReligion());
            ps.setString(9, t.getmBloodGroup());
            ps.setString(10, t.getmNationaliy());
            ps.setString(11, t.getmPresentAddress());
            ps.setString(12, t.getmParmanentAddress());
            ps.setString(13, t.getmDateOfJoin());
            ps.setString(14, t.getmDocuments());
            ps.setString(15, t.getmDesignation());
            ps.setString(16, t.getmTypeOfEmployee());
            ps.setString(17, t.getmExperience());
            ps.setString(18, t.getmCatagoryOfEmployee());
            ps.setString(19, t.getmMedicalfitness());
            ps.setString(20, t.getmExtraCurriculam());
            ps.setString(21, t.getmEmailAddress());
            ps.setString(22, t.getmMobileNumber());
           
           
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
    public int edit(MAddNewEmployee t) {
        System.out.println("hi");
        try {
            sql = "update addnewemployee set  empname = ?, f_name = ?, m_name = ?, gender = ?, designation = ?, dob = ?, email = ?, maritalstatus = ?, mobilenumber = ?, religion = ?, nationality = ?, bloodgroup = ?, typeofemployee = ?, presentaddress = ?, parmanentaddress = ?, experience = ?, medicalfitness = ?, catagoryofemployee = ?, documents = ?, extracurriculam = ? where empcode = ? ";
            ps = con.prepareStatement(sql);
            
//            ps.setString(1, t.getmEmpCode());
            ps.setString(1, t.getmEmpName());
            ps.setString(2, t.getmEmpFName());
            ps.setString(3, t.getmEmpMName());
            ps.setString(4, t.getmGender());
            ps.setString(5, t.getmDesignation());
            ps.setString(6, t.getmDateOfBirth());
            ps.setString(8, t.getmMaritalStatus());
            ps.setString(9, t.getmMobileNumber());
            ps.setString(7, t.getmEmailAddress());
            ps.setString(10, t.getmReligion());
            ps.setString(11, t.getmNationaliy());
            ps.setString(12, t.getmBloodGroup());
            ps.setString(13, t.getmTypeOfEmployee());
            ps.setString(14, t.getmPresentAddress());
            ps.setString(15, t.getmParmanentAddress());
            ps.setString(16, t.getmExperience());
            ps.setString(17, t.getmMedicalfitness());
            ps.setString(18, t.getmCatagoryOfEmployee());
            ps.setString(19, t.getmDocuments());
            ps.setString(20, t.getmExtraCurriculam());
            ps.setString(21, t.getmEmpCode());
            

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

            String sql = "delete from addnewemployee where empcode = ?";
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
    public MAddNewEmployee search(String EmpCode) {
        try {

            sql = "select * from addnewemployee where empcode = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, EmpCode);
            rs = ps.executeQuery();
            MAddNewEmployee ane = new MAddNewEmployee();
            while (rs.next()) {

                ane.setmEmpCode(rs.getString("empcode"));
                ane.setmEmpName(rs.getString("empname"));
                ane.setmEmpFName(rs.getString("f_name"));
                ane.setmEmpMName(rs.getString("m_name"));
                ane.setmGender(rs.getString("gender"));
                ane.setmDesignation(rs.getString("designation"));
                ane.setmDateOfBirth(rs.getString("dateofbirth"));
                ane.setmEmailAddress(rs.getString("email"));
                ane.setmMaritalStatus(rs.getString("maritalstatus"));
                ane.setmMobileNumber(rs.getString("mobilenumber"));
                ane.setmReligion(rs.getString("religion"));
                ane.setmNationaliy(rs.getString("nationality"));
                ane.setmBloodGroup(rs.getString("bloodgroup"));
                ane.setmTypeOfEmployee(rs.getString("typeofemployee"));
                ane.setmPresentAddress(rs.getString("presentaddress"));
                ane.setmParmanentAddress(rs.getString("parmanentaddress"));
                ane.setmExperience(rs.getString("experience"));
                ane.setmMedicalfitness(rs.getString("medicalfitness"));
                ane.setmCatagoryOfEmployee(rs.getString("catagoryofemployee"));
                ane.setmDocuments(rs.getString("documents"));
                ane.setmExtraCurriculam(rs.getString("extracurriculam"));
//                ane.setmImage(rs.getByte("image"));

//       image.set(rs.getByte(""));
            }
//            con.close(); //after completing task close the popup window
            return ane;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

}
