package model;

import java.awt.Color;
import java.io.File;

import move.*;

public class LightningLevel extends Level{
	/**
	 * Generated serialized
	 */
	private static final long serialVersionUID = -5041499917978722960L;
	int allowedTime;
	int usedTime;
	
	
	public LightningLevel(int LevelNumber, String LevelType, Board b, Bullpen p, int allowedTime) {
		super(LevelNumber, LevelType, b, p);
		this.allowedTime = allowedTime;
	}

	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doMove(IMove m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void loadLevel(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createLevelState() {
		this.levelState = new LevelState(this.LevelNumber, this.LevelType, this.b, -1,
				this.allowedTime, this.locked, this.star, this.p, new int[0], new Color[0]);
		
	}

	@Override
	public void loadLevelState(LevelState levelState) {
		this.levelState = levelState;
		this.LevelNumber = levelState.getLevelNum();
		this.LevelType = levelState.getLevelType();
		this.b = new Board(levelState.getBoard().getSquare());
		this.p = levelState.getBullpen();
		this.locked = levelState.getLocked();
		this.star = levelState.getAchievement();
		this.allowedTime = levelState.getAllowedTime();
	}
	
}
