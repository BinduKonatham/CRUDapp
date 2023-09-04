package controller;
import java.sql.SQLException;
import java.util.Scanner;
import model.Login;
import dao.LoginDAO;
import model.Product;
import dao.ProductDAO;
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int choice,option;
		Login l=new Login();
		LoginDAO ldao=new LoginDAO();
		Product p=new Product();
		ProductDAO pdao=new ProductDAO();
		do {
			System.out.println("1. Admin\n2. Agent\n3. Exit\n**********************************************************************************************************************\nEnter your choice:");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Admin Login:\n");
				System.out.println("Enter the user name");
				String username=sc.next();
				System.out.println("Enter the password");
				String password=sc.next();
				l.setUsername(username);
				l.setPassword(password);
				if(ldao.checkCredentials(l))
				{
					System.out.println("Login successful!!!");
					
					do {
					System.out.println("1. Add products\n2. Display products\n3. Update products\n4. Delete products\n5. Logout\n**********************************************************************************************************************\nEnter your choice:");
				    option=sc.nextInt();
				    switch(option) {
				    case 1:
				    	System.out.println("Add Product:");
				    	System.out.println("Enter Product ID:");
				    	String prodId=sc.next();
				    	sc.nextLine();
				    	System.out.println("Enter Product Name:");
				    	String prodName=sc.nextLine();
				    	System.out.println("Enter Minimum Selling Quantity:");
				    	int sellQuantity=sc.nextInt();
				    	System.out.println("Enter Price:");
				    	int prodCost=sc.nextInt();
				    	System.out.println("Enter Quantity to be needed:");
				    	int stock=sc.nextInt();
				    	p.setProdId(prodId);
				    	p.setProdName(prodName);
				    	p.setSellingQuantity(sellQuantity);
				    	p.setProdCost(prodCost);
				    	p.setStock(stock);
				    	pdao.addProduct(p);
				    	System.out.println("Product added successfully!!!\n");
				    break;
				    case 2:
				    	System.out.println("Products List:\n");
				    	pdao.display();
				    	break;
				    case 3:
				    	System.out.println("Update Products:\n");
				    	System.out.println("Enter the product ID to update:");
				    	String updateProdId=sc.next();
				    	p.setProdId(updateProdId);
				    	sc.nextLine();
				    	System.out.println("Enter updated product name:");
				    	String updatedProdName =sc.nextLine();
				    	System.out.println("Enter the updated minimum sell quantity");
	        			int updatedMinSellQuantity = sc.nextInt();
	        			System.out.println("Enter the updated price");
	        			int updatedPrice = sc.nextInt();
	        			System.out.println("Enter the updated quantity");
	        			int updatedQuantity = sc.nextInt();

	        		    // Set the updated values in the Product object
	        			p.setProdName(updatedProdName);
	        			p.setSellingQuantity(updatedMinSellQuantity);
	        			p.setProdCost(updatedPrice);
	        			p.setStock(updatedQuantity);
                        System.out.println("Updated Successfully!!");
	        			// Now call the update method
	        			pdao.updateProduct(p);
	        			break;
				    case 4:
				    	System.out.println("Delete Products:\n");
        			    System.out.println("Enter the Product ID to delete:");
        			    String deleteProductId = sc.next();
        			    // Set the prodId for the Product object
        			    p.setProdId(deleteProductId);
        			    System.out.println("Product Deleted Successfully!!");
        			    pdao.deleteProduct(p);
        			    break;
				    case 5:
				    	System.out.println("Logout");
				    	break;
				    default:System.out.println("Wrong Choice!! Try again...");
				    	
				    }
					}while(option!=5);
				}
				else
					System.out.println("Incorrect credentials.Please try again later!");
				break;
			case 2:
				System.out.println("Agent Login:\n");
				System.out.println("Enter the user name");
				String username1=sc.next();
				System.out.println("Enter the password");
				String password1=sc.next();
				l.setUsername(username1);
				l.setPassword(password1);
				if (ldao.checkCredentials(l))
				{
					System.out.println("Login successful!!!");
					
					do {
					System.out.println("1. Display products\n2. Logout\n**********************************************************************************************************************\nEnter your choice:");
				    option=sc.nextInt();
				    switch(option) {
				    case 1:
				    	System.out.println("Products List:\n");
				    	pdao.display();
				    	break;
				    case 2:
				    	System.out.println("Logout");
				    }
					}while(option!=2);
				}
				else
					System.out.println("Incorrect credentials.Please try again later!");
				break;
			case 3:System.out.println("Exit");
			    break;
			default:System.out.println("Wrong Choice!! Try again...");
			}
		}while(choice!=3);
		sc.close();
	}

}
 
