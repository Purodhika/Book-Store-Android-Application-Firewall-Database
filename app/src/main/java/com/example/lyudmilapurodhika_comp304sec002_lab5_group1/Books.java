package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Books {

        private String name;
        private String author;
        private String genre;
        private int cost;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Books(){}
        public Books(String name, String author, String genre, int cost)
        {
            this.name = name;
            this.author = author;
            this.genre = genre;
            this.cost = cost;
        }



        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getCost() {
        return cost;
    }

        public void setCost(int cost) {
        this.cost = cost;
    }
}
