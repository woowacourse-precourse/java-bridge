package bridge;

public class Validation {

    /**
     * 다리 길이 유효성 검사
     */
    public boolean SizeRangeValidate(int subject, int range1, int range2) {
        if (subject >= range1 && subject <= range2) return true;
        return false;
    }

    /**
     * 사용자가 이동할 칸, 게임을 retry 여부에대한 유효성 검사
     */
    public boolean CharValidate(String subject, String equal1, String equal2) {
        if (subject.equals(equal1) || subject.equals(equal2)) return true;
        return false;
    }
}
