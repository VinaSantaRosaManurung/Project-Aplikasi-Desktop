package tampilan_program;

import a_entitas.MuridBaru;
import b_interface.MuridBaru_Interface;
import c_implementasi.MuridBaru_Implementasi;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.swing.Action;

public class MainView extends BorderPane{
    Accordion mnAcording;
    TitledPane tpinput, tptentang1;
    BorderPane bptengah;
    
    //class untuk inputan
    DatePicker dpwaktu;
    TextField txfnama, txfhp;
    RadioButton [] rbgender;
    ChoiceBox choibagama;
    ComboBox cbasal;
    TextArea txaalamat;
    CheckBox [] cbinfo;
    ToggleGroup groupGender;
    //kontrol tombol
    Button btnSimpan, btnClear, btnUpdate, btnDelete;
    
    //kelas tampilan
    TableView<MuridBaru> tabel;
    
    
    MuridBaru_Interface akses;

    ObservableList<MuridBaru> dataMurid = FXCollections.observableArrayList();
    //Layout tambahan
    GridPane gp;
    TextField txfWaktuTmp;
    
    public MainView(){ 
        instatnceObjek();
        formMenuInputData();
        formMenuTentang();
        formBagianTengah();
        loadData();
        
        setLeft(mnAcording);
        setCenter(bptengah);
        aksiTombol();
    }
    
    void instatnceObjek(){
       akses = new MuridBaru_Implementasi();
       
       mnAcording = new Accordion();
       tpinput = new TitledPane();
       tptentang1 = new TitledPane();
       tpinput.setText("Form Input Data Murid Baru");
       tptentang1.setText("About Bimble");
       mnAcording.getPanes().addAll(tpinput, tptentang1);
       mnAcording.setExpandedPane(tpinput);
       mnAcording.setStyle("-fx-border-color: red");
       mnAcording.setStyle("-fx-background-color: #FA8072;");
       tpinput.setPrefHeight(400);
               
       bptengah = new BorderPane(); 
       
       //bagian instance objek inputan
        dpwaktu = new DatePicker();
        txfnama = new TextField();
        txfhp = new TextField();
        rbgender = new RadioButton[2];
        rbgender[0] = new RadioButton("L");
        rbgender[1] = new RadioButton("P");
         groupGender = new ToggleGroup();
        rbgender[0].setToggleGroup(groupGender);
        rbgender[1].setToggleGroup(groupGender);
               
        choibagama = new ChoiceBox(FXCollections.observableArrayList("Islam","Buddha","Protestan","Katholik","Konghucu"));
        cbasal = new ComboBox(FXCollections.observableArrayList("SMA", "SMK", "MA"));
        cbasal.setEditable(true);
        txaalamat = new TextArea();
        cbinfo = new CheckBox[4];
        cbinfo[0] = new CheckBox("TV");
        cbinfo[1] = new CheckBox("Koran");
        cbinfo[2] = new CheckBox("Brosur");
        cbinfo[3] = new CheckBox("Lainnya");
        //atur properties komponen inputan
        txaalamat.setPrefSize(20, 25);
        dpwaktu.setPrefWidth(220);
        choibagama.setPrefWidth(220);
        cbasal.setPrefWidth(220);
        txfnama.setPromptText("Nama Anda ....");
        txfhp.setPromptText("No HP Anda ....");
        dpwaktu.setPromptText("Waktu Pendaftaran Hari Ini....");
        cbasal.setPromptText("Asal Sekolah Anda ....");
                
        //kontrol tabel instance
        btnSimpan = new Button("Save");
        btnClear = new Button("Clear");
        btnUpdate = new Button("Update");
        btnDelete = new Button("Delete");
        btnUpdate.setDisable(true);
        //properties tombol
        btnSimpan.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/res_gambar/save.png"))));
        btnClear.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/res_gambar/clear.png"))));
        btnUpdate.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/res_gambar/update.png"))));
        btnDelete.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/res_gambar/delete.png"))));
                
        tabel = new TableView<>();
        
        //bagian layout khusus
        gp = new GridPane();
        txfWaktuTmp = new TextField();
        txfWaktuTmp.setEditable(false);
    }
    
