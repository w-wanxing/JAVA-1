package view;

import java.util.Scanner;

public class MainUI {
	
	public static void show() {
		System.out.println("1-ע�᣻2-�޸����룻3-ע��γ̣�4-ѡ�Σ�5-��¼��0-�˳�");
		System.out.println("���������ѡ��");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		if("1".equals(option)||"2".equals(option)||"3".equals(option)||"4".equals(option)||"5".equals(option)) {
		switch (option) {
		case "1":
			RegisterUI.show();
			break;
		case "2":
			ModifyPasswordUI.show();
			break;
		case "3":
			AddCourse.addcourse();	
		case "4":
			CourseSelection.show();
			break;
		case "5":
			LoginUI.show();
			break;
			}
		}else if("0".equals(option)) {
				System.out.println("�˳�����ϵͳ");
			}
	}
}
