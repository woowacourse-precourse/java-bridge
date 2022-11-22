# Bridge Project

## Guide Steps for Programming
1) Start **attempt count**
2) Take user input for **bridge length**
3) Check **bridge length** for valid input
4) Generate a random choice between 0 and 1
5) Translate generated numbers into *U* and *D* based on values
6) Repeat *step 3* until **bridge length** is achieved
7) Check bridge generation
8) Create **end game** to check for end of the game
9) Create **end game message** to print the end of game message
10) Print **bridge step message** to communicate to the user to input *U* or *D*
11) Take user input for **bridge step**
12) Check **bridge step** for valid input
13) Check user input verses the generated bridge
14) Generate **bridge cross message**
15) Print **bridge cross message**
16) Check for success of bridge crossing
17) If failure is detected in *step 14*, throw **restart message**
18) Take user input for **restart**
19) check **restart** for invalid input
20) If *R* is detected in **restart**, send back to *step 10*, increase **attempt count**, reset **bridge cross message**
21) If *Q* is detected in **restart**, send to **quit game**
22) If success is detected in *step 14*, check for **end game**
23) If **end game** is true, throw **end game message**
24) IF **end game** is false, send back to *step 10*