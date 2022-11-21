package bridge;

/**
 * Keeps track of attempts made
 */

public class Count {
  private int Attempts = 0;
  
  public void increaseAttempt(){
    this.Attempts++;
  }
  
  public int getAttempts(){
    return this.Attempts;
  }
}
