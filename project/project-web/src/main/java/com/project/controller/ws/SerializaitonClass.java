package com.project.controller.ws;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializaitonClass {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.firstName = "Vivekanand";
		emp.lastName = "Gautam";
 
		try {
			FileOutputStream fileOut = new FileOutputStream("C:/Users/admin/Desktop/src/employee.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(emp);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in C:/Users/admin/Desktop/src/employee.txt file");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

}
