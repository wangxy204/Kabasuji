package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.CloseKabasuji;
import controller.GoMenuController;
import controller.HorizontalFlipController;
import controller.LevelSelectController;
import controller.RotateLeftController;
import controller.RotateRightController;
import controller.VerticalFlipController;
import model.Board;
import model.Bullpen;
import model.Piece;
import model.Level;
import model.Square;

import model.*;



import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class LevelView extends JFrame {

	LevelSelection levelselection;
	JLabel moves = new JLabel();
	JLabel stayLabel = null;
	int moveUsed = 0;
	int totalMove = 0;
	
	JLabel timeLeft = new JLabel();
	int tLeft = 0;
	protected JPanel contentPane;
	BlueStripe bs;
	JBullPenView jbp;
	Level level;
	
	JButton horiFlip = new JButton();
	JButton vertiFlip = new JButton();
	JButton lRotate = new JButton();
	JButton rRotate = new JButton();
	JScrollPane scrollPane = new JScrollPane();
	int bullpenX = 20;
	int bullpenY = 140;
	boolean closeWindowsFlag;
	
	public void close(){
		WindowEvent	winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	/**
	 * Create the frame.
	 */
	public LevelView(final Level level, final LevelSelection levelselection) {
		
		closeWindowsFlag = false;
		this.levelselection= levelselection;

		this.level = level;
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 850);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		//----- manully design board

		JBoardView board = new JBoardView(450,210, level.getBoard());

		contentPane.add(board);
		
		HintView hv = new HintView(board,level.getBoard());
		
		
		
		//----------- manully design bullpen 

		JButton btnNewButton = new JButton("Menu");
		btnNewButton.setBounds(20, 20, 80, 80);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new openWindowView("Are you sure to go to menu? (Current level ends and achievement will be saved)").valid()== true){
				new GoMenuController(levelselection,LevelView.this).actionPerformed();
				closeWindowsFlag = true;
				}

			}
		});

		
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	if (closeWindowsFlag ==true){
		    		 close();
		    	}
		    	else{
		    		if (new  openWindowView("Are you sure to close the Kabasuji? (Current level ends and achievement will be saved)").valid()== true){
		    			new CloseKabasuji().actionPerformed();
		    	        }
		    		else{
		    				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		    			}
		    	}
		    }
		});


		jbp = new JBullPenView(level.getBullpen(),bullpenX,bullpenY);


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 824, Short.MAX_VALUE)
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 801, Short.MAX_VALUE)
				);

		contentPane.add(scrollPane);
		scrollPane.setBounds(20, 140, 180*2+35, 180*3+25);
		scrollPane.setViewportView(jbp);


		
		bs = new BlueStripe(1,level.getLevelNumber()+1);
		scrollPane.setColumnHeaderView(bs);

		contentPane.add(bs);        //   adddddddddddddddddddd

		bs.add(btnNewButton);
		
		
		contentPane.add(horiFlip);
		contentPane.add(vertiFlip);
		contentPane.add(lRotate);
		contentPane.add(rRotate);
		horiFlip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HorizontalFlipController(LevelView.this,level.getBullpen(),level.getBullpen().getPieces().get(1)).actionPerformed();
			}
		});
		
		horiFlip.setText("Horizontal Filp");
		vertiFlip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VerticalFlipController(LevelView.this,level.getBullpen(),level.getBullpen().getPieces().get(1)).actionPerformed();
				
			}
		});
		vertiFlip.setText("Vertical Filp");
		
		lRotate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RotateLeftController(LevelView.this,level.getBullpen(),level.getBullpen().getPieces().get(1)).actionPerformed();
			}
		});
		lRotate.setText("Rotate Left");
		rRotate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RotateRightController(LevelView.this,level.getBullpen(),level.getBullpen().getPieces().get(1)).actionPerformed();
			}
		});
		rRotate.setText("Rotate Right");
		
		horiFlip.setBounds(90+180*2, 600, 120, 40);
		vertiFlip.setBounds(220+180*2, 600, 120, 40);
		lRotate.setBounds(90+180*2, 650, 120, 40);
		rRotate.setBounds(220+180*2, 650, 120, 40);

		
		if (level.getAchievement().getAchievement()==1){
			stayLabel = new JLabel("star");
			stayLabel.setBackground(Color.WHITE);
			stayLabel.setBounds(700,35, 20, 20);
			stayLabel.setIcon(new ImageIcon("images//onestar.png"));
			bs.add(stayLabel);
		}
		else if (level.getAchievement().getAchievement()==2){
			stayLabel = new JLabel("star");
			stayLabel.setBackground(Color.WHITE);
			stayLabel.setBounds(700,35, 40, 30);
			stayLabel.setIcon(new ImageIcon("images//twostar.png"));
			bs.add(stayLabel);
		}
		else  if (level.getAchievement().getAchievement()==3){

			stayLabel = new JLabel("star");
			stayLabel.setBackground(Color.WHITE);
			stayLabel.setBounds(700,35, 60, 20);
			stayLabel.setIcon(new ImageIcon("images//threestar.png"));
			bs.add(stayLabel);
		}
		
		if(level.getLevelType().equals("puzzle")){
			
			moveUsed = ((PuzzleLevel) level).getUsedMove();
			totalMove = ((PuzzleLevel) level).getAllowedMove();
			
			bs.add(moves);
			moves.setText("Moves: " + moveUsed + "/" + totalMove);
			moves.setFont(new Font("SansSerif", Font.PLAIN, 30));
			moves.setForeground(Color.WHITE);
			moves.setBounds(140,35, 210, 50);
			
			
		}else if(level.getLevelType().equals("lightning")){
			
			bs.add(timeLeft);
			timeLeft.setText("Time left: " + tLeft);
			timeLeft.setForeground(Color.white);
			timeLeft.setFont(new Font("SansSerif", Font.PLAIN, 30));
			timeLeft.setBounds(140,35, 210, 50);
			
		}else if(level.getLevelType().equals("release")){
			

			int[] squareNum = ((ReleaseLevel)level).getSquareNum();
			Color[] cl = ((ReleaseLevel)level).getCl();
			for(int i = 0;i<144;i++){
				if(squareNum[i] != 0){
					JLabel ll = new JLabel("" + squareNum[i]);
					ll.setForeground(cl[i]);
				
					ll.setFont(new Font("SansSerif", Font.PLAIN, 28));
					int x = level.getBoard().getSquare()[i].getColumn();
					int y = level.getBoard().getSquare()[i].getRow();

					ll.setBounds(x*30+6, y*30+2, 30, 30);

					board.add(ll);
		
					
				}
			}
		}

		board.createSquareView();



		contentPane.setLayout(gl_contentPane);
		setVisible(true);

		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelView frame = new LevelView(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		 */
	}
	
	public void reDrawBullpan (Bullpen bullpen){

		 //scrollPane.remove(jbp);
		 jbp = new JBullPenView(level.getBullpen(),bullpenX,bullpenY);
		 
			scrollPane.setViewportView(jbp);
			contentPane.add(scrollPane);
	}
}
