package application;

import db.DB;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement st = null;

        try {
            connection = DB.getConnection();
            st = connection.prepareStatement(
                    "UPDATE seller SET BaseSalary = BaseSalary + ?" +
                            "WHERE (DepartmentId = ?)");
            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
