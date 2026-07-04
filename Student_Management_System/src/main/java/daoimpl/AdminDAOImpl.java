package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;
import dao.adminDAO;
public class AdminDAOImpl implements adminDAO {

    Connection con =
            DBConnection.getConnection();

    @Override
    public boolean login(String username,
                         String password) {

        boolean flag=false;

        try {

            String sql=
            "SELECT * FROM admin WHERE username=? AND password=?";

            PreparedStatement ps=
                    con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs=
                    ps.executeQuery();

            if(rs.next()) {
                flag=true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}