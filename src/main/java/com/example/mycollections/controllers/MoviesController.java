package com.example.mycollections.controllers;

import com.example.mycollections.models.Movies;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping ("/movies")
public class MoviesController {

    private final List<Movies> movies = new ArrayList<>() {{
        add(new Movies("The Shawshank Redemption",1994 , "Frank Darabont", 142));
        add(new Movies("The Godfather",1972 , "Francis Ford Coppola", 175));
        add(new Movies("Inception", 2010,"Christopher Nolan",  148));
    }};

    @GetMapping("/json")
    public List<Movies> getMoviesJson() {
        return movies;
    }

    @GetMapping("/html")
    public String getMoviesHtml() {
        String movieList = "<ul>";
        for (Movies movie : movies) {
            movieList += "<li>" + movie + "</li>";
        }
        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                """ +
                movieList +
                """
                    </body>
                </html>
                """;
    }
}
