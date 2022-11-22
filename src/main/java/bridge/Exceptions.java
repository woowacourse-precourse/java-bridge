package bridge;


import camp.nextstep.edu.missionutils.Console;

class Exceptions{
    static int sizeInt;
    private static InputStringShape inputStringShape = new StringToInt();
    public static boolean inputDirectionException(String direction){
        if(direction.equals("D")){
             return false;}
        if(direction.equals("U")){
            return false;}
        System.out.println("[ERROR] : IllegalArgumentException (U,D 중 하나를 입력하세요)");
        return true;
    }
    public static boolean inputReplayException(String direction){
        if(direction.equals("R")){
            return false;}
        if(direction.equals("Q")){
            return false;}
        System.out.println("[ERROR] : IllegalArgumentException (R,Q 중 하나를 입력하세요)");
        return true;
    }
    public static boolean inputBridgeSizeException(String size){
        try{
            sizeInt = inputStringShape.toInt(size);
            return false;
        }
        catch (NumberFormatException e){
            System.out.println("[ERROR] : IllegalArgumentException " +
                ": 양의 정수를 입력해주세요");
            return true;
        }
        finally {
            if(sizeInt < 0 ){
                System.out.println("[ERROR] : IllegalArgumentException " +
                        ": 양의 정수를 입력해주세요");
                return true;
            }
        }
    }
}