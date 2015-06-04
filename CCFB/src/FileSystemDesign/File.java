package FileSystemDesign;

public class File extends FileEntity {

	private int size;
	private String content;
	public File(String name, Directory directory, int size) {
		super(name, directory);
		this.size = size;
	}

	@Override
	int size() {
		return this.size;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
