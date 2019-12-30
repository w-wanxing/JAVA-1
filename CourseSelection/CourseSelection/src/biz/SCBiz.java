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
			System.out.println("1-选课；2-退选；3-选课情况查看；4-返回主界面");
			System.out.println("请输入你的选择：");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();
			
			if("1".equals(s) || "2".equals(s)) {
			switch (s) {
			case "1": //选课操作
			   addcourse(studentNo,studentDepartment);
			    break;
			case "2": //退选操作
			    exitRace();
			    break;
			}
		  }else if("3".equals(s)) {
			  show();
		  }else if("4".equals(s)) {
			  MainUI.show(); 
		  }
		}else {
			System.out.println("请注意，学院填写错误！");
		}
	}
	/*
	 * 选课操作
	 */
	public void addcourse(String studentNo,String studentDepartment) {
		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if(studentDepartment.equals(student.getStudentDepartment())) {
			
		}
	}
	/*
	 * 退选操作
	 */
	public void exitRace() {
		
	}
	/*
	 * 选课情况查看
	 */
	public void show() {
		
	}
	private void save() {
		StudentDao dbutil = StudentDao.getInstance();
		dbutil.update();
	}
}
