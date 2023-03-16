package TK1;

import java.util.Scanner;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: BungarRestoran.java , v 0.1 2023-03-13 22.53 Yosepri Disyandro Berutu Exp $$
 */
public class BungarRestoran {

    // below is to define menu(s)
    private static String nasiGorengSpesialMenu = "Nasi Goreng Spesial";
    private static String ayamBakarSpesialMenu = "Ayam Bakar Spesial";
    private static String steakSirloinSpesialMenu = "Steak Sirloin Spesial";
    private static String kwetiawSiramSpesialMenu = "Kwetiaw Siram Spesial";
    private static String kambingGulingSpesialMenu = "Kambing Goreng Spesial";

    // below is to define price menu(s)
    private static Double nasiGorengSpesialPrice = 9999.99;
    private static Double ayamBakarSpesialPrice = 12345.67;
    private static Double steakSirloinSpesialPrice = 21108.40;
    private static Double kwetiawSiramSpesialPrice = 13579.13;
    private static Double kambingGulingSpesialPrice = 98765.43;


    // below is to define discount
    private static Double discount = 0.10; // 10%

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat siang...");
        System.out.print("Pesan untuk berapa orang\t:\t");
        int totalPelanggan = scanner.nextInt();

        System.out.print("Pesanan atas nama\t\t\t:\t");
        scanner.nextLine();
        String namaPelanggan = scanner.nextLine();

        System.out.println("Menu Spesial hari ini");
        System.out.println("=====================\n");

        System.out.printf("\t1.%s\t\t@ Rp. %.2f\n",nasiGorengSpesialMenu, nasiGorengSpesialPrice);
        System.out.printf("\t2.%s\t\t@ Rp. %.2f\n",ayamBakarSpesialMenu, ayamBakarSpesialPrice);
        System.out.printf("\t3.%s\t\t@ Rp. %.2f\n",steakSirloinSpesialMenu, steakSirloinSpesialPrice);
        System.out.printf("\t4.%s\t\t@ Rp. %.2f\n",kwetiawSiramSpesialMenu, kwetiawSiramSpesialPrice);
        System.out.printf("\t5.%s\t@ Rp. %.2f\n",kambingGulingSpesialMenu, kambingGulingSpesialPrice);

        System.out.println("Pesanan Anda (batas pesanan 0-10 porsi)");
        System.out.printf("1.%s\t\t= ",nasiGorengSpesialMenu);
        int nasiGorengSpesialTotalPesanan = scanner.nextInt();

        System.out.printf("2.%s\t\t= ",ayamBakarSpesialMenu);
        int ayamBakarSpesialTotalPesanan = scanner.nextInt();

        System.out.printf("3.%s\t\t= ",steakSirloinSpesialMenu);
        int steakSirloinSpesialTotalPesanan = scanner.nextInt();

        System.out.printf("4.%s\t\t= ",kwetiawSiramSpesialMenu);
        int kwetiawSiramSpesialTotalPesanan = scanner.nextInt();

        System.out.printf("5.%s\t= ",kambingGulingSpesialMenu);
        int kambingGulingSpesialTotalPesanan = scanner.nextInt();

        System.out.println("\n\nSelamat menikmati makanan anda...\n\n");

        // Perhitungan total harga tiap pesanan
        Double nasiGorengSpesialTotalPrice = nasiGorengSpesialPrice * nasiGorengSpesialTotalPesanan;
        Double ayamBakarSpesialTotalPrice = ayamBakarSpesialPrice * ayamBakarSpesialTotalPesanan;
        Double steakSirloinSpesialTotalPrice = steakSirloinSpesialPrice * steakSirloinSpesialTotalPesanan;
        Double kwetiawSiramSpesialTotalPrice = kwetiawSiramSpesialPrice * kwetiawSiramSpesialTotalPesanan;
        Double kambingGulingSpesialTotalPrice = kambingGulingSpesialPrice * kambingGulingSpesialTotalPesanan;

        // Perhitungan total harga
        // total harga sebelum discount
        Double totalPrice = nasiGorengSpesialTotalPrice + ayamBakarSpesialTotalPrice + steakSirloinSpesialTotalPrice
                + kwetiawSiramSpesialTotalPrice + kambingGulingSpesialTotalPrice;

        // total potongan harga / total discount
        Double discountPrice = totalPrice * discount;

        // total harga setelah discount
        Double totalPriceAfterDiscount = totalPrice - discountPrice;

        // total harga pembelian per orang
        Double priceEachPerson = totalPriceAfterDiscount / totalPelanggan;

        System.out.println("Pembelian:");

        System.out.printf("1. %s\t\t %d porsi * Rp. %.2f\t=\tRp.\t%.2f\n",
                nasiGorengSpesialMenu, nasiGorengSpesialTotalPesanan, nasiGorengSpesialPrice, nasiGorengSpesialTotalPrice);
        System.out.printf("2. %s\t\t %d porsi * Rp. %.2f\t=\tRp.\t%.2f\n",
                ayamBakarSpesialMenu, ayamBakarSpesialTotalPesanan, ayamBakarSpesialPrice, ayamBakarSpesialTotalPrice);
        System.out.printf("3. %s\t %d porsi * Rp. %.2f\t=\tRp.\t%.2f\n",
                steakSirloinSpesialMenu, steakSirloinSpesialTotalPesanan, steakSirloinSpesialPrice, steakSirloinSpesialTotalPrice);
        System.out.printf("4. %s\t %d porsi * Rp. %.2f\t=\tRp.\t%.2f\n",
                kwetiawSiramSpesialMenu, kwetiawSiramSpesialTotalPesanan, kwetiawSiramSpesialPrice, kwetiawSiramSpesialTotalPrice);
        System.out.printf("5. %s\t %d porsi * Rp. %.2f\t=\tRp.\t%.2f+\n",
                kambingGulingSpesialMenu, kambingGulingSpesialTotalPesanan, kambingGulingSpesialPrice, kambingGulingSpesialTotalPrice);
        System.out.println("=========================================================================");
        System.out.printf("Total Pembelian\t\t\t\t\t\t\t\t\t\t=\tRp.\t%.2f\n", totalPrice);
        System.out.printf("Disc. 10 %% (Masa Promosi)\t\t\t\t\t\t\t=\tRp.\t%.2f -\n", discountPrice);
        System.out.println("=========================================================================");
        System.out.printf("Total Pembelian setelah disc %d %%\t\t\t\t=\tRp.\t%.2f\n", (int) (discount*100), totalPriceAfterDiscount);
        System.out.printf("Pembelian per orang (untuk %d orang)\t\t\t\t\t=\tRp.\t%.2f\n", totalPelanggan, priceEachPerson);

        System.out.println("\n\nTerima kasih atas kunjungan Anda...\n");
        System.out.println("...tekan ENTER untuk keluar...");
    }
}
