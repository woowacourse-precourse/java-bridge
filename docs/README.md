InputView
>유효성 검사: true/false 반환 => main에서 처리  
>> - readBridgeSizeValidation  
>> - readMovingValidation  
>> - readGameCommandValidation  
> 
>> - readBridgeSize: 사용자에게 다리 길이 입력받기  
>> - readMoving: 사용자가 이동할 칸 입력받기  
>> - readGameCommand: 게임 재시도/종료 여부 입력받기  

BridgeMaker  
>변수  
>> - private final BridgeNumberGenerator 
>> bridgeNumberGenerator

>생성자  
>> - BridgeMaker(bridgeNumberGenerator):
>> 변수에 파라미터값 넣기  

>메서드
>> - private bridgeAdd(int number): 숫자에 따라 U,D 반환
>> - makeBridge(int size): bridgeAdd 사용,
>> 다리 길이에 따른 U,D 리스트 반환

BridgeGame  
>변수  
>> - enum UpOrDown(): 위치 arraylist의 첫 번째 요소, 위 아래  
>> - ArrayList(Integer) position:현재위치,    
>> - ArrayList(Integer) formerPosition:이동 전 위치,  
>> - int retryNumber:재시도 횟수,  

> 메서드  
>> - move(String readMoving): 이동 전 / 현재 위치 formerPosition 저장  
>> => 이동 / [입력받은 값에 따라 up or down, 현재위치 +1]
>> - retry(): 현재위치 -1, 재시도 횟수 +1