package StateLogic;

/**
 * Класс с полями состояния окна
 * @version 1.1
 */
public class State {
    private final boolean isVisible;
    private final boolean isIcon;
    private final Pair<Integer, Integer> bounds;
    private final Pair<Integer, Integer> coordinates;

    /**
     *
     * @param isVisible - свернут ли фрейм
     * @param isIcon - открыт ли фрейм
     * @param bounds - размеры рамок фрэйма
     * @param coordinates - координаты фрэйма
     */
    public State(boolean isVisible, boolean isIcon, Pair<Integer, Integer> bounds, Pair<Integer, Integer> coordinates) {
        this.isVisible = isVisible;
        this.isIcon = isIcon;
        this.bounds = bounds;
        this.coordinates = coordinates;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public boolean isIcon() {
        return isIcon;
    }

    public Pair<Integer, Integer> getBounds() {
        return bounds;
    }

    public Pair<Integer, Integer> getCoordinates() {
        return coordinates;
    }
}
