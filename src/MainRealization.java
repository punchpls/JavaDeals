import java.util.ArrayList;
import java.util.Scanner;

class Product{
    private String productName;
    private int productPrice;
    private int productAmount;

    public int getProductValue(){
        return productPrice * productAmount;
    }

    public void setProductName(String name){
        this.productName = name;
    }

    public void setProductPrice(int price){
        this.productPrice = price;
    }

    public void setProductAmount(int amount){
        this.productAmount = amount;
    }

    final public void callContextMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the name of the product: ");
        this.setProductName(sc.nextLine());
        System.out.println("Input the price of the product: ");
        this.setProductPrice(sc.nextInt());
        System.out.println("Input the amount of the product: ");
        this.setProductAmount(sc.nextInt());
    }

    Product(){
        this.callContextMenu();
    }
}

class Participant{
    private String name;
    private String surname;
    private int age;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    final public void callContextMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the name of the party: ");
        this.setName(sc.nextLine());
        System.out.println("Input the surname of the party: ");
        this.setSurname(sc.nextLine());
        System.out.println("Input the age of the party: ");
        this.setAge(sc.nextInt());
        System.out.println();
    }
}

class Seller extends Participant{
    Seller(){
        System.out.println("Input the seller's information.");
        this.callContextMenu();
    }
}

class Buyer extends Participant{/*Я намеренно два одинаковых конструктора сделал, чтобы добавить предложение о
 разграничении покупателя и продавца.*/
    Buyer(){
        System.out.println("Input the buyer's information.");
        this.callContextMenu();
    }
}

class Deal{
    private String dealName;
    private int dealNumber;
    private Seller seller;
    private Buyer buyer;
    private ArrayList<Product> dealProducts = new ArrayList<>();
    private int dealValue;

    public String getDealName(){
        return dealName;
    }

    public void setDealName(String dealName){
        this.dealName = dealName;
    }

    public int getDealNumber(){
        return dealNumber;
    }

    public void setDealNumber(int dealNumber){
        this.dealNumber = dealNumber;
    }

    public int getDealValue(){
        for (Product dealProduct : dealProducts) {
            dealValue += dealProduct.getProductValue();
        }
        return dealValue;
    }

    public void addProduct(){
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("Press 1 to add a product.\nPress 2 to return to the main menu.");
            input = sc.nextInt();
            if (input == 1) {
                this.dealProducts.add(new Product());
            }
            else{
                System.out.println("Wrong input! Try again please.");
            }
        } while (input != 2);
    }

    @Override
    public String toString(){//heavy shiiiiit (ловлю Макконахи)
        return "Deal name: " + this.getDealName() + "\nDeal number: " + this.getDealNumber() +
                "\nDeal value: " + this.getDealValue() + "\nSeller's name: "  + this.seller.getName() +
                "\nSeller's surname: " + this.seller.getSurname() + "\nSeller's age: " +
                this.seller.getAge() + "\nBuyer's name: "  + this.buyer.getName() +
                "\nBuyer's surname: " + this.buyer.getSurname() + "\nBuyer's age: " +
                this.buyer.getAge();
    }

    final public void callContextMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the name of the deal: ");
        this.setDealName(sc.nextLine());
        System.out.println("Input the number of the deal: ");
        this.setDealNumber(sc.nextInt());
        System.out.println();
    }
    Deal(){
        this.callContextMenu();
        this.seller = new Seller();
        this.buyer = new Buyer();
        this.addProduct();
    }
}

final class DealManager {
    private ArrayList<Deal> deals = new ArrayList<>();

    public void callContextMenu () {
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println();
            System.out.println("Press 1 to add a deal.\nPress 2 to output the deals.\nPress 3 for exit.");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    this.deals.add(new Deal());
                    break;
                case 2:
                    for (Deal deal : deals) {
                        System.out.println(deal);
                    }/*Я не стал добавлять вывод информации о продуктах,
                    чтобы не загромождать аутпут. Если считаешь необходимым, то могу добавить.*/
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Wrong input! Try again please.");
            }
        } while (input != 3);
    }
}

public class MainRealization{
    public static void main (String[] args) {
        DealManager dealmanager = new DealManager();
        dealmanager.callContextMenu();
    }
}
