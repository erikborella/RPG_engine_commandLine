package core.idControl;


import core.weapons.Ammunition;
import core.weapons.Melee;
import core.weapons.Ranged;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

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
            this.loadMelee(jsonArray);
            jsonArray = (JSONArray) jsonObject.get("ranged");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return true;
    }

    private void loadMelee(JSONArray array) {
        for (int i = 0; i < array.size(); i++) {
            String name = (String) ( (JSONObject) array.get(i) ).get("name");
            String description = (String) ( (JSONObject) array.get(i) ).get("description");
            int size = Integer.parseInt((String) ( (JSONObject) array.get(i) ).get("size"));
            double weight = Double.parseDouble((String) ( (JSONObject) array.get(i) ).get("weight"));
            new Melee(name, description, size, weight, "d");
        }
    }

    private void loadRanged(JSONArray array) {
        for (int i = 0; i < array.size(); i++) {
            String name = (String) ( (JSONObject) array.get(i) ).get("name");
            String description = (String) ( (JSONObject) array.get(i) ).get("description");
            int size = Integer.parseInt((String) ( (JSONObject) array.get(i) ).get("size"));
            double weight = Double.parseDouble((String) ( (JSONObject) array.get(i) ).get("weight"));

            //TODO: CREATE A RANGED OBJECTS
        }
    }
}
