package com.example.mycollections.controllers;

import com.example.mycollections.models.Albums;
import com.example.mycollections.models.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/albums")
public class AlbumsController {
    private final List<Albums> albums = new ArrayList<>() {{
        add(new Albums("The Great Gatsby",1925 , "F. Scott Fitzgerald", 10));
        add(new Albums("To Kill a Mockingbird", 1960, "Harper Lee", 21));
        add(new Albums("1984", 1978, "George Orwell", 38));
    }};


    @GetMapping("/json")
    public List<Albums> getAlbumsJson() {
        return albums;
    }

    @GetMapping("/html")
    public String getAlbumsHtml() {
        String albumList = "<ul>";
        for (Albums album : albums) {
            albumList += "<li>" + album + "</li>";
        }
        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """ +
                albumList +
                """
                        </ul>
                    </body>
                """;
    }


}
