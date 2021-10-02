package DAO.Employee;

import Model.Training.MTraining;
import Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DAOTrainingEvent implements ICommon.ICommonDAO<MTraining>{
     Connection con = DBConnector.getConnection();
    Statement stmt;
    ResultSet rs;
    PreparedStatement ps;
    int status;
    String sql;
    
    @Override
    public int save(MTraining t) {
    try {
            con = DBConnector.getConnection();
            
           
            sql = "insert into training_event (title, training_place, start_date, end_date) values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getmTitle());
            ps.setString(2, t.getmTrainingPlace());
            ps.setString(3, t.getmStartDate());
            ps.setString(4, t.getmEndDate());
            

            status = ps.executeUpdate();
//            con.close();
            return status;

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }  
    }

    @Override
    public int edit(MTraining t) {
  
        try {
            sql = "update training_event set training_place = ? , start_date = ?, end_date = ? where title = ?";
            ps = con.prepareStatement(sql);

           
             ps.setString(1, t.getmTrainingPlace());
            ps.setString(2, t.getmStartDate());
            ps.setString(3, t.getmEndDate());
             ps.setString(4, t.getmTitle());
            
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

            String sql = "delete from training_event where title = ?";
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
    public MTraining search(String mEmpCode) {
        try {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
}
