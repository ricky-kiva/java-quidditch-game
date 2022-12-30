package main.models;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;;

public class Game {
    
    private static final int QUAFFLE_POINTS = 10;
    private static final int SNITCH_POINTS = 150;
    private static int gameCount;
    private HashMap<Team, Integer> scoreboard;

    public Game(Team home, Team away) {
        this.scoreboard = new HashMap<Team, Integer>();
        this.scoreboard.put(new Team(home), 0);
        this.scoreboard.put(new Team(away), 0);
        gameCount++;
    }

    public Integer getScore(Team team) {
        return this.scoreboard.get(team);
    }

    public void setScore(Team team, Integer score) {
        this.scoreboard.put(team, (getScore(team) + score));
    }

    public Team getTeam(String name) {
        return this.scoreboard.keySet().stream()
        .filter(key -> key.getHouse().equals(name))
        .findFirst()
        .orElse(null);
    }

    public String getPlaceholder(String play) {
        Pattern pattern = Pattern.compile("<\\w+>");
        Matcher matcher = pattern.matcher(play);
        while(matcher.find()) {
            return matcher.group(0).substring(1, ((matcher.group(0).length()) - 1));
        }
        return null;
    }

    public String replacePlaceholder(String play, String placeholder, String value) {
        return play.replace(("<" + placeholder + ">"), value);
    }

    public void quaffleScore(Team team) {
        this.setScore(team, QUAFFLE_POINTS);
    }

    public void catchSnitch(Team team) {
        this.setScore(team, SNITCH_POINTS);
    }

    public Team getRandomTeam() {
        return (Team) (this.scoreboard.keySet().toArray())[randomInt(0, 1)];
    }

    public String simulate(String play) {
        Team team = getRandomTeam();
        if (this.getPlaceholder(play).equals(Team.getPositionChaser())) {
            quaffleScore(team);
            return this.replacePlaceholder(play, Team.getPositionChaser(), (team.getChasers())[randomInt(0, 2)]);
        } else if (this.getPlaceholder(play).equals(Team.getPositionSeeker())) {
            catchSnitch(team);
            return this.replacePlaceholder(play, Team.getPositionSeeker(), team.getSeeker());
        } else {
            return "Nothing happened this round!";
        }
    }

    public int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, (max+1));
    }


}
