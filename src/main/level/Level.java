package main.level;

import java.util.ArrayList;
import java.util.List;

public class Level {

	public List<Entity> entities = new ArrayList<Entity>();
	
	public void add(Entity entity) {
		entity.init(this);
		entities.add(entity);
	}
	
	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
	}
	
	public void render() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render();
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findEntity(Class<T> type) {
		for (Entity entity : entities){
			if (entity.getClass().equals(type)) {
				return (T)entity;
			}
		}
		return null;
	}
	
}
