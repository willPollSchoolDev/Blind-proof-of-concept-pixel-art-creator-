package mainPackage;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler
{
	LinkedList<Obj> Objects = new LinkedList<Obj>();
	
	public void render(Graphics g )
	{
		for(int i = 0; i < Objects.size(); i++)
		{
			Obj temp = Objects.get(i);
			temp.paint(g);
		}
	}
	
	
	public void addObj(Obj o)
	{
		Objects.add(o);
	}
}
