File: readme.txt
Author: Group <Patroclus>

To launch level builder, run the file LaunchBuilder.java under src/builder.builder
To launch the game, run the file Kabasuji.java under src/model

Please run our game in windows.

For the Kabasuji game, we have two levels, the first level(puzzle level) is unlocked and the second level(lightning level) 
is locked until you get at least one star on the first level. To rotate or flip, select the piece by clicking it , then 
press the button to flip or rotate. All other features are the same except that the piece on board can not move out side 
the board at this point. When you meet the achievement, there will be stars on top right corner. In Lightning level, when 
the time is up, the game will end and go back to level selection panel. We had tested that all the level could be passed with three stars.
Our maxiumn levels is 20.

For the level builder,  Click New Level button to create a new level. For the piece creator on bottom left corner, user can 
create a piece by pressing 6 square. The piece can be successfully added into the piece container by pressing the "+" 
button if the piece is valid. In the piece container, you can delete the piece you created. You should select level type on 
the top right corner. If puzzle level is selected, you then input allowed move AND PRESS ENTER key to validate. If you select 
Lightning level, similarly input time allowed and Enter. If you select Release level(you have to select square on board first)
, select color first, then pick the number and place it on the board. 

For creating the board, press the squares.
 
For creating the hint, click on hint button to switch to hint mode and click on the squares of the board to create hint. A valid hint 
contains 6 squares on the board. 

Then click on the "+" button to create the board. To be able to create the board, the board
has to be connected and have 6n squares, and contains a valid hint. Then you can test the level by pressing the Test button.
Click on Create Level button to and then click on Save&Exit to finish creating the level. 

A valid Level contains a created board. For a release level, it is also required to put all three stacks of numbers on the board.

If level is not valid, builder will not create level.
Undo, redo, restart button can work perfectly. Then, when you open the game, the builded level will appear.   


Player tutorial video:
		https://youtu.be/sJbSEJ6BJtw

Builder tutorial video:
		https://youtu.be/PfGEeNio-J8

Our test cases use Robot classes to simulate mouse movements, so its best if you dont touch anything during the test cases.
The test cases are built to run on MacbookPro 13 inch. Yeah I know it sucks but because of high level designs
mistakes we dont have time to change it. You can run it on your computer but there is no guarantee it will
produce the desired results.
This is the video we running our test cases:
		https://www.youtube.com/watch?v=fl0mZCiS920

Our test case corved 84%.

 
