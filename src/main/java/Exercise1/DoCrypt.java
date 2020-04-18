package Exercise1;

import javax.imageio.IIOException;
import java.io.*;

public class DoCrypt {
    /**
     * this method should encrypt the content of the text file by shifting the ascii code of each character left with one position
     * @param inputFile the file that has to be encrypted
     * @param outputFile the encrypted file
     * @throws CryptoException throws exception if the file can not be found or if the encryption process fails
     */
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

    /**
     * this method should decrypt the encrypted text from the file by shifting right whit one position
     * @param inputFile the encrypted file that has to be decrypted
     * @param outputFile the decrypted file
     * @throws CryptoException throws exception if the file is missing or the decryption fails
     */
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
