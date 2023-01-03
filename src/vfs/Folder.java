package vfs;

import java.util.ArrayList;

public class Folder {

	public ArrayList<File> files;
	public ArrayList<Folder> subFolders;
	private String name;
	private String path;
	private String fullPath;
	
	Folder(String name, String path){
		this.name=  name + "/";
		this.path = path;
		this.fullPath = this.path + this.name;
		this.files = new ArrayList<File>();
		this.subFolders = new ArrayList<Folder>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getFullPath() {
		return this.fullPath;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public boolean deleteFile(String fileName) {
		for(int i=0; i<this.files.size(); i++) {
			if(this.files.get(i).getName().equals(fileName)) {
				this.files.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteFolder(String fileName) {
		for(int i=0; i<this.subFolders.size(); i++) {
			if(this.subFolders.get(i).getName().equals(fileName)) {
				this.subFolders.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean addFile(File file) {
		for(int i=0; i<this.files.size(); i++) {
			if(file.getName().equals(this.files.get(i).getName()))
				return false;
		}
		this.files.add(file);
		return true;
	}
	
	public boolean addFolder(Folder folder) {
		for(int i=0; i<this.subFolders.size(); i++) {
			if(folder.getName().equals(this.subFolders.get(i).getName()))
				return false;
		}
		this.subFolders.add(folder);
		return true;
	}
	
	public String displayData() {
		StringBuilder data = new StringBuilder();
		
		for(int i=0; i<this.files.size(); i++)
			data.append(this.files.get(i).getName() + "\n");
		
		for(int i=0; i<this.subFolders.size(); i++)
			data.append(this.subFolders.get(i).getName() + "\n");
		
		return data.toString();
	}
}
