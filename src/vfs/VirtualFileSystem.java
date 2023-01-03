package vfs;

public class VirtualFileSystem {

	private Folder root;
	private Block[] diskBlocks;
	private int size;
	private int freeBlocks;
	private AllocationMethod control;
	
	VirtualFileSystem(int number, AllocationMethod control){
		this.root = new Folder("root", "");
		this.size = this.freeBlocks = number;
		this.diskBlocks = new Block[this.size];
		this.control = control;
	}
	
	
	private File searchFile(Folder folder, String fullPath) {
		
		// searching the files of the folder
		for(int i=0; i<folder.files.size(); i++) {
			if(fullPath.equals(folder.files.get(i).getFullPath()))
				return folder.files.get(i);
		}
		
		// dfs the remain folders
		File file = null;
		for(int i=0; i<folder.subFolders.size(); i++) {
			file = searchFile(folder.subFolders.get(i), fullPath);
		}
		
		return file;
	}

	private Folder searchFolder(Folder folder, String fullPath) {
		
		if(fullPath.equals(folder.getFullPath()))
			return folder;
		
		// dfs the folders for matching
		Folder f = null;
		for(int i=0; i<folder.subFolders.size(); i++)
		   f = searchFolder(folder.subFolders.get(i), fullPath);
		
		return f;
	}

	public boolean isValidPath(String path) {
		if(searchFolder(root, path) != null)
			return true;
		return false;
	}
}
