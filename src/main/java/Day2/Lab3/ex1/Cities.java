package Day2.Lab3.ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Cities {
    private int id;
    private int Cid;
    private String Name;
    private Boolean Capital;
    private double surfaceArea;
    private double population;


    public Cities (int id, int Cid, String Name, Boolean Capital, double surfaceArea, double population) {
        this.setId(id);
        this.setCid(Cid);
        this.setName(Name);
        this.setCapital(Capital);
        this.setSurfaceArea(surfaceArea);
        this.setPopulation(population);
    }

    public void setId (int id) {
        this.id = id;
    }
    public void setCid (int Cid) {
        this.Cid = Cid;
    }
    public void setName (String Name) {
        this.Name = Name;
    }
    public void setCapital (Boolean Capital) {
        this.Capital = Capital;
    }
    public void setSurfaceArea (double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }
    public void setPopulation (double population) {
        this.population = population;
    }
    public int getId () { return id; }
    public int getCid() {
        return Cid;
    }
    public String getName () {
        return Name;
    }
    public Boolean getCapital () {
        return Capital;
    }
    public Double getSurfaceArea () {
        return surfaceArea;
    }
    public Double getPopulation () {
        return population;
    }
    public String toString () {
        return  Name ;
    }

    public static List<Cities> readCitiesFile (String path) throws IOException {
        List<Cities> cities = new LinkedList<>();
        BufferedReader br;
        br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        do {
            line = br.readLine();
            if (line != null) {
                String[] attributes = line.split(",");
                Cities c = new Cities(0,0,null,false,0.0,0.0);
                if (!(attributes[0].isEmpty()))
                    c.setId(Integer.parseInt(attributes[0]));
                if (!(attributes[1].isEmpty()))
                    c.setCid(Integer.parseInt(attributes[1]));
                c.setName(attributes[2]);
                if (attributes[3].equalsIgnoreCase("yes"))
                    c.setCapital(true);
                if (!(attributes[4].isEmpty()))
                    c.setSurfaceArea(Integer.parseInt(attributes[4]));
                if (!(attributes[5].isEmpty()))
                    c.setPopulation(Integer.parseInt(attributes[5]));
                cities.add(c);
            }
        } while (line != null);
        br.close();
        return cities;
    }
}