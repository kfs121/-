package parse;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		while(true) {
			System.out.print("�Է��Ͻÿ�(����:Z) ");
			input = sc.nextLine();
			try {
				Integer.parseInt(input);
				System.out.println("�����Դϴ�!!");
			}
			catch(NumberFormatException e){
				if(input.equals("Z")) {
					System.out.println("���α׷��� �����մϴ�!!");
					return;
				}
				
				System.out.println("�����Դϴ�!!");
			}
		}

	}

}
