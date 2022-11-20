InputView
>유효성 검사: true/false 반환 => main에서 처리  
readBridgeSizeValidation
readMovingValidation
readGameCommandValidation  
>readBridgeSize: 사용자에게 다리 길이 입력받기  
readMoving: 사용자가 이동할 칸 입력받기  
readGameCommand: 게임 재시도/종료 여부 입력받기  

BridgeMaker  
>makeBridge(int size): 다리 길이에 따른 U,D 리스트 반환

BridgeGame  
>int position:현재위치, int retryNumber:재시도 횟수  
>move(): 현재위치 +1
>retry(): 현재위치 -1, 재시도 횟수 +1