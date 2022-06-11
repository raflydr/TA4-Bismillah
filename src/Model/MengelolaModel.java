package Model;

import Database.KoneksiDB;
import Entity.JajanEntity;
import Entity.MengelolaEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MengelolaModel {
    String sql;
    public Connection conn = KoneksiDB.getconection();

    public ArrayList<MengelolaEntity> getMengelola() {
        ArrayList<MengelolaEntity> mengelolaEntities = new ArrayList<>();
        try {
            String sql = "select *" +
                    "from mengelola ";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                MengelolaEntity mengelolaEntity = new MengelolaEntity();
                mengelolaEntity.setId_jajan(rs.getInt("id_jajan"));
                mengelolaEntity.setId_transaksi(rs.getInt("id_transaksi"));
                mengelolaEntity.setJumlah_jajan(rs.getInt("jumlah_jajan"));
                mengelolaEntity.setJumlah_harga_jajan(rs.getFloat("jumlah_harga_jajan"));
                mengelolaEntities.add(mengelolaEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mengelolaEntities;
    }

    public void insertMengelola(ArrayList<MengelolaEntity> mengelolaEntity) {
        ArrayList<MengelolaEntity> mengelolaEntities = new ArrayList<>();
        try {
            for (MengelolaEntity i : mengelolaEntity
            ) {sql = String.format("INSERT INTO mengelola (ID_JAJAN ,ID_TRANSAKSI, JUMLAH_JAJAN, JUMLAH_HARGA_JAJAN) VALUES " +
                            "('%s', '%s', '%s', '%s');",
                    i.getId_jajan(),
                    i.getId_transaksi(),
                    i.getJumlah_jajan(),
                    i.getJumlah_harga_jajan());
                PreparedStatement statement = conn.prepareStatement(sql);
                if (statement.executeUpdate() > 0) {
                    System.out.println("Berhasil Menambah Data");
                } else {
                    System.out.println("Gagal Menambah Data");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       //eturn mengelolaEntities;
    }
}
