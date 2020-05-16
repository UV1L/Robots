package StateLogic;

/**
 * Класс с полями состояния окна
 * @version 1.0
 */
public class State {

    private final boolean isVisible;
    private final Pair<Integer, Integer> position;
    private final Pair<Integer, Integer> coordinates;

    /**
     *
     * @param isVisible - виден ли фрэйм
     * @param position - позиция фрэйма
     * @param coordinates - координаты фрэйма
     */
    public State(boolean isVisible, Pair<Integer, Integer> position, Pair<Integer, Integer> coordinates) {
        this.isVisible = isVisible;
        this.position = position;
        this.coordinates = coordinates;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    public Pair<Integer, Integer> getCoordinates() {
        return coordinates;
    }
}
