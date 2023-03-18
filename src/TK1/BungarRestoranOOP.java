package TK1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yosepri Disyandro Berutu (yosepri.disyandro@dana.id)
 * @version $Id: BungarRestoranOOP.java , v 0.1 2023-03-18 09.34 Yosepri Disyandro Berutu Exp $$
 */
public class BungarRestoranOOP {

    /**
     * innter Class
     */
    private class Menu{

        /**
         * menuName
         */
        private String name;

        /**
         * menuPrice
         */
        private Double price;

        /**
         * totalOrder
         */
        private int totalOrder;

        public Menu(String name, Double price, int totalOrder){
            this.name = name;
            this.price = price;
            this.totalOrder = totalOrder;
        }

        public Menu(String name, Double price){
            this.name = name;
            this.price = price;
            this.totalOrder = 0;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public int getTotalOrder() {
            return totalOrder;
        }

        public void setTotalOrder(int totalOrder) {
            this.totalOrder = totalOrder;
        }
    }


    /**
     * below is to define menu(s)
     */
    private static String nasiGorengSpesialMenu = "Nasi Goreng Spesial";
    private static String ayamBakarSpesialMenu = "Ayam Bakar Spesial";
    private static String steakSirloinSpesialMenu = "Steak Sirloin Spesial";
    private static String kwetiawSiramSpesialMenu = "Kwetiaw Siram Spesial";
    private static String kambingGulingSpesialMenu = "Kambing Goreng Spesial";

    /**
     * below is to define price menu(s)
     */
    private static Double nasiGorengSpesialPrice = 9999.99;
    private static Double ayamBakarSpesialPrice = 12345.67;
    private static Double steakSirloinSpesialPrice = 21108.40;
    private static Double kwetiawSiramSpesialPrice = 13579.13;
    private static Double kambingGulingSpesialPrice = 98765.43;

    /**
     * discount
     */
    private static Double discount = 0.10; // 10%

    /**
     * totalPelanggan
     */
    private int totalCustomer;

    /**
     * customerName
     */
    private String customerName;

    /**
     * list of orders that customer ordered
     */

    private Double totalPrice;

    private Double discountPrice;

    private Double totalPriceAfterDiscount;

    private Double priceEachPerson;

    private List<Menu> orders;



    public BungarRestoranOOP() {
        iniateMenu();
    }

    public void iniateMenu(){
        orders = new ArrayList<>();
        orders.add(new Menu(nasiGorengSpesialMenu, nasiGorengSpesialPrice));
        orders.add(new Menu(ayamBakarSpesialMenu, ayamBakarSpesialPrice));
        orders.add(new Menu(steakSirloinSpesialMenu, steakSirloinSpesialPrice));
        orders.add(new Menu(kwetiawSiramSpesialMenu, kwetiawSiramSpesialPrice));
        orders.add(new Menu(kambingGulingSpesialMenu, kambingGulingSpesialPrice));
    }

    public int getTotalCustomer() {
        return totalCustomer;
    }

    public void setTotalCustomer(int totalCustomer) {
        this.totalCustomer = totalCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Double getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount;
    }

    public void setTotalPriceAfterDiscount(Double totalPriceAfterDiscount) {
        this.totalPriceAfterDiscount = totalPriceAfterDiscount;
    }

    public Double getPriceEachPerson() {
        return priceEachPerson;
    }

    public void setPriceEachPerson(Double priceEachPerson) {
        this.priceEachPerson = priceEachPerson;
    }

    private static void showMenu(BungarRestoranOOP restoran) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat siang...");
        System.out.print("Pesan untuk berapa orang\t: ");
        restoran.setTotalCustomer(scanner.nextInt());

        System.out.print("Pesanan atas nama\t\t\t: ");
        scanner.nextLine();
        restoran.setCustomerName(scanner.nextLine());

        System.out.println("Menu Spesial hari ini");
        System.out.println("=====================\n");

        for(Menu menu : restoran.orders){
            System.out.printf("\t%d.%s\t\t@ Rp. %.2f\n", restoran.orders.indexOf(menu)+1, menu.getName(), menu.getPrice());
        }

    }

    private static void printBill(BungarRestoranOOP restoran) {
        System.out.println("Pembelian:");
        for(Menu menu : restoran.orders){
            System.out.printf("%d. %s\t\t %d porsi * Rp. %.2f\t=\tRp.\t%.2f\n",restoran.orders.indexOf(menu)+1,
                    menu.getName(), menu.getTotalOrder(), menu.getPrice(), (menu.getPrice()*menu.getTotalOrder()));
        }

        System.out.println("=========================================================================");
        System.out.printf("Total Pembelian\t\t\t\t\t\t\t\t\t\t=\tRp.\t%.2f\n", restoran.getTotalPrice());
        System.out.printf("Disc. %d %% (Masa Promosi)\t\t\t\t\t\t\t=\tRp.\t%.2f -\n", (int) (discount*100), restoran.getDiscountPrice());
        System.out.println("=========================================================================");
        System.out.printf("Total Pembelian setelah disc %d %%\t\t\t\t\t=\tRp.\t%.2f\n", (int) (discount*100), restoran.getTotalPriceAfterDiscount());
        System.out.printf("Pembelian per orang (untuk %d orang)\t\t\t\t\t=\tRp.\t%.2f\n", restoran.getTotalCustomer(), restoran.getPriceEachPerson());

        System.out.println("\n\n\t\tTerima kasih atas kunjungan Anda...\n");
        System.out.println("\t\t...tekan ENTER untuk keluar...");
    }

    private static void calculateBill(BungarRestoranOOP restoran) {
        restoran.setTotalPrice(restoran.orders.stream()
                .mapToDouble(menu -> menu.getPrice() * menu.getTotalOrder())
                .sum());

        restoran.setDiscountPrice(restoran.getTotalPrice() * discount);
        restoran.setTotalPriceAfterDiscount(restoran.getTotalPrice() - restoran.getDiscountPrice());
        restoran.setPriceEachPerson(restoran.totalPriceAfterDiscount/restoran.totalCustomer);
    }

    private static void noteOrder(BungarRestoranOOP restoran) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pesanan Anda (batas pesanan 0-10 porsi)");
        for(Menu menu : restoran.orders){
            System.out.printf("%d.%s\t\t= ", restoran.orders.indexOf(menu)+1, menu.getName());
            menu.setTotalOrder(scanner.nextInt());
        }

        System.out.println("\n\nSelamat menikmati makanan anda...\n\n");
    }

    public static void main(String[] args) {
        BungarRestoranOOP restoran = new BungarRestoranOOP();
        showMenu(restoran);
        noteOrder(restoran);
        calculateBill(restoran);
        printBill(restoran);
    }
}
