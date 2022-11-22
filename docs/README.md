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
>> - ArrayList(Integer) position:현재위치,
>> - int tryNumber: 시도 횟수,  
>> - boolean question: 재시도 여부 질문을 촉발시키는 버튼  

> 메서드  
>> - move(String readMoving): 이동 전 / 현재 위치 formerPosition 저장  
>> => 이동 / [입력받은 값에 따라 up or down, 현재위치 +1]
>> - retry(): 현재위치 -1, 재시도 횟수 +1

Enum UpOrDown
>위치 arraylist의 첫 번째 요소, 위 아래를 나타내는 상수 값

OutputView
>아이디어: BridgeGame의 현재 위치를 바탕으로,
> 현재 위치의 O,X를 출력하고, 현재 위치를 제외한 지나온 곳은 만든 다리의
> 형태와 같을 것이므로, 현재 위치 제외 다리에 해당하는 O,X값을 출력 
> 
>메서드
>> - isMatch: 현재 위치와 주어진 다리 일치 여부(O,X 출력을 위해)
>
>> - printUpPosition: 현재 위치의 O,X,빈칸을 출력하는 함수(윗줄과 아랫줄로 나뉘어 있다)
>> - printDownPosition
>
>> - printBlankOrMatch: 다리의 빈칸 또는 일치 여부 출력
>> - printUpBeforePosition: 지나온 곳(즉, 다리) 출력(윗줄, 아랫줄로 나뉘어 있다)
>> - printDownBeforePosition
>
>> - printMap: 현재까지의 결과 출력
>> - printSuccessOrNot: 성공 여부(최종결과에 활용)
>> - printResult: 최종 결과 출력