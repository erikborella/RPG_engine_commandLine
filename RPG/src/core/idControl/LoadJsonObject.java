package core.idControl;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadJsonObject {
    File jsonPath;

    public LoadJsonObject(File jsonPath) {
        this.jsonPath = jsonPath;
    }

    public boolean load() {
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        if (!jsonPath.exists()) {
            return false;
        }
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(this.jsonPath));
            JSONArray jsonArray = (JSONArray) jsonObject.get("melee");
            System.out.println(jsonArray.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return true;
    }
}
