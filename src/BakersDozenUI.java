import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.Timer;
import java.awt.event.MouseAdapter; 
//import java.util.Timer;
//import java.util.TimerTask;



public class BakersDozenUI {

	/// game vars
	private JFrame frame;
	public Timer timer = new Timer(1000,new ActionListener(){
        public void actionPerformed(ActionEvent e)
    {
       incrementTimer();
    }
    });;
	public int score = 0;
	public int moves = 0;
	public long elapsedSeconds = 0;
	
	/// gui controls
	JLabel lblTime = new JLabel("00:00");
	JLabel lblMoves = new JLabel("0");
	JLabel lblScore = new JLabel("0");
	BakersDozenBoard bdboard = new BakersDozenBoard();
	//JPanel bdboard = new JPanel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BakersDozenUI window = new BakersDozenUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the application.
	 */
	public BakersDozenUI() {
		initialize();
		
		frame.getContentPane().add(bdboard);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
		// Dealing (and shuffling) cards
		Deal();
		
		//frame = new JFrame("Baker's Dozen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		// starting play timer
		timer.start();
		bdboard.setEnabled(true);
		
		
		
	}
	
	public void incrementTimer() {
		elapsedSeconds++;
		lblTime.setText(String.format("%02d", elapsedSeconds / 60) + ":" + String.format("%02d", elapsedSeconds % 60));
		
	}
	
	public void DisplayGameOver() {
		
		WinDialog wd = new WinDialog(score, moves, lblTime.getText());
		wd.setVisible(true);
	}
	
	public void Reset() {
		score = 0;
		moves = 0;
		elapsedSeconds = 0;
		Deal();
	}
	
	// todo: create array of cards, scramble, then assign to values in tboard
	public void Deal() {
		//System.out.println("Deal-1");
		Card[] cards = new Card[52];
		
		cards[0] = new Card(1, "diamond");
		cards[1] = new Card(2, "diamond");
		cards[2] = new Card(3, "diamond");
		cards[3] = new Card(4, "diamond");
		cards[4] = new Card(5, "diamond");
		cards[5] = new Card(6, "diamond");
		cards[6] = new Card(7, "diamond");
		cards[7] = new Card(8, "diamond");
		cards[8] = new Card(9, "diamond");
		cards[9] = new Card(10, "diamond");
		cards[10] = new Card(11, "diamond");
		cards[11] = new Card(12, "diamond");
		cards[12] = new Card(13, "diamond");

		//System.out.println("Deal-2");

		cards[13] = new Card(1, "heart");
		cards[14] = new Card(2, "heart");
		cards[15] = new Card(3, "heart");
		cards[16] = new Card(4, "heart");
		cards[17] = new Card(5, "heart");
		cards[18] = new Card(6, "heart");
		cards[19] = new Card(7, "heart");
		cards[20] = new Card(8, "heart");
		cards[21] = new Card(9, "heart");
		cards[22] = new Card(10, "heart");
		cards[23] = new Card(11, "heart");
		cards[24] = new Card(12, "heart");
		cards[25] = new Card(13, "heart");

		//System.out.println("Deal-3");

		cards[26] = new Card(1, "spade");
		cards[27] = new Card(2, "spade");
		cards[28] = new Card(3, "spade");
		cards[29] = new Card(4, "spade");
		cards[30] = new Card(5, "spade");
		cards[31] = new Card(6, "spade");
		cards[32] = new Card(7, "spade");
		cards[33] = new Card(8, "spade");
		cards[34] = new Card(9, "spade");
		cards[35] = new Card(10, "spade");
		cards[36] = new Card(11, "spade");
		cards[37] = new Card(12, "spade");
		cards[38] = new Card(13, "spade");
		

		//System.out.println("Deal-4");
		cards[39] = new Card(1, "club");
		cards[40] = new Card(2, "club");
		cards[41] = new Card(3, "club");
		cards[42] = new Card(4, "club");
		cards[43] = new Card(5, "club");
		cards[44] = new Card(6, "club");
		cards[45] = new Card(7, "club");
		cards[46] = new Card(8, "club");
		cards[47] = new Card(9, "club");
		cards[48] = new Card(10, "club");
		cards[49] = new Card(11, "club");
		cards[50] = new Card(12, "club");
		cards[51] = new Card(13, "club");
		
		// assign values to cards

		//System.out.println("rank=" + cards[0].rank);
		//System.out.println("suit=" + cards[0].suit);
		

		//System.out.println("rank=" + cards[13].rank);
		//System.out.println("suit=" + cards[13].suit);
		

		//System.out.println("rank=" + cards[26].rank);
		//System.out.println("suit=" + cards[26].suit);

		//System.out.println("rank=" + cards[39].rank);
		//System.out.println("suit=" + cards[39].suit);
		//System.out.println("Deal-5");
		cards = Shuffle(cards); // shuffling

		//System.out.println("rank=" + cards[0].rank);
		//System.out.println("suit=" + cards[0].suit);
		//System.out.println("Deal-6");
		List<Card>[] tBoard = new ArrayList[13]; // creating board layout

		//System.out.println("Deal-7");
		// dealing cards
		for(int x = 0; x < 13; x++) {
			tBoard[x] = new ArrayList<Card>();
			for(int y = 0; y < 4; y ++) {
			//	System.out.println("Dealing card #" + (4*x + y));
				tBoard[x].add(cards[4*x + y]);
			}
		}

		//System.out.println("Deal-8");
		
		bdboard = new BakersDozenBoard(tBoard);

		//System.out.println("Deal-9");
	}
	
