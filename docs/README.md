# 다리 건너기 미션 수행하기

-------------
## 기능 목록

1. 게임 시작 문구 출력하기(UI) - Application#makeBridgeFirst()

2. 자동으로 생성할 다리 길이 입력 받기(UI) - Application#makeBridgeFirst()(InputView#readBridgeSize())
    * 예외 : 3 이상 20 이하의 정수가 아니면 IllegalArgumentException 발생시키고 [ERROR]로 시작하는 에러 메시지 출력하고 다시 입력받기(UI) - InputView#bridgeSizeExceptionCheck()

3. 다리 길이만큼 랜덤(0,1)로 이루어진 다리를 생성(핵심로직) - Application#makeBridgeFirst()(BridgeMaker#makeBridge())

4. 이동할 칸을 입력 받기(UI) - Application#inputBridgeState()(InputView#readMoving())
    * 에외 : U 나 D의 문자가 아니면 IllegalArgumentException 발생시키고 [ERROR]로 시작하는 에러 메시지 출력하고 다시 입력받기(UI) - InputView#readMovingExceptionCheck()

5. 입력받은 문자(U/D)가 각각 생성된 다리(1/0)과 일치하는지 확인하기(핵심로직) - BridgeGame#compareMoving()
    * 일치하는 경우
        - 사용자 칸을 이동하기(핵심로직) - BridgeGame#move()
            - 이동할 수 있는 칸을 선택했으므로 올바른 위치에 O를 표시하고(핵심로직) - BridgeGame#addSuccessStateToBridge()
            - 지금까지 입력된 출력하기(UI) - OutputView#printCurrentStateBridge()
        + 다리의 길이만큼 계속 입력받기(조건)
        * 게임 종료일 경우(계속 일치해서 다리를 모두 건넜을 경우) 
            - 지금까지 건넌 다리의 상태를 저장하고 게임 성공 여부 판단(핵심로직) - Application#successBridgeState()(Application#checkSuccessOrFailure()(게임 성공 여부))
            - 최종 게임 결과, 게임 성공 여부 : 성공, 지금까지 총 시도한 횟수를 출력하기(UI) - OutputView#printResult()

    * 일치하지 않는 경우 
        - 사용자 칸을 이동하기(핵심로직) - BridgeGame#move()
            - 이동할 수 없는 칸을 선택했으므로 올바른 위치에 X를 표시하고(핵심로직) - BridgeGame#addFailureStateToBridge()
            - 지금까지 입력된 다리 저장하고 출력하기(UI)- OutputViewe#getAndPrintCurrentStateBridge()
        - 게임 재시작(R)/종료(Q) 여부 입력받기(UI) - InputView#getRestartOrQuit()(InputView#readGameCommand())
            * 예외 : R이나 Q의 문자가 아니면 IllegalArgumentException 발생시키고 [ERROR]로 시작하는 에러 메시지 출력하고 다시 입력받기(UI) - InputView#readGameCommandExceptionCheck()

            * 게임 재시작일 경우(R을 선택했을 경우) - BridgeGame#retry()
                + 다리를 다시 처음부터 입력받기(조건)
                + 다리의 구성, 길이는 재시작 전과 같음(조건)
                * tryCount 증가시키기 - Application#main
            * 게임 종료일 경우(Q를 선택했을 경우) 
                - 지금까지 건넌 다리의 상태를 저장하고 게임 성공 여부 판단(핵심로직) - Application#successBridgeState()(Application#checkSuccessOrFailure()(게임 성공 여부))
                - 최종 게임 결과, 게임 성공 여부 : 실패, 지금까지 총 시도한 횟수를 출력하기(UI) - OutputView#printResult()

------------
## 단위 테스트 구현(도메인에 작성)
1. 핵심 로직
    * makeBridge() - ApplicationTest#다리_생성_테스트()
        다리 생성하기

    * move() - ApplicationTest#기능_테스트(), ApplicationTest2#기능_테스트2()
        사용자 칸을 이동하기
        + addSuccessStateToBridge() 
            올바른 위치에 O표시하기
        + addFailureStateToBridge()
            올바른 위치에 X표시하기
        * compareMoving()
            사용자 입력 값과 다리의 값이 일치하는지 판단하기
        * currentStateBridgeSavePrint()
            현재까지 저장된 다리를 저장하고 출력
        * checkSuccessOrFailure()
        게임 성공 여부 판단하기
        * retry()
        게임이 재시작일 경우 true, 아닐 경우 false 반환하기
        * printResult()
        최종 게임 결과, 게임 성공 여부, 지금까지 총 시도한 횟수를 출력하기


2. UI 로직

    * readBridgeSize() - UI_readBridgeSizeTest()
        * 예외 체크
            - 3 이상 20 이하의 정수가 아니면 IllegalArgumentException 발생시키고 [ERROR]로 시작하는 에러 메시지 출력하고 다시 입력받기 
    
    * readMoving() - UI_readMovingTest()
        * 예외 체크
            - U 나 D의 문자가 아니면 IllegalArgumentException 발생시키고 [ERROR]로 시작하는 에러 메시지 출력하고 다시 입력받기

    * readGameCommand() - UI_readGameCommandTest()
        * 예외 체크
            - R이나 Q의 문자가 아니면 IllegalArgumentException 발생시키고 [ERROR]로 시작하는 에러 메시지 출력하고 다시 입력받기

    

------------
## 기능 요구 사항

* 다리의 길이 입력(3<=길이<=20) -> 그 숫자 길이만큼 매번 1(위 칸)이나 0(아래 칸)을 랜덤으로 생성함
* 다리는 왼쪽에서 오른쪽으로 건너고, U(위 칸), D(아래 칸)만 사용자 입력으로 받음
* 사용자 입력으로 받은 다리 선택(U/D)이 앞서 컴퓨터가 랜덤넘버로 지정한(1/0)과 각각 일치하면 O표시, 아니면 X표시, 선택하지 않은 칸은 공백 표시
* 잘못된 값 입력 시 IllegalArgumentException 발생시키고 [ERROR]로 시작하는 에러 메시지 출력하고 다시 입력받기

* 다리를 끝까지 건너면 게임 종료 
* 다리를 건너다가 실패하면 재시작(R)/종료(Q) 중 하나만 선택
    * 재시작일 경우에는 처음에 만들어진 다리를 재사용함
* 게임 종료시 다리시작([) 다리 끝(]) 다리 칸 구분( | ) 현재까지 건넌 다리, 게임 성공 여부, 총 시도횟수(첫 시도 포함 게임 종료시까지 시도한 총 횟수) 출력

