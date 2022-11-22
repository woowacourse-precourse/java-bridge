package bridge;

public class Exception {
    public static void BridgeSizeCheck(String BridgeSize) {
        String sizeRegex = "^([3-9]{1})$|^(1[0-9]{1})$|^20$";
        if (! BridgeSize.matches(sizeRegex)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void WrongInsert(String InsertString, String Check1, String Check2){
        if (InsertString.length()>=2){
            throw new IllegalArgumentException("[ERROR] 길이가 2 이상입니다.");
        }
        if (!InsertString.contains(Check1) && !InsertString.contains(Check2)){
            throw new IllegalArgumentException("[ERROR] " + Check1 + ", " + Check2 + "이 외의 값을 입력하였습니다.");
        }
    }
}
