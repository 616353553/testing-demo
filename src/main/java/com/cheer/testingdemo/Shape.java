package com.cheer.testingdemo;

public interface Shape {

    Integer area();

    Boolean equalSize(Shape shape);

    Shape convertTo(Class<? extends Shape> shapeClass) throws Exception;
}
