import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class Facet {
	private R3Vector[] _vertex;
	private Color _color;
	
	public Facet(R3Vector v0, R3Vector v1, R3Vector v2, R3Vector v3, Color c) {
		_vertex = new R3Vector[4];
		_vertex[0] = v0;
		_vertex[1] = v1;
		_vertex[2] = v2;
		_vertex[3] = v3;
		_color = c;
	}
	
	public void scale(double u) {
		_vertex[0].scale(u);
		_vertex[1].scale(u);
		_vertex[2].scale(u);
		_vertex[3].scale(u);
	}
	
	public void rotate(double dx, double dy, double dz) {
		_vertex[0].rotate(dx, dy, dz);
		_vertex[1].rotate(dx, dy, dz);
		_vertex[2].rotate(dx, dy, dz);
		_vertex[3].rotate(dx, dy, dz);
	}

	public void translate(double dx, double dy, double dz) {
		_vertex[0].translate(dx, dy, dz);
		_vertex[1].translate(dx, dy, dz);
		_vertex[2].translate(dx, dy, dz);
		_vertex[3].translate(dx, dy, dz);
	}

	public void ortdraw(Graphics2D g) {
		if (R3Vector.vect(R3Vector.toR3Vector(_vertex[0], _vertex[1]),
				R3Vector.toR3Vector(_vertex[1], _vertex[2])).getZ() > 0) {
			Path2D p = new Path2D.Double();
			p.moveTo(_vertex[0].getX(), _vertex[0].getY());
			p.lineTo(_vertex[1].getX(), _vertex[1].getY());
			p.lineTo(_vertex[2].getX(), _vertex[2].getY());
			p.lineTo(_vertex[3].getX(), _vertex[3].getY());
			p.lineTo(_vertex[0].getX(), _vertex[0].getY());
			p.closePath();
			g.setColor(_color);
			//g.fill(p);
			g.setColor(Color.BLACK);
			g.draw(p);
		}
	}

	public void perstdraw(Graphics2D g, double c) {
			Path2D p = new Path2D.Double();
			double t = c / (c - _vertex[0].getZ());
			p.moveTo(_vertex[0].getX() * t, -_vertex[0].getY() * t);
			t = c / (c - _vertex[1].getZ());
			p.lineTo(_vertex[1].getX()* t, -_vertex[1].getY() * t);
			t = c / (c - _vertex[2].getZ());
			p.lineTo(_vertex[2].getX() * t, -_vertex[2].getY() * t);
			t = c / (c - _vertex[3].getZ());
			p.lineTo(_vertex[3].getX() * t, -_vertex[3].getY() * t);
			t = c / (c - _vertex[0].getZ());
			p.lineTo(_vertex[0].getX() * t, -_vertex[0].getY() * t);
			p.closePath();
			g.setColor(_color);
			//g.fill(p);
			g.setColor(Color.BLACK);
			g.draw(p);
	}
}
