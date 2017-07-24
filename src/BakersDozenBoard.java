import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.io.File;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class BakersDozenBoard extends JPanel {

	private List<Card>[] foundation = new ArrayList[4]; 
	private List<Card>[] board = new ArrayList[13];
	
	/// gui vars
	private static final int CARD_WIDTH = 73;
	private static final int CARD_HEIGHT = 97;
	private static final int SPACING = 5;  //distance between cards
	private static final int FACE_UP_OFFSET = 15;  //distance for cascading face-up cards
	private static final int FACE_DOWN_OFFSET = 5;  //distance for cascading face-down cards
	private int selectedRow = -1;
	private int selectedCol = -1;
	
	 public BakersDozenBoard() {
	       // setBorder(BorderFactory.createLineBorder(Color.black));
			setPreferredSize(new Dimension(CARD_WIDTH * 13 + SPACING * 14, CARD_HEIGHT * 4 + SPACING * 3/* + FACE_DOWN_OFFSET * 7 + 13 * FACE_UP_OFFSET*/));
			
	    }
	 
	 public BakersDozenBoard( List<Card>[] _board) {
		 	//board = _board;
		 //System.out.println("BDB...");
		 //System.out.println("_board.length= " +_board.length );
	        for(int x = 0; x < _board.length; x++) {
	        	board[x] = new ArrayList<Card>();
//System.out.println("x="+x);
	//        	System.out.println("_board["+x+"] size"+_board[x].size());
	        	board[x].addAll(_board[x]);
	        	
	        	System.out.println("board[x].size = "  + board[x].size());
	        	System.out.println("board[x][0] = "  + board[x].get(0).rank + board[x].get(0).suit);
	        }
	  //      System.out.println("BDB.1");
		 	//setBorder(BorderFactory.createLineBorder(Color.black));
	    //    System.out.println("BDB.2");
			setPreferredSize(new Dimension(CARD_WIDTH * 13 + SPACING * 14, CARD_HEIGHT * 4 + SPACING * 3/* + FACE_DOWN_OFFSET * 7 + 13 * FACE_UP_OFFSET*/));

        	System.out.println("board[0][0] = "  + board[0].get(0).rank + board[0].get(0).suit);
			 System.out.println("...BDB");
			 //paintComponent(this.getGraphics());
	    }
	
	  /*public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;

	   // myBackgroundRoutine(g2);
	  }*/


	 	@Override
		public void paintComponent(Graphics g)
		{

		    super.paintComponent(g);
	 		
	 		
			System.out.println("paint component");
        	System.out.println("board[0][0] = "  + board[0].get(0).rank + board[0].get(0).suit);
			
			//background
			g.setColor(new Color(211, 211, 211));
			System.out.println("1");
			g.fillRect(0, 0, getWidth(), getHeight());
			System.out.println("2");

			//face down
			//drawCard(g, getStockCard(), SPACING, SPACING);

			//stock
			//drawCard(g, game.getWasteCard(), SPACING * 2 + CARD_WIDTH, SPACING);
			//if (selectedRow == 0 && selectedCol == 1)
			//	drawBorder(g, SPACING * 2 + CARD_WIDTH, SPACING);

			//aces
			//for (int i = 0; i < 4; i++)
			//	drawCard(g, getFoundationCard(i), SPACING * (4 + i) + CARD_WIDTH * (3 + i), SPACING);
			

			//System.out.println("3");

			//piles
			for (int i = 0; i < 13; i++)
			{

				System.out.println("piles " + i);
				//List<Card> pile = board[i];
				List<Card> pile = new ArrayList<Card>();
				System.out.println("p.1");
				System.out.println("board.length = " + board.length);
				System.out.println("p.1.1");
				System.out.println("board[0][0] = " + board[0].get(0).rank +  board[0].get(0).suit);
				System.out.println("p.1.2");
				System.out.println("board[i] size = " + board[i].size());
				System.out.println("p.2");
				pile.addAll(board[i]);
				System.out.println("p.3");
				int offset = 0;
				System.out.println("p.4");
				for (int j = 0; j < pile.size(); j++)
				{

					System.out.println("p.j " + j);
					drawCard(g, pile.get(j), SPACING + (CARD_WIDTH + SPACING) * i, CARD_HEIGHT + 2 * SPACING + offset);
					System.out.println("p.j.1");
					if (selectedRow == 1 && selectedCol == i && j == pile.size() - 1)
						drawBorder(g, SPACING + (CARD_WIDTH + SPACING) * i, CARD_HEIGHT + 2 * SPACING + offset);

					System.out.println("p.j.2");

					if (pile.get(j).isFaceUp())
						offset += FACE_UP_OFFSET;
					else
						offset += FACE_DOWN_OFFSET;
					

					System.out.println("p.j.3");
				}
			}

			System.out.println("3");
		}
		

		//precondition:  0 <= index < 4
		//postcondition: returns the card on top of the given
		//               foundation, or null if the foundation
		//               is empty
		public Card getFoundationCard(int index)
		{
			if (foundation[index].isEmpty()) return null;
    		Stack<Card> sc = new Stack<Card>();
			sc.addAll(foundation[index]);
	        return sc.peek();
		}
		
		/*
		//returns the card on top of the stock,
		//or null if the stock is empty
		public Card getStockCard()
		{
	        if (stock.size() == 0) return null;
	        return stock.peek();
		}
*/
		private void drawCard(Graphics g, Card card, int x, int y)
		{
			if (card == null)
			{
				g.setColor(Color.BLACK);
				g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);
			}
			else
			{
				String fileName = card.getFileName();
				if (!new File(fileName).exists())
				    throw new IllegalArgumentException("bad file name:  " + fileName);
				Image image = new ImageIcon(fileName).getImage();
				g.drawImage(image, x, y, CARD_WIDTH, CARD_HEIGHT, null);
			}
		}
	  
	  private void drawBorder(Graphics g, int x, int y)
		{
			g.setColor(Color.YELLOW);
			g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);
			g.drawRect(x + 1, y + 1, CARD_WIDTH - 2, CARD_HEIGHT - 2);
			g.drawRect(x + 2, y + 2, CARD_WIDTH - 4, CARD_HEIGHT - 4);
		}

		public void unselect()
		{
			selectedRow = -1;
			selectedCol = -1;
		}

		public boolean isWasteSelected()
		{
			return selectedRow == 0 && selectedCol == 1;
		}

		public void selectWaste()
		{
			selectedRow = 0;
			selectedCol = 1;
		}

		public boolean isPileSelected()
		{
			return selectedRow == 1;
		}

		public int selectedPile()
		{
			if (selectedRow == 1)
				return selectedCol;
			else
				return -1;
		}

		public void selectPile(int index)
		{
			selectedRow = 1;
			selectedCol = index;
		}

		public void mouseExited(MouseEvent e)
		{
		}

		public void mouseEntered(MouseEvent e)
		{
		}

		public void mouseReleased(MouseEvent e)
		{
		}

		public void mousePressed(MouseEvent e)
		{
		}

		public void mouseClicked(MouseEvent e)
		{
			//none selected previously
			int col = e.getX() / (SPACING + CARD_WIDTH);
			int row = e.getY() / (SPACING + CARD_HEIGHT);
			if (row > 1)
				row = 1;
			if (col > 6)
				col = 6;
/*
			if (row == 0 && col == 0)
				game.stockClicked();
			else if (row == 0 && col == 1)
				game.wasteClicked();
			else if (row == 0 && col >= 3)
				game.foundationClicked(col - 3);
			else if (row == 1)
				game.pileClicked(col);
				*/
			repaint();
		}

	}