package bridge;

import java.util.ArrayList;
import java.util.List;

public class GenerateMessage {
  private final String start = "[";
  private final String end = "]";
  private static String topLine = "";
  private static String bottomLine = "";
  private static final String divide = "|";
  private static final String space = "   ";
  private static final String failure = " X ";
  private static final String success = " O ";
  private final Count count;
  
  public GenerateMessage(Count count) {
    this.count = count;
  }
  
  public void reset(){
    this.topLine = "";
    this.bottomLine = "";
  }
  
  public List<String> get(){
    List<String> temp = new ArrayList<>();
    temp.add(start + this.topLine + end);
    temp.add(start + this.bottomLine + end);
    return temp;
  }
  
  public boolean add(boolean result, String step){
    if(result && count.getSteps() == 0){
      startSuccess(step);
      return true;
    }
    if(result){
      con(step, true);
      return true;
    }
    if(count.getSteps() == 0){
      startFail(step);
      return true;
    }
    con(step, false);
    return true;
  }
  
  public void startSuccess(String step){
    boolean eqU = step.equals("U");
    boolean eqD = step.equals("D");
    if(eqU){
      this.topLine = this.topLine + success;
      this.bottomLine = this.bottomLine + space;
    }
    if(eqD){
      this.topLine = this.topLine + space;
      this.bottomLine = this.bottomLine + success;
    }
  }
  public void startFail(String step){
    boolean eqU = step.equals("U");
    boolean eqD = step.equals("D");
    if(eqU){
      this.topLine = this.topLine + failure;
      this.bottomLine = this.bottomLine + space;
    }
    if(eqD){
      this.topLine = this.topLine + space;
      this.bottomLine = this.bottomLine + failure;
    }
  }
  public void con(String step, boolean result){
    boolean eqU = step.equals("U");
    boolean eqD = step.equals("D");
    if(result){
      if(eqU){
        this.topLine = this.topLine + divide + success;
        this.bottomLine = this.bottomLine + divide + space;
      }
      if(eqD){
        this.topLine = this.topLine + divide + space;
        this.bottomLine = this.bottomLine + divide + success;
      }
    }
    if(!result){
      if(eqU){
        this.topLine = this.topLine + divide + failure;
        this.bottomLine = this.bottomLine + divide + space;
      }
      if(eqD){
        this.topLine = this.topLine + divide + space;
        this.bottomLine = this.bottomLine + divide + failure;
      }
    }
  }
}
