package bridge.util;

public class Exceptions {
    public static int isNumber(String str){
        try{
            return Integer.parseInt(str);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static void validInput(String str) {
        if (str != "U" && str != "D") {
            throw new IllegalArgumentException("[ERROR]");
        }
    };

    public static void validReInput(String str){
        if (str !="1" && str !="0"){
            throw new IllegalArgumentException("[ERROR]");
        }
    };
}
