package view;
import biz.*;
import dao.SCDao;
import dao.StudentDao;
import entity.SC;
import entity.Student;

import java.*;
import java.util.HashMap;
import java.util.Scanner;
public class ModifyPasswordUI {
	public static void show() {
		 
		    StudentDao studentDao;
		    HashMap<String, Student> students;
			Student student;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������˺ţ�");
		String studentNo = scanner.nextLine();
		System.out.println("���������룺");
		String password = scanner.nextLine();
		System.out.println("�����������룺");
		String firstPasswd = scanner.nextLine();
		System.out.println("���ٴ��������룺");
		String secondPasswd = scanner.nextLine();
		StudentBiz sc = new StudentBiz();
		sc.modify(
			studentNo,
			password,
			firstPasswd,
			secondPasswd);
		    
	}    
}
