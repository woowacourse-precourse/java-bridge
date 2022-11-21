package bridge;

public class Check {
  
  private static final IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
  
  public static int checkBridgeSize(String in) throws IllegalArgumentException{
    try{
      int num = Integer.valueOf(in);
      if(num < 21 && num > 2){
        return num;
      }
      throw illegalArgumentException;
    }
    catch(Exception e){
      throw illegalArgumentException;
    }
  }
}
