package bridge;

public class ValidationCheck {
    public int toInts(String bridgeSize) {
        try{
            return Integer.parseInt(bridgeSize);
        }catch(IllegalArgumentException illegalArgumentException){
            throw new IllegalArgumentException(" 다리 길이는 숫자여야합니다. 3~20 사이의 숫자만 입력해주세요");
        }
    }
    public String isBlank(String text){
        if (text == null || text.trim().isEmpty()){
            throw new IllegalArgumentException(" 입력에 공백을 입력했습니다.");
        }
        return text;
    }
    public int checkBridgeSizeRange(int bridgeSize) throws IllegalArgumentException {
        if(bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(" 다리 길이는 3에서 20사이여야합니다.");
        }
        return bridgeSize;
    }
    public String checkMovingEnum(String moving) throws IllegalArgumentException {
        if(moving.equals("U") || moving.equals("D")){
            return moving;
        }
        throw new IllegalArgumentException(" 이동할 칸은 U 혹은 D 만 입력해야만합니다.");
        // "U" -> 변수선언 가능성
        // enum class 이용 가능
    }
    public String checkGameCommand(String gameCommand) throws IllegalArgumentException {
        if(gameCommand.equals("R") || gameCommand.equals("Q")){
            return gameCommand;
        }
        throw new IllegalArgumentException(" 게임 재시도 여부는 R 혹은 Q만 입력해야만합니다.");
    }
}
