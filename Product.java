import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * Student Name: Can Gok, id: 150118014
 * Product class of the program
 */

public class Product {
	
	private String productName;
	
	private Calendar saleDate;
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private double price;
	
	public Product(String sName, Calendar sDate, double price) {
		this.saleDate = sDate;
		this.productName = sName;
		this.saleDate = sDate;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", transactionDate=" + dateFormat.format(saleDate.getTime()) + ", price=" + price + "]";
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Calendar getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Calendar saleDate) {
		this.saleDate = saleDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
