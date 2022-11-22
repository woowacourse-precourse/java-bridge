package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Count.getSteps;

public class GenerateMessage {
  private final String start = "[";
  private final String end = "]";
  private static String topLine = "";
  private static String bottomLine = "";
  private static final String divide = "|";
  private static final String space = "   ";
  private static final String failure = " X ";
  private static final String success = " O ";
  
  public static void resetMessage(){
    topLine = "";
    bottomLine = "";
  }
  
  public List<String> get(){
    List<String> temp = new ArrayList<>();
    temp.add(start + topLine + end);
    temp.add(start + bottomLine + end);
    return temp;
  }
  
  public static boolean addMessage(boolean result, String step){
    if(getSteps() == 1){
      if(result){
        startSuccess(step);
        return true;
      }
      startFail(step);
      return false;
    }
    if(result){
      con(step, true);
      return true;
    }
    con(step, false);
    return false;
  }
  
  public static void startSuccess(String step){
    boolean eqU = step.equals("U");
    boolean eqD = step.equals("D");
    if(eqU){
      topLine = topLine + success;
      bottomLine = bottomLine + space;
    }
    if(eqD){
      topLine = topLine + space;
      bottomLine = bottomLine + success;
    }
  }
  public static void startFail(String step){
    boolean eqU = step.equals("U");
    boolean eqD = step.equals("D");
    if(eqU){
      topLine = topLine + failure;
      bottomLine = bottomLine + space;
    }
    if(eqD){
      topLine = topLine + space;
      bottomLine = bottomLine + failure;
    }
  }
  public static void con(String step, boolean result){
    boolean eqU = step.equals("U");
    boolean eqD = step.equals("D");
    if(result){
      if(eqU){
        topLine = topLine + divide + success;
        bottomLine = bottomLine + divide + space;
      }
      if(eqD){
        topLine = topLine + divide + space;
        bottomLine = bottomLine + divide + success;
      }
    }
    if(!result){
      if(eqU){
        topLine = topLine + divide + failure;
        bottomLine = bottomLine + divide + space;
      }
      if(eqD){
        topLine = topLine + divide + space;
        bottomLine = bottomLine + divide + failure;
      }
    }
  }
}
