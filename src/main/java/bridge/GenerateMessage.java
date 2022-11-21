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
  
  public List<String> get(){
    List<String> temp = new ArrayList<>();
    temp.add(start + this.topLine + end);
    temp.add(start + this.bottomLine + end);
    return temp;
  }
  
  public void start(boolean result, String step){
    boolean eqU = step.equals("U");
    boolean eqD = step.equals("D");
    if(result){
      if(eqU){
        this.topLine = this.topLine + success;
        this.bottomLine = this.bottomLine + space;
      }
      if(eqD){
        this.topLine = this.topLine + space;
        this.bottomLine = this.bottomLine + success;
      }
    }
    if(eqU){
      this.topLine = this.topLine + failure;
      this.bottomLine = this.bottomLine + space;
    }
    if(eqD){
      this.topLine = this.topLine + space;
      this.bottomLine = this.bottomLine + failure;
    }
  }
  
  public void add(boolean result, String step){
    boolean eqU = step.equals("U");
    boolean eqD = step.equals("D");
    if(result){
      if(eqU){
        this.topLine = this.topLine + divide + success;
        this.bottomLine = this.bottomLine + divide + space;
      }
      if(eqD){
        this.topLine = this.topLine + divide + space;
        this.bottomLine = this.bottomLine + divide +success;
      }
    }
    if(eqU){
      this.topLine = this.topLine + divide + failure;
      this.bottomLine = this.bottomLine + divide + space;
    }
    if(eqD){
      this.topLine = this.topLine + divide + space;
      this.bottomLine = this.bottomLine + divide +failure;
    }
  }
}
