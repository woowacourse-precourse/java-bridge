package bridge.model;
import static bridge.option.Option.*;
public class User {
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
    public void successResult(){this.result = SUCCESS;}
    public void setStartPosition(){this.position = START_POSITION;}
    public void addCount(){this.count++;}
}
