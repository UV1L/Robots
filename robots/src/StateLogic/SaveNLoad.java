package StateLogic;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Класс для загрузки состояний объектов в файл и выгрузки из того же файла
 * @version 1.0
 */
public class SaveNLoad {

    /**
     * записывает состояния в файл
     * @param allStates хэш мап со всеми состояниями всех объектов разделенных по префиксам
     */
    public void saveStates(HashMap<String, State> allStates) {
        try {
            FileWriter file = new FileWriter("states.txt");
            for (var key: allStates.keySet()) {
                file.write(key + " " + allStates.get(key).getPosition().first() +
                        " " + allStates.get(key).getPosition().second() +
                        " " + allStates.get(key).getCoordinates().first() +
                        " " + allStates.get(key).getCoordinates().second() +
                        " " + allStates.get(key).isVisible() +
                        " " + allStates.get(key).isIcon() + '\n');
            }
            file.close();
        }

        catch (IOException ignored) {
        }
    }

    /**
     * возвращает состояния прочитанные из файла
     * @return ArrayList строк состояний
     */
    public ArrayList<String> loadStates() {
        ArrayList<String> states = new ArrayList<>();
        try {
            FileReader allStates = new FileReader("states.txt");
            Scanner scanner = new Scanner(allStates);
            while (scanner.hasNextLine()) {
                states.add(scanner.nextLine());
            }
            return states;
        }

        catch (IOException ignored) {
            return new ArrayList<>();
        }
    }


}
