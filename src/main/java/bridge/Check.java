package bridge;

import java.util.List;

public class Check {
  
  private static Count count;
  
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
  
  public static String checkBridgeStep(String in) throws IllegalArgumentException{
    try{
     if(in.equals("D") || in.equals("U")){
       return in;
     }
     throw illegalArgumentException;
    }
    catch(Exception e){
      throw illegalArgumentException;
    }
  }
  
  public static boolean checkBridge(String in, List<String> bridge){
    int step = count.getSteps();
    if(in.equals(bridge.get(step))){
      return true;
    }
    return false;
  }
}
