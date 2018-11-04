package android.niky.mahem_final.JobBank;

public class Job_Sabt_Class {

    private String modiriat,senf_type,sabt_num,phone_office,mobile,fax,address,telegram,insta,email,tozihat;

    public String getModiriat() {
        return modiriat;
    }

    public String getSenf_type() { return senf_type; }

    public String getSabt_num() { return sabt_num; }

    public String getPhone_office() { return phone_office; }

    public String getMobile() { return mobile; }

    public String getFax() { return fax; }

    public String getAddress() { return address; }

    public String getTelegram() { return telegram; }

    public String getInsta() { return insta; }

    public String getEmail() { return email; }

    public String getTozihat() { return tozihat; }

    public void setEmail(String email) { this.email = email; }

    public void setFax(String fax) { this.fax = fax; }

    public void setInsta(String insta) { this.insta = insta; }

    public void setMobile(String mobile) { this.mobile = mobile; }

    public void setSabt_num(String sabt_num) { this.sabt_num = sabt_num; }

    public void setTelegram(String telegram) { this.telegram = telegram; }

    public void setTozihat(String tozihat) { this.tozihat = tozihat; }

    public Job_Sabt_Class(String m,String senf,String phone,String ad)
    {
        this.modiriat=m;
        this.senf_type=senf;
        this.phone_office=phone;
        this.address=ad;
        this.sabt_num="";
        this.email="";
        this.fax="";
        this.telegram="";
        this.mobile="";
        this.insta="";
        this.tozihat="";
    }

    public void Network()
    {

    }
}
