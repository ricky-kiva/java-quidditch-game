package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.models.Game;
import main.models.Team;

public class GameTest {

    Game game;

    @Before
    public void setup() {
        Team home = new Team("GRYFFINDOR", "Rezy", "Ricky", new String[] {"Loak", "Kiri", "Tuk"});
        Team away = new Team("Jake Sully", "Navi", "Avatar", new String[] {"Waters", "Gilmour", "Syd"});
        
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

}
