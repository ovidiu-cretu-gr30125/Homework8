package Exercise1;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ConsoleUI {
    public static void main(String [] args) throws CryptoException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Type #encrypt# to encrypt a file\nType #decrypt# to decrypt a file\nType #exit# to exit.");
            if(UI(scanner.next(),scanner)) return ;
        }
    }
    private static boolean UI(String action, Scanner scanner) throws CryptoException {
        DoCrypt doCrypt = new DoCrypt();
        switch (action) {
            case "encrypt":
                System.out.println("Enter the name of the file you want to encrypt: ");
                String inputFileName = scanner.next();
                String inputFileNameWithoutExtension;
                int index = inputFileName.lastIndexOf('.');
                if (index == -1) {
                    inputFileNameWithoutExtension=inputFileName;
                } else {
                    inputFileNameWithoutExtension= inputFileName.substring(0, index);
                }
                File inputFile = new File(inputFileName);
                File outputFile = new File("" + inputFileNameWithoutExtension + ".enc");
                doCrypt.encryptFile(inputFile, outputFile);
                break;
            case "decrypt":
                System.out.println("Enter the name of the file you want to decrypt: ");
                String inputFileName1 = scanner.next();
                String inputFileNameWithoutExtension1;
                int index1 = inputFileName1.lastIndexOf('.');
                if (index1 == -1) {
                    inputFileNameWithoutExtension1=inputFileName1;
                } else {
                    inputFileNameWithoutExtension1= inputFileName1.substring(0, index1);
                }
                File inputFile1 = new File(inputFileName1);
                File outputFile1 = new File(""+inputFileNameWithoutExtension1+".dec");
                doCrypt.decryptFile(inputFile1,outputFile1);
                break;
            case "exit":
                return true;
            default:
                System.out.println("Wrong option!");
        }
        return false;
    }
}
