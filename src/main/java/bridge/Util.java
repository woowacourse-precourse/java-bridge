package bridge;

public class Util {

    //숫자인가?
    public static boolean isNumber(String input){
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    //문자인가?
    public static boolean isLetter(String input){
        try{
            Double.parseDouble(input);
            return false;
        } catch (NumberFormatException nfe){
            return true;
        }
    }

}
