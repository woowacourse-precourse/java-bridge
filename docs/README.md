## 다리건너기 게임
### 1. Application 클래스
다리길이 입력을 위해 InputView의 readBridgeSize 호출  


### 2. InputView의 ReadBridgeSize
    --다리생성--
    숫자가 아닐 시 예외처리
    3 ~ 20이 아닐 시 예외처리
    --이동--
    한자리 문자열이 아닐 시 예외처리
    L, U가 아닐 시 예외처리
    --재도전--
    한자리 문자열이 아닐 시 예외처리
    R, Q가 아닐 시 예외처리
1. 다리생성  
입력받은 숫자를 BridgeMaker의 makeBridge로 전달하여 다리생성  
2. 이동
이동할 칸을 입력받음   
BridgeGame에 값을 전송  
3. 재도전  
재시작 구문 출력
BridgeGame에 값을 전송
### 3. BridgeMaker
입력받은 숫자로 랜덤 다리생성

### 4. BridgeGame 클래스
    U, D이 아니라면 예외발생
1. InputView에서 값을 받음
2. 건널 수 있는 다리면 계속 진행
3. 갈 수 없는 다리를 선택했거나 마지막에 도착 시 재도전에 관한 문구 출력

### 5. OutputVeiw
Input에서 값을 받아 올바르게 출력되도록 구현

### 6. 리팩토링
### 7. 테스트코드 작성