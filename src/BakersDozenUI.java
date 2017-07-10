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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.util.Timer;
import java.util.TimerTask;

public class BakersDozenUI {

	private JFrame frame;
	public Timer timer = new Timer(true);
	public int score = 0;
	public int moves = 0;
	public long elapsedSeconds = 0;
	

	JLabel lblTime = new JLabel("00:00");
	JLabel lblMoves = new JLabel("0");
	JLabel lblScore = new JLabel("0");

	
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
		
		timer.schedule(new TimerTask() {

            @Override
            public void run() {
                incrementTimer();
            }
        }, 1000);
		
		DisplayGameOver();
		
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1090, 507);
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
		btnStartPause.setFont(new Font("Dialog", Font.PLAIN, 19));
		menuBar.add(btnStartPause);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Dialog", Font.PLAIN, 19));
		menuBar.add(btnReset);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setFont(new Font("Dialog", Font.PLAIN, 19));
		menuBar.add(btnUndo);
		
		JPanel finalStacksPanel = new JPanel();
		frame.getContentPane().add(finalStacksPanel, BorderLayout.NORTH);
		
		JLabel finalStack1 = new JLabel("");
		finalStack1.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/Solitaire.png")));
		finalStacksPanel.add(finalStack1);
		
		JLabel finalStack2 = new JLabel("");
		finalStack2.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/Solitaire.png")));
		finalStacksPanel.add(finalStack2);
		
		JLabel finalStack3 = new JLabel("");
		finalStack3.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/Solitaire.png")));
		finalStacksPanel.add(finalStack3);
		
		JLabel finalStack4 = new JLabel("");
		finalStack4.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/Solitaire.png")));
		finalStacksPanel.add(finalStack4);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 13, 0, -400));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_2);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_7);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_6);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_9);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_8);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_5);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_10);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_4);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_15);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_3);
		
		JLabel label_30 = new JLabel("");
		label_30.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_30);
		
		JLabel label_34 = new JLabel("");
		label_34.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_34);
		
		JLabel label_31 = new JLabel("");
		label_31.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_31);
		
		JLabel label_35 = new JLabel("");
		label_35.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_35);
		
		JLabel label_36 = new JLabel("");
		label_36.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_36);
		
		JLabel label_42 = new JLabel("");
		label_42.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_42);
		
		JLabel label_40 = new JLabel("");
		label_40.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_40);
		
		JLabel label_33 = new JLabel("");
		label_33.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_33);
		
		JLabel label_32 = new JLabel("");
		label_32.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_32);
		
		JLabel label_49 = new JLabel("");
		label_49.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_49);
		
		JLabel label_28 = new JLabel("");
		label_28.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_28);
		
		JLabel label_48 = new JLabel("");
		label_48.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_48);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_16);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_13);
		
		JLabel label_23 = new JLabel("");
		label_23.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_23);
		
		JLabel label_26 = new JLabel("");
		label_26.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_26);
		
		JLabel label_38 = new JLabel("");
		label_38.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_38);
		
		JLabel label_27 = new JLabel("");
		label_27.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_27);
		
		JLabel label_39 = new JLabel("");
		label_39.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_39);
		
		JLabel label_37 = new JLabel("");
		label_37.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_37);
		
		JLabel label_43 = new JLabel("");
		label_43.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_43);
		
		JLabel label_44 = new JLabel("");
		label_44.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_44);
		
		JLabel label_47 = new JLabel("");
		label_47.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_47);
		
		JLabel label_46 = new JLabel("");
		label_46.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_46);
		
		JLabel label_50 = new JLabel("");
		label_50.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_50);
		
		JLabel label_45 = new JLabel("");
		label_45.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_45);
		
		JLabel label_24 = new JLabel("");
		label_24.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_24);
		
		JLabel label_41 = new JLabel("");
		label_41.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_41);
		
		JLabel label_25 = new JLabel("");
		label_25.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_25);
		
		JLabel label_22 = new JLabel("");
		label_22.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_22);
		
		JLabel label_29 = new JLabel("");
		label_29.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_29);
		
		JLabel label_21 = new JLabel("");
		label_21.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_21);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_12);
		
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_20);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_11);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label);
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_19);
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(label_18);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BakersDozenUI.class.getResource("/Images/card_back_smallest.png")));
		panel_1.add(lblNewLabel);
	}

}
