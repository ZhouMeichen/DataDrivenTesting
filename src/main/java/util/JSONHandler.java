package util;

import java.io.File;
import java.io.IOException;
import org.json.*;
import org.apache.commons.io.FileUtils;

public class JSONHandler {

    public JSONObject parse(String fileName) {
         File file = new File(fileName);
         String content;
         JSONObject jsonObj = null;
        try {
            content = FileUtils.readFileToString(file, "utf-8");
            jsonObj = new JSONObject(content);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
         return jsonObj;
    }
}
