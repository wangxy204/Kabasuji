package builder.view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;

import builder.model.*;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import model.*;
public class JPieceCreatorView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7437149537257431547L;
	
	private LevelEditor lvle;
	private PieceCreator pc;
	JSquareView[] squareV = new JSquareView[36];
	/**
	 * Create the panel.
	 */
	public JPieceCreatorView(LevelEditor lvle) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lvle = lvle;
		this.pc = lvle.getPieceCreator();
		
		Square[] squareToDisplay = pc.getSquares();
		boolean[] selectedSquare = pc.getSelected();
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 180, 180);
		add(panel);
		panel.setLayout(new GridLayout(6, 6, 0, 0));
		
		for (int i = 0; i < 36; i++){
			if (selectedSquare[i]){
				squareV[i] = new JSquareView(squareToDisplay[i], Color.GRAY);
			} else {
				squareV[i] = new JSquareView(squareToDisplay[i], Color.WHITE);
			}
			panel.add(squareV[i]);
		}
		
		ImageIcon addLevel = new ImageIcon("images//addLevel.png");
		JButton addButton = new JButton();
		addButton.setBounds(263,68,60,60);
		addButton.setIcon(addLevel);
		add(addButton);
		
		
		setOpaque(false);
		setLayout(null);
		
		
		


	}
}
