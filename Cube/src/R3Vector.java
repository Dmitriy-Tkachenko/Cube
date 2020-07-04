public class R3Vector {
	public double x, y, z;
	
	
	public R3Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static R3Vector sum(R3Vector a, R3Vector b) {
		R3Vector c = new R3Vector(0, 0, 0);
		c.x = a.x + b.x;
		c.y = a.y + b.y;
		c.z = a.z + b.z;
		return c;
	}
	
	public static R3Vector minus(R3Vector a, R3Vector b) {
		R3Vector c = new R3Vector(0, 0, 0);
		c.x = a.x - b.x;
		c.y = a.y - b.y;
		c.z = a.z - b.z;
		return c;
	}
	
	public void scale(double b) {
		x *= b;
		y *= b;
		z *= b;
	}
	
	public static double mulScale(R3Vector a, R3Vector b) {
		double c = 0;
		c += a.x * b.x;
		c += a.y * b.y;
		c += a.z * b.z;
		return c;
	}
	
	public static R3Vector multiplyVector(R3Vector a, R3Vector b) {
		R3Vector c = new R3Vector(0, 0, 0);
		c.x = a.y * b.z - a.z * b.y;
		c.y = -(a.x * b.z - a.z * b.x);
		c.z = a.x * b.y - a.y * b.x;
		return c;
	}
	
	public static double mulMix(R3Vector a, R3Vector b, R3Vector c) {
		return mulScale(multiplyVector(a, b), c);
	}
	
	public void translate(double dx, double dy, double dz) {
		this.x += dx;
		this.y += dy;
		this.z += dz;
	}
	
	public void printVector() {
		System.out.println(this.x + " " + this.y + " " + this.z + " ");
	}
	
	public void rotateZ(double u) {
		u = Math.toRadians(u);
		double nx, ny;
		nx = this.x * Math.cos(u) - this.y * Math.sin(u);
		ny = this.x * Math.sin(u) + this.y * Math.cos(u);
		this.x = round100(nx);
		this.y = round100(ny);
	}
	
	public void rotateX(double u) {
		u = Math.toRadians(u);
		double nz, ny;
		ny = -this.z * Math.sin(u) + this.y * Math.cos(u);
		nz = this.z * Math.cos(u) + this.y * Math.sin(u);
		this.z = round100(nz);
		this.y = round100(ny);
	}
	
	public void rotateY(double u) {
		u = Math.toRadians(u);
		double nx, nz;
		nx = this.x * Math.cos(u) + this.z * Math.sin(u);
		nz = -this.x * Math.sin(u) + this.z * Math.cos(u);
		this.x = round100(nx);
		this.z = round100(nz);
	}
	
	public void rotate(double ux, double uy, double uz){
		rotateX(ux);
		rotateY(uy);
		rotateZ(uz);
	}
	
	public static R3Vector toR3Vector(R3Vector b, R3Vector e) {
		return new R3Vector(e.x - b.x,
							e.y - b.y,
							e.z - b.z);
	}
	
	public static R3Vector vect(R3Vector a, R3Vector b) {
		return new R3Vector(a.y*b.z - a.z*b.y,
				a.z*b.x - a.x*b.z,
				a.x*b.y - a.y*b.x);
	}
	
	public static double round100(double a) {
		return (double)((int)(a * 100)) / 100;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}

}
