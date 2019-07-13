package android.niky.mahem_final.other;


public class ImageItem {


    private String image,id,noe;

    public ImageItem()
    {

    }

    public ImageItem(String img)
    {
image=img;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNoe(String noe) {
        this.noe = noe;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getNoe() {
        return noe;
    }

    public String getImage() {
        return image;
    }
}
