package ru.job4j.ood.srp;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.ood.tdd.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Cinema3DTest {
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

/*    При поекпке билета может быть
    указано неверное время сеанса*/

    @Test(expected = Exception.class)
    public void buyNotExistDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }

    //При покупке билета может быть выбрано несуществующее место
    @Test(expected = Exception.class)
    public void buyNotExistSeat() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }

    //При покупке билетва может быть выбрано занятое место
    //Тогда метод buy должен попросить выбрать другое место

    @Test
    public void buySeatTaken() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticketBuyOld = cinema.buy(account, 1, 1, date);
        Ticket ticketBuyNew = cinema.buy(account, 1, 1, date);
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticketBuyOld);
        List<Session> sessions = cinema.find(session -> true);
        assertFalse(tickets.contains(ticketBuyOld));
    }


}