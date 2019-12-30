package dao;
import java.util.HashMap;
import entity.*;

public class SCDao implements IDao {

	private static SCDao instance;
	private HashMap<String, Course> courses;
	private Student course;
	
	@Override
	public void insert(IEntity entity) {
		Course cs = (Course)entity;
		courses.put(cs.getCourseNo(), cs);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String, IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntity getEntity(String Id) {
		// TODO Auto-generated method stub
		return courses.get(Id);
	}

}
