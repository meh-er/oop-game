package org.uob.a2.gameobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.nio.file.*;

import org.uob.a2.utils.*;

public class Score {
    private int score;

    public Score(){
        score = 0;
    }

    public int getScore(){
        return score;
    }

    public void setScore(){
        this.score += score;
    }
}