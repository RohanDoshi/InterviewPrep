package FileSystemDesign;

public abstract class FileEntity {
	protected long created;
	protected long lastModified;
	protected long lastAccessed;
	protected String name;
	protected String permissions;
	protected Directory parent;
	protected boolean isHidden;
	
	public FileEntity(String name, Directory directory) {
		this.name = name;
		this.parent = directory;
		this.created = System.currentTimeMillis();
		this.lastAccessed = System.currentTimeMillis();
		this.lastModified = System.currentTimeMillis();
	}
	
	abstract int size();
	
	public boolean delete() {
		if(parent == null)
			return false;
		return parent.delete(this);
	}
	
	public String getFullPath() {
		if(parent == null)
			return name;
		
		return parent.getFullPath() +"/"+name;
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public long getLastModified() {
		return lastModified;
	}

	public void setLastModified(long lastModified) {
		this.lastModified = lastModified;
	}

	public long getLastAccessed() {
		return lastAccessed;
	}

	public void setLastAccessed(long lastAccessed) {
		this.lastAccessed = lastAccessed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
	
}
