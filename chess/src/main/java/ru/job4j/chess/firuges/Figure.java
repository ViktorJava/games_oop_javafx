package ru.job4j.chess.firuges;

/**
 * Интерфейс описывающий поведение фигур.
 */
public interface Figure {
    /**
     * Это метод используется для получения позиции фигуры на поле. Он возвращает тип перечисления.
     *
     * @return позиция фигуры на поле.
     */
    Cell position();

    /**
     * Этот метод возвращает массив с клетками, которые должна пройти фигура от клетки source до клетки dest.
     *
     * @param source начальная клетка пути.
     * @param dest   конечная клетка пути.
     * @return путь.
     */
    Cell[] way(Cell source, Cell dest);

    /**
     * Этот метод возвращает имя картинки фигуры. Этот метод имеет реализацию по умолчанию.
     *
     * @return имя картинки фигуры.
     */
    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }

    /**
     * Этот метод создаст объект класса с позицией dest.
     */
    Figure copy(Cell dest);


}
