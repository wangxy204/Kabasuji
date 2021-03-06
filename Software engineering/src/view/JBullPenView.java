package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Bullpen;
import model.Piece;

/**
 * representing the bullpen
 * @author kdai
 * @author jshen3
 * @author xwang111 
 *
 */
public class JBullPenView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8737427457509103124L;

	Bullpen bp;
	
	JPieceView[] jp = new JPieceView[20];
	ArrayList<Piece> pieces;
	int pNum = 0;
	int BullPenXcount =0;
	int BullPenycount =0;
	int bpX;
	int bpY;
	
	//JScrollPane scrollPane = new JScrollPane();
	
	/**
	 * create bullpen view
	 * @param bp
	 * @param bpX
	 * @param bpY
	 */
	public JBullPenView(Bullpen bp, int bpX, int bpY) {
		this.bp = bp;
		this.bpX = bpX;
		this.bpY = bpY;

		pieces = bp.getPieces();
		pNum = pieces.size();

		createJBullPenView();
	}
	
	private void createJBullPenView(){

		//setBounds(bpX,bpY,180*2+15,180*3+20);
		setPreferredSize(new Dimension(180*2+15,180*4+20));

		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(null);
		
		for(int i = 0; i< pNum;i++){
			if (i%2==0){
				BullPenXcount=0;
			}
			jp[i] = new JPieceView(pieces.get(i),(180+5)*BullPenXcount+5,((int)(i/2))*(180+5)+5);
			BullPenXcount++;
			add(jp[i]);
		}
		jp[bp.getPieceSelected()].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

	}
	
	public JPieceView[] getPieceView(){
		return jp;
	}
	
	
}

