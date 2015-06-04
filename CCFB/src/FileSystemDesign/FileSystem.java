package FileSystemDesign;

import java.util.Hashtable;
import java.util.Map;

public class FileSystem {
	private Map<String,Drive> mapDrives;
	public FileSystem() {
		this.mapDrives = new Hashtable<>();
	}
	
	public void addDrive(Drive drive) {
		if(drive == null)
			return;
		
		mapDrives.put(drive.getName(), drive);
	}
	
}
