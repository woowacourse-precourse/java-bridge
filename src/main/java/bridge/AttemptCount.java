package bridge;

public class AttemptCount {
  private int Attempts = 0;
  
  public void increaseAttempt(){
    this.Attempts++;
  }
  
  public int getAttempts(){
    return this.Attempts;
  }
}
