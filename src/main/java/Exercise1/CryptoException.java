package Exercise1;

public class CryptoException extends Exception {
    public CryptoException(String msg,Throwable throwable){
        super(msg,throwable);
    }
}
