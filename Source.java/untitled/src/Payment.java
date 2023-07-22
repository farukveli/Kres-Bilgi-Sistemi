import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Payment {
    private int paymentId;
    private int studentId;
    private float amount;
    private Date payDate;

    private int installmentNo;
    public Payment(int paymentId, int studentId, int amount, Date date) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.amount = amount;
        this.payDate = date;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public float getAmount() {
        return amount;
    }

    public Date getDate() {
        return payDate;
    }

    public int getInstallmentNo() {
        return installmentNo;
    }

    public static ResultSet getPaymentStatus(Connection con) throws SQLException {
        String sql = "SELECT paymentStatement";
        Statement stmt = con.createStatement();
        return stmt.executeQuery(sql);
    }



}
