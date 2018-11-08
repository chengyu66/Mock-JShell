package a2;
/**
 * The class represents the file.
 * It has the ability as what the file can do in the computer
 * It can collect the content
 */
public class File extends FileDirectory{
	
	private String content;
	
	/**
	   * the constructor of file
	   * initialize content
	   * 
	   * @param None
	   * @return the String path of this FileDirectory.
	   */
	public File(String name, Directory parent){
		super(name, parent);
		this.content = "";
	}

	/**
	   * output the content of the file
	   * 
	   * @param None
	   * @return the String content
	   */
	public String getContent() {
		return content;
	}
	
	/**
	   * rewrite the content of the file
	   * 
	   * @param the String content
	   * @return None
	   */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	   * add the content.
	   * 
	   * @param the String content
	   * @return None
	   */
	public void addContent(String content){
		this.content += content;
	}
}
