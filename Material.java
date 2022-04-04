import java.awt.*;

public abstract class Material {
    protected Color color;
    public Color getColor(Vector3d pos, Vector3d normal, Scene scene, Camera cam){
        return color;
    }
    abstract boolean bounces();
    abstract Ray bouncedRay(Ray ray, Vector3d normal, Vector3d pos);
}