package isp.lab8.safehome;

public class TooManyAttemptsException extends Exception {
    String MASTER_KEY;

    public TooManyAttemptsException(String MASTER_KEY,String msg){
        super(msg);
        this.MASTER_KEY=MASTER_KEY;
    }
}
