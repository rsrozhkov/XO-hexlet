package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure cuttrentMove(final Field field) {

        int countFigure = 0;

        for (int i = 0; i < field.getSize(); i++) {
            countFigure += countFigureInTheRow(field,i);

        }

        if (countFigure == field.getSize()*field.getSize()) return null;

        if (countFigure % 2 == 0) return Figure.X;

        return Figure.O;
    }

    private int countFigureInTheRow(final Field field, final int row) {
        int countFigure = 0;
        for (int i = 0; i < field.getSize(); i++) {
            try {
                if(field.getFigure(new Point(row,i)) != null) {
                    countFigure++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }

        }
        return countFigure;
    }
}
