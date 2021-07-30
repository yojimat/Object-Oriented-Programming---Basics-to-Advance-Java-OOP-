package InheritancePolymorphism_PresentsManagement;
public abstract class Sweet {
    private String name;
    private double weight;
    private double sugarWeight;

    public void setSugarWeight(double sugarWeight) {
        this.sugarWeight = sugarWeight;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    protected double getWeight() {
        return weight;
    }

    protected double getSugarWeight() {
        return sugarWeight;
    }

    protected String getName() {
        return name;
    }
}
