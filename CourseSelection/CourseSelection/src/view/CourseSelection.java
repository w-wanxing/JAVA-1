package view;
import java.*;
import java.util.Scanner;
import biz.*;
public class CourseSelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginUI.show();
		//show();
	}

	public static void show() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入学号：");
		String studentNo = scanner.nextLine();
		System.out.println("请输入学院：");
		String studentDepartment = scanner.nextLine();
		SCBiz scbiz = new SCBiz();
		scbiz.judge(studentNo, studentDepartment);
	}

}