    void formMenuInputData(){
        gp.setHgap(5);
        gp.setVgap(5);
        
        //layout tambahan
        HBox hb1_gender = new HBox(5);
        HBox hb2_info = new HBox(5);
        HBox hb3_kontrol = new HBox(5);
        hb1_gender.getChildren().addAll(rbgender[0], rbgender[1]);
        hb2_info.getChildren().addAll(cbinfo[0], cbinfo[1], cbinfo[2], cbinfo[3]);
        hb3_kontrol.getChildren().addAll(btnSimpan, btnClear, btnUpdate);
        
        gp.add(new Label("Waktu"), 0, 0);
        gp.add(new Label("Nama"), 0, 1);
        gp.add(new Label("Gender"), 0, 2);
        gp.add(new Label("Agama"), 0, 3);
        gp.add(new Label("Asal Sekolah"), 0, 4);
        gp.add(new Label("Alamat"), 0, 5);
        gp.add(new Label("No HP/TLP"), 0, 6);
        gp.add(new Label("Informasi"), 0, 7);
        
        gp.add(new Label(":"), 1, 0);
        gp.add(new Label(":"), 1, 1);
        gp.add(new Label(":"), 1, 2);
        gp.add(new Label(":"), 1, 3);
        gp.add(new Label(":"), 1, 4);
        gp.add(new Label(":"), 1, 5);
        gp.add(new Label(":"), 1, 6);
        gp.add(new Label(":"), 1, 7);
        
        gp.add(txfnama, 2, 1);
        gp.add(hb1_gender, 2, 2);
        gp.add(choibagama, 2, 3);
        gp.add(cbasal, 2, 4);
        gp.add(txaalamat, 2, 5);
        gp.add(txfhp, 2, 6);
        gp.add(hb2_info, 2, 7);
        gp.add(hb3_kontrol, 2, 8);
        gp.add(dpwaktu, 2, 0);
        
        tpinput.setContent(gp);
    }
    void formMenuTentang(){
        Text txText = new Text("Vina Bimble merupakan bimbel yang cukup besar di Indonesia.\n"+
                "Bimbel ini tersebar hampir diseluruh penjuru negeri termasuk di Pekanbaru\n"+
                "tercinta ini. Berikut akan di berikan informasi mengenai bimbel ini.\n\n"+
                "Informasi sekilas tentang Vina Bimble — Pekanbaru :\n"+
                "Vina Bimble adalah pusat bimbingan belajar bagi siswa sekolah.\n"+
                "Bimbel dengan revolusi pembelajaran. Optimasi otak kanan dan otak kiri,\n"+
                "Strategi untuk Sukses (SMS). Metode Cornell, Peta Pikiran dan Formula Raja.\n"+
                "Vina Bimble menjamin kelulusan UN dengan jaminan uang kembali 100%.\n\n"+
                "-------------------------FASILITAS------------------------------------------\n"+
                "* Kelas maksimal 8 siswa\n"+
                "* Guru muda, kompeten dan berpengalaman\n"+
                "* Modul update — Bank soal yang diperbarui\n"+
                "* Kurikulum yang terus berkembang\n"+
                "* Manajemen kelas yang proaktif\n"+
                "* Konsultasi pekerjaan rumah untuk persiapan ujian\n"+
                "* Jaminan akan lulus dan masuk PTN Favorite\n\n"+
                "-------------------------PILIHAN HARI BELAJAR----------------------------\n"+
                "* Senin Rabu jumat\n"+
                "* Selasa Kamis Sabtu\n\n"+
                "-------------------------PILIHAN WAKTU-----------------------------------\n"+
                "* 30–15.00 (Sesi 1)\n"+
                "* 15:00–16:30 (Sesi 2)\n"+
                "* 4: 30–18: 00 (Sesi 3)\n\n"+
                "Info WhatsApp 082288463676");

        tptentang1.setContent(txText);

    }
    void formBagianTengah(){
        //bagian top judul -> judul
        Text text = new Text("Selamat Datang di Vina Bimble");
        Text text2 = new Text("Jalan Sudirman No.14 Pekanbaru");
        Text text3 = new Text("Daftar Calon Murid Baru Vina Bimble");
        text.setFont(new Font("Arial Black", 30));
        text2.setFont(new Font("Arial Black", 15));
        text3.setFont(new Font("Arial", 25));
        VBox  vb = new VBox();
        vb.getChildren().addAll(text, text2, text3, new Separator(Orientation.HORIZONTAL));
        vb.setPadding(new Insets(25, 25, 25, 25));
        vb.setStyle("-fx-border-width: 5;");
        vb.setStyle("-fx-border-color: red;");
        vb.setStyle("-fx-background-color: #FA8072;");
        
        bptengah.setTop(vb);
        //bagian center/tengah -> tabel
        TableColumn tc1 = new TableColumn("Waktu");
        TableColumn tc2 = new TableColumn("Nama");
        TableColumn tc3 = new TableColumn("Gender");
        TableColumn tc4 = new TableColumn("Agama");
        TableColumn tc5 = new TableColumn("Asal Sekolah");
        TableColumn tc6 = new TableColumn("Alamat");
        TableColumn tc7 = new TableColumn("No HP/TLP");
        TableColumn tc8 = new TableColumn("Informasi");
        
        tc1.setCellValueFactory(new PropertyValueFactory("waktu"));
        tc2.setCellValueFactory(new PropertyValueFactory("nama"));
        tc3.setCellValueFactory(new PropertyValueFactory("gender"));
        tc4.setCellValueFactory(new PropertyValueFactory("agama"));
        tc5.setCellValueFactory(new PropertyValueFactory("asal_sekolah"));
        tc6.setCellValueFactory(new PropertyValueFactory("alamat"));
        tc7.setCellValueFactory(new PropertyValueFactory("hp"));
        tc8.setCellValueFactory(new PropertyValueFactory("informasi"));
        
        tabel.getColumns().addAll(tc1, tc2, tc3, tc4, tc5, tc6, tc7, tc8);
        
        bptengah.setCenter(tabel);
        
        //bagian buttom/bawah -> kontrol tombol
        HBox hbkontroltombol = new HBox(5);
        hbkontroltombol.getChildren().addAll(btnDelete);
        hbkontroltombol.setPadding(new Insets(5, 0, 5, 5));
        hbkontroltombol.setStyle("-fx-background-color: #FA8072;");
        hbkontroltombol.setStyle("-fx-border-color: red;");
        
        bptengah.setBottom(hbkontroltombol);
    }
    void aksiTombol(){
        btnSimpan.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                
                if(btnSimpan.getText()=="Cancle"){
                    clearDataKomponent();
                    gp.getChildren().remove(gp.getChildren().size()-1);
                    gp.add(dpwaktu, 2, 0);
                    btnSimpan.setText("Simpan"); 
                    btnUpdate.setDisable(true);
                }else{
                try {
                    String waktu;
                    String nama;
                    String gender;
                    String agama;
                    String asal_sekolah;
                    String alamat;
                    String hp;
                    String informasi;
                    
                    if(dpwaktu.getValue()==null){
                        System.err.println("Waktu Harus Diisi");
                    }else if(txfnama.getText().isEmpty()){
                        System.err.println("Nama Harus Diisi");
                    }else if(groupGender.getSelectedToggle()==null){
                        System.err.println("Gender Harus Dipilih");
                    }else if(choibagama.getValue()==null){
                        System.err.println("Agama Harus Dipilih");
                    }else if(cbasal.getEditor().getText().isEmpty()){
                        System.err.println("Asal Sekolah Harus Diisi");
                    }else if(txaalamat.getText().isEmpty()){
                        System.err.println("Alamat Harus Diisi");
                    }else if(txfhp.getText().isEmpty()){
                        System.err.println("No HP Harus Diisi");
                    }else{
                        System.err.println("Semua Data FIX");
                        
                    Date waktusekarang = new Date();
                    String waktucombi=dpwaktu.getValue().toString()+" |"+waktusekarang.getHours()+":"+waktusekarang.getMinutes()+":"+waktusekarang.getSeconds()+"|";
                    
                    waktu=waktucombi;
                    nama=txfnama.getText();
                    gender="";
                    for(int i=0; i<rbgender.length; i++){
                        if(rbgender[i].isSelected()){
                            groupGender.selectToggle(rbgender[i]);
                            gender = rbgender[i].textProperty().get().toString();
                        }
                    }
                    agama=choibagama.getValue().toString();
                    asal_sekolah=cbasal.getEditor().getText();
                    alamat=txaalamat.getText();
                    hp=txfhp.getText();
                    
                    informasi="";
                    ObservableList datasumber =FXCollections.observableArrayList();
                    datasumber.clear();
                    
                    for(int i=0; i<cbinfo.length; i++){
                        if(cbinfo[i].isSelected()){
                            datasumber.add(cbinfo[i].textProperty().get().toString());
                        }
                    }
                    informasi=datasumber.toString();
                    //cek console
                    System.out.println("Waktu : "+ waktu);
                    System.out.println("Nama : "+ nama);
                    System.out.println("Gender : "+ gender);
                    System.out.println("Agama : "+ agama);
                    System.out.println("Asal Sekolah : "+ asal_sekolah);
                    System.out.println("Alamat : "+ alamat);
                    System.out.println("HP : "+ hp);
                    System.out.println("Informasi : "+ informasi);
                    
                    MuridBaru mrd = new MuridBaru(waktu, nama, gender, agama, asal_sekolah, alamat, hp, informasi);
                    
                    akses.insert(mrd);
                    loadData();
                    clearDataKomponent();
                    
                    
                    }
                   //membuat waktu supaya unix 
                } catch (Exception ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
               }               
           });
                btnClear.setOnAction(new EventHandler<ActionEvent>(){
                 @Override
                 public void handle(ActionEvent event){
                     clearDataKomponent();
               }
           }); 
            btnUpdate.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    try {
                    String waktu;
                    String nama;
                    String gender;
                    String agama;
                    String asal_sekolah;
                    String alamat;
                    String hp;
                    String informasi;
                    
                    if(txfWaktuTmp.getText().isEmpty()){
                        System.err.println("Waktu Harus Diisi");
                    }else if(txfnama.getText().isEmpty()){
                        System.err.println("Nama Harus Diisi");
                    }else if(groupGender.getSelectedToggle()==null){
                        System.err.println("Gender Harus Dipilih");
                    }else if(choibagama.getValue()==null){
                        System.err.println("Agama Harus Dipilih");
                    }else if(cbasal.getEditor().getText().isEmpty()){
                        System.err.println("Asal Sekolah Harus Diisi");
                    }else if(txaalamat.getText().isEmpty()){
                        System.err.println("Alamat Harus Diisi");
                    }else if(txfhp.getText().isEmpty()){
                        System.err.println("No HP Harus Diisi");
                    }else{
                        System.err.println("Semua Data FIX");
                        
                    waktu = txfWaktuTmp.getText();
                    nama=txfnama.getText();
                    gender="";
                    for(int i=0; i<rbgender.length; i++){
                        if(rbgender[i].isSelected()){
                            groupGender.selectToggle(rbgender[i]);
                            gender = rbgender[i].textProperty().get().toString();
                        }
                    }
                    agama=choibagama.getValue().toString();
                    asal_sekolah=cbasal.getEditor().getText();
                    alamat=txaalamat.getText();
                    hp=txfhp.getText();
                    
                    informasi="";
                    ObservableList datasumber =FXCollections.observableArrayList();
                    datasumber.clear();
                    
                    for(int i=0; i<cbinfo.length; i++){
                        if(cbinfo[i].isSelected()){
                            datasumber.add(cbinfo[i].textProperty().get().toString());
                        }
                    }
                    informasi=datasumber.toString();
                    //cek console
                    System.out.println("Waktu : "+ waktu);
                    System.out.println("Nama : "+ nama);
                    System.out.println("Gender : "+ gender);
                    System.out.println("Agama : "+ agama);
                    System.out.println("Asal Sekolah : "+ asal_sekolah);
                    System.out.println("Alamat : "+ alamat);
                    System.out.println("HP : "+ hp);
                    System.out.println("Informasi : "+ informasi);
                    
                    MuridBaru mrd = new MuridBaru(waktu, nama, gender, agama, asal_sekolah, alamat, hp, informasi);
                    
                    akses.update(mrd);
                    loadData();
                    clearDataKomponent();
                    
                    //Mengembalikan settingan simpan
                    gp.getChildren().remove(gp.getChildren().size()-1);
                    gp.add(dpwaktu, 2, 0);
                    btnSimpan.setText("Simpan");
                    btnUpdate.setDisable(true);
                    }

                   //membuat waktu supaya unix 
                } catch (Exception ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            });

                btnDelete.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        try {
                            MuridBaru mrd = (MuridBaru) tabel.getSelectionModel().getSelectedItem();
                            akses.delete(mrd.getWaktu().toString());
                            
                            loadData();
                        } catch (Exception ex) {
                            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
//btnCetak, btnKembali
        tabel.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                btnUpdate.setDisable(false);
                MuridBaru mrd = (MuridBaru) tabel.getSelectionModel().getSelectedItem();
                String waktu = mrd.getWaktu();
                String nama = mrd.getNama();
                String gender = mrd.getGender();
                String agama = mrd.getAgama();
                String asal_sekolah = mrd.getAsal_sekolah();
                String alamat = mrd.getAlamat();
                String hp = mrd.getHp();
                String informasi = mrd.getInformasi();
                
                System.out.println("Waktu : "+ waktu);
                System.out.println("Nama : "+ nama);
                System.out.println("Gender : "+ gender);
                System.out.println("Agama : "+ agama);
                System.out.println("Asal Sekolah : "+ asal_sekolah);
                System.out.println("Alamat : "+ alamat);
                System.out.println("HP : "+ hp);
                System.out.println("Informasi : "+ informasi);
                
                //dpwaktu.setValue(waktu);
                txfWaktuTmp.setText(waktu);
                btnSimpan.setText("Cancle");
                gp.getChildren().remove(gp.getChildren().size()-1);
                gp.add(txfWaktuTmp, 2, 0);
                
                txfnama.setText(nama);
                
                        for(int i=0; i<rbgender.length; i++){
                            if(rbgender[i].textProperty().get().toString().equals(gender)){
                                groupGender.selectToggle(rbgender[i]);
                            }
                        }
                        choibagama.setValue(agama);
                        cbasal.getEditor().setText(asal_sekolah);
                        txaalamat.setText(alamat);
                        txfhp.setText(hp);
                        //cbinfo
                        
                        //mencari checkbox terpilih
                        cbinfo[0].setSelected(false);
                        cbinfo[1].setSelected(false);
                        cbinfo[2].setSelected(false);
                        cbinfo[3].setSelected(false);
                        
                        ObservableList datatmp = FXCollections.observableArrayList();
                        datatmp.clear();
                        String data = informasi;
                        String hilangkansiku=data.substring(1, data.length()-1)+",";
                        System.out.println("tanpa siku : "+hilangkansiku);
                        int posisiawal = 0;
                        for(int i=0; i<hilangkansiku.length(); i++){
                            if(hilangkansiku.charAt(i)==','){
                                System.out.println("Data >"+ hilangkansiku.substring(posisiawal, i));
                                datatmp.add(hilangkansiku.substring(posisiawal, i));
                                posisiawal=i+2;
                            }
                        }
                        //mencari checkbox yang terseleksi
                        for(int i=0; i<datatmp.size(); i++){
                            for(int j=0; j<cbinfo.length; j++){
                                if(cbinfo[j].textProperty().get().toString().equals(datatmp.get(i))){
                                    cbinfo[j].setSelected(true);
                                }
                            }
            }
            }
        });
    }
    
    void loadData(){
        try {
            dataMurid.clear();
            dataMurid = akses.getAll();
            
            tabel.setItems(dataMurid);
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void clearDataKomponent(){
        
        dpwaktu.setValue(null);
        txfnama.clear();
        groupGender.selectToggle(null);
        choibagama.setValue(null);
        cbasal.getEditor().clear();
        txaalamat.clear();
        txfhp.clear();
        for(int i=0; i<cbinfo.length; i++){
        cbinfo[i].setSelected(false);
    }
 }
}