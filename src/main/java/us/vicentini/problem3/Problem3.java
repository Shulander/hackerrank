package us.vicentini.problem3;

import java.util.*;

public class Problem3
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int w = in.nextInt();
		int h = in.nextInt();
		int circleX = in.nextInt();
		int circleY = in.nextInt();
		int r = in.nextInt();
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x3 = in.nextInt();
		int y3 = in.nextInt();

		Circle c = new Circle(circleX, circleY, r);
		MySquare s = new MySquare(x1, h - y1 - 1, x3, h - y3 - 1);

		for(int i = 0; i < h; i++)
		{
			for(int j = 0; j < w; j++)
			{
				System.out.print((c.isInside(j, i) || s.isInside(j, h - i - 1) ? '#' : '.'));
			}
			System.out.println("");
		}
		// your code goes here
	}

	public static class Circle
	{

		private final double x;
		private final double y;
		private final double r;

		public Circle(int circleX, int circleY, int r)
		{
			this.x = circleX;
			this.y = circleY;
			this.r = r;
		}

		public boolean isInside(int x1, int y1)
		{
			double d = Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
			return d <= r;
		}

	}

	private static class MySquare
	{
		private static final double ERROR = 0.000000000001;
		private final double x1;
		private final double y1;
		private final double x2;
		private final double y2;
		private final double hip;
		private double angle;
		private final double dx2;
		private final double dy2;

		public MySquare(int _x1, int _y1, int _x2, int _y2)
		{
			if(_x1 < _x2)
			{
				this.x1 = _x1;
				this.y1 = _y1;
				this.x2 = _x2;
				this.y2 = _y2;
			}
			else
			{
				this.x1 = _x2;
				this.y1 = _y2;
				this.x2 = _x1;
				this.y2 = _y1;
			}

			hip = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

			if(_y2 == y1)
			{
				angle = 0;
			}
			else
			{
				angle = Math.atan2(y2 - y1, x2 - x1);
			}

			angle = Math.PI / 4 - angle;

//			System.out.println("angle: " + (angle * 180 / Math.PI));

			dx2 = Math.cos(angle) * (x2 - x1) - Math.sin(angle) * (y2 - y1);
			dy2 = Math.sin(angle) * (x2 - x1) + Math.cos(angle) * (y2 - y1);

//			System.out.println("(" + dx2 + "," + dy2 + ")");

		}

		public boolean isInside(final int _x, final int _y)
		{
			if(_x == 9 && _y == 0)
			{
				int a = 10;
			}

			double dx = Math.cos(angle) * (_x - x1) - Math.sin(angle) * (_y - y1);
			double dy = Math.sin(angle) * (_x - x1) + Math.cos(angle) * (_y - y1);
			
//			dx = Math.round(dx*100000)/100000.0;
//			dy = Math.round(dy*100000)/100000.0;

			boolean returnValue = dx+ERROR >= 0 && dx-ERROR <= dx2 && dy+ERROR >= 0 && dy-ERROR <= dy2;

			if(returnValue == true)
			{
//				System.out.println("adsf");
			}

			return returnValue;
		}

	}
}
