package core.idControl;

import core.GameObject;
import core.weapons.Ammunition;
import core.weapons.Melee;
import core.weapons.Ranged;
import core.weapons.Shield;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Essa classe serve para carregar objetos nos arquivos de configuraçoes deles em formato json
 */
public class LoadObject {

    private ArrayList<File> files = new ArrayList<>();
    private final String[] WEAPONS_TYPE = {"melee", "shield", "ranged", "ammunition", "magic"};

    JSONParser jsonParser = new JSONParser();

    /**
     * Recebe uma pasta inicial que devera conter todos os itens basicos
     * @param jsonFolder Pasta de configuraçao basica de objetos
     */
    public LoadObject(File jsonFolder) {
        for (File file : jsonFolder.listFiles()) {
            if (file.isFile() && this.isJson(file)) {
                this.files.add(file);
            }
        }
    }


    private boolean isJson(File file) {
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf('.')+1, fileName.length());
        return extension.equals("json");
    }

    /**
     * Procura por um objeto de jogo nos arquivos de configuraçoes adicionados e retorna uma instacia dele
     * @param name Nome do objeto
     * @return
     */
    public GameObject getByName(String name) {
        for (File file : this.files) {
            try {
                JSONObject json = (JSONObject) this.jsonParser.parse(new FileReader(file));
                for (String weaponType : this.WEAPONS_TYPE) {
                    JSONArray weaponArray = (JSONArray) json.get(weaponType);
                    for (int i = 0; i < weaponArray.size(); i++) {
                        JSONObject weapon = (JSONObject) weaponArray.get(i);
                        if (weapon.get("name").equals(name)) {
                            GameObject object = this.getNewWeapon(weapon, weaponType);
                            return object;
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private GameObject getNewWeapon(JSONObject weaponJson, String weaponType) {
        String name, description, damage, defence;
        int size, distance;
        double weight;

        name = (String) weaponJson.get("name");
        description = (String) weaponJson.get("description");
        size = Integer.parseInt((String) weaponJson.get("size"));
        weight = Double.parseDouble((String) weaponJson.get("weight"));

        if (weaponType.equals("melee")) {
            damage = (String) weaponJson.get("damage");
            return new Melee(name, description, size, weight, damage);
        }

        if (weaponType.equals("shield")) {
            defence = (String) weaponJson.get("defence");
            return new Shield(name, description, size, weight, defence);
        }

        if (weaponType.equals("ranged")) {
            distance = Integer.parseInt((String) weaponJson.get("distance"));
            damage = (String) weaponJson.get("damage");
            return new Ranged(name, description, size, weight, distance, damage);
        }

        if (weaponType.equals("ammunition")) {
            damage = (String) weaponJson.get("damage");
            return new Ammunition(name, description, size, weight, damage, 1);
        }

//      TODO

//        if (weaponType.equals("magic")) {
//
//        }
        return null;
    }


}