	public Card[] Shuffle(Card[] cards)
	   {
	       Random rnd = new Random();
	       for (int i = cards.length -1; i > 0; i--)
	       {
	          int index = rnd.nextInt(i + 1);
	          // Simple swap
	          Card temp = cards[index];
	          cards[index] = cards[i];
	          cards[i] = temp;

	       }
	       return cards;
	   }


	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1090, 766);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(5, 5, 5, 5));
		menuBar.setBackground(SystemColor.menu);
		frame.setJMenuBar(menuBar);
		
		JLabel lblScoreLabel = new JLabel("Score: ");
		lblScoreLabel.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblScoreLabel.setBackground(SystemColor.menu);
		menuBar.add(lblScoreLabel);
		lblScore.setFont(new Font("Dialog", Font.PLAIN, 19));
		
		menuBar.add(lblScore);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JLabel lblMovesLabel = new JLabel("Moves: ");
		lblMovesLabel.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblMovesLabel.setBackground(SystemColor.menu);
		menuBar.add(lblMovesLabel);
		lblMoves.setFont(new Font("Dialog", Font.PLAIN, 19));
		
		lblMoves.setBackground(SystemColor.menu);
		menuBar.add(lblMoves);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue_1);
		
		JLabel lblTimeLabel = new JLabel("Time: ");
		lblTimeLabel.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblTimeLabel.setBackground(SystemColor.menu);
		menuBar.add(lblTimeLabel);
		lblTime.setFont(new Font("Dialog", Font.PLAIN, 19));
		
		lblTime.setBackground(SystemColor.menu);
		menuBar.add(lblTime);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue_2);
		
		JButton btnStartPause = new JButton("Start/Pause");
		btnStartPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(timer.isRunning()) {
					timer.stop();
					bdboard.setEnabled(false);
				}else {
					timer.start();
					bdboard.setEnabled(true);
				}
			}
		});
		btnStartPause.setFont(new Font("Dialog", Font.PLAIN, 19));
		menuBar.add(btnStartPause);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Dialog", Font.PLAIN, 19));
		menuBar.add(btnReset);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setFont(new Font("Dialog", Font.PLAIN, 19));
		menuBar.add(btnUndo);
		
		
	}

}
