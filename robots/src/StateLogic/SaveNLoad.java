package StateLogic;

import java.io.*;
import java.util.*;

/**
 * Класс для загрузки состояний объектов в файл и выгрузки из того же файла
 * @version 1.1
 */
public class SaveNLoad {
    final String fileName = "states.txt";

    /**
     * записывает состояния в файл
     * @param allStates хэш мап со всеми состояниями всех объектов разделенных по префиксам
     */
    public void saveStates(Map<String, State> allStates) {
        try (FileWriter file = new FileWriter(fileName)) {
            for (var key: allStates.keySet()) {
                file.write(key + " " + allStates.get(key).getBounds().first() +
                        " " + allStates.get(key).getBounds().second() +
                        " " + allStates.get(key).getCoordinates().first() +
                        " " + allStates.get(key).getCoordinates().second() +
                        " " + allStates.get(key).isVisible() +
                        " " + allStates.get(key).isIcon() + '\n');
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * возвращает состояния прочитанные из файла
     * @return ArrayList строк состояний
     */
    public List<String> loadStates() {
        List<String> states = new ArrayList<>();
        try (FileReader allStates = new FileReader(fileName)) {
            Scanner scanner = new Scanner(allStates);
            while (scanner.hasNextLine()) {
                states.add(scanner.nextLine());
            }
            return states;
        }
        catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
