package inventory;


import java.sql.*;

/**
 * Created by 15Cyndaquil on 6/29/2017.
 */
public class ATester {
    public static void main(String[] args){

        String userName = "sa";
        String password = "";

        String url = "jdbc:hsqldb:mem:Product";

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection conn = DriverManager.getConnection(url, userName, password);

            Statement st = conn.createStatement();
            PreparedStatement ps;
            st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS PRODUCT_SELL (\n" +
                    "    UPC char(12),\n" +
                    "    MODEL char(7),\n" +
                    "    ITEM char(7),\n" +
                    "    NAME char(20),\n" +
                    "    CATEGORY char(20),\n" +
                    "    PRICE_REG double,\n" +
                    "    PRICE_CUR double,\n" +
                    "    COST double\n" +
                    ")");
            ps = conn.prepareStatement("INSERT INTO PRODUCT_SELL (UPC, MODEL, ITEM, NAME, CATEGORY, PRICE_REG, PRICE_CUR, COST) VALUES " +
                    "(0, 1,2, 3,4,5,6,7)");
            ps.execute();
            ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT_SELL");
            rs.next();
            for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
                System.out.println(rs.getMetaData().getColumnLabel(i)+": "+rs.getString(i));
            }

            st.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
