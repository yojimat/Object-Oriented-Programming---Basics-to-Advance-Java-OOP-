package hometasksOOP.InheritancePolymorphism_PresentsManagement;
import java.util.List;
import java.util.ArrayList;

public class Present {
    private List<Sweet> present;

    public Present() {
        present = new ArrayList<Sweet>();
    }

    public void addSweet(Sweet sweet) {
        if(sweet == null) return;

        present.add(sweet);
    }

    public double calculateTotalWeight() {
        double totalWeight = 0;
        for (Sweet sweet : present) {
            if(sweet != null)
                totalWeight += sweet.getWeight();
        }
        return totalWeight;
    }

    public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight) {
        List<Sweet> filteredSweets = new ArrayList<Sweet>();
        for (Sweet sweet : present) {
            if (sweet != null && sweet.getSugarWeight() >= minSugarWeight && sweet.getSugarWeight() <= maxSugarWeight) {
                filteredSweets.add(sweet);
            }
        }
        return filteredSweets.toArray(new Sweet[filteredSweets.size()]);
    }

    public Sweet[] getSweets() {
        return present.toArray(new Sweet[present.size()]);
    }
}