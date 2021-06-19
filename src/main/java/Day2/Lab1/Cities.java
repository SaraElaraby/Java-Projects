package Day2.Lab1;

public class Cities {
    private String id;
    private String Cid;
    private String Name;
    private String Capital;
    private String surfaceArea;
    private String population;
    
    public Cities (String id, String Cid, String Name, String Capital, String surfaceArea, String population) {
        this.setId(id);
        this.setCid(Cid);
        this.setName(Name);
        this.setCapital(Capital);
        this.setSurfaceArea(surfaceArea);
        this.setPopulation(population);
    }

    public void setId (String id) {
        this.id = id;
    }
    public void setCid (String Cid) {
        this.Cid = Cid;
    }
    public void setName (String Name) {
        this.Name = Name;
    }
    public void setCapital (String Capital) {
        this.Capital = Capital;
    }
    public void setSurfaceArea (String surfaceArea) {
        this.surfaceArea = surfaceArea;
    }
    public void setPopulation (String population) {
        this.population = population;
    }
    public String getId () {
        return id;
    }
    public String getCid () {
        return Cid;
    }
    public String getName () {
        return Name;
    }
    public String getCapital () {
        return Capital;
    }
    public String getSurfaceArea () {
        return surfaceArea;
    }
    public String getPopulation () {
        return population;
    }
    public String toString () {
        return  Name ;
    }
}