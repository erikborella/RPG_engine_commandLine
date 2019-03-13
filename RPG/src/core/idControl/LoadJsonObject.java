package core.idControl;


import core.weapons.*;
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
            this.loadMelee(jsonArray);
            jsonArray = (JSONArray) jsonObject.get("ranged");
            this.loadRanged(jsonArray);
            jsonArray = (JSONArray) jsonObject.get("ammunition");
            this.loadAmmunition(jsonArray);
            jsonArray = (JSONArray) jsonObject.get("shield");
            this.loadShield(jsonArray);
            jsonArray = (JSONArray) jsonObject.get("magic");
            this.loadMagic(jsonArray);

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
            String damage = (String) ((JSONObject) array.get(i)).get("damage");

            new Melee(name, description, size, weight, damage);
        }
    }

    private void loadRanged(JSONArray array) {
        for (int i = 0; i < array.size(); i++) {
            String name = (String) ( (JSONObject) array.get(i) ).get("name");
            String description = (String) ( (JSONObject) array.get(i) ).get("description");
            int size = Integer.parseInt((String) ( (JSONObject) array.get(i) ).get("size"));
            double weight = Double.parseDouble((String) ( (JSONObject) array.get(i) ).get("weight"));
            String damage = (String) ((JSONObject) array.get(i)).get("damage");
            int distance = Integer.parseInt((String) ( (JSONObject) array.get(i) ).get("distance"));

            new Ranged(name, description, size, weight, distance, damage);
        }
    }

    private void loadAmmunition(JSONArray array) {
        for (int i = 0; i < array.size(); i++) {
            String name = (String) ( (JSONObject) array.get(i) ).get("name");
            String description = (String) ( (JSONObject) array.get(i) ).get("description");
            int size = Integer.parseInt((String) ( (JSONObject) array.get(i) ).get("size"));
            double weight = Double.parseDouble((String) ( (JSONObject) array.get(i) ).get("weight"));
            double damage = Double.parseDouble((String) ((JSONObject) array.get(i)).get("damage"));

            new Ammunition(name, description, size, weight, damage, 0);
        }
    }

    private void loadShield(JSONArray array) {
        for (int i = 0; i < array.size(); i++) {
            String name = (String) ( (JSONObject) array.get(i) ).get("name");
            String description = (String) ( (JSONObject) array.get(i) ).get("description");
            int size = Integer.parseInt((String) ( (JSONObject) array.get(i) ).get("size"));
            double weight = Double.parseDouble((String) ( (JSONObject) array.get(i) ).get("weight"));
            String defence = (String) ( (JSONObject) array.get(i) ).get("defence");

            new Shield(name, description, size, weight, defence);
        }
    }

    private void loadMagic(JSONArray array) {
        for (int i = 0; i < array.size(); i++) {
            String name = (String) ( (JSONObject) array.get(i) ).get("name");
            String description = (String) ( (JSONObject) array.get(i) ).get("description");
            int size = Integer.parseInt((String) ( (JSONObject) array.get(i) ).get("size"));
            double weight = Double.parseDouble((String) ( (JSONObject) array.get(i) ).get("weight"));

            new Magic(name, description, size, weight);
        }
    }
}
