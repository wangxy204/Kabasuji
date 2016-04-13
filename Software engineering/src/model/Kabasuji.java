package model;

import java.awt.Color;
import java.util.Random;


import view.Application;
import view.LevelSelection;
import view.SplashScreen;

public class Kabasuji {
	Level[] levels;
	
	
	  public static void main(String[] args) {
		    // Throw a nice little title page up on the screen first
		    SplashScreen splash = new SplashScreen(2000);
		    // Normally, we'd call splash.showSplash() and get on with the program.
		    // But, since this is only a test...
		    splash.showSplashAndExit();
		    //Application app = new Applicaiton();
		    LevelSelection levelSec = new LevelSelection(createTestLevel());
		  }
	
	  
	  
	public Kabasuji(Level[] level){
		this.levels = level;
		     LevelSelection levelSec = new LevelSelection(level);
	}
	  

	
	
	private void initializeControllers() {
		


	}
	
	  public static Level[] createTestLevel(){
			Level[] testLevels = new Level[15];
			int[] squareNum = new int[144];
			Color[] cl = new Color[144];
			
			for (int i=0;i<144;i++){
				squareNum[i] =0;
				cl[i]=null;
			}
			int count18=0;
			for (int i=1;i<4;i++){
				for (int j=1;j<7;j++){
				squareNum[count18] =j;
				if (i==1){
				cl[count18]=Color.RED;
				}
				else if (i==2){
					cl[count18]=Color.YELLOW;
					}
				else if (i==3){
					cl[count18]=Color.GREEN;
					}
				count18=count18+5;
				}
			}
			
			for (int i=0;i<15;i++){
				Square bullPenSquare[] = new Square[6]; 
				bullPenSquare[0] = new Square(1,3);
				bullPenSquare[1] = new Square(0,1);
				bullPenSquare[2] = new Square(0,2);
				bullPenSquare[3] = new Square(0,3);
				bullPenSquare[4] = new Square(0,4);
				bullPenSquare[5] = new Square(0,5);		
				
				Piece bullPenPiece = new Piece(0,0,bullPenSquare,bullPenSquare[0],2);
				bullPenPiece.setColor(new Color(0,0,0));
				
				
				Piece[] bullPenPieceArray = new Piece[6];
				bullPenPieceArray[0] = bullPenPiece;
				bullPenPieceArray[1] = bullPenPiece;
				bullPenPieceArray[2] = bullPenPiece;
				bullPenPieceArray[3] = bullPenPiece;
				bullPenPieceArray[4] = bullPenPiece;
				bullPenPieceArray[5] = bullPenPiece;
				
				Bullpen bp = new Bullpen(bullPenPieceArray);
				
				
				
				Square[] boardSquare = new Square[144]; 
				for (int i1=0;i1<12;i1++){
					for (int j=0;j<12;j++){
				
						boardSquare[i1*12+j] = new Square(i1,j);
					}
				}
				
				Square hitSquares[] = new Square[6]; 
				hitSquares[0] = new Square(6,4);
				hitSquares[1] = new Square(5,2);
				hitSquares[2] = new Square(5,3);
				hitSquares[3] = new Square(5,4);
				hitSquares[4] = new Square(5,5);
				hitSquares[5] = new Square(5,6);	
				
				Hint hints = new Hint(hitSquares);
			
				Board testBoard = new Board(boardSquare);
				testBoard.sethint(hints);
				
				if (i%3==0){
				testLevels[i] = new PuzzleLevel(i,GetLevelTpye(i%3),testBoard,bp,20);
				testLevels[i].updateLevelStar(new Achievement(new Random().nextInt(3) + 1));
				}
				else if (i%3==1){
				testLevels[i] = new LightningLevel(i,GetLevelTpye(i%3),testBoard,bp,20);
				testLevels[i].updateLevelStar(new Achievement(new Random().nextInt(3) + 1));
				}
				else {
				testLevels[i] = new ReleaseLevel(i,GetLevelTpye(i%3),testBoard,bp,squareNum,cl);
				testLevels[i].updateLevelStar(new Achievement(new Random().nextInt(3) + 1));
				}
		
			}
			testLevels[13].updateLevelStar(new Achievement(0));
			testLevels[14].updateLevelStar(new Achievement(-1));
			
			return testLevels;
			/*
			public Level(int LevelNumber, String LevelType, Board b, Bullpen p){
				this.LevelNumber = LevelNumber;
				this.LevelType = LevelType;
				this.b = b;
				this.p = p;
			}
		
			*/
		}
		public static String GetLevelTpye(int levelNum){
			if(levelNum==0){
				return "puzzle";
			}
			else if(levelNum==1){
				return "lightning";
			}
			else {
				return "release";
			}
		}
}
