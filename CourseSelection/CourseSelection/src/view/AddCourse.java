package view;

import java.util.Scanner;

import biz.CourseBiz;

public class AddCourse {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addcourse();
	}
	public static void addcourse() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������γ̺ţ�");
		String courseNo = scanner.nextLine();
		System.out.println("������γ����ƣ�");
		String courseName = scanner.nextLine();
		System.out.println("������ɼ���");
		int courseGrade = Integer.parseInt(scanner.nextLine());
		CourseBiz cb = new CourseBiz();
		cb.addCourse(courseNo,
				courseName, 
				courseGrade);
	}
}
