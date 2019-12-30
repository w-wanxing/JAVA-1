package biz;

import java.util.Scanner;

import dao.StudentDao;
import entity.IEntity;
import entity.Student;
import view.*;

public class StudentBiz {
	StudentDao studentDao;
	private Student student;
	/*
	 * �û���¼
	 */
	public void login(String studentNo, String studentPassword) {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("�û�������");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			studentDao = StudentDao.getInstance();
			student = (Student)studentDao.getEntity(studentNo); 
			System.out.println(student.getStudentName()+"ͬѧ��ã�");
			MainUI.show();
		} else {
			System.out.println("���벻��ȷ");
			MainUI.show();
		}

	}
	/*
	 * �û�ע�ᣬҵ���߼�ʵ��
	 */
	public void register(String studentNo,
			            String firstPassword, 
						String secondPassword,
						String studentName, 
						String studentGender, 
						int studentAge, 
						String studentDepartment ) {
		if(firstPassword.equals(secondPassword)) {   //�жϵ�һ����ڶ�������������ǲ���һ��
			student = new Student();
			student.setStudentNo(studentNo);  //��ѧ����Ϣ����
			student.setStudentPassword(firstPassword);
			student.setStudentName(studentName);
			student.setStudentGender(studentGender);
			student.setStudentAge(studentAge);
			student.setStudentDepartment(studentDepartment);
			studentDao = StudentDao.getInstance();
			studentDao.insert(student);
			System.out.println(student.getStudentName()+"ͬѧע��ɹ���");
			save();
			MainUI.show();
		}else {
			MainUI.show();
		}
	}
	/*
	 * �û��޸�����
	 */
	public void modify(
		String studentNo, 
		String passwd,
		String firstPasswd, 
		String secondPasswd ){
		
		   studentDao = StudentDao.getInstance();
		   student = (Student)studentDao.getEntity(studentNo);      //��ѧ�����˺�����ȡ���ѧ������Ϣ
		   //System.out.println(student.getStudentPassword());
		   if(passwd.equals(student.getStudentPassword())) {        //�ж���������������ѧ���������ǲ���һ��
			
				if(firstPasswd.equals(secondPasswd)) {              //�жϸ��µ����������������Ƿ�һ��
					student.setStudentPassword(firstPasswd);
					System.out.println("�޸ĳɹ�!");
					save();
					//IEntity ientity = studentDao.getEntity(studentNo);
					
					MainUI.show(); 
					}else {
						System.out.println("�������벻һ�������������룡");
						ModifyPasswordUI.show();
					}
				}else {
					Scanner scanner = new Scanner(System.in);
					System.out.println("ԭ�����������");
					System.out.println("1-���������棻2-�޸�����");
					System.out.println("������ѡ��");
					
					String stu = scanner.nextLine();
					if("1".equals(stu)||"2".equals(stu)) {
						if("1".equals(stu)) {
							MainUI.show();
						}else {
							ModifyPasswordUI.show();
						}
					}else {
						System.out.println("������1��2��");
					}
				}
		}
	private void save() {
		StudentDao dbutil = StudentDao.getInstance();
		dbutil.update();
	}
}

