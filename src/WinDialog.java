import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WinDialog extends JDialog {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinDialog dialog = new WinDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinDialog() {
		setBounds(100, 100, 450, 204);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPlayAgain = new JButton("Play Again");
				btnPlayAgain.setFont(new Font("Dialog", Font.PLAIN, 19));
				btnPlayAgain.setActionCommand("");
				buttonPane.add(btnPlayAgain);
				getRootPane().setDefaultButton(btnPlayAgain);
			}
			{
				JButton btnExit = new JButton("Exit");
				btnExit.setFont(new Font("Dialog", Font.PLAIN, 19));
				btnExit.setActionCommand("");
				buttonPane.add(btnExit);
			}
		}
		{
			JSplitPane splitPane = new JSplitPane();
			splitPane.setContinuousLayout(true);
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			getContentPane().add(splitPane, BorderLayout.CENTER);
			{
				JLabel lblWinner_1 = new JLabel("Winner!!!");
				lblWinner_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblWinner_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
				splitPane.setLeftComponent(lblWinner_1);
			}
			{
				table = new JTable();
				table.setFont(new Font("Dialog", Font.PLAIN, 19));
				table.setFillsViewportHeight(true);
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null},
						{null, null},
						{null, null},
					},
					new String[] {
						"New column", "New column"
					}
				));
				splitPane.setRightComponent(table);
			}
		}
	}

	
	/**
	 * Create the dialog.
	 */
	public WinDialog(int score, int moves, String time) {
		setBounds(100, 100, 450, 204);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPlayAgain = new JButton("Play Again");
				btnPlayAgain.setFont(new Font("Dialog", Font.PLAIN, 19));
				btnPlayAgain.setActionCommand("");
				buttonPane.add(btnPlayAgain);
				getRootPane().setDefaultButton(btnPlayAgain);
			}
			{
				JButton btnExit = new JButton("Exit");
				btnExit.setFont(new Font("Dialog", Font.PLAIN, 19));
				btnExit.setActionCommand("");
				buttonPane.add(btnExit);
			}
		}
		{
			JSplitPane splitPane = new JSplitPane();
			splitPane.setContinuousLayout(true);
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			getContentPane().add(splitPane, BorderLayout.CENTER);
			{
				JLabel lblWinner_1 = new JLabel("Winner!!!");
				lblWinner_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblWinner_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
				splitPane.setLeftComponent(lblWinner_1);
			}
			{
				table = new JTable();
				table.setFont(new Font("Dialog", Font.PLAIN, 19));
				table.setFillsViewportHeight(true);
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{"Score: ", score},
							{"Time: ", time},
							{"Moves: ", moves},
						},
						new String[] {
							"New column", "New column"
						}
					));
				splitPane.setRightComponent(table);
			}
		}
	}

}


