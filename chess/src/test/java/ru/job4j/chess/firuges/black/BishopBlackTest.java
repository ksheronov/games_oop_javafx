package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.white.BishopWhite;

import javax.swing.text.Position;
import java.nio.file.attribute.PosixFileAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void whenPositionIsTrue() {
        Cell cell = A8;
        BishopBlack black = new BishopBlack(cell);
        assertThat(cell).isEqualTo(black.position());
    }

    @Test
    public void whenCopyIsTrue() {
        Cell cell = A8;
        Cell copyCell = B4;
        BishopBlack black = new BishopBlack(cell);
        assertThat(copyCell).isEqualTo(black.copy(copyCell).position());
    }

    @Test
    public void whenWayC1ToG5() {
        BishopBlack black = new BishopBlack(C1);
        Cell[] result = black.way(G5);
        Cell[] expected = {D2, E3, F4, G5};
        assertThat(result).containsExactly(expected);
    }

    @Test
    void wayWayException() {
        BishopBlack black = new BishopBlack(A1);
        Cell newCell = A5;
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    Cell[] result = black.way(newCell);
                }
        );
        assertThat(exception.getMessage()).isEqualTo(String.format("Could not move by diagonal from %s to %s", black.position(), newCell));
    }
}