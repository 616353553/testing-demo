package com.cheer.testingdemo;

public class Rectangle implements Shape {

    private Integer width;
    private Integer length;

    public Rectangle(){
        this.width = 0;
        this.length = 0;
    }

    public Rectangle(Integer width, Integer length) {
        this.width = width;
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }


    @Override
    public Integer area() {
        if (this.width == null || this.length == null) {
            return null;
        }
        return this.width * this.length;
    }

    @Override
    public Boolean equalSize(Shape shape) {
        if (shape == null) {
            return Boolean.FALSE;
        }
        return this.area().equals(shape.area());
    }

    @Override
    public Shape convertTo(Class<? extends Shape> shapeClass) throws Exception {
        return null;
    }
}
