package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.models.Game;
import main.models.Team;

public class GameTest {

    Game game;

    @Before
    public void setup() {
        Team home = new Team("GRYFFINDOR", "Rezy", "Ricky", new String[] {"Loak", "Kiri", "Tuk"});
        Team away = new Team("AVATAR", "Jake Sully", "Neytiri", new String[] {"Waters", "Gilmour", "Syd"});
        
        game = new Game(home, away);
    }

    @Test
    public void getPlaceholderTest() {
        assertEquals(game.getPlaceholder("<chaser> gets the next pass"), "chaser");
    }

    @Test
    public void replacePlaceholderTest() {
        assertEquals(game.replacePlaceholder("<chaser> gets the next pass","chaser","Katie"), "Katie gets the next pass");
    }

    @Test
    public void quaffleScoreTest() {
        game.quaffleScore(game.getTeam("GRYFFINDOR"));
        game.quaffleScore(game.getTeam("GRYFFINDOR"));
        assertEquals(game.getScore(game.getTeam("GRYFFINDOR")), 20);
    }

}
