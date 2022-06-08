package ProductManage;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductManage {
    List<Product> products = new ArrayList<>();
    ValiDate valiDate = new ValiDate();

    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    {readAndWriteFile.readFile(products);}

    public void productManageMenu(){
        System.out.println("Menu :");
        System.out.println("1. show product list");
        System.out.println("2. Add new product");
        System.out.println("3. Edit product");
        System.out.println("4. delete product");
        System.out.println("5. sort follow price");
        System.out.println("6. find max of price");
        System.out.println("7. read from file");
        System.out.println("8. write in file");
        System.out.println("9. Exit");

        int choice = valiDate.choice("choice");

        switch (choice){
            case 1:
                showProductList();
                break;
            case 2:
                addNewProduct();
                break;
            case 3:
                editProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                sortFllowPrice();
                break;
            case 6:
                findFllowMaxPrice();
                break;
            case 7:
                readFromFile();
                break;
            case 8:
                writetoFile();
                break;
            case 9:
                System.exit(0);
        }
    }

//    case1:
    public void showProductList(){
        System.out.println("Product list:");
        for (Product pt: products) {
            System.out.println(pt);
        }
    }

//    case 2
    public void addNewProduct(){
        products.add(creatNewProduct());
    }

//    case 3:
    public void editProduct() {
        String id = valiDate.importString("id of editProduct");
        for (int i = 0; i < products.size(); i++) {
            if (id.equals(products.get(i).getId())) {
                products.set(i, creatNewProduct());
                break;
            } else {
                System.out.println("this is not this ID in list");
                productManageMenu();
            }
        }
    }

//    case 4
    public void deleteProduct() {
        String id = valiDate.importString("id of deleteProduct");
        for (int i = 0; i < products.size(); i++) {
            if (id.equals(products.get(i).getId())) {
                products.remove(i);
                break;
            } else {
                System.out.println("this is not this ID in list");
                productManageMenu();
            }
        }
    }

//    case 5
    public void sortFllowPrice(){
        Collections.sort(products);
    }

//    case 6
    public void findFllowMaxPrice(){
        Collections.sort(products);
        System.out.println("MaxPriceProduct is " + products.get(products.size()-1).toString());
    }

//    case 7
    public void readFromFile(){
        readAndWriteFile.readFile(products);
    }

//   case 8
    public void writetoFile(){
        readAndWriteFile.writeFile(products);
    }





    public Product creatNewProduct(){
        System.out.println("Enter information off new product:");
        String id = valiDate.importString("id");
        for (int i = 0; i < products.size(); i++) {
            if (id.equals(products.get(i).getId())){
                System.out.println("there are this product in list, please choice other id");
                creatNewProduct();
            }
        }
        String name = valiDate.importString("name");
        double price = valiDate.importDouble("price");
        double amount= valiDate.importDouble("amount");
        String describe= valiDate.importString("describe");

        Product product = new Product(id,name,price,amount,describe);
        return product;
    }
}
