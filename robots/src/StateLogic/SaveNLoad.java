package StateLogic;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для загрузки состояний объектов в файл и выгрузки из того же файла
 * @version 1.0
 */
public class SaveNLoad {
    private final String file = System.getProperty("user.home") + "\\data";

    /**
     * записывает состояния в файл
     * @param allStates хэш мап со всеми состояниями всех объектов разделенных по префиксам
     */
    public void saveStates(HashMap<String, State> allStates) {
        try (var fos = new FileOutputStream(file);
             var oos = new ObjectOutputStream(fos)) {
            oos.writeObject(allStates);
            oos.close();
        }

        catch (IOException ignored) {
        }
    }

    /**
     * возвращает состояния прочитанные из файла
     * @return хэш мап прочитанный из файла со всеми состояниями и префиксами
     */
    public HashMap<String, State> loadStates() {
        try (var fis = new FileInputStream(file);
             var ois = new ObjectInputStream(fis)) {

            return (HashMap<String, State>) ois.readObject();
        }

        catch (IOException | ClassNotFoundException ignored) {
            return new HashMap<>();
        }
    }


}
