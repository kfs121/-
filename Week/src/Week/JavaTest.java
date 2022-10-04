package Week;

import java.util.Scanner;

enum Week {
	MON, TUE, WED, THU, FRI, SAT, SUN;

}
public class JavaTest {

	public static void main(String[] args) {
		String inputWeek;
		
		Scanner sc = new Scanner(System.in);
		Week week;
		while(true) {
			System.out.print("������ �Է��ϼ���: ");
			inputWeek = sc.nextLine();
			
			try {
				week = Week.valueOf(inputWeek);
				
				switch(week) {
				case MON:
					System.out.println("�ְ�ȸ�ǰ� �ֽ��ϴ�.");
					break;
					
				case TUE:
					System.out.println("ȭ�����Դϴ�.");
					break;
					
				case WED:
					System.out.println("������� �����ϴ� �� �Դϴ�.");
					break;
					
				case THU:
					System.out.println("������Դϴ�.");
					break;
					
				case FRI:
					System.out.println("�ݿ����Դϴ�.");
					break;
					
				case SAT:
					System.out.println("������Դϴ�.");
					break;
					
				case SUN:
					System.out.println("������ �����Դϴ�.");
					break;
				}
			}
			catch (IllegalArgumentException e){
				if(inputWeek.equals("XXX")) {
					System.out.println("���α׷��� �����մϴ�.");
					return;
				}else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			}
			
			System.out.println();
			
		}

	}

}


