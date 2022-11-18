package bridge.model;

public class User {
    private static final Integer START_POSITION = 0;
    private static final Integer START_COUNT = 1;
    private static final Boolean SUCCESS = Boolean.TRUE;
    private static final Boolean FAIL = Boolean.FALSE;
    private Integer position;
    private Integer count;
    private Boolean result;
    public User(){
        this.position = START_POSITION;
        this.count = START_COUNT;
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
    public void resetUser(){
        this.result = SUCCESS;
        this.position = START_POSITION;
        this.count++;
    }
}
