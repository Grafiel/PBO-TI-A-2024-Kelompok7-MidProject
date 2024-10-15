import java.util.ArrayList;
import java.util.Scanner;

public class SistemPembelianTiketBioskop {
    public static String filmDipilih;
    public static ArrayList<String> riwayatPemesanan = new ArrayList<>();

    public static void showMenu() {
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("MENU : ");
            System.out.println("1. Pilih Film");
            System.out.println("2. Pembatalan/Ubah Pemesanan");
            System.out.println("3. Riwayat Pemesanan");
            System.out.println("0. Exit");
            System.out.print("Pilih menu yang ingin dijalankan (masukkan nomor): ");
            String selectedMenu = input.nextLine();
            switch (selectedMenu) {
                case "1":
                    pemilihanFilm();
                    break;
                case "2":
                    ubahAtauBatalkanPesanan();
                    break;
                case "3":
                    tampilkanRiwayatPemesanan();
                    break;
                case "0":
                    isRunning = false;
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }

    public static void daftarPengguna() {
        Scanner input = new Scanner(System.in);
        System.out.println("MASUKAN DATA PENGGUNA");
        System.out.print("Masukan nama: ");
        String nama = input.nextLine();
        System.out.print("Masukan email: ");
        String email = input.nextLine();
        System.out.print("Masukan nomor telepon: ");
        String telepon = input.nextLine();
        System.out.println("Nama    : " + nama + "\nEmail   : " + email + "\nNo.Telp : " + telepon);
        showMenu();
    }

    public static void pemilihanFilm() {
        Scanner input = new Scanner(System.in);
        System.out.println("PILIH FILM");
        System.out.println("Daftar Film yang Tersedia: ");
        System.out.println("1. Wolverine X Deadpool");
        System.out.println("2. Joker: Folie à Deux");
        System.out.println("3. Piece by Piece");
        System.out.println("4. Kuasa Gelap");
        System.out.print("Pilih film yang ingin ditonton (masukkan nomor): ");

        int pilihan = input.nextInt();
        input.nextLine();

        switch (pilihan) {
            case 1:
                filmDipilih = "Wolverine X Deadpool";
                break;
            case 2:
                filmDipilih = "Joker: Folie à Deux";
                break;
            case 3:
                filmDipilih = "Piece by Piece";
                break;
            case 4:
                filmDipilih = "Kuasa Gelap";
                break;
            default:
                filmDipilih = "Pilihan tidak valid";
        }
        if (!filmDipilih.equals("Pilihan tidak valid")) {
            riwayatPemesanan.add(filmDipilih);
        }
        System.out.println("Anda memilih: " + filmDipilih);
    }

    public static void ubahAtauBatalkanPesanan() {
        if (filmDipilih == null || filmDipilih.equals("Pilihan tidak valid")) {
            System.out.println("Tidak ada film yang dipilih");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Menu Pembatalan/Ubah");
        System.out.println("1. Pembatalan");
        System.out.println("2. Ubah Pesanan");
        System.out.print("Masukkan Pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine();

        switch (pilihan) {
            case 1:
                batalkanPesanan();
                break;
            case 2:
                ubahPesanan();
                break;
            default:
                System.out.println("Pilihan tidak valid");
        }
    }

    public static void batalkanPesanan() {
        riwayatPemesanan.remove(filmDipilih);
        filmDipilih = null;
        System.out.println("Berhasil dibatalkan");
    }

    public static void ubahPesanan() {
        System.out.println("Mengubah pesanan Anda : ");
        pemilihanFilm();
    }

    public static void tampilkanRiwayatPemesanan() {
        if (riwayatPemesanan.isEmpty()) {
            System.out.println("Tidak ada riwayat pemesanan.");
        } else {
            System.out.println("Riwayat Pemesanan:");
            for (String film : riwayatPemesanan) {
                System.out.println("- " + film);
            }
        }
    }

    public static void main(String[] args) {
        daftarPengguna();
    }
}
