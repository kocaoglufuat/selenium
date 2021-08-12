package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //Properties objesı olustursak
    //bu objenın projenın her yerınden class ısmı ıle cagrılabılmesı ıcın statıc yapıyoruz
    static private Properties properties;

    static {
        String path="src/configuration.properties";
        try {
            FileInputStream fileInputStream= new FileInputStream(path);
            properties=new Properties();

           //bu class calıstıgında statıc block calısacak
            //ve tek bır ıslem yapacak

            properties.load(fileInputStream);

           fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getproperty(String key){
        return properties.getProperty(key);
    }



}

