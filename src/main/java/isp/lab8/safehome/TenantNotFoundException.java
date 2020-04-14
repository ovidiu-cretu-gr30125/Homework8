package isp.lab8.safehome;

public class TenantNotFoundException extends  Exception {
    public String name;

    public TenantNotFoundException(String name,String msg){
        super(msg);
        this.name=name;
    }
}
