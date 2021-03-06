package com.vivarium;

import com.vivarium.controller.VivariumController;
import com.vivarium.model.*;
import com.vivarium.view.GamePanel;
import com.vivarium.view.SidePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame("Vivarium");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Vivarium vivarium = new Vivarium();
        VivariumController vc = new VivariumController(vivarium);
        Random ran = new Random();

        SidePanel sidePanel = new SidePanel(vc);
        GamePanel gp = new GamePanel(vc, sidePanel);

        JScrollPane sp = new JScrollPane(gp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        window.add(sp, BorderLayout.CENTER);
        window.add(sidePanel, BorderLayout.EAST);
        window.pack();
        window.setVisible(true);

        // spawn des chameaux
        for (int i = 0; i < 25; i++) {
            vc.add(new Camel(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, Sex.Female));
            vc.add(new Camel(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, Sex.Male));
        }

        // spawn des cactus, aubergines et autres plantes
        for (int i = 0; i < 50; i++) {
            vc.add(new Aubergine(ran.nextInt(vivarium.getTerrain().getWidth()), ran.nextInt(vivarium.getTerrain().getHeight()), vivarium));
            vc.add(new Mushroom(ran.nextInt(vivarium.getTerrain().getWidth()), ran.nextInt(vivarium.getTerrain().getHeight()), vivarium));
            vc.add(new Tree(ran.nextInt(vivarium.getTerrain().getWidth()), ran.nextInt(vivarium.getTerrain().getHeight()), vivarium));
            vc.add(new Grass(ran.nextInt(vivarium.getTerrain().getWidth()), ran.nextInt(vivarium.getTerrain().getHeight()), vivarium));
            Area randomAreaDesert = vivarium.getTerrain().getRandomAreaOfType(AreaType.Desert);
            vc.add(new Cactus((int) randomAreaDesert.getCoords().getX() + 40, (int) randomAreaDesert.getCoords().getY() + 40, vivarium));
        }


        // spawn des "bouquetins"
        for (int i = 0; i < 60; i++) {

            Sex sex;
            if (i % 2 == 0) {
                sex = Sex.Male;
            } else {
                sex = Sex.Female;
            }
            vc.add(new Bouquetin(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, sex));
        }
        for (int i = 0; i < 10; i++) {

            Sex sex;
            if (i % 2 == 0) {
                sex = Sex.Male;
            } else {
                sex = Sex.Female;
            }
            vc.add(new Rabbit(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, sex));
        }

        // Spawn des aigles
        for (int i = 0; i < 24; i++) {
            Sex sex;
            if (i % 2 == 0) {
                sex = Sex.Male;
            } else {
                sex = Sex.Female;
            }
            vc.add(new Eagle(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, sex));
        }

        //Spawn des loups
        for (int i = 0; i < 10; i++) {
            Sex sex;
            if (i % 2 == 0) {
                sex = Sex.Male;
            } else {
                sex = Sex.Female;
            }
            vc.add(new Wolf(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, sex));
        }

        // Who let the dogs out ?
        for (int i = 0; i < 10; i++) {
            Sex sex;
            if (i % 2 == 0) {
                sex = Sex.Male;
            } else {
                sex = Sex.Female;
            }
            vc.add(new Dog(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, sex));
        }

        for (int i = 0; i < 10; i++) {

            Sex sex;
            if (i % 2 == 0) {
                sex = Sex.Male;
            } else {
                sex = Sex.Female;
            }
            vc.add(new Dragon(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, sex));
        }

        for (int i = 0; i < 10; i++) {

            Sex sex;
            if (i % 2 == 0) {
                sex = Sex.Male;
            } else {
                sex = Sex.Female;
            }
            vc.add(new Bear(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, sex));
        }

        for (int i = 0; i < 20; i++) {

            Sex sex;
            if (i % 2 == 0) {
                sex = Sex.Male;
            } else {
                sex = Sex.Female;
            }
            vc.add(new Cow(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, sex));
        }

        for (int i = 0; i < 10; i++) {

            Sex sex;
            if (i % 2 == 0) {
                sex = Sex.Male;
            } else {
                sex = Sex.Female;
            }
            vc.add(new Fox(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, sex));
        }

        for (int i = 0; i < 10; i++) {

            Sex sex;
            if (i % 2 == 0) {
                sex = Sex.Male;
            } else {
                sex = Sex.Female;
            }
            vc.add(new Bear(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, sex));
        }

        for (int i = 0; i < 4; i++) {

            Sex sex;
            if (i % 2 == 0) {
                sex = Sex.Male;
            } else {
                sex = Sex.Female;
            }
            vc.add(new Trex(ran.nextInt(vc.getTerrain().getWidth()), ran.nextInt(vc.getTerrain().getHeight()), vivarium, sex));
        }

        // Spawn FreshwaterFish
        for(int i = 0; i < 10; i++) {
            Area randomAreaDesert = vivarium.getTerrain().getRandomAreaOfType(AreaType.Water);
            vc.add(new FreshwaterFish((int) randomAreaDesert.getCoords().getX() + 40 , (int) randomAreaDesert.getCoords().getY() + 40, vivarium, Sex.getRandom()));
        }

        // Spawn BlowFish
        for(int i = 0; i < 10; i++) {
            Area randomAreaDesert = vivarium.getTerrain().getRandomAreaOfType(AreaType.Water);
            vc.add(new Blowfish((int) randomAreaDesert.getCoords().getX() + 40 , (int) randomAreaDesert.getCoords().getY() + 40, vivarium, Sex.getRandom()));
        }

        while (true) {
            vc.loop();
            window.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
