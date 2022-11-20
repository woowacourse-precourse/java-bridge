## 🌉 다리건너기 게임 🌉
### 1. Application 클래스
1. 다리길이 입력을 위해 InputView의 readBridgeSize 호출
2. 게임 실행을 위해 BridgeGame의 move 호출

### 2. InputView의 ReadBridgeSize
    숫자가 아닐 시 예외처리
    3 ~ 20이 아닐 시 예외처리
숫자를 입력받고 BridgeMaker의 makeBridge로 전달하여 랜덤다리 생성

### 3. BridgeGame의 move
    U, D가 아닐 시 예외처리
1. InputView의 readMoving로 값을 입력받음  
2. 입력받은 값과 다리의 값을 비교
   1. 같을 시 성공하거나 실패할 때 까지 진행
   2. 실패 시 break 후 retry문을 불러옴
3. 입력받은 값을 OutputView에도 전달하여 진행상황 출력

### 4-1. 실패 시 : BridgeGame의 retry 호출
    R, Q가 아닐 시 예외처리
1. R 입력 시 BridgeGame의 move 재호출
2. Q 입력 시 OutputView의 printResult 출력 후 종료

### 4-2. 성공 시 
OutputView의 printResult 출력 후 종료

### 5. 리팩토링
### 6. 테스트코드 작성