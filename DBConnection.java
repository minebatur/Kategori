import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.Statement;
        import java.util.ArrayList;
        import java.util.List;


public class DBConnection {
    private Statement st; //beyan // SQL ifadelerini veritabanına göndermek için bu interface’ten oluşturulan nesneleri kullanırsınız.
    private Connection con; //bağlantı //Connection: Bu interface, bütün metotları ile veritabanına irtibat kurmak için kullanılır.
    private ResultSet rs; //sonuçkümesi
    //Statements nesnelerini kullanarak SQL sorgusunu çalıştırdıktan sonra veritabanından alınan verileri
    // tutmak için bu nesneler kullanılır. Onu taşımanıza izin veren bir yineleyici görevi görür.

    List<Category> getList() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String driver = "com.mysql.jdbc.Driver";
        String hostName = "jdbc:mysql://localhost:3306/";
        String dbName = "kategori";
        String userName = "root";
        String password = "root";
        List<Category> categories = new ArrayList<>();

        try {
            Class.forName(driver);
            //bağlantı açma:Veritabanı ile fiziksel bağlantı sağlayan ve Connection nesnesini oluşturan
            // DriverManager.getConnection() metodu gerekmektedir.
            System.out.println("bağlantı gerçekleşiyor...");
            con = DriverManager.getConnection(hostName + dbName, userName, password);
//            DriverManager: Bu sınıf, veritabanı sürücülerinin listesini yönetir.
//           Sorgu çalıştırma. Veritabanına SQL ifadesi göndermek inin, Statement türünde bir nesne gerekmektedir.
            //con nesnesini kullanarak, kullanıcı adresi ve şifre doğrultusunda URL girilerek veritabanına bağlanma işlemi başlatılır.
            st = con.createStatement();
            //st nesnesi ile bağlantı oluşturulur.
            System.out.println("bağlantı kuruldu...");
            rs = st.executeQuery("SELECT * FROM kategori");

            while (rs.next()) {
                int id = rs.getInt("id");
                int parentİd = rs.getInt("parentİd");
                String name = rs.getString("name");

                Category category = new Category(id, parentİd, name);
                categories.add(category);
            }
            con.close();
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("hata:" + e);
        }
        return categories;
    }
}