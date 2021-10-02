package DAO;

import Model.Training.MTraining;
import Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DAOEmployeeTraining implements ICommon.ICommonDAO<MTraining>{
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
            java.util.Date date = new java.util.Date();
            java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
            sql = "insert into employee_training (title, training_provider, trainer, trainee, training_location) values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getmTitle());
            ps.setString(2, t.getmTrainingProvider());
            ps.setString(3, t.getmTrainer());
            ps.setString(4, t.getmTrainee());
            ps.setString(5, t.getmTrainingLocation());
        
          

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
         System.out.println("hi");
        try {
            sql = "update employee_training set   title = ?, training_provider = ? , trainer = ?, trainee = ?, training_location where emp_code = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, t.getmTitle());
             ps.setString(2, t.getmTrainingProvider());
            ps.setString(3, t.getmTrainer());
            ps.setString(4, t.getmTrainee());
            ps.setString(5, t.getmTrainingLocation());
           ps.setString(6, t.getmEmpCode() );
            
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

            String sql = "delete from employee_training where emp_code = ?";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
