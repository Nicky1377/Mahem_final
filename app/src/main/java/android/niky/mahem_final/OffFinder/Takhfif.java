package android.niky.mahem_final.OffFinder;



public class Takhfif {
    private String last_c,new_c,t_percent,t_describe,t_city;
    private int t_image;

    public Takhfif(String last_c, String new_c, String t_percent, String t_describe , String t_city,int t_image) {
        this.last_c = last_c;
        this.new_c = new_c;
        this.t_percent = t_percent;
        this.t_describe = t_describe;
        this.t_city = t_city;

        this.t_image=t_image;
    }

    public int getT_image() {
        return t_image;
    }

    public String getLast_c() {
        return last_c;
    }

    public String getNew_c() {
        return new_c;
    }

    public String gett_percent() {
        return t_percent;
    }

    public String getT_describe() {
        return t_describe;
    }

    public String getT_city() {
        return t_city;
    }
}

