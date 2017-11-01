package mysql;

import java.sql.*;

public class mysql
{
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String userName = "root";
    private static String userPwd = "123456";
    private static String dbName = "poem";
    public static Connection getConnection()
    {
        String  url1 = "jdbc:mysql://localhost/" + dbName;
        String  url2 = "?user=" + userName + "&password=" + userPwd;
        String  url3 = "&useUnicode=true&characterEncoding=utf-8";
        String  url = url1 + url2 + url3;
        try
        {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url);
            return con;
        }
        catch (Exception e)
        {
            e.printStackTrace(); 
        }
        return null;
    }
    public static void closeDB(Connection con, PreparedStatement pstm, ResultSet rs)
    {
        try
        {
            if(rs != null) rs.close();
            if(pstm != null) pstm.close();
            if(con != null) con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * 关闭连接
     *
     * @param dbConnection
     *            Connection
     */
    public static void closeConnection(Connection dbConnection)
    {
        try
        {
            if (dbConnection != null && (!dbConnection.isClosed()))
            {
                dbConnection.close();
            }
        }
        catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
        }

    }

    /**
     * 关闭结果集
     */
    public static void closeResultSet(ResultSet res)
    {
        try
        {
            if (res != null)
            {
                res.close();
                res = null;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 关闭Statement对象
     *
     * @param stm
     */
    public static void closeStatement(Statement stm)
    {
        try
        {
            if(stm != null)
                stm.close();
            stm = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * 关闭PreparedStatement对象
     *
     * @param ps
     */
    public static void closeStatement(PreparedStatement ps)
    {
        try
        {
            if(ps != null)
                ps.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
