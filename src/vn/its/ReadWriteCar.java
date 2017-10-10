package vn.its;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReadWriteCar {

	// Kiểm tra file có object chưa
	static boolean hasObject(File lf) {
		boolean check = true;
		try {
			FileInputStream fis = new FileInputStream(lf);
			ObjectInputStream ois = new ObjectInputStream(fis);
			if (ois.readObject() == null) {
				check = false;
			}
			ois.close();
		} catch (FileNotFoundException e) {
			check = false;
		} catch (IOException e) {
			check = false;
		} catch (ClassNotFoundException e) {
			check = false;
			e.printStackTrace();
		}
		return check;
	}

	// Ghi object vào file
	static void write() {
		try {
			File lf = new File("day2");
			ObjectOutputStream oos = null;
			FileOutputStream fos;

			// File chưa tồn tại thì tạo file và ghi bình thường
			if (!lf.exists()) {
				fos = new FileOutputStream(lf);
				oos = new ObjectOutputStream(fos);
			} else {

				// File đã tồn tại nhưng chưa có object nào thì ghi bình thường
				if (!hasObject(lf)) {
					fos = new FileOutputStream(lf);
					oos = new ObjectOutputStream(fos);
				} else {

					// File đã tồn tại, có object rồi thì ghi thêm xuống dưới
					fos = new FileOutputStream(lf, true);
					oos = new ObjectOutputStream(fos) {
						protected void writeStreamHeader() throws IOException {
							reset();
						}
					};
				}
			}
			Car car = new Car();
			ArrayList<Car> ar = car.addCar();
			for (Car a : ar) {
				a.toString();
				oos.writeObject(a.toString());
			}
			oos.close();
			System.out.println("Ghi xong");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Đọc object từ file
	static void read() {
		try {
			File lf = new File("day2");
			ObjectInputStream ois = null;
			FileInputStream fis;
			
			// File chưa tồn tại thì thông báo
			if (!lf.exists()) {
				System.out.println("File không tồn tại");
			} else {
				
				// File đã tồn tại, thì đọc file
				fis = new FileInputStream(lf);
				ois = new ObjectInputStream(fis);
				int i = 1;
				while (true) {
					Object s = ois.readObject();
					System.out.println("Car" + i++ + " - " + s.toString());
				}
			}
			
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
		}
	}
}
