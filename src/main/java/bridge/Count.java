package bridge;

/**
 * Keeps track of attempts made
 */

public class Count {
  private int Attempts = 0;
  
  private int Steps = 0;
  
  public void increaseAttempt(){
    this.Attempts++;
  }
  
  public int getAttempts(){
    return this.Attempts;
  }
  
  public void increaseSteps(){
    this.Steps++;
  }
  
  public int getSteps(){
    return this.Steps;
  }
  
  public void resetSteps(){
    this.Steps = 0;
  }
}
