package core.map;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MapCreator {

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