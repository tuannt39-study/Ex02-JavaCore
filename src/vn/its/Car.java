package vn.its;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("serial")
public class Car implements Serializable{
	
	private int numberPlate;
	private int yearOfManuFacture;
	private String brand;
	
	@SuppressWarnings("resource")
	public ArrayList<Car> addCar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Số lượng xe nhập thêm: ");
		int n = sc.nextInt();
		ArrayList<Car> arr = new ArrayList<Car>();
		for (int i = 1; i <= n; i++) {
			int np = ThreadLocalRandom.current().nextInt(10000, 99999);
			int year = ThreadLocalRandom.current().nextInt(1980, 2012);
			String br = Brand.getRandomBrand().toString();
			Car car = new Car(np, year, br);
			arr.add(car);
		}
		return arr;
	}

	public Car() {
		super();
	}

	public Car(int numberPlate, int yearOfManuFacture, String brand) {
		super();
		this.numberPlate = numberPlate;
		this.yearOfManuFacture = yearOfManuFacture;
		this.brand = brand;
	}

	public int getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(int numberPlate) {
		this.numberPlate = numberPlate;
	}

	public int getYearOfManuFacture() {
		return yearOfManuFacture;
	}

	public void setYearOfManuFacture(int yearOfManuFacture) {
		this.yearOfManuFacture = yearOfManuFacture;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "[numberPlate=" + numberPlate + ", yearOfManuFacture=" + yearOfManuFacture + ", brand=" + brand + "]";
	}
}
