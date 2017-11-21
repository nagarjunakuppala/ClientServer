 class Vehicle{
	static int vin=0000;
	String color="No Color";
	//static block
	static{
		System.out.println("vehicle class static block");
	}
	//instance block
	{
		System.out.println("vehicle class instance block");
	}
	//constructor
	public Vehicle(){
		System.out.println("vehicle class no arg constructor.");
	}
	
	public void methodone(){
		
		System.out.println("Vehicle class method one");
	}
	public String getColor(){
		System.out.println("vehicle class get color method");
		return "no color";	}
	
	public int getVehicleId(){
		System.out.println("Vehicle class vehicle id");
		vin = 00000;
		return vin;
				
	}
	public  String engineType(){
		System.out.println("vehicle class engine type method");
		return "no engine";
	 }
}

class Car extends Vehicle{
	
public int noOfWheels(){
	System.out.println("car class no of wheel method");
	return 4;
}

public   String engineType(){
	System.out.println("car class engine type method");
	return "V6";
 }

public int getVehicleId(){
	//vin = 111111;
	return vin;
			
}
public String getColor(){
	//color = "Blue";
	System.out.println("car class get color method");
	return color;	}


}

class Bus extends Vehicle{
	
public int noOfWheels(){
	System.out.println("bus class no of wheel method");
	return 6;
}

public String engineType(){
	System.out.println("bus class engine type method");
	return "V10";
 }

public int getVehicleId(){
	//vin = 22222;
	return vin;
			
}

public String getColor(){
	//color = "white";
	System.out.println("bus class get color method");
	return color;	}

public static String printMyName(String name){
	return name;
}

public String toString(){
	return "This is a Bus Instance";
	
}

}

final class A{
	
}



public class ExtendsTest extends Vehicle{

	public  int amount=10;
	static{
		System.out.println("HI");
	}
	
	{
	System.out.println(amount);
	}
	
	public static void main(String[] args) {
		/*Bus bus = new Bus();
		System.out.println("bus Id is: "+bus.getVehicleId());
		System.out.println("bus Color is: "+bus.getColor());
		//bus.methodone();
		bus.color="Red";
		bus.vin=55555;
		
		System.out.println("bus Id is: "+bus.getVehicleId());
		System.out.println("bus Color is: "+bus.getColor());
		
		Car car = new Car();
		System.out.println("Car Id :"+car.getVehicleId());
		System.out.println("car Color is: "+car.getColor());
		car.color="Cream";
		car.vin=66666;
	//	System.out.println(amount);
		
		System.out.println("Car Id :"+car.getVehicleId());
		System.out.println("car Color is: "+car.getColor());
		
		System.out.println("bus Id is: "+bus.getVehicleId());*/
		
		Bus b = new Bus();
		System.out.println(b);
		System.out.println(b.printMyName("rekha"));
		
		System.out.println(Bus.printMyName("nag"));
		
		

	}
	public void m1(){
		System.out.println(amount);
	}

}
