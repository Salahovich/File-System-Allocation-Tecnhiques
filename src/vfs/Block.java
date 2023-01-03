package vfs;

public class Block {

	public boolean allocated;
	public Block next;
	
	Block() {}
	
	public boolean isFree() {
		return !allocated;
	}
	
	public void release() {
		this.allocated = false;
	}
	
	public void allocate() {
		this.allocated = true;
	}
	
	public String toString() {
		return allocated?"1":"0";
	}
}
