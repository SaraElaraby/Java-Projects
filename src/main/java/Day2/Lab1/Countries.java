package Day2.Lab1;

public class Countries {
    private String cid;
    private String name,continent;
    
    public Countries (String cid, String name, String continent) {
        this.cid = cid;
        this.name = name;
        this.continent = continent;
    }
    
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String toString() {
        return name;
    }



}
