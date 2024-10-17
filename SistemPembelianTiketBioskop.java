import java.util.ArrayList;
import java.util.Scanner;



public class SistemPembelianTiketBioskop {

    public static String filmDipilih;
    private static String pilihJadwal;
    public static ArrayList<String> riwayatPemesanan = new ArrayList<>();
    private static final int totalKursi = 10;
    private static boolean[] kursi = new boolean[totalKursi]; // false = tersedia, true = terisi
    private static int nomorKursi = -1;
    private static String tipeStudio = null;
    private static String metodePembayaran = null;
    private static String ulasan;
    private static int rating;


    public static void showMenu() {
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("MENU : ");
            System.out.println("1. Pilih Film");
            System.out.println("2. Pilih Tipe Studio");
            System.out.println("3. Pilih Kursi");
            System.out.println("4. Pembatalan/Ubah Pemesanan");
            System.out.println("5. Bayar");
            System.out.println("6. Ulasan & Rating");
            System.out.println("7. Riwayat Pemesanan");
            System.out.println("0. Exit");
            System.out.print("Pilih menu yang ingin dijalankan (masukkan nomor): ");
            String selectedMenu = input.nextLine();
            switch (selectedMenu) {
                case "1":
                    pemilihanFilm();
                    break;

                case "2":
                    pemilihanTipeStudio();
                    System.out.println("Tipe studio yang dipilih: " + tipeStudio);
                    break;

                case "3":
                    tampilkanKursi();
                    pilihKursi(input);
                    break;

                case "4":
                    ubahAtauBatalkanPesanan();
                    break;

                case "5":
                    pemilihanMetodePembayaran();
                    System.out.println("Metode pembayaran yang dipilih: " + metodePembayaran);
                    break;

                case "6":
                    berikanUlasanDanRating();
                    lihatUlasan();
                    break;

                case "7":
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

    private static void lihatUlasan() {
        System.out.println("Ulasan: " + ulasan);
        System.out.println("Rating: " + rating + " bintang");
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
        detailFilm();
    }

    public static void detailFilm() {
        Scanner input = new Scanner(System.in);
        if (filmDipilih == null) {
            System.out.println("Tidak ada film yang dipilih.");
            return;
        }

        switch (filmDipilih) {
            case "Wolverine X Deadpool":
                System.out.println("Judul: Wolverine X Deadpool\nGenre: Aksi, Petualangan, Superhero\nDurasi: 2 j 8 m");
                break;
            case "Joker: Folie à Deux":
                System.out.println("Judul: Joker: Folie à Deux\nGenre: Drama, Kriminal, Musik\nDurasi: 2 j 18 m");
                break;
            case "Piece by Piece":
                System.out.println("Judul: Piece by Piece\nGenre: Drama, Keluarga\nDurasi: 1 j 33 m");
                break;
            case "Kuasa Gelap":
                System.out.println("Judul: Kuasa Gelap\nGenre: Horror\nDurasi: 1 j 36 m");
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
                riwayatPemesanan.remove(filmDipilih);
                showMenu();
        }
    }

    public static void jadwalFilm() {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih Jadwal Nonton:");
        System.out.println("1. 10:00 AM");
        System.out.println("2. 01:00 PM");
        System.out.println("3. 04:00 PM");
        System.out.println("4. 07:00 PM");
        System.out.print("Masukkan pilihan (1-4): ");

        int pilihan = input.nextInt();
        input.nextLine();
        switch (pilihan) {
            case 1:
                pilihJadwal = "10:00 AM";
                break;
            case 2:
                pilihJadwal = "01:00 PM";
                break;
            case 3:
                pilihJadwal = "04:00 PM";
                break;
            case 4:
                pilihJadwal = "07:00 PM";
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                jadwalFilm();
        }
        System.out.println("Anda telah memilih jadwal: " + pilihJadwal);
    }

    private static void tampilkanKursi() {
        System.out.println("Kursi yang tersedia:");
        for (int i = 0; i < totalKursi; i++) {
            if (!kursi[i]) {
                System.out.print((i + 1) + " "); //kursi yang tersedia
            } else {
                System.out.print("X "); //kursi yang sudah terisi
            }
        }
        System.out.println();
    }

    private static void pilihKursi(Scanner input) {
        System.out.print("Pilih nomor kursi (1-" + totalKursi + ") untuk memesan (0 untuk keluar): ");
        int pilihan = input.nextInt();

        if (pilihan == 0) {
            System.out.println("Terima kasih! Selamat menikmati film!");
            return;
        }
        pesanKursi(pilihan - 1);

    }

    public static void pesanKursi(int nomorKursi) {
        if (nomorKursi < 0 || nomorKursi >= totalKursi) {
            System.out.println("Nomor kursi tidak valid.");
        } else if (kursi[nomorKursi]) {
            System.out.println("Kursi sudah terisi. Silakan pilih kursi lain.");
        } else {
            kursi[nomorKursi] = true; // Tandai kursi sebagai terisi
            System.out.println("Kursi " + (nomorKursi + 1) + " berhasil dipesan.");
            SistemPembelianTiketBioskop.nomorKursi = nomorKursi; // Set the selected seat
        }
    }

    public static void pemilihanTipeStudio() {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih Tipe Studio:");
        System.out.println("1. VIP");
        System.out.println("2. Standar");
        System.out.print("Masukkan pilihan (1-2): ");

        int pilihan = input.nextInt();
        input.nextLine(); // Mengkonsumsi newline

        switch (pilihan) {
            case 1:
                tipeStudio = "VIP";
                break;
            case 2:
                tipeStudio = "Standar";
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                pemilihanTipeStudio(); // Minta pengguna untuk memilih lagi
                return;
        }

        System.out.println("Anda telah memilih tipe studio: " + tipeStudio);
    }

    public static void pemilihanMetodePembayaran() {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih Metode Pembayaran:");
        System.out.println("1. Kartu Kredit");
        System.out.println("2. E-wallet");
        System.out.println("3. Transfer Bank");
        System.out.print("Masukkan pilihan (1-3): ");

        int pilihan = input.nextInt();
        input.nextLine(); //newline

        switch (pilihan) {
            case 1:
                metodePembayaran = "Kartu Kredit";
                break;
            case 2:
                metodePembayaran = "E-wallet";
                break;
            case 3:
                metodePembayaran = "Transfer Bank";
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                pemilihanMetodePembayaran(); // Minta user untuk memilih lagi
                return;
        }

        System.out.println("Anda telah memilih metode pembayaran: " + metodePembayaran);
    }

    public static void berikanUlasanDanRating() {
        Scanner input = new Scanner(System.in);

        // Meminta ulasan dari pengguna
        System.out.print("Silakan berikan ulasan untuk film: ");
        ulasan = input.nextLine();

        // Meminta rating dari pengguna
        System.out.print("Silakan berikan rating (1-5): ");
        rating = input.nextInt();

        // Validasi rating
        while (rating < 1 || rating > 5) {
            System.out.print("Rating tidak valid. Silakan berikan rating (1-5): ");
            rating = input.nextInt();
        }

        System.out.println("Terima kasih! Ulasan dan rating Anda telah diterima.");
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

        if (nomorKursi != -1) {
            kursi[nomorKursi] = false;
            nomorKursi = -1;
        }
        System.out.println("Berhasil dibatalkan");
    }

    public static void ubahPesanan() {
        Scanner input = new Scanner(System.in);
        riwayatPemesanan.remove(filmDipilih);

        // Reset
        if (nomorKursi != -1) {
            kursi[nomorKursi] = false;
            nomorKursi = -1;
        }

        System.out.println("Mengubah pesanan Anda : ");
        pemilihanFilm();
        pemilihanTipeStudio();
        tampilkanKursi();
        pilihKursi(input);
    }


    public static void tampilkanRiwayatPemesanan() {
        if (riwayatPemesanan.isEmpty()) {
            System.out.println("Tidak ada riwayat pemesanan.");
        } else {
            System.out.println("Riwayat Pemesanan:");
            for (String film : riwayatPemesanan) {
                System.out.println("- " + "Film                 : "  + filmDipilih);
                System.out.println("- " + "Jadwal Nonton        : "  + pilihJadwal);
                System.out.println("- " + "Studio Type          : "  + tipeStudio);
                System.out.println("- " + "Metode Pembayaran    : "  + metodePembayaran);
                System.out.println("- " + "Ulasan               : "  + ulasan);
                System.out.println("- " + "Rating (1-5)         : "  + rating);
            }
        }
    }
    public static void main(String[] args) {
        daftarPengguna();
    }
}
