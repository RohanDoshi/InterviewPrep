package ElevatorDesign;

public class Elevator implements ElevatorOperations {

	private int numOfFloors;
	private int currentFloor;
	
	public Elevator(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	@Override
	public void addDestination(int floor) {
		
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ElevatorDirection getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElevatorStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
