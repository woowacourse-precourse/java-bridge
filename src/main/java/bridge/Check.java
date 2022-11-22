package bridge;

import java.util.List;

public class Check{
  
  private static Count count = new Count();
  
  private static final IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
  
  public static int checkBridgeSize(String in) throws IllegalArgumentException{
    try{
      int num = Integer.parseInt(in);
      if(num < 21 && num > 2){
        return num;
      }
      System.out.println("[ERROR] INVALID INPUT");
      throw illegalArgumentException;
    }
    catch(IllegalArgumentException e){
      System.out.println("[ERROR] INVALID INPUT");
      throw illegalArgumentException;
    }
  }
  
  public static String checkBridgeStep(String in) throws IllegalArgumentException{
    try{
     if(in.equals("D") || in.equals("U")){
       return in;
     }
      System.out.println("[ERROR]");
     throw illegalArgumentException;
    }
    catch(Exception e){
      System.out.println("[ERROR]");
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
  
  public static String checkFail(String temp) throws IllegalArgumentException{
    if(temp.equals("R") || temp.equals("Q")){
      return temp;
    }
    System.out.println("[ERROR]");
    throw illegalArgumentException;
  }
}
