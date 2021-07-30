package classesExercise_BookManagement;

import java.util.Objects;

public class Publisher {
    private int id;
    private String publisherName;

    public Publisher(int id, String publisherName) {
        this.id = id;
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return "Publisher{" + "id=" + id + ", publisherName=" + publisherName + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Publisher publisher = (Publisher) o;
        return id == publisher.id && Objects.equals(publisherName, publisher.publisherName);
    }
}
