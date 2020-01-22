package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты черного слона.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 19.01.2020
 */
public class BishopBlackTest {
    /**
     * Когда фактическая позиция, равна начальной позиции фигуры.
     */
    @Test
    public void whenPositionEqualInitPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position(), is(Cell.C1));
    }

    /**
     * Когда позиция копии фигуры, равна актуальной позиции фигуры.
     */
    @Test
    public void whenCopyEqualActualPosition() {
        Figure bishopBlack = new BishopBlack(Cell.A2).copy(Cell.A3);
        assertThat(bishopBlack.position(), is(Cell.A3));
    }

    /**
     * Когда у слона диагональный ход.
     */
    @Test
    public void whenIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.isDiagonal(Cell.C8, Cell.A6), is(true));
    }

    /**
     * Когда у слона не диагональный ход.
     */
    @Test
    public void whenIsNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.isDiagonal(Cell.C8, Cell.C6), is(false));
    }

    /**
     * Тест пути прохождения фигуры.
     */
    @Test
    public void returnAllWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell[] way = bishopBlack.way(bishopBlack.position(), Cell.G4);
        assertThat(way, is(new Cell[]{Cell.D7, Cell.E6, Cell.F5, Cell.G4}));
    }

    /**
     * Исключение, когда у слона не диагональный ход.
     */
    @Test(expected = IllegalStateException.class)
    public void whenIsNotDiagonalThenThrowException() {
        new BishopBlack(Cell.C8).way(Cell.C8, Cell.H8);
    }
}