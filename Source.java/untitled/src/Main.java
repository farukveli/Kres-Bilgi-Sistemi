import java.sql.*;
import java.util.Date;

public class Main {


    public static void main(String[] args) {

        Connect con = new Connect();
        try {
            con.connection("KresBilgiSistemi", "postgres", "1234");
        }
        catch (Exception e) {
            System.out.println("zort");
        }

        try {
            /*java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            Kid k = Kid.newKid(con.getConnection(), 12, "dsad", "dsa",  sqlDate, true, false, "m", "half", 3, 23 ,12, 12, 12,"sda");
)            Classroom.getClassList("dsa", con.getConnection());*/

            AnaMenu anamenu = new AnaMenu(con.getConnection());
            //new EditKid(con.getConnection());
        }
        catch (Exception e) {
            System.out.println(e);
        }


        //System.out.println("zort");
    }
}