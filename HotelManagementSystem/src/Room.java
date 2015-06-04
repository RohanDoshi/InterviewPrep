import java.util.List;


public class Room {
	private int roomNum;
	private RoomType roomType;
	private String description; 
	List<RoomPricePeriod> list;
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public List<RoomPricePeriod> getList() {
		return list;
	}
	public void setList(List<RoomPricePeriod> list) {
		this.list = list;
	}
	
}
