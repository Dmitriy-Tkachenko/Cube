import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Cube {
	
	private Facet[] facets;
	
	public Cube(){
		facets = new Facet[6];
		facets[0] = new Facet(new R3Vector(0,0,0), // ok
		new R3Vector(0,0,1),
		new R3Vector(0,1,1),
		new R3Vector(0,1,0),
		Color.BLUE);
		facets[1] = new Facet(new R3Vector(0,1,1), // ok
		new R3Vector(1,1,1),
		new R3Vector(1,1,0),
		new R3Vector(0,1,0),
		Color.RED);
		facets[2] = new Facet(new R3Vector(0,0,0), // ok
		new R3Vector(0,1,0),
		new R3Vector(1,1,0),
		new R3Vector(1,0,0),
		Color.PINK);
		facets[3] = new Facet(new R3Vector(0,0,0), // ok
		new R3Vector(1,0,0),
		new R3Vector(1,0,1),
		new R3Vector(0,0,1),
		Color.ORANGE);
		facets[4] = new Facet(new R3Vector(1,1,1), //
		new R3Vector(0,1,1),
		new R3Vector(0,0,1),
		new R3Vector(1,0,1),
		Color.GREEN);
		facets[5] = new Facet(new R3Vector(1,0,0),
		new R3Vector(1,1,0),
		new R3Vector(1,1,1),
		new R3Vector(1,0,1),
		Color.GRAY);
		}
	
	public void scale (double k) {
		for(int i = 0; i < facets.length; i++)
			facets[i].scale(k);
	}
	public void translate(double dx, double dy, double dz) {
		for(int i = 0; i < facets.length; i++)
			facets[i].translate(dx, dy, dz);
	}
	public void rotate(double dx, double dy, double dz) {
		for(int i = 0; i < facets.length; i++)
			facets[i].rotate(dx, dy, dz);
	}

	public void ortdraw(Graphics2D g) {
		for(int i = 0; i < facets.length; i++)
			facets[i].ortdraw(g);
	}

	public void perstdraw(Graphics2D g) {
		for(int i = 0; i < facets.length; i++)
			facets[i].perstdraw(g, 100);
	}

}
