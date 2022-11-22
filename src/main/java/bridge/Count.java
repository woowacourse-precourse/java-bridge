package bridge;

public class Count {
  private static int Attempts = 1;
  
  private static int Steps = 0;
  
  public static void increaseAttempt(){
    Attempts++;
  }
  
  public static int getAttempts(){
    return Attempts;
  }
  
  public static void increaseSteps(){
    Steps++;
  }
  
  public static int getSteps(){
    return Steps;
  }
  
  public static void resetSteps(){
    Steps = 0;
  }
}
