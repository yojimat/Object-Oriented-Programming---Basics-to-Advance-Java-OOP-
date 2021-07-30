package InheritancePolymorphism_PresentsManagement;
public abstract class Cookie extends Sweet {
    private double doughWeight;

    public void setDoughWeight(double weight) {
        doughWeight = weight;
    }

    public double getDoughWeight() {
        return doughWeight;
    }
}
