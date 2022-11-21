package bridge;

public class ErrorCheck {
    public static boolean isValidInteger(String bridgeLength) {
        try{
            Integer.parseInt(bridgeLength);
            return true;
        }catch(Exception e){
            System.out.println("[ERROR] 다리의 길이는 숫자로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public static boolean isValidBridgeLengthRange(String bridgeLength) {
        if(Integer.parseInt(bridgeLength)>20 || Integer.parseInt(bridgeLength)<3) {
            System.out.println("[ERROR] 다리의 길이는 3~20 사이로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return true;
    }
}