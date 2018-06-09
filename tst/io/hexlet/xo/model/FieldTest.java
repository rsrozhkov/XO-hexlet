package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AbstractXOException;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {

        final Field field = new Field();

        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigure() throws Exception {

        final Field field = new Field();

        final Point inputPoint = new Point(0,0);

        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void getFigureWhenFigureIsNotSet() throws Exception {

        final Field field = new Field();

        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void getFigureWhenXIsLessThenZero() throws Exception {

        final Field field = new Field();

        final Point inputPoint = new Point(-1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenYIsLessThenZero() throws Exception {

        final Field field = new Field();

        final Point inputPoint = new Point(0,-1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenXIsMoreThenSize() throws Exception {

        final Field field = new Field();

        final Point inputPoint = new Point(field.getSize()+1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenYIsMoreThenSize() throws Exception {

        final Field field = new Field();

        final Point inputPoint = new Point(0,field.getSize()+1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {}
    }
}