package vn.its;

import java.util.Random;

public enum Brand {
	
	TOYOTA, BMW, HUYNDAI;
	
	static Brand getRandomBrand() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
	
	public static void main(String[] args) {
		System.out.println(Brand.getRandomBrand().toString());
	}
	
}