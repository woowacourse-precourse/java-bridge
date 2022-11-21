# 기능구현
### 1. 다리를 생성한다
- [x] 다리의 길이를 입력받는다.  -InputView#readBridgeSize()
- [x] 다리를 1,0형태의 리스트로 저장한다.  -BridgeMaker#makeNumberBridge()
- [x] 1,0 형태의 리스트를 U,D형태로 변환한다.  -BridgeMaker#transferNumberToAlphabet()
- [x] 다리를 U,D형태의 리스트로 저장한다.  -BridgeMaker#makeBridge()

### 2. 다리를 이동한다
- [x] 이동할 칸을 입력받는다.
- [] 이동이 가능한지 여부를 판단한다.
- [] 이동이 가능하다면 게임을 진행한다.
- [x] 이동이 불가능하다면 게임 재시작/종료 여부를 입력받는다.
- [] 게임 재시작/종료 여부를 입력받는다.
- [] 이동 후 결과 출력용 리스트를 업데이트한다.


# 테스트
### 1. 다리를 생성하는 테스트
- [x] 인터페이스 오버라이딩이 잘 되는지 테스트한다.  -BridgeMakerTest#오버라이드()
- [x] 1,0이 U,D로 잘 변환 되는지 테스트한다.  -BridgeMakerTest#숫자_알파벳으로_변환_테스트()
- [x] 입력한 길이에 맞게 리스트가 생성되는지 테스트한다.  -BridgeMakerTest#다리_길이_테스트()


