package bridge;

import java.util.List;

public class PlayGame {
    private  static boolean Playing=true;
    private static int total=1;
    private static int count=1;

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

    public String moveStart(String result,List<String> Bridge,int count){
        outputView.printMoving();
        String inputMoving=inputView.readMoving();
        int index=count-1;
       if( isSame(Bridge.get(index),inputMoving)){
          return result=outputView.printMap(result,inputMoving,count);
       }
       if( !isSame(Bridge.get(index),inputMoving)){
           result=outputView.printFailMap(result,inputMoving,count);
           if(retry()){
               total++;
               return result="";
           }
           if(!retry()){
               Playing=false;
               return result;
           }
       }
       return result;}
    public boolean retry() {
        outputView.printReGame();
       String regame= inputView.readGameCommand();
       return regame.equals("R");
    }
    public void run(){
       try{ int size=sizeStart();
       List<String> Bridge= bridgemaker.makeBridge(size);
       int i=0;
       String answer="";
       while(Playing){

      answer= moveStart(answer,Bridge,count);
      if(answer.equals("")){
       count=1;
        continue;}
      if(count==Bridge.size()){
          outputView.printResult(answer,total);
          return;
      }
      count++;


    }
        return ;}catch (Exception e){
           throw new IllegalArgumentException(e);
       }
    }
    public void bridgeMoving(List<String> Bridge,String inputMoving){

    }
    public boolean isSame(String eachBridge,String inputMoving){
        return eachBridge.equals(inputMoving);
    }
}
