package core.map;

import core.map.mapIdControl.MapKeeper;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe para criaçao de mapas
 * @version 0.5
 */
public class MapCreator {

    private static ArrayList<File> blacklist = new ArrayList<File>();
    private HashMap<MapCord, String> symbolsCache = new HashMap<MapCord, String>();
    private File mapPath;

    /**
     * Exeção para se caso é tentado converter um arquivo ja convertido
     */
    public class CurrentMapSerializeExecption extends Exception {

        /**
         * Define a mensagem de erro
         * @param message Mensagem de erro
         */
        public CurrentMapSerializeExecption(String message) {
            super(message);
        }

        /**
         * Pega a mensagem de erro
         * @return Mensagem de erro
         */
        @Override
        public String getMessage() {
            return super.getMessage();
        }
    }
    private class MapCord {
        public int i;
        public int j;

        public MapCord(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object obj) {
            MapCord a = (MapCord) obj;
            return this.i == a.i && this.j == a.j;
        }

        @Override
        public int hashCode() {
            String temp = this.i + "" + this.j;
            return Integer.parseInt(temp);
        }
    }

    /**
     * Seta o mapa a ser serializado
     * @param mapPath arquivo do mapa
     * @throws FileNotFoundException Arquivo não existente
     */
    public MapCreator(File mapPath) throws FileNotFoundException {
        if (!mapPath.exists()) {
            throw new FileNotFoundException();
        }
        this.mapPath = mapPath;
    }

    /**
     * Faz a conversão do mapa, e retorna um objeto {@link Map} prontinho
     * @return Mapa convertido
     * @throws FileNotFoundException Arquivo inexistente
     * @throws CurrentMapSerializeExecption Arquivo atual, ou com mesmo nome ja foi convertido
     */
    public Map convertMap() throws FileNotFoundException, CurrentMapSerializeExecption {
        boolean alredySerialize = false;
        for (File path : this.blacklist) {
            if (path.getName().equals(this.mapPath.getName())) {
                alredySerialize = true;
                break;
            }
        }

        if (!alredySerialize) {
            String[][] preMap = this.toArray();
//            preMap = this.filtreMapWalls(preMap);
            if (this.mapLinks(preMap)) {
                this.blacklist.add(this.mapPath);

                preMap = this.filtreLinks(preMap);

                MapEntity[][] tempMap = new MapEntity[preMap.length][];
                Map map = new Map(tempMap, this.mapPath.getName());
                for (int i = 0; i < tempMap.length; i++) {
                    tempMap[i] = new MapEntity[preMap[i].length];
                    for (int j = 0; j < tempMap[i].length; j++) {
                        String mapName = "";
                        if ((mapName = this.symbolsCache.get(new MapCord(i, j))) != null) {
                            //is link
                            File file = this.getInPathFile(mapName);
                            if (!file.exists()) {
                                throw new FileNotFoundException();
                            } else {
                                MapCreator mapCreator = new MapCreator(file);
                                Map existentMap;
                                if ((existentMap = MapKeeper.getMapByName(file.getName())) != null) {
                                    if (existentMap.getName().equals(this.mapPath.getName())) {
                                        throw new CurrentMapSerializeExecption("Link do propio mapa");
                                    }
                                    tempMap[i][j] = new MapLink(null,
                                            preMap[i][j].charAt(0),
                                            existentMap);
                                } else {
                                    tempMap[i][j] = new MapLink(null,
                                            preMap[i][j].charAt(0),
                                            mapCreator.convertMap());
                                }
                            }
                        } else {
                            tempMap[i][j] = new MapEntity(null, preMap[i][j].charAt(0));
                        }
                    }
                }

                return map;

            } else {
                System.out.println("Links sintax error");
            }
        } else {
            System.out.println(this.mapPath.getName() + " Alredy seriaze");

        }

        return null;
    }

