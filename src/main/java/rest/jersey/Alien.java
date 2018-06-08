package rest.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {

	private String name;
	private int points;
	private int Id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	//Para ver en el log el objeto JSON
	
	@Override
	public String toString() {
		return "Alien [name=" + name + ", points=" + points + ", Id=" + Id + "]";
	}
	
}
