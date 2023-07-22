import java.sql.*;
import java.util.Date;

public class Kid {
    private int kidId;
    private String firstName;
    private String lastName;
    private java.sql.Date birthDate;
    private boolean breakfast;
    private boolean lunch;
    private String gender;
    private String regType;
    private int nonAttendances;
    private int pGuardId;
    private int sGuardId;
    private int installment;

    private int amount;
    private String classroom;
    public static Connection conn;

    public Kid(int kidId, String firstName, String lastName, java.sql.Date birthDate, boolean breakfast, boolean lunch, String gender, String regType, int nonAttendances, int pGuardId, int sGuardId, int installment, int amount, String classroom) {
        this.kidId = kidId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.gender = gender;
        this.regType = regType;
        this.nonAttendances = nonAttendances;
        this.pGuardId = pGuardId;
        this.sGuardId = sGuardId;
        this.installment = installment;
        this.amount = amount;
        this.classroom = classroom;
    }

    //create a new kid
    public static Kid newKid(Connection conn, int id, String firstName, String lastName, java.sql.Date birthDate, boolean breakfast, boolean lunch,
                             String gender, String regType, int nonAttendances, int pGuardId, int sGuardId, int installment, int amount, String classroom) throws SQLException {
        //Date exception!!!!
        Kid ret = new Kid(id, firstName, lastName, birthDate, breakfast, lunch, gender, regType, nonAttendances, pGuardId, sGuardId, installment, amount, classroom);
        CallableStatement stmt = conn.prepareCall("INSERT INTO kid VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        stmt.setInt(1, id);
        stmt.setString(2, firstName);
        stmt.setString(3, lastName);
        stmt.setDate(4, birthDate);
        stmt.setBoolean(5, breakfast);
        stmt.setBoolean(6, lunch);
        stmt.setString(7,gender);
        stmt.setString(8,regType);
        stmt.setInt(9, nonAttendances);
        stmt.setInt(10, installment);
        stmt.setString(11, classroom);
        stmt.setFloat(12, amount);
        stmt.setInt(13, pGuardId);
        stmt.setInt(14, sGuardId);
        stmt.executeUpdate();
        return ret;
        }



    public int getId() {
        return kidId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public boolean isLunch() {
        return lunch;
    }

    public String getGender() {
        return gender;
    }

    public String getRegType() {
        return regType;
    }

    public int getNonAttendances() {
        return nonAttendances;
    }

    public void incrementNonAttendance(Connection con, int id) throws Exception {
        // attendanceTrigger ayni ogrenciye ayni gun iki defa devamsizlik eklenmesini engeller.
        CallableStatement stmt = con.prepareCall("INSERT INTO nonAttendance VALUES(?,?)");
        stmt.setInt(1, id);
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        stmt.setDate(2, sqlDate);
        stmt.execute();
    }

    public void pay(Connection con, int id) throws Exception {
        CallableStatement stmt = con.prepareCall("{ call pay(?,?) }");
        stmt.setInt(1, id);
        stmt.setDate(2, (java.sql.Date) new Date());
        stmt.execute();
    }

    public void setClassroom(Connection con, int id, String classroom) throws Exception {
        PreparedStatement stmt=con.prepareStatement("update kid where id = ? set class = ?");
        stmt.setInt(1, id);
        stmt.setString(2, classroom);
        stmt.execute();
    }

    public static ResultSet breakfastAndLunch(Connection con) throws Exception {
        CallableStatement stmt = con.prepareCall("SELECT * FROM kid WHERE breakfast = true INTERSECT SELECT * FROM kid WHERE lunch = true");
        return stmt.executeQuery();
    }

    public static ResultSet breakfastOnly(Connection con) throws Exception {
        CallableStatement stmt = con.prepareCall("SELECT * FROM kid WHERE breakfast = true ");
        return stmt.executeQuery();
    }

    public static  ResultSet lunchOnly(Connection con) throws Exception {
        CallableStatement stmt = con.prepareCall("SELECT * FROM kid WHERE lunch = true");
        return stmt.executeQuery();
    }

    public static ResultSet noMeal (Connection con) throws Exception {
        CallableStatement stmt = con.prepareCall("SELECT * FROM kid WHERE breakfast = false INTERSECT SELECT * FROM kid WHERE lunch = false");
        return stmt.executeQuery();
    }

    public static ResultSet getAllKids(Connection con) throws Exception {
        CallableStatement stmt = con.prepareCall("SELECT kidid, firstName, lastName FROM kid ORDER BY kidid");
        return stmt.executeQuery();
    }
    public static boolean registerKid (Connection con, String firstName, String lastName, java.sql.Date birthDate,
                                       boolean breakfast, boolean lunch, String gender, String regType, String address, String phone, String depType) {
        try {
            PreparedStatement statement =con.prepareStatement("INSERT INTO kid " +
                    " (kidId, fistName, lastName, birthDate, breakfast, lunch, gender, regType, nonAttendances)" +
                    " VALUES (nextval(student_id_seq), ?, ?, ?, ?, ?, ?, ?, 0)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setDate(3, birthDate);
            statement.setBoolean(4, breakfast);
            statement.setBoolean(5, lunch);
            statement.setString(6, gender);
            statement.setString(7, regType);
            statement.execute();

            statement = con.prepareStatement("INSERT INTO guardian (kidId, firstName, lastName, address, phone, depType)" +
                                                " VALUES (nextval(student_id_seq), ?, ?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, address);
            statement.setString(4, phone);
            statement.setString(5, depType);
            statement.execute();

            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public  static ResultSet getKidInfo(Connection conn, int kidId) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM kid WHERE kidId = ?");
        stmt.setInt(1, kidId);
        return stmt.executeQuery();
    }

    public  static ResultSet getKidPayment(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM paymentstatement");
        return stmt.executeQuery();
    }

    public static boolean registerGuardian (Connection con, String firstName, String lastName, String address, String phone, String depType) {
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO guardian (kidId, firstName, lastName, address, phone, depType)" +
                    " VALUES (nextval(student_id_seq), ?, ?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, address);
            statement.setString(4, phone);
            statement.setString(5, depType);
            statement.execute();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean editKid(Connection con, String firstName, String lastName, java.sql.Date birthDate,
                                  boolean breakfast, boolean lunch, String gender, String regType) {
        try {
        PreparedStatement statement = con.prepareStatement("UPDATE kid SET firstName = ?, lastName = ?, birthDate = ?, breakfast = ?, lunch = ?, gender = ? WHERE kidId = ?");
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setDate(3, birthDate);
        statement.setBoolean(4, breakfast);
        statement.setBoolean(5, lunch);
        statement.setString(6, gender);
        statement.execute();
        return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
         }
        }



    public static boolean deleteStudent(Connection con, int id) {
        try {
            PreparedStatement statement = con.prepareStatement("DELETE FROM kid WHERE kidId = ?");
            statement.setInt(1, id);
            statement.execute();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static int getNonattendance (Connection con, int kidId) throws SQLException {

        PreparedStatement stmt = con.prepareStatement("SELECT nonAttendances FROM kid WHERE kidId = ?");
        stmt.setInt(1, kidId);

        return 0;
    }


    public static ResultSet getNonattendanceOver (Connection con, int limit)  {

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT nonAttendances FROM kid GROUP BY kidId HAVING COUNT(*) > ?");
            stmt.setInt(1, limit);
            return stmt.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ResultSet getKidGuardian(Connection conn, int kidId) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM guardian WHERE kidId = ?");
        stmt.setInt(1, kidId);
        return stmt.executeQuery();
    }






}
