package com.bsuir.lr.Labs.models;

public class ComplexRequest {
    private double real;
    public double getReal(){return this.real;}
    public void setReal(double value) {this.real = value;}
    private double img;
    public double getImg(){return this.img;}
    public void setImg(double value) {this.img = value;}

    public ComplexRequest(double real, double img) {
        this.real = real;
        this.img = img;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        ComplexRequest req = (ComplexRequest) o;
        return (req.img == this.img && req.real == this.real);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (int)Double.doubleToLongBits(this.real);
        result = 31 * result + (int)Double.doubleToLongBits(this.img);
        return result;
    }

    @Override
    public String toString() {
        return "\n" + getClass().getSimpleName() + "{" +
                "real=" + real +
                ", img='" + img + "}";
    }
}
