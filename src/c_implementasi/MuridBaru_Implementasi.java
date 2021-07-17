package c_implementasi;

import a_entitas.MuridBaru;
import b_interface.MuridBaru_Interface;
import config.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MuridBaru_Implementasi implements MuridBaru_Interface{

    @Override
    public MuridBaru insert(MuridBaru mrd) throws Exception {
        PreparedStatement prepare = Koneksi.ambilKoneksi().prepareStatement("insert into t_calon_murid_baru values (?,?,?,?,?,?,?,?)");
        prepare.setString(1, mrd.getWaktu());
        prepare.setString(2, mrd.getNama());
        prepare.setString(3, mrd.getGender());
        prepare.setString(4, mrd.getAgama());
        prepare.setString(5, mrd.getAsal_sekolah());
        prepare.setString(6, mrd.getAlamat());
        prepare.setString(7, mrd.getHp());
        prepare.setString(8, mrd.getInformasi());
        
        prepare.executeUpdate();
        
        return mrd;
    }

    @Override
    public void update(MuridBaru mrd) throws Exception {
        PreparedStatement prepare = Koneksi.ambilKoneksi().prepareStatement("update t_calon_murid_baru set nama=?, gender=?, agama=?, asal_sekolah=?, alamat=?, hp=?, informasi=? where waktu=?");
        prepare.setString(1, mrd.getNama());
        prepare.setString(2, mrd.getGender());
        prepare.setString(3, mrd.getAgama());
        prepare.setString(4, mrd.getAsal_sekolah());
        prepare.setString(5, mrd.getAlamat());
        prepare.setString(6, mrd.getHp());
        prepare.setString(7, mrd.getInformasi());
        prepare.setString(8, mrd.getWaktu());
        
        prepare.executeUpdate();

    }

    @Override
    public void delete(String waktu) throws Exception {
        PreparedStatement prepare = Koneksi.ambilKoneksi().prepareStatement("delete from t_calon_murid_baru where waktu=?");
        prepare.setString(1, waktu);
        
        prepare.executeUpdate();
    }

    @Override
    public ObservableList<MuridBaru> getAll() throws Exception {
        Statement statement = Koneksi.ambilKoneksi().createStatement();
        ResultSet hasil = statement.executeQuery("SELECT * from t_calon_murid_baru");
        ObservableList data = FXCollections.observableArrayList();
        
        while(hasil.next()){
            MuridBaru mrd = new MuridBaru();
            mrd.setWaktu(hasil.getString(1));
            mrd.setNama(hasil.getString(2));
            mrd.setGender(hasil.getString(3));
            mrd.setAgama(hasil.getString(4));
            mrd.setAsal_sekolah(hasil.getString(5));
            mrd.setAlamat(hasil.getString(6));
            mrd.setHp(hasil.getString(7));
            mrd.setInformasi(hasil.getString(8));
            
            data.add(mrd);
        }
        return data;
    }
}