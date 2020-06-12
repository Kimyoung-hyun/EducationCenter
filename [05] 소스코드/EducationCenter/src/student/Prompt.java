package student;

import java.util.Scanner;

public class Prompt {
	
	public void runPrompt(){
		
		Scanner scan = new Scanner(System.in);
		MyCalendar c = new MyCalendar();
		
		int year;
		int month;
		int num;
		
		while(true){
				
			System.out.print("연도를 입력하세요 : ");
			year = scan.nextInt();
			scan.skip("\r\n");
			
			
			System.out.print("달을 입력하세요 : ");
			month = scan.nextInt();
			scan.skip("\r\n");
			
			if (month < 1 || month > 12){
				System.out.println("잘못된 월을 입력했습니다.");
				break;
			}
			
			System.out.println();
			// 입력받은 년, 월에 맞는 달력 호출
			c.printCalendar(year, month);
			
			while (true) {
				
				System.out.println("1. <<        2. >>");
				System.out.println("3. exit");
				System.out.print("번호 : ");
				num = scan.nextInt();
				scan.skip("\r\n");
				System.out.println();
				
				if (num == 1) { // 지난 달
					
					month = month - 1;
					if (month == 0) {
						
						month = 12;
						year = year - 1;
						
					}
					c.printCalendar(year, month);
					System.out.println();
					continue;
					
				} else if (num == 2) { // 다음 달
					
					month = month + 1;
					if (month == 13) {
						
						month = 1;
						year = year + 1;
						
					}
					c.printCalendar(year, month);
					System.out.println();
					continue;
					
				} else if (num == 3) { // 종료
					
					break;
					
				} else { // 그 외 번호 입력 시
					
					System.out.println("잘못된 번호입니다.");
					continue;
					
				}
				
			}
			
			break;
				
		}
		
		System.out.println("달력 종료");
		System.out.println();
	}
	
}
