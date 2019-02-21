package edu.eci.arsw.cinema.services;

import edu.eci.arsw.cinema.filters.filterException;
import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import java.util.ArrayList;
import java.util.List;

public class main {

    /**
     *
     * @author Alejandro Rodriguez
     */
    public static void main(String[] args) throws CinemaException, CinemaPersistenceException, filterException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CinemaServices c = ac.getBean(CinemaServices.class);
          String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie 2","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night 2","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema cine=new Cinema("Pruebacine",functions);
        c.addNewCinema(cine);
        
        System.out.println(c.getAllCinemas().contains(cine));
        System.out.println(c.busqueda(cine, functionDate, "3").size());

    }

}
