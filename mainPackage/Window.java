package mainPackage;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame 
{
	Window(int H, int W)
	{
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("prototype space game");
		this.add(new GamePanel(H,W,25));
		this.setSize(H,W);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	Window()
	{
Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int h = (int)size.getHeight();
		int w = (int)size.getWidth();
		
		this.add(new GamePanel(h,w,25));
		this.setSize(h,w);
		
		this.setTitle("prototype space game");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
