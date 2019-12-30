package dao;
import entity.Course;
import entity.IEntity;
import entity.Student;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Set;

public class CourseDao implements IDao {
	
	private static CourseDao instance;
	private HashMap<String, Course> courses;
	private Course course;
	private  FileInputStream cfs;
	public FileOutputStream cfos;
	private Course entity;
	
	private CourseDao() {
		courses = new HashMap<String, Course>();
		course = new Course();
		getCoursesFromInputStream("course.dat");
	}
	
	private void getCoursesFromInputStream(String isName) {
		try {
		    cfs = new FileInputStream(isName);
			byte[] content = new byte[1024];
			int i=0;
			int conInteger = 0;
			while(true) {
				try {
					conInteger = cfs.read();
				} catch(IOException e) {
					e.printStackTrace();
				}
				if(-1 == conInteger) {
					break;
				}else if('\r' == (char)conInteger || '\n' == (char)conInteger) {
					try {
						this.processCourseString(new String(content,"GBK").trim());
						i=0;
					} catch(UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					continue;
				}else {
					content[i] = (byte)conInteger;
					i++;
				  }
			     }
		     } catch(Exception e) {
				e.printStackTrace();
		 }
      }
	
	public void processCourseString(String userString) {
		String [] userFields = userString.split(",");
		Course cs = new Course();
		cs.setCourseNo(userFields[0]);
		cs.setCourseName(userFields[1]);
		cs.setCourseGrade(Integer.parseInt(userFields[2]));
		
		courses.put(cs.getCourseNo(), cs);
	}	

	@Override
	public void insert(IEntity entity) {
		// TODO Auto-generated method stub
		Course cs = (Course)entity;
		courses.put(cs.getCourseNo(), cs);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		Course cs2 = (Course)entity;
		courses.remove(cs2.getCourseNo(), cs2);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Set<String> csSet = courses.keySet();
		StringBuffer uStringBuffer = new StringBuffer();
		for(String courseNo:csSet) {
			Course cs = (Course)courses.get(courseNo);
			
			String uString = cs.getCourseNo() + ","
					+ cs.getCourseName() + ","
					+ cs.getCourseGrade() + "\r\n";
			uStringBuffer.append(uString);
		}
		putCoursesToFile(uStringBuffer.toString(),"course.dat");
	}
	
	private void putCoursesToFile(String uString,String osName) {
		try {
			cfos = new FileOutputStream(osName);
			try {
				cfos.write(uString.getBytes("GBK"));
			}catch(UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static CourseDao getInstance() {
		if(instance == null) {
			synchronized(CourseDao.class) {
				if(instance == null) {
					instance = new CourseDao();
					return instance;
				}
			}
		}
		return instance;
	}

	@Override
	public HashMap<String, entity.IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return courses.get(Id);
	}

}
