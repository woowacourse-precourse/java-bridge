package bridge;

public class Convert {
  private static IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
  
  public static String convert(int in) throws IllegalArgumentException{
    try{
      if(in == 0){
        return "D";
      }
      if(in == 1){
        return "U";
      }
      throw illegalArgumentException;
    }
    catch(Exception e){
      throw illegalArgumentException;
    }
  }
}
