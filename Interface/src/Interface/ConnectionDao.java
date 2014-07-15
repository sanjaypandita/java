package Interface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ConnectionDao
{
    public Statement statement=null;
    public Connection dbConnection=null;
    public String selectTableSql;
    public List<connection> getAllconnections() throws SQLException{
        List<connection>mylist=new ArrayList();
        try 
        {
            MyConnection_1 mc=new MyConnection_1();
            dbConnection = mc.getConnection();
            statement = dbConnection.createStatement();
            String selectTableSQL="SELECT * FROM userlogin.user";
            ResultSet rs=statement.executeQuery(selectTableSql);
            
            
            while(rs.next()){
                        Integer sId=rs.getInt("id");
                        String sName=rs.getString("username");
                        String sPassword=rs.getString("passwd");
                        String sEmail=rs.getString("email");
                        
            connection e=new connection(sId,sName,sPassword,sEmail);
            System.out.println("Student Id:"+sId);
            System.out.println("Student Name:"+sName);
            System.out.println("Student Password:"+sPassword);
            System.out.println("Student Email:"+sEmail);
            
            mylist.add(e);
            }
        }
            catch(SQLException ex)
                    {
                    System.out.println(ex.getMessage());
                    
                    }
        finally
            {
                    if(statement !=null){
                    statement.close();
                    }
                    
                    if(dbConnection !=null)
                    {
                    dbConnection.close();
                    }
                    }
            return mylist();
        }
        public void insertEmployee(Integer Id,String Name,String Password,String Email) throws SQLException{
            String insertTableSQL="INSERT INTO userlogin.user" 
                    + "(Id,Name,Password,Email)"+"VALUES" +"("+ Id +",'"+ Name +"','"+ Password +"','"+ Email+"')";
            
            try{
                MyConnection_1 mc=new MyConnection_1();
                dbConnection=mc.getConnection();
                statement=dbConnection.createStatement();
                statement.executeUpdate(insertTableSQL);
                System.out.println("Record is inserted");
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
                
                
            }
            finally{
                if (statement !=null)
                {
                    statement.close();
                }
                if (dbConnection !=null) {dbConnection.close();
                }
                
            
            }
            }

    private List<connection> mylist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        }
                
    
