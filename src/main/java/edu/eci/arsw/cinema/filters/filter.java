/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.filters;

import java.util.List;

/**
 *
 * @author user
 */
public interface filter {
    
    public List<Movie> busqueda ( String cinema, String date );
        
   

}
