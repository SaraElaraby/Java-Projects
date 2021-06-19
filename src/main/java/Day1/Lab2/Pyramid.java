package Day1.Lab2;

public class Pyramid {
    String pharaoh;
    String modern_name;
    String site;
    double height;

    public Pyramid (String pharaoh, String modern_name, String site, Double height) {
        this.pharaoh = pharaoh;
        this.modern_name = modern_name;
        this.site = site;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public String getModern_name() {
        return modern_name;
    }

    public String getPharaoh() {
        return pharaoh;
    }

    public String getSite() {
        return site;
    }

    public void setHeight (double height) {
        this.height = height;
    }

    public void setModern_name (String modern_name) {
        this.modern_name = modern_name;
    }

    public void setPharaoh (String pharaoh) {
        this.pharaoh = pharaoh;
    }

    public void setSite (String site) {
        this.site = site;
    }

    public String toString () {
        return "Pyramid -----> Pharaoh : " + this.pharaoh + ", Modern Name : " + this.modern_name + ", Site : " + this.site + ", Height : " + this.height + "\n";
    }

}