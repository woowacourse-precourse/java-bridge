package bridge.model;

public class User {
    private static final Integer START = 0;
    private static final Boolean SUCCESS = Boolean.TRUE;
    private final Boolean FAIL = Boolean.FALSE;
    private Integer position;
    private Integer count;
    private Boolean result;
    public User(){
        this.position = START;
        this.count = START;
        this.result = SUCCESS;
    }
    public Integer getPosition(){
        return this.position;
    }
    public Integer getCount(){
        return this.count;
    }
    public void addPosition(){this.position++;}
    public void failResult(){this.result = FAIL;}
    public Boolean getResult(){return this.result;}
}
