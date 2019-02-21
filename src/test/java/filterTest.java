/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.eci.arsw.cinema.filters.filterException;
import edu.eci.arsw.cinema.filters.filteringByAvailability;
import edu.eci.arsw.cinema.filters.filteringByGender;
import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.impl.InMemoryCinemaPersistence;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class filterTest {

    public filterTest() {
    }

    @Test
    public void shouldFilteringByAvailability() throws filterException {
        filteringByAvailability ipct = new filteringByAvailability();
        String functionDate = "2018-14-19 17:30";
        List<CinemaFunction> functions = new ArrayList<>();
        List<Movie> pelis = new ArrayList<>();
        Movie a = new Movie("SuperHeroes Movie", "Action");
        Movie b = new Movie("The Night", "Horror");
        pelis.add(a);
        pelis.add(b);
        CinemaFunction funct1 = new CinemaFunction(a, functionDate);
        CinemaFunction funct2 = new CinemaFunction(b, functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c = new Cinema("cinemaXD", functions);

        assertEquals("Its not the same functions", ipct.filtro(c, functionDate, "3"), pelis);
    }

    @Test
    public void shouldFilteringByGender() throws filterException {
        filteringByGender fbg = new filteringByGender();
        String functionDate = "2018-14-19 17:30";
        List<CinemaFunction> functions = new ArrayList<>();
        List<Movie> pelis = new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie", "Action"), functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night", "Horror"), functionDate);
        CinemaFunction funct3 = new CinemaFunction(new Movie("Sabrina", "Horror"), functionDate);
        CinemaFunction funct4 = new CinemaFunction(new Movie("Scary Injuries", "Horror"), functionDate);
        CinemaFunction funct5 = new CinemaFunction(new Movie("Dead Silense", "Horror"), functionDate);
        functions.add(funct1);
        functions.add(funct2);
        functions.add(funct3);
        functions.add(funct4);
        functions.add(funct5);

        pelis.add(funct2.getMovie());
        pelis.add(funct3.getMovie());
        pelis.add(funct4.getMovie());
        pelis.add(funct5.getMovie());

        Cinema c = new Cinema("cinemaXD", functions);
        assertEquals("Its not the same functions", fbg.filtro(c, functionDate, "Horror"), pelis);

    }
}
