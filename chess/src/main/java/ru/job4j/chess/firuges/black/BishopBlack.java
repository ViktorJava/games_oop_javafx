package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Реализация черного слона.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    /**
     * Наш любимый констрактор.
     *
     * @param position позиция фигуры на поле.
     */
    public BishopBlack(final Cell position) {
        this.position = position;
    }

    /**
     * Метод возвращает позицию фигуры на поле.
     *
     * @return позиция фигуры на поле.
     */
    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Расчёт пути движения слона.
     *
     * @param source начальная клетка пути.
     * @param dest   конечная клетка пути.
     * @return массив клеток пути.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
//            проверка диагональности хода.
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(String.format("Could not way by diagonal from %s to %s", source, dest));
        }
//        расчёт длинны пути
        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
//        слон ходит по четырём направлениям. Расчитываем направление.
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
//        System.out.printf("deltaX " + deltaX + " deltaY " + deltaY + "\n");
//        расчитываем путь.
        Cell step = source;
        for (int index = 0; index < size; index++) {
            int x = step.x + deltaX;
            int y = step.y + deltaY;
            steps[index] = Cell.findBy(x, y);
            step = steps[index];
        }
        return steps;
    }

    /**
     * Проверка диагональности хода.
     *
     * @param source начальная клетка.
     * @param dest   конечная клетка.
     * @return true при диагональности хода.
     */
    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = true;
        if (source.x == dest.x) {
            result = false;
        } else if (source.y == dest.y) {
            result = false;
        }
        return result;
    }

    /**
     * Создание экземпляра класса в заданной клетке.
     *
     * @param dest клетка создания объекта.
     * @return экземпляр класса.
     */
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}