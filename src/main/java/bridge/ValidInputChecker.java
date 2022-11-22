package bridge;

public class ValidInputChecker {
    public static int validateIntAndParseInt(String str){
        try{
            return Integer.parseInt(str);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.");
        }
    }
    public static void validateBridgeSizeRange(int bridgeSize){
        if(bridgeSize < 3 || bridgeSize > 20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void validateUorD(String UorD){
        if(!"U".equals(UorD) && !"D".equals(UorD)){
            throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해야 합니다.");
        }
    }

    public static void validateRorQ(String RorQ){
        if(!"R".equals(RorQ) && !"Q".equals(RorQ)){
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해야 합니다.");
        }
    }
}
