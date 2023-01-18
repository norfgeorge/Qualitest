package Utilities;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("src/test/java/ConfigFiles/config.properties");
        Properties p = new Properties();

        p.load(fr);
    }
}

