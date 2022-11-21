package bridge;

public class Check {
  
  private final IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
  
  public boolean checkBridgeSize(String in) throws IllegalArgumentException{
    try{
      int num = Integer.valueOf(in);
      if(num < 21 && num > 2){
        return true;
      }
      return false;
    }
    catch(Exception e){
      throw illegalArgumentException;
    }
  }
}
