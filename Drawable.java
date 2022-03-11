import java.awt.Color;

public abstract class Drawable {
    boolean isReflective;
    Color color;
    //abstract boolean intersects(Ray ray);
    abstract double closestIntersectionPoint(Ray ray);
    abstract Vector3d normal(Vector3d point);
    //abstract void precomputeCamera(Vector3d pos);
    abstract Drawable copy();
}