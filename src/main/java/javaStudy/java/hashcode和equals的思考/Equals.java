package javaStudy.java.hashcode和equals的思考;

/**
 * @author dhslegen
 */
public class Equals {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Equals(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Equals) {
            return id.equals(((Equals) obj).getId());
        }
        return false;
    }

}
