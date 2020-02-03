package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты бизнес логики.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 21.01.2020
 */
public class LogicTest {

    /**
     * Тест обычного хода.
     */
    @Test
    public void whenGoodMove() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        assertThat(logic.move(Cell.C8, Cell.A6), is(true));
    }

    /**
     * Нет фигуры, которой нужно ходить.
     */
    @Test
    public void whenEmptyDest() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B8));
        assertThat(logic.move(Cell.C8, Cell.A6), is(false));
    }

    /**
     * Тест случая наличия фигуры на пути.
     */
    @Test
    public void whenWrongMove() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new BishopBlack(Cell.B7));
        assertThat(logic.move(Cell.C8, Cell.A6), is(false));
    }
}