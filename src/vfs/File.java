package vfs;

public class File {

	private Block[] fileBlocks;
	private int blockSize;
	private String name;
	private String path;
	private String fullPath;
	
	File(String name, String path){
		this.name = name;
		this.path = path;
		this.fullPath =  this.path + this.name;
	}
	
	public void allocateBlocks(Block[] blocks) {
		this.fileBlocks = blocks;
		this.blockSize = blocks.length;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getFullPath() {
		return this.fullPath;
	}
	
	public String getBlocks() {
		StringBuilder stringBlocks = new StringBuilder();
		for(int i=0; i<this.blockSize; i++)
			stringBlocks.append(this.fileBlocks[i] + " ");
		
		return stringBlocks.toString();
	}
}
