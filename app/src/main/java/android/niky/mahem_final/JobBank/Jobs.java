package android.niky.mahem_final.JobBank;
public class Jobs {
    private String row,name,managment,phone;

    public String getRow() {
        return row;
    }

    public String getName() {
        return name;
    }

    public String getManagment() {
        return managment;
    }

    public String getPhone() {
        return phone;
    }

    public Jobs(String row, String name, String managment, String phone) {
        this.row = row;
        this.name = name;
        this.managment = managment;
        this.phone = phone;
    }
}