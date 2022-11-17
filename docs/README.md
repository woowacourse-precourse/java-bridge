# Application Workflow
- start game
- enter bridge length
- generate random bridge
- while not end of bridge
  - receive user move
  - next move if valid
  - retry or terminate if invalid
- show the final game status and other info


# Classes
### Application
### BridgeGame
#### <em>cannot call InputView or OutputViewer</em>
- (field) bridge 
- move
  - receives which direction to move
- retry
### BridgeMaker
- One and only function is to generate bridge
### BridgeRandomNumberGenerator
- DO NOT MODIFY
### InputView
#### to make it compact, it throws the exception outwards
- enter bridge length
- enter user move
- enter retry or terminate
### OutputView
### Err
- wrong bridge length
- wrong move
- wrong retry or terminate

# Interface
### BridgeNumberGenerator
- DO NOT MODIFY
