package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Mahasiswa;

public class MahasiswaDao {
    MysqlDataSource dataSource;
    Connection connection;
    
    public MahasiswaDao() throws SQLException{
        dataSource=new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setDatabaseName("MvcNative");
        
        connection=dataSource.getConnection();
    }
    
    public void tambahMahasiswa(Mahasiswa mahasiswa) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("INSERT INTO mahasiswa values(?,?,?,?,?)");
        ps.setString(1, mahasiswa.getNim());
        ps.setString(2, mahasiswa.getNama());
        ps.setInt(3, mahasiswa.getUmur());
        ps.setString(4, mahasiswa.getAsalSekolah());
        ps.setString(5, mahasiswa.getAlamat());
        ps.execute();
        connection.close();
    }
    
    public List<Mahasiswa> getAllMahasiswa() throws SQLException{
        List<Mahasiswa> mahasiswas=new ArrayList<Mahasiswa>();
        PreparedStatement ps=connection.prepareStatement("SELECT * FROM mahasiswa");
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            Mahasiswa mahasiswa=new Mahasiswa();
            mahasiswa.setNim(rs.getString("nim"));
            mahasiswa.setNama(rs.getString("nama"));
            mahasiswa.setUmur(rs.getInt("umur"));
            mahasiswa.setAsalSekolah(rs.getString("asal_sekolah"));
            mahasiswa.setAlamat(rs.getString("alamat"));
            mahasiswas.add(mahasiswa);
        }
        connection.close();
        return mahasiswas;
        
    }
    
    public Mahasiswa getMahasiswa(String nim) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("SELECT * FROM mahasiswa where nim=?");
        ps.setString(1, nim);
        ResultSet rs=ps.executeQuery();
        Mahasiswa mahasiswa=new Mahasiswa();
        while(rs.next()){
            mahasiswa.setNim(rs.getString("nim"));
            mahasiswa.setNama(rs.getString("nama"));
            mahasiswa.setUmur(rs.getInt("umur"));
            mahasiswa.setAsalSekolah(rs.getString("asal_sekolah"));
            mahasiswa.setAlamat(rs.getString("alamat"));
        }
            connection.close();
            return mahasiswa;
    }
    
    public void updateMahasiswa(Mahasiswa mahasiswa) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("UPDATE mahasiswa set nama=?,umur=?,asal_sekolah=?,"
                + "alamat=? where nim=?");
        ps.setString(1, mahasiswa.getNama());
        ps.setInt(2, mahasiswa.getUmur());
        ps.setString(3, mahasiswa.getAsalSekolah());
        ps.setString(4, mahasiswa.getAlamat());
        ps.setString(1, mahasiswa.getNim());
        ps.executeUpdate();
        connection.close();
    }
    
    public void hapusMahasiswa(String nim) throws SQLException{
        PreparedStatement ps=connection.prepareStatement("DELETE FROM mahasiswa where nim=?");
        ps.setString(1, nim);
        ps.executeUpdate();
        connection.close();
    }
    
}
