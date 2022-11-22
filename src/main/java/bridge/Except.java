package bridge;

public class Except {
    public void BridgeSizeCheck(int BridgeSize) {
        if (BridgeSize < 3 || BridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
    public void InsertCorrect(String InsertString, String Check1,String Check2) {
        if (InsertString.length()>=2) throw new IllegalArgumentException("[ERROR] 길이가 2 이상입니다.");
        if (!InsertString.contains(Check1) && !InsertString.contains(Check2))
            throw new IllegalArgumentException("[ERROR] "+Check2+","+Check2+" 이외의 값을 입력하였습니다.");
    }
}
