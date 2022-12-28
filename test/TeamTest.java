package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import main.models.Team;
import main.models.Game;

public class TeamTest {
    @Test
    public void hasNullTest() {
        assertTrue(Team.hasNull(new String[] {null, "Sally", "Kathy"}));
    }
}