/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.filters;


import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandro y jonathan
 */


public class filteringByAvailability implements filter {

    @Override
    public List<Movie> filtro(Cinema cinema, String date, String parametro) {
        List<Movie> pelis = new ArrayList();
        List<CinemaFunction> functions = cinema.getFunctions();
        int dispo = Integer.parseInt(parametro);
        for (CinemaFunction i : functions) {
            if (i.disponible() > dispo) {
                pelis.add(i.getMovie());
            }
        }
        return pelis;

    }


}
