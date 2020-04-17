package isp.lab8.safehome;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccessLogDisplay {
    List<AccessLog> accessLogList = new ArrayList<AccessLog>();
    public void readFile() {
        try (
                final FileInputStream fileInputStream = new FileInputStream("accessLog{1587149882920}.dat");
                final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            final AccessLog accessLog = (AccessLog)objectInputStream.readObject();
            accessLogList.add(accessLog);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void displayAccessLogList(){
        System.out.println(accessLogList.toString());
    }
}
