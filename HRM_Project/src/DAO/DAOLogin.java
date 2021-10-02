package DAO;

import Controller.Main.Dashboard;
import Controller.Main.Registation;
import ICommon.ICommonLogin;
import Model.Login.MLogin;
import Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DAOLogin implements ICommonLogin<MLogin> {

    Connection con = DBConnector.getConnection();
    Statement stmt;
    ResultSet rs;
    PreparedStatement ps;
    int status;
    String sql;

    @Override
    public int login(MLogin t) {
       
            
            try {
               
                String sql = "select * from registation where emp_code = ?, create_account_as = ?, password = ?";
                ps =con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                MLogin l = new MLogin();
                while(rs.next()){
                  l.setmEmp_Code(rs.getString("emp_code"));
                  l.setmLogINAs(rs.getString("create_account_as"));
                  l.setmPassword(rs.getString("password"));
            
                }
                
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error: " + e);
                return 0;
            }
        
    }

    @Override
    public int registation(MLogin t) {
        try {
            con = DBConnector.getConnection();
            sql = "insert into registation(emp_code, emp_name, email, create_account_as, password) values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getmEmp_Code());
            ps.setString(2, t.getmEmp_Name());
            ps.setString(3, t.getmEmailID());
            ps.setString(4, t.getmLogINAs());
            ps.setString(5, t.getmPassword());

            status = ps.executeUpdate();
//            con.close();
            return status;

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

}
