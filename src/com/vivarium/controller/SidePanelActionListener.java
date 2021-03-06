package com.vivarium.controller;

import com.vivarium.model.Sex;
import com.vivarium.model.*;
import com.vivarium.view.SidePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SidePanelActionListener implements ActionListener {

    private SidePanel sidePanel;
    private VivariumController vc;
    private String AnimalNameComboBox = "Bear";
    private String VegetalNameComboBox = "Aubergine";
    private Sex AnimalSexComboBox = Sex.Male;

    public SidePanelActionListener(SidePanel sidePanel, VivariumController vc)
    {
        this.sidePanel=sidePanel;
        this.vc = vc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // If the user changes the animal in the side panel's appropriate combo box, gets the animal name
        if("Choice".equals(e.getActionCommand())) {
            JComboBox cb = (JComboBox)e.getSource();
            AnimalNameComboBox = (String)cb.getSelectedItem();
        }

        // If the user changes the vegetal in the side panel's appropriate combo box, gets the vegetal name
        if("VegetalChoice".equals(e.getActionCommand())) {
            JComboBox cb = (JComboBox)e.getSource();
            VegetalNameComboBox = (String)cb.getSelectedItem();
        }

        // If the user changes the animal's sex in the side panel's appropriate combo box, gets the sex
        if("Sex".equals(e.getActionCommand())) {
            JComboBox cb = (JComboBox)e.getSource();
            if("Male".equals(cb.getSelectedItem())) {
                AnimalSexComboBox = Sex.Male;
            }
            else AnimalSexComboBox = Sex.Female;
        }

        // If the user clicks on the animal spawn button
        if("Spawn".equals(e.getActionCommand())) {
            Organism o = null;
            try{
                o = OrganismFactory.AnimalFactory(AnimalNameComboBox,sidePanel.getSpawnPosX(),sidePanel.getSpawnPosY(),vc.getVivarium(), AnimalSexComboBox);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            String newName = sidePanel.getNewAnimalName();
            if (!newName.equals(""))
                o.setName(newName);
            sidePanel.setFocus(o);
            vc.add(o);

        }

        // If the user clicks on the vegetal spawn button
        if("SpawnVegetal".equals(e.getActionCommand())) {
            Organism o = null;
            try {
                o = OrganismFactory.VegetalFactory(VegetalNameComboBox,sidePanel.getSpawnPosX(),sidePanel.getSpawnPosY(),vc.getVivarium());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            String newName = sidePanel.getNewVegetalName();
            if(!newName.equals(""))
                o.setName(newName);
            sidePanel.setFocus(o);
            vc.add(o);
        }

        // If the user clicks on the kill button
        if ("Kill".equals(e.getActionCommand())){
            // Checks whether the focus is on an organism or not
            if (sidePanel.getFocus() != null){
                // If it is, delete this animal from the vivarium
                vc.delete(sidePanel.getFocus());
            }
        }

        if ("StatNameUpdate".equals(e.getActionCommand())){
            sidePanel.getFocus().setName(sidePanel.getFocusName());
        }

    }
}
