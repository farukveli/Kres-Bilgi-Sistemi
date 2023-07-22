import java.sql.*;

public class Classroom {

    private String className;
    private int quota;

    public Classroom(String className, int quota) {
        this.className = className;
        this.quota = quota;
    }

    public String getClassName() {
        return className;
    }

    public int getQuota() {
        return quota;
    }

    ResultSet listClassroom(Connection con) throws SQLException {
        String sql = "SELECT * FROM kid where class = className";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
       /* while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("firstName")  + "\t" + rs.getString("lastName"));
        }*/
        return rs;
    }

    public static ResultSet getClassList(String classname, Connection con) throws SQLException {

        PreparedStatement stmt=con.prepareStatement("SELECT * FROM kid where classroom = ?");
        stmt.setString(1, classname);
        ResultSet rs = stmt.executeQuery();
        /*while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("firstName")  + "\t" + rs.getString("lastName"));
        }*/
        return rs;
    }

    public static boolean assignTeacherToClass(String classname, int teacherid, Connection con) throws SQLException {
        PreparedStatement stmt=con.prepareStatement("UPDATE classroom SET teacherid = ? WHERE classname = ?");
        stmt.setInt(1, teacherid);
        stmt.setString(2, classname);
        stmt.executeUpdate();
        return true;
    }

    public static boolean createNewClassroom(String classname, int quota, Connection con)  {
        try
        {
            PreparedStatement stmt=con.prepareStatement("INSERT INTO classroom (classname, quota, numOfStudent) VALUES (?, ?, 0)");
            stmt.setString(1, classname);
            stmt.setInt(2, quota);
            stmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
