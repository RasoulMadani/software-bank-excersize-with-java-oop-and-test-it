package baseClasses;

public class Disc {
    private String name;

    public Disc(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Disc{" +
                "name='" + name + '\'' +
                '}';
    }
}
