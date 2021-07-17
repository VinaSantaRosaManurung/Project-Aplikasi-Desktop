package a_entitas;

import javafx.beans.property.SimpleStringProperty;

public class MuridBaru {
    SimpleStringProperty waktu = new SimpleStringProperty();
    SimpleStringProperty nama = new SimpleStringProperty();
    SimpleStringProperty gender = new SimpleStringProperty();
    SimpleStringProperty agama = new SimpleStringProperty();
    SimpleStringProperty asal_sekolah = new SimpleStringProperty();
    SimpleStringProperty alamat = new SimpleStringProperty();
    SimpleStringProperty hp = new SimpleStringProperty();
    SimpleStringProperty informasi = new SimpleStringProperty();
    
    public MuridBaru(){
    }
    public MuridBaru(String waktu, String nama, String gender, String agama, 
                     String asal_sekolah, String alamat, String hp, String informasi){
        
        this.waktu = new SimpleStringProperty(waktu);
        this.nama = new SimpleStringProperty(nama);
        this.gender = new SimpleStringProperty(gender);
        this.agama = new SimpleStringProperty(agama);
        this.asal_sekolah = new SimpleStringProperty(asal_sekolah);
        this.alamat = new SimpleStringProperty(alamat);
        this.hp = new SimpleStringProperty(hp);
        this.informasi = new SimpleStringProperty(informasi);
    }
    
    public MuridBaru(String nama, String gender, String agama, 
                     String asal_sekolah, String alamat, String hp, String informasi){
        this.nama = new SimpleStringProperty(nama);
        this.gender = new SimpleStringProperty(gender);
        this.agama = new SimpleStringProperty(agama);
        this.asal_sekolah = new SimpleStringProperty(asal_sekolah);
        this.alamat = new SimpleStringProperty(alamat);
        this.hp = new SimpleStringProperty(hp);
        this.informasi = new SimpleStringProperty(informasi);
    }
    
    public void setAgama(String agama){
        this.agama.set(agama);
    }
    public void setAlamat(String alamat){
        this.alamat.set(alamat);
    }
    public void setAsal_sekolah(String asal_sekolah){
        this.asal_sekolah.set(asal_sekolah);
    }
    public void setGender(String gender){
        this.gender.set(gender);
    }
    public void setHp(String hp){
        this.hp.set(hp);
    }
    public void setInformasi(String informasi){
        this.informasi.set(informasi);
    }
    public void setNama(String nama){
        this.nama.set(nama);
    }
    public void setWaktu(String waktu){
        this.waktu.set(waktu);
    }
    
    public String getAgama(){
        return agama.get();
    }
    public String getAlamat(){
        return alamat.get();
    }
    public String getAsal_sekolah(){
        return asal_sekolah.get();
    }
    public String getGender(){
        return gender.get();
    }
    public String getHp(){
        return hp.get();
    }
    public String getInformasi(){
        return informasi.get();
    }
    public String getNama(){
        return nama.get();
    }
    public String getWaktu(){
        return waktu.get();
    }
}