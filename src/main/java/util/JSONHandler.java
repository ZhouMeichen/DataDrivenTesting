package util;

import java.io.File;
import java.io.IOException;
import org.json.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import org.apache.commons.io.FileUtils;

public class JSONHandler {

    public JSONObject fromFile(String fileName) {
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
    
    public JSONObject fromString(String str) {
        return new JSONObject(str);
    }
    
    public boolean validateJSONSchema(String json, String schema) {
        JsonNode schemaNode;
        JsonSchemaFactory factory;
        JsonSchema jsonSchema;
        JsonNode jsonNode;
        ProcessingReport report = null;
        try {
            schemaNode = JsonLoader.fromString(schema);
            factory = JsonSchemaFactory.byDefault();
            jsonSchema = factory.getJsonSchema(schemaNode);
            jsonNode = JsonLoader.fromString(json);
            report = jsonSchema.validate(jsonNode);
        } catch (IOException | ProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return report.isSuccess();
    }
}
