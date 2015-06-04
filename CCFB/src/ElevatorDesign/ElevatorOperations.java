package ElevatorDesign;

public interface ElevatorOperations {

	void addDestination(int floor);
	void moveUp();
	void moveDown();
	ElevatorDirection getDirection();
	ElevatorStatus getStatus();
	
}
