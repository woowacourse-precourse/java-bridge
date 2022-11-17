package bridge.validator;

public interface NumberValidator {
    public default boolean isNumeric(String target){
        try{
            Integer.parseInt(target);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
