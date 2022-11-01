package FileIOForTest;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

interface SELECT_MENU
{
    int INPUT=1, PRINT=2, EXIT=3;
    int SELECT_COUNT = 4;
}

public class FileIOForTest {
	private final static String FILE_NAME = "Person.bin";
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<Person>();
		int select;
		while(true) {
			printMenu();
			select = scan.nextInt();
			scan.nextLine();
			
			switch(select) {
				case SELECT_MENU.INPUT:
					try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
						people.add(getPerson());
						out.writeObject(people);
						break;
					} catch(IOException e) {
						e.printStackTrace();
					}
				
				case SELECT_MENU.PRINT:
					ArrayList<Person> readPeople = null;
					try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))){
						while(true) {
							try {
								readPeople = (ArrayList<Person>)in.readObject();
							} catch(EOFException e) {
								break;
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
						}
						System.out.printf("�� %d�� �Դϴ�.\n", readPeople.size());
						for(int i = 0; i < readPeople.size(); i++) {
							readPeople.get(i).showPersonInfo();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
					
				case SELECT_MENU.EXIT:
					System.out.println("���α׷��� �����մϴ�.");
					return;	
			}
		
		}
		
		
	}
	
	public static void printMenu() {
		System.out.println("== �޴� ==");
		System.out.println("1. �Է�\n2. ���\n3. ����");
		System.out.print("������ �ϰڽ��ϱ�? ");
	}
	
	public static Person getPerson() {
		String name;
		int age;
		System.out.print("�̸� : ");
		name = scan.nextLine();
		
		System.out.print("���� : ");
		age = scan.nextInt();
		
		scan.nextLine();
		
		return new Person(name, age);
	}
}

class Person implements Serializable{
	private String name;
	private int age;
	private static int count = 0;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void showPersonInfo() {
		System.out.printf("�̸� : %s\n",name);
		System.out.printf("���� : %d\n",age);
	}
	
	public static int getCount() {
		return count;
	}
}