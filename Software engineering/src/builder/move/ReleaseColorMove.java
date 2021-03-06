package builder.move;

import java.awt.Color;

import javax.swing.JComboBox;

import builder.model.LevelEditor;
import builder.view.JReleaseColoredNum;

/**
 * This class represent a move to change the color of the num
 * @author lthoang
 *
 */
public class ReleaseColorMove implements IMove {

	LevelEditor editor;
	JReleaseColoredNum lev;
	JComboBox<String> box;
	public ReleaseColorMove(LevelEditor editor2, JReleaseColoredNum lev, JComboBox<String> box) {
		this.editor = editor2;
		this.lev = lev;
		this.box = box;
	}

	@Override
	public boolean isMoveValid(LevelEditor level) {
		return true;
	}

	@Override
	public boolean doMove(LevelEditor level) {
		String c = (String) box.getSelectedItem();
		switch (c){
		case "Yellow":
			lev.setColorNum(Color.YELLOW);
			break;
		case "Pink":
			lev.setColorNum(Color.PINK);
			break;
		case "Orange":
			lev.setColorNum(Color.ORANGE);
			break;
		}
		return true;
	}

	@Override
	public boolean undo(LevelEditor level) {
		// TODO Auto-generated method stub
		return false;
	}

}
