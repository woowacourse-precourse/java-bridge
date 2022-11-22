다음과 같은 메소드를 거쳐야 함

1) bridgeSize를 결정 -> Inputview의 readBridgeSize() 
- 관련된 오류 처리 필요
- 다리_사이즈_생성 test를 통해서 test 진행함


2) 브릿지 사이즈에 맞게 다리를 만들기 (BridgeMaker.java)
- bridgeMaker과 bridgenumbergenerator을 활용해서
- each_bridge()를 따로 생성해서 더욱 간편하게 작성함
- 다리 생성 테스트 test를 통해서 test 진행함

3) 이동할 칸 선택 (U or D) -> inputview의 move 활용
- readMoving() inputview 활용
- 이동할 칸 선택하도록 / 관련된 오류 처리 필요
- 이때 칸과 다리를 출력해야 함(따로 메서드 필요) -> outputview
4) x가 뜰 경우 게임을 다시 시도할지 여부 입력 -> inputview
- (U or R)
5) 최종 결과 출력 -> outputview에서 result를 통해서 활용