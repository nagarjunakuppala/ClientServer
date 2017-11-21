abstract class Book{
	public int bookID;
	public double price;
	
	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public abstract double getCost();
	
	public String toString(){
		return "Book ID: "+bookID+" price is:"+price+" Cost of the Book  is: "+getCost();
	}
	
}

class Book1 extends Book{

	public double getCost() {
		return price+((price*10)/100);
	}
	
}
class Book2 extends Book{
	public static double shippingCharge = 2.5;
	public double getCost() {
		return price+((price*10)/100)+shippingCharge;
	}
	
}
class Book3 extends Book{
	private double weight;
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double shippingCharge =(getWeight()*5)/100;
	public double getCost() {
		return price+((price*10)/100)+shippingCharge;
	}
	
}

public class TestRunner{
	
	public static void main(String[] args) {
		
		Book[] books = new Book[5];
		for(int i=0;i<3;i++){
			books[i] = new Book1();
		}
		books[0].bookID = 123;
		books[0].price = 10;
		books[1].bookID = 234;
		books[1].price = 12;
		books[2].bookID = 345;
		books[2].price = 14;
		System.out.println(books[0]);
		System.out.println(books[1]);
		System.out.println(books[2]);
		books[3]=new Book2();
		books[3].bookID=456;
		books[3].price=13;
		System.out.println(books[3]);
		books[4]=new Book3();
		books[4].bookID=567;
		books[4].price=13;
		System.out.println(books[4]);
		
	}
}
	