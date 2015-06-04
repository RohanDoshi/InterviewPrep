package FileSystemDesign;

public class Drive {
	private String name;
	private Directory rootDirectory;
	private double driveSize;
	
	public Drive(int driveSize) {
		this.rootDirectory = new Directory("/", null);
		this.driveSize = driveSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int directorySize() {
		return this.rootDirectory.size();
	}
	
	public int numberOfFiles() {
		return this.rootDirectory.numberOfFiles();
	}
	
	public double freeSize() {
		return this.driveSize - directorySize();
	}
}
