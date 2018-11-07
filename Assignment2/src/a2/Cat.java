package a2;
import a2.FileSystem;

public class Cat extends Command{

  public Cat(FileSystem fs) {
    super(fs);
  }
  public void run(String[] input) {
    for (int i=1;i<input.length;i++) {
      if (this.isValid(input[i])) {
        FileDirectory fd = fs.trace(input[i]);
        if (fd instanceof File) {
          File f = (File)fd;
          System.out.println(f.getContent() +"\n\n\n");
        }else {
          System.out.println("cat: /"+input[i]+" "+errorMessage());
        }
      }else {
        System.out.println("cat: /"+input[i]+" "+errorMessage());
      }
    }
  }
  
  public String errorMessage() {
    return "No such file or directory";
  }
  
  public boolean isValid(String path) {
    boolean result = false;
    if (path.length()>=2) {
      result = true;
    }else {
      result = false;
    }
    return result;
  }
}
