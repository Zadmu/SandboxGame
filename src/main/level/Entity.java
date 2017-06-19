package main.level;

import java.util.HashMap;
import java.util.Map;

import main.level.component.Component;

public class Entity {

	protected Level level;
	protected Map<Class<? extends Component>, Component> components = new HashMap<>();
	
	public void init(Level level){
		this.level = level;
		init();
	}
	
	public void add(Component component){
		components.put(component.getClass(), component);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Component> T getComponent(Class<T> component) {
		// TODO: Error Checking
		return (T) components.get(component);
	}
	
	protected void init(){	
	}
	
	public void update() {
	}
	
	public void render() {
	}
	
}

