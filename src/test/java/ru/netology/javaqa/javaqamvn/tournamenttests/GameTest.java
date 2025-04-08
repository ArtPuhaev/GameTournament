package ru.netology.javaqa.javaqamvn.tournamenttests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.javamvn.tournament.Game;
import ru.netology.javaqa.javamvn.tournament.NotRegisteredException;
import ru.netology.javaqa.javamvn.tournament.Player;


public class GameTest {

    @Test
    public void shouldLetFirstPlayerWin() {
        Game game = new Game();
        Player p1 = new Player(1, "Ivan", 100);
        Player p2 = new Player(2, "Anya", 110);
        Player p3 = new Player(3, "Kolya", 120);
        Player p4 = new Player(4, "Olya", 140);
        Player p5 = new Player(5, "Navi", 100);

        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);
        game.register(p5);

        int expected = 1;
        int actual = game.round("Anya", "Ivan");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldLetSecondPlayerWin() {
        Game game = new Game();
        Player p1 = new Player(1, "Ivan", 100);
        Player p2 = new Player(2, "Anya", 110);
        Player p3 = new Player(3, "Kolya", 120);
        Player p4 = new Player(4, "Olya", 140);
        Player p5 = new Player(5, "Navi", 100);

        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);
        game.register(p5);

        int expected = 2;
        int actual = game.round("Ivan", "Anya");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowDraw() {
        Game game = new Game();
        Player p1 = new Player(1, "Ivan", 100);
        Player p2 = new Player(2, "Anya", 110);
        Player p3 = new Player(3, "Kolya", 120);
        Player p4 = new Player(4, "Olya", 140);
        Player p5 = new Player(5, "Navi", 100);

        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);
        game.register(p5);

        int expected = 0;
        int actual = game.round("Ivan", "Navi");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionForNotRegistered() {
        Game game = new Game();
        Player p1 = new Player(1, "Ivan", 100);
        Player p2 = new Player(2, "Anya", 110);
        Player p3 = new Player(3, "Kolya", 120);
        Player p4 = new Player(4, "Olya", 140);
        Player p5 = new Player(5, "Navi", 100);

        game.register(p1);
        game.register(p2);
        game.register(p3);
        game.register(p4);
        game.register(p5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Darya");
        });
    }
}
