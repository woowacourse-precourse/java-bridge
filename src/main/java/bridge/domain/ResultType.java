package bridge.domain;

public enum ResultType {
    SUCCESS("성공"),
    FAIL("실패");

    private final String name;

    ResultType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
