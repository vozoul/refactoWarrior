package warriors.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cfg {
    private Connection con;
    private String url;
    private String db;
    private String opt;
    private String usr;
    private String pwd;

    public Cfg(){
        this.url = "jdbc:mysql://127.0.0.1:3306/";
        this.db = "donjon";
        this.opt = "autoReconnect=true&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        this.usr = "root";
        this.pwd = "root";
    }

    public Connection getConnection(){
        try {
            con = DriverManager.getConnection(url+db+"?"+opt, usr, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
