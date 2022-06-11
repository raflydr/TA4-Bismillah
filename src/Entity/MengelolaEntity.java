package Entity;

public class MengelolaEntity {
    private int id_jajan, id_transaksi, qty_jajan;
    private float harga_qty_jajan, total_pembayaran;
    //public static JajanEntity jajanEntity = new JajanEntity();
    //public static TransaksiEntity transaksiEntity = new TransaksiEntity();


    public  MengelolaEntity() {
    }

    public MengelolaEntity(int id_jajan, int id_transaksi,int qty_jajan, float harga_qty_jajan, float total_pembayaran) {
        this.id_jajan = id_jajan;
        this.id_transaksi = id_transaksi;
        this.qty_jajan = qty_jajan;
        this.harga_qty_jajan = harga_qty_jajan;
        this.total_pembayaran = total_pembayaran;
    }

    public int getId_jajan() {
        return id_jajan;
    }
    public void setId_jajan(int id_jajan) {
        this.id_jajan = id_jajan;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }
    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getQty_jajan() {
        return qty_jajan;
    }
    public void setQty_jajan(int qty_jajan) {
        this.qty_jajan = qty_jajan;
    }

    public float getHarga_qty_jajan() {
        return harga_qty_jajan;
    }
    public void setHarga_qty_jajan(float harga_qty_jajan) {
        this.harga_qty_jajan = harga_qty_jajan;
    }

    public float getTotal_pembayaran() {
        return total_pembayaran;
    }
    public void setTotal_pembayaran(float total_pembayaran) {
        this.total_pembayaran = total_pembayaran;
    }
}
