import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kids {
    void listKids(Connection con) throws SQLException {
        //Kardesi olmayan ogrencileri bulur.

        String sql = " SELECT * FROM kid " +
                     " EXCEPT" +
                     " SELECT * FROM kid kid1, kid kid2, guardian g " +
                      "WHERE (kid1.primaryGuardianId = g.id OR kid1.secondaryGuardianId = g.id) AND " +
                    "kid1.id <> kid2.id AND (kid2.primaryGuardianId = g.id OR kid2.secondaryGuardianId = g.id)";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("firstName")  + "\t" + rs.getString("lastName"));
        }
    }
}
