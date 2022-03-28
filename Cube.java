import java.awt.Color;
import java.util.LinkedList;
import java.util.Objects;

public class Cube extends Drawable {

    private double largeur; // axe y
    private double hauteur; // axe z
    private double profondeur; // axe x
    private Vector3d center;
    private boolean isReflective;
    private LinkedList <Vector3d> interBons; // Liste où l'on stocke les intersections du rayon avec les plans du cube
    private LinkedList <Plane> listPlans;  // Liste des 6 plans constituants le cube

    public Cube(double _largeur, double _hauteur, double _profondeur, Vector3d _center, boolean _isReflective, Color _color) {
        listPlans = new LinkedList<Plane>();
        interBons = new LinkedList<Vector3d>();
        largeur = _largeur;
        hauteur = _hauteur;
        profondeur = _profondeur;
        center = _center;
        isReflective = _isReflective;
        color = _color;
        fill(); // On remplit la liste des plans
    }

    private void fill () { // Cette méthode permet d'initialiser les plans dans la liste, cad 6 plans pour un cube
        Vector3d centrePlans; // Variable pour stocker le centre des plans, pour alléger les expressions

        centrePlans = (center.add(new Vector3d (profondeur/2, 0, 0)));  // On centre les plans selon les 3 directions x, y et z
        listPlans.add(new Plane(new Vector3d(1, 0, 0), centrePlans, color, isReflective ));

        centrePlans = (center.add(new Vector3d (-profondeur/2, 0, 0)));
        listPlans.add(new Plane(new Vector3d(-1, 0, 0), centrePlans, color, isReflective ));

        centrePlans = (center.add(new Vector3d (0, largeur/2, 0)));
        listPlans.add(new Plane (new Vector3d(0, 1, 0), centrePlans, color, isReflective));

        centrePlans = (center.add(new Vector3d (0, -largeur/2, 0)));
        listPlans.add(new Plane (new Vector3d(0, -1, 0), centrePlans, color, isReflective));

        centrePlans = (center.add(new Vector3d (0, 0, hauteur/2)));
         listPlans.add(new Plane(new Vector3d (0, 0, 1), centrePlans, color, isReflective));

        centrePlans = (center.add(new Vector3d (0, 0, -hauteur/2)));
        listPlans.add(new Plane (new Vector3d(0, 0, -1), centrePlans, color, isReflective));
    }

    double closestIntersectionPoint(Ray ray) {
        double t; // distance émission
        Vector3d pointInter;
        double tMin = Double.MAX_VALUE;

        for (Plane unPlan : listPlans ) {
           t = unPlan.closestIntersectionPoint(ray);

           if (t > 0) {
               pointInter = ray.at(t); // récupère les coordonnées du point

               if(appartient(pointInter)) {  // Si l'intersection est sur un point du cube
                    if(t < tMin) {
                        tMin = t;
                        interBons.add(pointInter); // On ajoute le Vecteur 3D danns la liste des intersections bonnes, qui représente le vecteur allant de la caméra au point d'intersection
                    }
               }
           }
        }
        return (tMin == Double.MAX_VALUE ? -1: tMin);
    }


    private boolean appartient (Vector3d point){
        Vector3d versCentre = center.sub(point); // Renvoie la distance du point d'intersection au centre du cube

        return (Math.abs(versCentre.x) < (profondeur+0.01)/2 && Math.abs(versCentre.y) < (largeur+0.01)/2 && Math.abs(versCentre.z) < (hauteur+0.01)/2); // renvoie true si le point intersection est dans le cube, false sinon
    }

    Vector3d normal(Vector3d point) {
        for (Plane unPlan : listPlans) {
           //return new Vector3d(unPlan.normal(new Vector3d (0,0,0)));
        }

       return new Vector3d(-1, 0, 0); // temporaire
    }

    Drawable copy() {

        return new Cube(largeur, hauteur, profondeur, center, isReflective, color);
    }

    /*public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
            for(Plane unPlan : listPlans) {
                return Objects.equals(unPlan.normal(new Vector3d(0,0,0)), cube.normal(new Vector3d(0,0,0))) && Objects.equals(center, cube.center);
            }

            return true; // temporaire
    }*/

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return largeur == cube.largeur && hauteur == cube.hauteur && profondeur == cube.profondeur && isReflective == cube.isReflective && Objects.equals(center, cube.center);
    }
}
