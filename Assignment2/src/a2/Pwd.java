package a2;
/**
 * Determines how similar each pair of users is based on their ratings. This
 * similarity value is represented with with a float value between 0 and 1,
 * where 1 is perfect/identical similarity. Stores these values in the
 * userUserMatrix.
 * 
 * @param items1 is the column of the first user.
 * @param items2 is the column of the second user.
 * @return return a double represents the distance between users.
 */
public class Pwd extends Command {

  public Pwd(FileSystem fs) {
    super(fs);
  }

  public void run(String[] input) {
    System.out.println(fs.getCurrentDirectory());
  }
}
