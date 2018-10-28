package a2;

public class File extends FileDirectory{
	
	private String name;
	private String content;
	
	public File(String name, Directory parent){
		super(name, parent);
		this.content = "";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
}
