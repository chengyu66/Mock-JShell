package a2;

import java.util.ArrayList;

/**
 * This class stores directories in LIFO behavior
 * 
 */
public class DirectoryStack {

  private ArrayList<Directory> content;

  public DirectoryStack() {
    this.content = new ArrayList<Directory>();

  }

  /**
   * Pushes directory to the top of the Directory stack.
   * 
   * @param Directory
   */

  public void push(Directory dir) {
    this.content.add(dir);


  }

  /**
   * Pushes directory to the top of the Directory stack.
   * 
   * @return The directory on top of the Directory Stack
   */

  public Directory pop() {
    // get the size of the Directory stack
    int size = this.content.size();
    // if not empty
    if (!(this.isEmpty())) {
      // get the directory on top
      Directory result = this.content.get(size - 1);
      this.content.remove(size - 1);
      return result;
    } else {
      return null;
    }

  }

  /**
   * Checks whether the function is empty
   * 
   * @return boolean whether the DirectoryStack is empty.
   */
  public boolean isEmpty() {

    return this.content.size() == 0;
  }


}
