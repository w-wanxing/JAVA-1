package biz;

import dao.StudentDao;
import entity.Student;
import view.MainUI;
import java.util.HashMap;
import java.util.Scanner;
import dao.*;
import entity.*;

public class SCBiz {
	StudentDao studentDao;
	private Student student;
	
	public void judge(String studentNo,String studentDepartment){
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
			
		if(studentDepartment.equals(student.getStudentDepartment())) {
			System.out.println("1-ѡ�Σ�2-��ѡ��3-ѡ������鿴��4-����������");
			System.out.println("���������ѡ��");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();
			
			if("1".equals(s) || "2".equals(s)) {
			switch (s) {
			case "1": //ѡ�β���
			   addcourse(studentNo,studentDepartment);
			    break;
			case "2": //��ѡ����
			    exitRace();
			    break;
			}
		  }else if("3".equals(s)) {
			  show();
		  }else if("4".equals(s)) {
			  MainUI.show(); 
		  }
		}else {
			System.out.println("��ע�⣬ѧԺ��д����");
		}
	}
	/*
	 * ѡ�β���
	 */
	public void addcourse(String studentNo,String studentDepartment) {
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if(studentDepartment.equals(student.getStudentDepartment())) {
			
		}
	}
	/*
	 * ��ѡ����
	 */
	public void exitRace() {
		
	}
	/*
	 * ѡ������鿴
	 */
	public void show() {
		
	}
	private void save() {
		StudentDao dbutil = StudentDao.getInstance();
		dbutil.update();
	}
}
