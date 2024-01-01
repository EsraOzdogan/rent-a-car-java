package com.etiya;

import com.etiya.entities.Brand;
import com.etiya.entities.Car;
import com.etiya.entities.Model;
import com.etiya.entities.Transmission;

public class Main {
    public static void main(String[] args) {
        Brand brand1 = new Brand();
        brand1.setId(1);
        brand1.setName("BMW");

        Model model1 = new Model();
        model1.setId(1);
        model1.setName("Series 1");
        model1.setBrand(brand1);

        Car car1 = new Car();
        car1.setId(1);
        car1.setPlate("06ABC01");
        car1.setModel(model1);


        Brand brand2 = new Brand();
        brand2.setId(2);
        brand2.setName("Mercedes");


        Model model2 = new Model();
        model2.setId(2);
        model2.setName("Series 2");
        model2.setBrand(brand1);

        Car car2 = new Car();
        car2.setId(2);
        car2.setPlate("06ABC02");
        car2.setModel(model1);

        Transmission transmission1 = new Transmission();
        transmission1.setId(1);
        transmission1.setName("manuel");
    }
}