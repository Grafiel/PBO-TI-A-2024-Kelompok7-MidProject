import java.util.Scanner;

public class SistemPembelianTiketBioskop {
    public static String filmDipilih;

    public static void showMenu() {
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("MENU : ");
            System.out.println("1. Pilih Film");
            System.out.println("2. Pembatalan/Ubah Pemesanan");
            System.out.println("3. Riwayat Pemesanan");
            System.out.println("0. Exit");
            System.out.println("Pilih menu yang ingin dijalankan (masukan nomor): ");
            String selectedMenu = input.nextLine();
            switch (selectedMenu) {
                case "1":
                    pemilihanFilm();
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }

    public static void daftarPengguna() {
        Scanner input = new Scanner(System.in);
        System.out.println("MASUKAN DATA PENGGUNA");
        System.out.println("Masukan nama: ");
        String nama = input.next();
        System.out.println("Masukan email: ");
        String email = input.next();
        System.out.println("Masukan nomor telepon: ");
        String telepon = input.next();
        System.out.println("Nama    : " + nama + "\nEmail   : " + email + "\nNo.Telp : " + telepon);
        showMenu();
        input.close();
    }

    public static void pemilihanFilm() {
        Scanner input = new Scanner(System.in);
        System.out.println("PILIH FILM");
        System.out.println("Daftar Film yang Tersedia: ");
        System.out.println("1. Wolverine X Deadpool");
        System.out.println("2. Joker: Folie à Deux");
        System.out.println("3. Piece by Piece");
        System.out.print("Pilih film yang ingin ditonton (masukkan nomor): ");
        int pilihan = input.nextInt();

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
            default:
                filmDipilih = "Pilihan tidak valid";
        }
        System.out.println("Anda memilih: " + filmDipilih);
        detailFilm();
        input.close();
    }

    public static void detailFilm() {
        Scanner input = new Scanner(System.in);
        if (filmDipilih == null) {
            System.out.println("Tidak ada film yang dipilih.");
            return;
        }

        switch (filmDipilih) {
            case "Wolverine X Deadpool":
                System.out.println("hahaha");
                break;
            case "Joker: Folie à Deux":
                System.out.println("uheeee");
                break;
            case "Piece by Piece":
                System.out.println("nihaha");
                break;
            default:
                System.out.println("Tidak ada detail untuk film yang dipilih.");
                break;
        }
        System.out.println("Tekan 1 untuk konfirmasi: ");
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1:
                jadwalFilm();
                break;
            default:
                System.out.println("Pilihan tidak valid");
        }
    }

    public static void jadwalFilm() {
        System.out.println("NIHAHAHA");
        showMenu();
    }
    public static void main(String[] args) {
        daftarPengguna();
    }
}
