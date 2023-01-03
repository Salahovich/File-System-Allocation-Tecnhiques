package vfs;

public interface AllocationMethod {

	public int[] allocate(Block[] blocks, int size);
	public boolean canAllocate(Block[] blocks, int size);
}
