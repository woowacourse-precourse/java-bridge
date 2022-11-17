package bridge;

public class ValidateInput {

    public static final String ERROR_MESSAGE="[ERROR] ";
    public static int validateBridgeSize(String bridgeSize) throws IllegalArgumentException{
        try{
            if(!(3<=Integer.parseInt(bridgeSize)&&Integer.parseInt(bridgeSize)<=20)){
                throw new IllegalArgumentException();
            }
            return Integer.parseInt(bridgeSize);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public static String validateMoving(String moving) throws IllegalArgumentException{
        if(!(moving.equals("U")||moving.equals("D"))){
            throw new IllegalArgumentException();
        }
        return moving;
    }
}
