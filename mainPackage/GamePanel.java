package mainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel 
{
	private int R = 0;
	private int G = 0;
	private int B = 0;
	private Point[] buildArr;
	private Color[] buildArrC;
	private Point pass;
	private Color passC;
	
	private Tile[] buildArrT;
	
	private boolean showCursor = true;
	private int width;
	private int height;
	private int unitSize;
	private int mouseX,mouseY;
	private int keyToColor;
	private Handler handler;
	GamePanel(int H, int W, int U) 
	{
		handler = new Handler();
		buildArrT = new Tile[100];
		pass = new Point();
		buildArr = new Point[100];
		buildArrC = new Color[100];
		width = W;
		height = H;
		unitSize = U;
		this.setFocusable(true);
		this.requestFocus();
		this.addMouseWheelListener(new MyWheelListener());
		this.addKeyListener(new MyKeyAdapter());
		this.setSize(width,height);
		this.setVisible(true);
		this.setBackground(Color.WHITE);
		this.addMouseMotionListener(new MyMouseMovement());
		this.addMouseListener(new MyClickListener());
		 
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		
		
		
		for(int i = 0; i < height/unitSize; i++)
		{
			
			pass = mouseTest(g);

		}
		for(int i = 0; i < buildArr.length; i++)
		{
			if(buildArr[i] != null)
			{
				buildArrT[i] = new Tile(buildArr[i].x,buildArr[i].y,unitSize,unitSize,passC);
			}
			
		}
		handler.render(g);
		
		
	
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.blue);
		g.fillRect(0, unitSize, unitSize, 0);
		System.out.println("Drawing");
	}
	public class MyMouseMovement implements MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
			
			repaint();
			
		}
		
	}
	
	
	public Point mouseTest(Graphics g)
	{
		int boxX = 0;
		int boxY = 0;
		boolean draw = true;
		g.setColor(passC);
		if(showCursor)
		{
			for(int i = 0; i < width; i++)
			{
				// UPDATE X POSITION
				if(boxX > width)
				{
					draw = false;
				}
				if(mouseX == 0 && mouseX <= 25)
				{
					boxX = 0;
				}
				else if(mouseX >= 25*i && mouseX <= 25*(i+1))
				{
					boxX = 25*i;
				}
				
				// UPDATE Y POSITION
				if(boxY > height)
				{
					draw = false;
				}
				if(mouseX == 0 && mouseY <= 25)
				{
					boxY = 0;
				}
				else if(mouseY >= 25*i && mouseY <= 25*(i+1))
				{
					boxY = 25*i;
				}
			}
			if(draw)
			{
				g.fillRect(boxX, boxY, unitSize, unitSize);
			}
		}
		
		Point returnVal = new Point(boxX,boxY);
		return returnVal;
		
	}
	
	
	private class MyClickListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			if(e.getButton() == MouseEvent.BUTTON3)
			{
				showCursor = !showCursor;
				System.out.println("leftClick");
				
			}
			
			if(e.getButton() == MouseEvent.BUTTON1)
			{
				for(int i = 0; i < buildArr.length; i++)
				{
					if(buildArrC[i] == null)
					{
						buildArrC[i] = passC;
						
					}
					if(buildArr[i] == null)
					{
						buildArr[i] = pass;
						System.out.println("NEW POINT: " + buildArr[i].x + " " + buildArr[i].y + "WITH COLOR " + buildArrC[i]);
						handler.addObj(new Tile(buildArr[i].x,buildArr[i].y,unitSize,unitSize,passC));
						break;
					}
					
				}
				
			}
			repaint();
			
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	private class MyKeyAdapter extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e)
		{
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_1:
				keyToColor = 0;
				break;
			case KeyEvent.VK_2:
				keyToColor = 1;
				break;
			case KeyEvent.VK_3:
				keyToColor = 2;
				break;
			case KeyEvent.VK_0:
				passC = new Color(R,G,B);
				
			}
			repaint();
		}
	}

	private class MyWheelListener implements MouseWheelListener
	{
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			char cTc = 'R';
			
			
			switch(keyToColor)
			{
			case 0:
				cTc = 'R';
				break;
			case 1:
				cTc = 'G';
				break;
			case 2:
				cTc = 'B';
				break;
			}
			if(cTc == 'R')
			{
				if(R < 250)
				{
					if(e.getWheelRotation() == 1)
					{
						R+= 1;
						System.out.println(R);
					}
					if(e.getWheelRotation() == -1)
					{
						R-= 1;
					}
				}
				else if(R == 250)
				{
					if(e.getWheelRotation() == -1)
					{
						R -= 1;
					}
				}
			}
			if(cTc == 'G')
			{
				if(G < 250)
				{
					if(e.getWheelRotation() == 1)
					{
						G+= 1;
					}
					if(e.getWheelRotation() == -1)
					{
						G-= 1;
					}
				}
				else if(G == 250)
				{
					if(e.getWheelRotation() == -1)
					{
						G -= 1;
					}
				}
				System.out.println(G);
			}
			if(cTc == 'B')
			{
				if(B < 250)
				{
					if(e.getWheelRotation() == 1)
					{
						B+= 1;
						
					}
					if(e.getWheelRotation() == -1)
					{
						B-= 1;
					}
				}
				else if(B == 250)
				{
					if(e.getWheelRotation() == -1)
					{
						B -= 1;
					}
				}
				System.out.println(B);
			}
			
		}
	}
}
	