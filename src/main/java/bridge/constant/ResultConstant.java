package bridge.constant;

public enum ResultConstant {
    SUCCESS("성공","O"), FAIL("실패","X");

    String korean, mark;

    ResultConstant(String korean,String mark){
        this.korean = korean;
        this.mark =mark;
    }

    public String getKorean(){
        return korean;
    }

    public String getMark(){
        return mark;
    }
}
