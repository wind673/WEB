package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class function
{

    private Connection conn;//用于保存数据库连接对象

    private Statement stm;//用于执行SQL语句

    private PreparedStatement ps;//用于执行SQL语句（预处理）

    private ResultSet rs;//用于保存查询的结果集

    private int id;
    private int history_id;
    private int collect_id;
    
    public user getUser(String userName, String password)
    {
        user user = new user();
        String sql = "select * from user where user='" + userName + "'";
        try
        {
            conn = mysql.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next())
            {
                user.email = rs.getString("email"); 
                user.id = Integer.parseInt(rs.getString("id"));
                user.name = rs.getString("name");
                user.password = rs.getString("password");
                user.school = rs.getString("school");
                user.sex = rs.getString("sex");
                user.user = rs.getString("user"); 
            } 
            if(!user.password.equals(password)) user = null; 
            return user;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            mysql.closeResultSet(rs);
            mysql.closeStatement(stm);
            mysql.closeConnection(conn);
        } 
        return null;
    }

    public String getHistory(int user_id)
    {
    	String history = " "; 		
        try
        {
            conn = mysql.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from history where user_id='" + user_id + "'");
           
            while (rs.next())
            {
            	history += rs.getString("history"); 
            }  
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            mysql.closeResultSet(rs);
            mysql.closeStatement(stm);
            mysql.closeConnection(conn);
        }
    	
    	return history;
    }
    
    
    public String getCollect(int user_id)
    { 	
    	String collect = " "; 		
        try
        {
            conn = mysql.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from collect where user_id='" + user_id + "'");
           
            while (rs.next())
            {
            	collect += rs.getString("collect"); 
            }  
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            mysql.closeResultSet(rs);
            mysql.closeStatement(stm);
            mysql.closeConnection(conn);
        }
    	
    	return collect;
    	 
    }
    
    public void deleteHistory(int user_id,int history_id)
    { 	
    	if(history_id > 0)//单条删除
    	{
	        try
	        {
	            conn = mysql.getConnection();
	            ps = conn.prepareStatement("delete from history where id = ?"); 
	            ps.setInt(1,history_id);
	            ps.executeUpdate();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            mysql.closeStatement(ps);
	            mysql.closeConnection(conn);
	        }
    	}
    	else //删除全部
    	{ 
            try
            {
	            conn = mysql.getConnection();
	            ps = conn.prepareStatement("delete from history where user_id = ?"); 
	            ps.setInt(1,user_id);
	            ps.executeUpdate();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                mysql.closeStatement(ps);
                mysql.closeConnection(conn);
            }
    	}
    	 
    }
    
    public void deleteCollect(int user_id,int collect_id)
    { 	
    	if(collect_id > 0)//单条删除
    	{
	        try
	        {
	            conn = mysql.getConnection();
	            ps = conn.prepareStatement("delete from collect where id = ?"); 
	            ps.setInt(1,collect_id);
	            ps.executeUpdate();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            mysql.closeStatement(ps);
	            mysql.closeConnection(conn);
	        }
    	}
    	else //删除全部
    	{ 
            try
            {
	            conn = mysql.getConnection();
	            ps = conn.prepareStatement("delete from collect where user_id = ?"); 
	            ps.setInt(1,user_id);
	            ps.executeUpdate();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                mysql.closeStatement(ps);
                mysql.closeConnection(conn);
            }
    	}
    	 
    }
    
    
    public int registerUser(user user)
    { 
        int error = 0;
        error = 0;
        try
        {
            conn = mysql.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from user");
            while (rs.next())
            {
                id = rs.getInt("id");
                if(user.user.equals(rs.getString("user")))
                {
                    error = 1;//该用户名已经存在
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            error = 2;
        }
        finally
        {
            mysql.closeResultSet(rs);
            mysql.closeStatement(stm);
            mysql.closeConnection(conn);
        }
         
        
        if(error == 0)
        {
            try
            {
                conn = mysql.getConnection(); 
                ps = conn.prepareStatement("insert into user(id,user,password,name,sex,school,email) values(?,?,?,?,?,?,?)");
                id ++;
                ps.setInt(1, id);
                ps.setString(2, user.user);
                ps.setString(3, user.password);
                ps.setString(4, user.name);
                ps.setString(5, user.sex); 
                ps.setString(6, user.school);
                ps.setString(7, user.email);
                ps.executeUpdate();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                error = 3;
            }
            finally
            {
                mysql.closeStatement(ps);
                mysql.closeConnection(conn);
            }
        }
        return error;

    }


    public int setUser(user user)
    {
        String sql = "update user set password=?,name=?,sex=?,school=?,email=? where id=?";
        int count = 0;

        try
        {
            conn = mysql.getConnection();
            ps = conn.prepareStatement(sql);
             
            ps.setString(1, user.password);
            ps.setString(2, user.name);
            ps.setString(3, user.sex);
            ps.setString(4, user.school);
            ps.setString(5, user.email);
            
            ps.setInt(6, user.id);
            
            count = ps.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            count = -1;
        }
        finally
        {
            mysql.closeStatement(ps);
            mysql.closeConnection(conn);
        } 
        return count;
    }
    
    public void setHistory(int user_id,String history)
    {
        history_id = 0;
        try
        {
            conn = mysql.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from history");
            while (rs.next())
            {
                history_id = rs.getInt("id");  
            }
        }
        catch (Exception e)
        {
            e.printStackTrace(); 
        }
        finally
        {
            mysql.closeResultSet(rs);
            mysql.closeStatement(stm);
            mysql.closeConnection(conn);
        }
         
      try
      {   
    	 
          conn = mysql.getConnection();
          ps = conn.prepareStatement("insert into history(id,user_id,history) values(?,?,?) ");
          
          
          history_id ++;
          ps.setInt(1, history_id);
          
          ps.setInt(2, user_id);  
          
          history += "<a href='user_history_delete?history_id="+history_id+"'>"+"删除该记录" + "</a></p>" + "<br>";
          ps.setString(3, history);  
           
          ps.executeUpdate();
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
      finally
      {
          mysql.closeStatement(ps);
          mysql.closeConnection(conn);
      }  
    }
    
    
    public int setCollect(int user_id,int poem_id,String collect)
    {
        collect_id = 0;
        int error = 0;
        try
        {
            conn = mysql.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from collect");
            while (rs.next())
            {
            	collect_id = rs.getInt("id");  
            	if(user_id == rs.getInt("user_id"))
            		if(poem_id == rs.getInt("poem_id")) error = -1;
            			
            }
        }
        catch (Exception e)
        {
            e.printStackTrace(); 
            error = -2;
        }
        finally
        {
            mysql.closeResultSet(rs);
            mysql.closeStatement(stm);
            mysql.closeConnection(conn);
        }
     
      if(error == 0)
      try
      {   
    	 
          conn = mysql.getConnection();
          ps = conn.prepareStatement("insert into collect(id,user_id,poem_id,collect) values(?,?,?,?) ");
           
          collect_id ++;
          ps.setInt(1, collect_id);
          
          ps.setInt(2, user_id);  
          
          ps.setInt(3, poem_id);  
          
          collect += "<a href='user_collect_delete?collect_id="+collect_id+"'>"+"取消该收藏" + "</a></p>" + "<br>";
          ps.setString(4, collect);  
           
          ps.executeUpdate();
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
      finally
      {
          mysql.closeStatement(ps);
          mysql.closeConnection(conn);
      } 
      return error;
    }
    
    
    
    
    
    public int findPoem(String str_find, poem poem[])
    {
        String sql = "select * from poem";
        int cnt = 0;
        poem temp = new poem();

        try
        {
            conn = mysql.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next())
            {
                temp.id = rs.getInt("id");
                temp.author = rs.getString("author");
                temp.name = rs.getString("name");
                temp.era = rs.getString("era");
                temp.text = rs.getString("text");
                temp.comment = rs.getString("comment");
                temp.explain = rs.getString("explain");

                //实例化，防止运行出错
                if(temp.author == null) temp.author = "";
                if(temp.name == null) temp.name = "";
                if(temp.era == null) temp.era = "";
                if(temp.text == null) temp.text = "";
                if(temp.comment == null) temp.comment = "";
                if(temp.explain == null) temp.explain = ""; 
                
                //搜索关键字
                if(temp.author.indexOf(str_find) >= 0
                        || temp.name.indexOf(str_find) >= 0
                        || temp.era.indexOf(str_find) >= 0
                        || temp.text.indexOf(str_find) >= 0
                        || temp.explain.indexOf(str_find) >= 0
                  )
                {
                    poem[cnt].id = temp.id;
                    poem[cnt].author = temp.author;
                    poem[cnt].name = temp.name;
                    poem[cnt].era = temp.era;
                    poem[cnt].text = temp.text;
                    poem[cnt].comment = temp.comment;
                    poem[cnt].explain = temp.explain;
                    cnt ++;
                }

            }
            return cnt;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            cnt = -1;
        }
        finally
        {
            mysql.closeResultSet(rs);
            mysql.closeStatement(stm);
            mysql.closeConnection(conn);
        }
        return cnt;
    }

    public poem showPoem(int id)
    {
        String sql = "select * from poem";   
        poem temp = new poem();

        try
        {
            conn = mysql.getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next())
            { 
	            temp.id = rs.getInt("id");
	            if(temp.id == id)
	            { 
		            temp.author = rs.getString("author");
		            temp.name = rs.getString("name");
		            temp.era = rs.getString("era");
		            temp.text = rs.getString("text");
		            temp.comment = rs.getString("comment");
		            temp.explain = rs.getString("explain");
		
		            //实例化，防止运行出错
		            if(temp.author == null) temp.author = " ";
		            if(temp.name == null) temp.name = " ";
		            if(temp.era == null) temp.era = " ";
		            if(temp.text == null) temp.text = " ";
		            if(temp.comment == null) temp.comment = " ";
		            if(temp.explain == null) temp.explain = " ";
	            }
            }
            temp.id = id;
            return temp;
        }
        catch (Exception e)
        {
            e.printStackTrace(); 
        }
        finally
        {
            mysql.closeResultSet(rs);
            mysql.closeStatement(stm);
            mysql.closeConnection(conn); 
        }
        return null;
    }









}