    private int getLineLength() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(this.mapPath));
            int lineSize = 0;
            while (bf.readLine() != null) {
                lineSize++;
            }

            return lineSize;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private File getInPathFile(String name) {
        int lastLash = this.mapPath.toString().lastIndexOf("/") + 1;
        if (lastLash < 0) {
            lastLash = this.mapPath.toString().lastIndexOf("\\") + 1;
        }
        File file = new File(this.mapPath.toString().substring(0, lastLash) + name);
        return file;
    }

    private String[][] toArray() {
        try {
            String[][] preArray;
            BufferedReader bf = new BufferedReader(new FileReader(this.mapPath));
            int lineSize = this.getLineLength();
            String line;
            preArray = new String[lineSize][];
            for (int i = 0; (line = bf.readLine()) != null; i++) {
                String[] tempLine = new String[line.length()];
                for (int j = 0; j < line.length(); j++) {
                    tempLine[j] = ""+line.charAt(j);
                }
                preArray[i] = tempLine;
            }
            return preArray;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String[][] filtreMapWalls(String[][] array) {
        String[][] tempArray = new String[array.length - 2][];

        int iTemp = 0, jTemp;

        for (int i = 0; i < array.length; i++) {
            jTemp = 0;
            //verifica se é canto
            if (!array[i][0].equals("┌") && !array[i][0].equals("└")) {
                tempArray[iTemp] = new String[array[i].length - 2];
                for (int j = 0; j < array[i].length; j++) {
                    if (!array[i][j].equals("│")) {
                        tempArray[iTemp][jTemp++] = array[i][j];
                    }
                }
                iTemp++;
            }
        }

        return tempArray;
    }

    private String concatStringArray(String[] arr) {
        StringBuilder temp = new StringBuilder("");
        for (String c : arr) {
            temp.append(c);
        }
        return temp.toString();
    }

    private boolean checkLinksPairs(String[][] map) {
        int openCont = 0, closeCont = 0;
        for (String[] line : map) {
            for (String c : line) {
                if (c.equals("{")) {
                    openCont++;
                } else if (c.equals("}")) {
                    closeCont++;
                }
            }
        }
        return openCont == closeCont;
    }

    private boolean mapLinks(String[][] map) {
        if (!checkLinksPairs(map)) {
            return false;
        }
        for (int i = 0; i < map.length; i++) {
            int lastLinkLength = 0;
            for (int j = 0; j < map[i].length; j++) {
                int tempLinkLength = 0;
                StringBuilder temp = new StringBuilder("");
                if (map[i][j].equals("{")) {
                    for (int k = j+1; k < map[i].length; k++) {
                        if (map[i][k].equals("}")) {
                            symbolsCache.put(new MapCord(i, (j-1) - lastLinkLength), temp.toString());
                            lastLinkLength += tempLinkLength + 2;
                            break;
                        } else {
                            temp.append(map[i][k]);
                            tempLinkLength++;
                        }
                    }
                }
            }
        }

        return true;
    }

    private String[][] filtreLinks(String[][] arr) {
        String[][] tempArr = new String[arr.length][];
        for (int i = 0; i < tempArr.length; i++) {
            ArrayList<String> tempLine = new ArrayList<String>();
            boolean inKey = false;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals("{")) {
                    inKey = true;
                } else if (arr[i][j].equals("}")) {
                    inKey = false;
                } else if (!inKey) {
                    tempLine.add(arr[i][j]);
                }
            }
            tempArr[i] = tempLine.toArray(new String[tempLine.size()]);
        }
        return tempArr;
    }

    /**
     * Gera um arquivo com um template pronto para o mapa de acordo com o tamanho dele
     * @param filePath Localização da criação do arquivo
     * @param height altura do mapa
     * @param weight largura do mapa
     * @return Se um arquivo com o mesmo nome existir, retorna false e não gera nada. Se não retorna true e cria o arquivo
     */
    public static boolean gerateTemplate(File filePath, int height, int weight) {
        if (filePath.exists()) {
            return false;
        }
        StringBuilder temp = new StringBuilder("");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if (i == 0 && j == 0) {
                    temp.append("┌");
                } else if (i == 0 && j == weight-1) {
                    temp.append("┐");
                } else if (i == height-1 && j == 0) {
                    temp.append("└");
                } else if (i == height-1 && j == weight-1) {
                    temp.append("┘");
                } else if (i == 0 || i == height-1) {
                    temp.append("─");
                } else if (j == 0 || j == weight-1) {
                    temp.append("│");
                } else {
                    temp.append(" ");
                }
            }
            temp.append("\n");
        }

        try {
            FileWriter a = new FileWriter(filePath);
            a.write(temp.toString());
            a.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        System.out.printf("Map template %s {%d, %d} create\n", filePath.getName(), height, weight);
        return true;
    }

}