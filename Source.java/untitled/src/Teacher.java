import java.sql.*;


public class Teacher {
    private int teacherId;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public Teacher(int teacherId, String firstName, String lastName, String address, String phone) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public static boolean registerTeacher(Connection con, String firstName, String lastName, String address, String phone) {
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO teacher (teacherId, firstName, lastName, address, phone)" +
                    " VALUES (nextval(teacher_id_seq), ?, ?, ?, ?)");
            ((PreparedStatement) statement).setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, address);
            statement.setString(4, phone);
            statement.execute();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }





}
