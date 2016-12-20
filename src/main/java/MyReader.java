import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.regex.Pattern;

public class MyReader {
    private String path;

    MyReader(String path) {
        this.path = path;
    }

    public String[] readerWords() {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(this.path));
            String line = reader.readLine();
            if(line==null){
                return null;
            }
            Pattern pattern2 = Pattern.compile("[\\s,-.\"?':!]+");
            String[] str = pattern2.split(line);
            return str;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}


