package softtesting;

import java.util.Scanner;

/**
 *
 * @author Git
 */
public class JohnTravoltaCase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int upahNormal = 0, upahLembur = 0, jamKerja = 0, jamLembur, 
            gajiNormal = 0, gajiLembur = 0, gajiTotal, pengeluaran = 0,
            tabungan;
        String nama = null;

        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Masukkan Nama: ");
            nama = in.nextLine();
            System.out.print("Masukkan Gaji (/jam): ");
            upahNormal = in.nextInt();
            System.out.print("Masukkan Jam Kerja: ");
            jamKerja = in.nextInt();
        } catch (Exception e) {
            System.out.println((char) 27 + "[01;31mInput Salah!!" + (char) 27 + "[00;00m");
            System.exit(0);
        }

        if (jamKerja > 40) {                    //jika jam kerja diatas 40 jam (lembur)
            gajiNormal = upahNormal * 40;
            jamLembur = jamKerja - 40;
            upahLembur = ((upahNormal * 3) / 2);
            gajiLembur = jamLembur * upahLembur;
            gajiTotal = gajiNormal + gajiLembur;
        } else {
            gajiNormal = jamKerja * upahNormal;
            gajiTotal = gajiNormal;
        }

        System.out.format("\nNama: %s\n", nama);
        System.out.format("Gaji (/jam): Rp. %d\n", upahNormal);
        System.out.format("Gaji Pokok: Rp. %d\n", gajiNormal);
        System.out.format("Upah Lembur: Rp. %d\n", upahLembur);
        System.out.format("Gaji Lembur: Rp. %d\n", gajiLembur);
        System.out.format("Gaji Total (Pemasukkan): Rp. %d\n", gajiTotal);

        try {
            System.out.print("\nMasukkan Pengeluaran: ");
            pengeluaran = in.nextInt();
        } catch (Exception e) {
            System.out.println((char) 27 + "[01;31mInput Salah!!" + (char) 27 + "[00;00m");
            System.exit(0);
        }

        if (gajiTotal == pengeluaran) {         // pemasukan sama dengan pengeluaran
            System.out.println((char) 27 + "[01;33mStatus: Tidak Bisa Menabung" + (char) 27 + "[00;00m");
        } else if (gajiTotal > pengeluaran) {   // pemasukan lebih besar dari pengeluaran
            System.out.println((char) 27 + "[01;32mStatus: Bisa Menabung" + (char) 27 + "[00;00m");
            tabungan = gajiTotal - pengeluaran;
            System.out.format("Besar Tabungan: Rp. %d\n", tabungan);
        } else {                                // pemasukan lebih kecil dari pengeluaran
            System.out.println((char) 27 + "[01;31mStatus: Cari Tambahan" + (char) 27 + "[00;00m");
        }
    }
}
