package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import main.models.Team;
import main.models.Game;

public class TeamTest {
    @Test
    public void hasNullOrBlankTest() {
        assertTrue(Team.hasNullOrBlank(new String[] {null, "Sally", "Kathy"}));
        assertTrue(Team.hasNullOrBlank(new String[] {"  ", "Sally", "Kathy"}));
    }
}