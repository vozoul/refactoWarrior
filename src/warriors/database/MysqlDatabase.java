package warriors.database;

import warriors.config.Cfg;
import warriors.engine.Heroe;
import warriors.engine.Warrior;
import java.sql.*;

public class MysqlDatabase {

    private static Connection con;
    private static PreparedStatement pst;
    private static ResultSet rst;

    public static void MysqlDatabase(){
        con = new Cfg().getConnection();
    }

    public static void connectTest() {
        try {
            con = new Cfg().getConnection();
            Heroe test = new Warrior();
            addInDB(test);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addInDB(Heroe test) {
        String query = "INSERT INTO heroes ( name,image,life, maxLife,atk,maxAtk) VALUES (?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1,test.getName());
            pst.setString(2,test.getImage());
            pst.setInt(3,test.getLife());
            pst.setInt(4,test.getMaxLife());
            pst.setInt(5,test.getAttackLevel());
            pst.setInt(6,test.getMaxAttackLevel());
            pst.executeUpdate();

            System.out.println("Ajout OK !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
