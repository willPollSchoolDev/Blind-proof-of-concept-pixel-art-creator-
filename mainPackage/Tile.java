package mainPackage;
import java.awt.Color;
import java.awt.Graphics;
public class Tile extends Obj
{
	private int x;
	private int y;
	private int height, width;
	private final Color color;
	
	public Tile(int x, int y, int w, int h, Color c)
	{
		this.x = x;
		this.y = y;
		this.color = c;
		this.width = w;
		this.height = h;
	}
	public void paint(Graphics e)
	{
		e.setColor(color);
		e.fillRect(x, y, width, height);
	}
	@Override
	public String toString() {
		return "Tile [x=" + x + ", y=" + y + ", height=" + height + ", width=" + width + ", color=" + color + "]";
	}
}
