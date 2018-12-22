import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.text.html.HTML.Tag.SELECT;
import static jdk.nashorn.internal.objects.NativeRegExp.test;

public class DataBase {

    private static String FROM;
    /**
     * Connect to a sample database
     */
    public static void connect() throws SQLException {
        Connection conn = null;
        Statement st=null;
        ResultSet rs=null;
        PreparedStatement pst=null;
        try {
            // db parameters
            String url = "jdbc:sqlite:D:\\1-FCI\\YEAR THREE\\Software Engineering -1\\SWE\\TheFinderDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            st=conn.createStatement();
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } }

    public void save_Post(Integer postID,String userID,String UserKind,String Category,String Image, String Content,String VQ1,String VQ2,String VQ3,String VQ4) throws SQLException{
        Connection conn = null;
        Statement st=null;
        ResultSet rs=null;
        PreparedStatement pst=null;
        try {
            // db parameters
            String url = "jdbc:sqlite:D:\\1-FCI\\YEAR THREE\\Software Engineering -1\\SWE\\TheFinderDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            st=conn.createStatement();
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String sql = "INSERT INTO Post(postID,userID,UserKind,Category,Image,Content,VQ1,VQ2,VQ3,VQ4) VALUES(?,?,?,?,?,?,?,?,?,?)";

        // try (conn = this.connect());
        PreparedStatement pstmt = conn.prepareStatement(sql); //{
        pstmt.setInt(1, postID);
        pstmt.setString(2, userID);
        pstmt.setString(3, UserKind);
        pstmt.setString(4, Category);
        pstmt.setString(5, Image);
        pstmt.setString(6, Content);
        pstmt.setString(7, VQ1);
        pstmt.setString(8, VQ2);
        pstmt.setString(9, VQ3);
        pstmt.setString(10, VQ4);

        pstmt.executeUpdate();

    }




    public void EditPost(Integer postID,String userID,String UserKind,String Category,String Image, String Content,String VQ1,String VQ2,String VQ3,String VQ4) throws SQLException {


        Connection conn = null;
        Statement st=null;
        ResultSet rs=null;
        PreparedStatement pst=null;
        try {
            // db parameters
            String url = "jdbc:sqlite:D:\\1-FCI\\YEAR THREE\\Software Engineering -1\\SWE\\TheFinderDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            st=conn.createStatement();
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        String sql = "UPDATE Post SET UserKind = ? , " + "Category = ? ,"+ "Image = ? ," + "Content = ? ,"
                + "VQ1 = ? ,"+ "VQ2 = ? ,"+ "VQ3 = ? ,"+ "VQ4 = ? "
                + "WHERE postID = ?"+ "AND userID = ?";

        // try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql); //{

        // set the corresponding param
        pstmt.setString(1, UserKind);
        pstmt.setString(2, Category);
        pstmt.setString(3, Image);
        pstmt.setString(4, Content);
        pstmt.setString(5, VQ1);
        pstmt.setString(6, VQ2);
        pstmt.setString(7, VQ3);
        pstmt.setString(8, VQ4);
        pstmt.setInt(9, postID);
        pstmt.setString(10, userID);
        // update
        pstmt.executeUpdate();
    }


    public void DeletePost(Integer postID,String userID ) throws SQLException {

        Connection conn = null;
        Statement st=null;
        ResultSet rs=null;
        PreparedStatement pst=null;
        try {
            // db parameters
            String url = "jdbc:sqlite:D:\\1-FCI\\YEAR THREE\\Software Engineering -1\\SWE\\TheFinderDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            st=conn.createStatement();
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql = "DELETE FROM Post WHERE postID = ?"+ "AND userID = ?";

        //  try (Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql); //{

        // set the corresponding param
        pstmt.setInt(1, postID);
        pstmt.setString(2, userID);
        // execute the delete statement
        pstmt.executeUpdate();


    }

    public void SearchPost(String Category) throws SQLException {

        Connection conn = null;
        Statement st=null;

        PreparedStatement pst=null;
        try {
            // db parameters
            String url = "jdbc:sqlite:D:\\1-FCI\\YEAR THREE\\Software Engineering -1\\SWE\\TheFinderDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            st=conn.createStatement();
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql = "SELECT postID, userID, UserKind, Image, Content, VQ1, VQ2, VQ3, VQ4 "
                +"FROM Post WHERE Category == ?";


        PreparedStatement pstmt  = conn.prepareStatement(sql);

        // set the value
        pstmt.setString(1,Category);
        //
        ResultSet rs  = pstmt.executeQuery();




        // loop through the result set
        while (rs.next()) {
            System.out.println(rs.getInt("postID") +  "\t" +
                    rs.getString("userID") + "\t" +
                    rs.getString("UserKind") + "\t" + rs.getString("Image") + "\t"
                    +rs.getString("Content") + "\t" +
                    rs.getString("VQ1") + "\t" +rs.getString("VQ2") + "\t" +
                    rs.getString("VQ3") + "\t" +rs.getString("VQ4") + "\t");
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Integer postID = 401;
        String userID="ID1";
        String UserKind="Male";
        String Category="Gold";
        String Image="ImageD";
        String Content="Lost";
        String VQ1="Q1";
        String VQ2="Q2";
        String VQ3="Q3";
        String VQ4="Q4";

        DataBase p=new DataBase();
        //p.save_Post(postID, userID, UserKind, Category, Image, Content, VQ1, VQ2, VQ3, VQ4);
        p.SearchPost(Category);


    }

}



