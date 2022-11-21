package bridge;

public class Convert {
  private static IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
  
  public static String convert(int in) throws IllegalArgumentException{
    try{
      String temp = String.valueOf(in);
      return temp;
    }
    catch(Exception e){
      throw illegalArgumentException;
    }
  }
}
