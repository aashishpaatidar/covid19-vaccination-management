package io.covid19vms.dto;

public class CentreListDTO {
	private int id;
	private String centreName;
	private int capacity;
	private int inventory;

	public CentreListDTO(int id, String centreName, int capacity, int inventory) {
		super();
		this.id = id;
		this.centreName = centreName;
		this.capacity = capacity;
		this.inventory = inventory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

}
