package FileSystemDesign;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Directory extends FileEntity {

	private Set<FileEntity> filesDirectoriesSet;
	public Directory(String name, Directory directory) {
		super(name, directory);
		filesDirectoriesSet = new HashSet<>();
	}

	@Override
	int size() {
		int total = 0;
		Iterator<FileEntity> iterator = filesDirectoriesSet.iterator();
		while(iterator.hasNext())
			total += iterator.next().size();
		return total;
	}
	
	public boolean delete(FileEntity file) {
		if(filesDirectoriesSet.contains(file)) {
			filesDirectoriesSet.remove(file);
			return true;
		}
		return false;
	}
	
	public boolean add(FileEntity file) {
		if(file == null)
			return false;
		
		if(filesDirectoriesSet.contains(file))
			return false;
		
		filesDirectoriesSet.add(file);
		return true;
	}
	
	public int numberOfFiles() {
		Iterator<FileEntity> iterator = filesDirectoriesSet.iterator();
		int num = 0;
		while(iterator.hasNext()) {
			FileEntity file = iterator.next();
			if(file instanceof File) 
				num++;
			else {
				num += ((Directory)file).numberOfFiles();
			}
		}
		return num;
	}

}
