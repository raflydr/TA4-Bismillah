package Model;

import Database.KoneksiDB;
import Entity.JajanEntity;
import Entity.MengelolaEntity;
import Entity.TransaksiEntity;

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
                mengelolaEntity.setQty_jajan(rs.getInt("qty_jajan"));
                mengelolaEntity.setHarga_qty_jajan(rs.getFloat("harga_qty_jajan"));
                mengelolaEntity.setTotal_pembayaran(rs.getFloat("total_pembayaran"));
                mengelolaEntities.add(mengelolaEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mengelolaEntities;
    }
    public ArrayList<MengelolaEntity> getDetail() {
        ArrayList<MengelolaEntity> mengelolaEntities = new ArrayList<>();
        try {
            String sql = "select * from transaksi t right join mengelola m on t.id_transaksi = m.id_transaksi";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                MengelolaEntity mengelolaEntity = new MengelolaEntity();
                mengelolaEntity.setId_jajan(rs.getInt("id_jajan"));
                mengelolaEntity.setId_transaksi(rs.getInt("id_transaksi"));
                mengelolaEntity.setQty_jajan(rs.getInt("qty_jajan"));
                mengelolaEntity.setHarga_qty_jajan(rs.getFloat("harga_qty_jajan"));
                mengelolaEntity.setTotal_pembayaran(rs.getFloat("total_pembayaran"));
                TransaksiEntity transaksiEntity = new TransaksiEntity();
                //mengelolaEntity.setId_transaksi(rs.getInt("id_transaki"));
                //mengelolaEntity.setId_transaksi(transaksiEntity);
                //transaksiEntity.setTgl_transaksi(rs.getDate("tgl_transaksi"));
               // mengelolaEntity.setTgl_transaksi(transaksiEntity);

                //transaksiEntity.setId_transaksi(rs.getInt("id_transaksi"));
                //transaksiEntity.setTgl_transaksi(rs.getDate("tgl_transaksi"));
                transaksiEntity.setId_transaksi(rs.getInt("id_transaksi"));
                transaksiEntity.setTgl_transaksi(rs.getDate("tgl_transaksi"));
                //mengelolaEntity.setId_transaksi1(rs.getInt("id_transaksi"));
                //mengelolaEntity.setTgl_transaksi(rs.getDate("tgl_transaksi"));
                //mengelolaEntity.setId_transaksi1(transaksiEntity);
                //mengelolaEntity.setTgl_transaksi(transaksiEntity);
                mengelolaEntities.add(mengelolaEntity);
                //mengelolaEntities.add(transaksiEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mengelolaEntities;
    }

    public boolean insertMengelola(ArrayList<MengelolaEntity> mengelolaEntity) {
        ArrayList<MengelolaEntity> mengelolaEntities = new ArrayList<>();
        try {
            for (MengelolaEntity i : mengelolaEntity
            ) {sql = String.format("INSERT INTO mengelola (ID_JAJAN ,ID_TRANSAKSI, QTY_JAJAN, " +
                            "HARGA_QTY_JAJAN, TOTAL_PEMBAYARAN) VALUES " +
                            "('%s', '%s', '%s', '%s', '%s');",
                    i.getId_jajan(),
                    i.getId_transaksi(),
                    i.getQty_jajan(),
                    i.getHarga_qty_jajan(),
                    i.getTotal_pembayaran());
                PreparedStatement statement = conn.prepareStatement(sql);
                if (statement.executeUpdate() > 0) {
                    System.out.println("Berhasil Menambah Data");
                } else {
                    System.out.println("Gagal Menambah Data");
                    break;
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
