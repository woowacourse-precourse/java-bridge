> Application 아키텍쳐
> > 1. **bridge.Bridge**: Bridge에 관련된 모든 클래쓰들을 담은 패키지
> > > - **BridgeMaker**: Bridge를 생성하는 클래쓰
> > > - **ValidBridgeInput**: 입력 받은 Bridge의 크기의 유효성을 검사하는 클래쓰
> > > - **Bridge**: Bridge의 패턴을 담는 클래쓰
> > 2. **bridge.User**: User의 입력들을 관리하는 모든 클래쓰를 담은 패키지
> > > - **ValidUserInput**: User의 moving 및 command의 입력 유효성을 검증하는 클래쓰
> > > - **User**: User의 Input History를 관리하는 클래쓰
> > 3. **bridge**: 실제 게임에 관련된 모든 클래쓰를 관리하는 패키지
> > > - **InputView**: 모든 입력을 관리하는 클래쓰
> > > - **OutputView**: 모든 UI(출력 메시지)를 관리하는 클래쓰
> > > - **BridgeGame**: 모든 게임의 흐름을 관리하는 클래쓰
> > > - **Application**: main 클래쓰