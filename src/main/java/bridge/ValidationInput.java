package bridge;

public class ValidationInput {
    public static void checkDigit(String number){
        try{
            Integer.parseInt(number);
        }catch(Exception e){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
        }
    }

    public static void validSizeOfBridge(String number){
        int size = Integer.parseInt(number);
        if(!(size >= 3 && number <= 20)){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20사이의 숫자여야 합니다.")
        }
    }
    

}
