package builder.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import builder.model.LevelEditor;
import builder.move.IMove;
import builder.move.ReleaseColorMove;
import builder.view.JReleaseColoredNum;

/**
 * This class manages the controlling of the release color
 * @author lthoang
 *
 */
public class ReleaseColorController implements ActionListener {
	JReleaseColoredNum lev;
	JComboBox<String> box;
	LevelEditor editor;
	/**
	 * construct controller for the release color combo box
	 * @param comboBox
	 * @param lev
	 * @param editor2
	 */
	public ReleaseColorController(JComboBox<String> comboBox,
			JReleaseColoredNum lev, LevelEditor editor2) {
		this.lev = lev;
		this.box = comboBox;
		this.editor = editor2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IMove m = new ReleaseColorMove(editor, lev, box);
		m.doMove(editor);
		lev.update();
		lev.repaint();
	}

}
