package Exercise1;

import javax.imageio.IIOException;
import java.io.*;

public class DoCrypt {
    public void encryptFile(File inputFile, File outputFile) throws CryptoException {
        try {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            fileInputStream.read(inputBytes);
            byte[] outputBytes = new byte[(int) inputBytes.length];
            for(int i=0;i<inputBytes.length;i++){
                outputBytes[i]= (byte) (inputBytes[i]-1);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            fileOutputStream.write(outputBytes);
        }catch (FileNotFoundException ex) {
            throw new CryptoException("Error in encrypting or decrypting the file! The file is missing!", ex);
        }catch (IOException ex){
            throw  new CryptoException("Error in encrypting or decrypting file!",ex);
        }
    }
    public void decryptFile(File inputFile,File outputFile) throws CryptoException{
        try {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int)inputFile.length()];
            fileInputStream.read(inputBytes);
            byte[] outputBytes = new byte[(int) inputBytes.length];
            for(int i=0;i<inputBytes.length;i++){
                outputBytes[i]=(byte) (inputBytes[i]+1);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            fileOutputStream.write(outputBytes);
        }catch (FileNotFoundException ex){
            throw new CryptoException("Error in encrypting or decrypting the file! The file is missing!", ex);
        }catch (IOException ex){
            throw  new CryptoException("Error in encrypting or decrypting file!",ex);
        }
    }
}
