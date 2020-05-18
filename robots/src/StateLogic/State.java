package StateLogic;

/**
 * Класс с полями состояния окна
 * @version 1.0
 */
public class State {

    private final boolean isVisible;
    private final boolean isDisplayable;
    private final Pair<Integer, Integer> position;
    private final Pair<Integer, Integer> coordinates;

    /**
     *
     * @param isVisible - свернут ли фрейм
     * @param isDisplayable - открыт ли фрейм
     * @param position - позиция фрэйма
     * @param coordinates - координаты фрэйма
     */
    public State(boolean isVisible, boolean isDisplayable, Pair<Integer, Integer> position, Pair<Integer, Integer> coordinates) {
        this.isVisible = isVisible;
        this.isDisplayable = isDisplayable;
        this.position = position;
        this.coordinates = coordinates;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public boolean isDisplayable() {
        return isDisplayable;
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    public Pair<Integer, Integer> getCoordinates() {
        return coordinates;
    }
}
