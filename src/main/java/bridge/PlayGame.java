package bridge;

import java.util.List;

public class PlayGame {
    private  static boolean Playing=true;
    private static int count=0;
    OutputView outputView;
    InputView inputView;
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    BridgeMaker bridgemaker;
    public PlayGame(){
    this.outputView=new OutputView();
    this.inputView=new InputView();
    this.bridgeRandomNumberGenerator=new BridgeRandomNumberGenerator();
    this.bridgemaker=new BridgeMaker(bridgeRandomNumberGenerator);}

    public int sizeStart(){
        outputView.printStart();
        outputView.printInputSize();
       return inputView.readBridgeSize();
    }

    public String moveStart(List<String> Bridge,int index){
        String answer="";
        outputView.printMoving();
        String inputMoving=inputView.readMoving();
        int count=index+1;
       if( isSame(Bridge.get(index),inputMoving)){
          return answer=outputView.printMap(answer,inputMoving,count);
       }
       if( !isSame(Bridge.get(index),inputMoving)){
           answer=outputView.printFailMap(answer,inputMoving,count);
           if(retry()){
               System.out.println(answer);
               count=0;
               return answer="";
           }
           if(!retry()){
               Playing=false;
               return answer;
           }
       }
       return answer;}
    public boolean retry() {
        outputView.printReGame();
       String regame= inputView.readGameCommand();
       return regame.equals("R");
    }
    public void run(){
        int size=sizeStart();
       List<String> Bridge= bridgemaker.makeBridge(size);
       int i=0;
       String answer="";
       while(Playing){

      answer= moveStart(Bridge,count);
      if(!answer.equals("")){
       count++;}}
       return ;


    }
    public void bridgeMoving(List<String> Bridge,String inputMoving){

    }
    public boolean isSame(String eachBridge,String inputMoving){
        return eachBridge.equals(inputMoving);
    }
}
