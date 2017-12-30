package com.vivarium.view;

import com.vivarium.controller.SidePanelActionListener;
import com.vivarium.controller.VivariumController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SidePanel extends JPanel{

    private SidePanelActionListener listener;
    private VivariumController vc;

    public SidePanel(VivariumController vc) {
        super();
        this.vc = vc;

        //setLayout(new GridLayout(2,1));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        // Create Listener for ActionEvents
        listener = new SidePanelActionListener(this, vc);

        createSpawnPosPanel();
        createSpawnAnimalPanel();
        createSpawnVegetalPanel();
        createStatsPanel();
    }

    /**
     * Create spawnPosPanel in the sidePanel
     * This panel allows the user to set the coordinates in order to spawn organisms
     */
    private void createSpawnPosPanel() {
        // Create spawnPosPanel general settings
        JPanel spawnPosPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spawnPosPanel.setBorder(BorderFactory.createTitledBorder("Spawn position"));
        add(spawnPosPanel);

        // Create default insets
        Insets defaultInsets = new Insets(5,0,0,0);

        // Create X position field
        createLabel(spawnPosPanel,"X :",JLabel.CENTER,gbc,defaultInsets,0,0,1,1);
        createTextField(spawnPosPanel,6,gbc,null,listener,defaultInsets,1,0,1,1, false);

        // Create Y position field
        createLabel(spawnPosPanel,"Y :",JLabel.CENTER,gbc,defaultInsets,0,1,1,1);
        createTextField(spawnPosPanel,6,gbc,null,listener,defaultInsets,1,1,1,1, false);

        // Create the "set" button
        createButton(spawnPosPanel,"Set",gbc,"Setting coords",listener,defaultInsets,0,2,2,1);
    }

    /**
     * Create SpawnAnimalPanel inside the SidePanel
     * This panel allows the user to spawn a desired animal with multiple options
     */
    private void createSpawnAnimalPanel() {
        // Create spawnAnimalPanel general settings
        JPanel spawnPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        spawnPanel.setBorder(BorderFactory.createTitledBorder("Spawn an animal"));
        add(spawnPanel);

        // Create default insets
        Insets defaultInsets = new Insets(5,0,0,0);

        // Create ComboBox to select animal to spawn
        String[] animalStrings = {"Bear","Blowfish","Bouquetin","Camel","Cow","Dog","Dragon","Eagle","Fish","FreshwaterFish","Rabbit","Trex","Wolf"};
        createComboBox(spawnPanel,animalStrings,gbc,"Choice",listener,new Insets(5,0,0,5),0,0,1,1);

        // Create ComboBox to select sex
        String[] animalSexStrings = {"Male","Female"};
        createComboBox(spawnPanel,animalSexStrings, gbc,"Sex",listener,defaultInsets,1,0,1,1);

        // Create text field for organism's name
        createLabel(spawnPanel,"Name :",JLabel.CENTER,gbc,defaultInsets,0,1,1,1);
        createTextField(spawnPanel,15,gbc,"NameUpdate",listener,defaultInsets,1,1,1,1, true);

        // Create spawn button
        createButton(spawnPanel,"Spawn",gbc,"Spawn",listener,defaultInsets,0,2,2,1);

    }

    /**
     * Create SpawnVegetalPanel inside the SidePanel
     * This panel allows the user to spawn a desired vegetal
     */
    private void createSpawnVegetalPanel() {
        JPanel spawnVegetalPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty=0;
        spawnVegetalPanel.setBorder(BorderFactory.createTitledBorder("Spawn a vegetal"));
        add(spawnVegetalPanel);

        // Create default insets
        Insets defaultInsets = new Insets(5,0,0,0);

        // Create ComboBox to select vegetal to spawn
        String[] vegetalStrings = {"Aubergine","Cactus","Grass","Mushroom","Tree"};
        createComboBox(spawnVegetalPanel,vegetalStrings, gbc,"VegetalChoice",listener,new Insets(5,0,0,5),0,0,1,1);

        // Create spawn button
        createButton(spawnVegetalPanel,"Spawn",gbc,"SpawnVegetal",listener,defaultInsets,1,0,1,1);
    }

    /**
     * Create infoPanel inside the SidePanel
     * This panel displays the organism's stats
     */
    private void createStatsPanel() {
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        infoPanel.setBorder(BorderFactory.createTitledBorder("Organism stats"));
        add(infoPanel);

        // Create default insets
        Insets defaultInsets = new Insets(5,0,0,0);

        // Create text field for organism's name
        createLabel(infoPanel,"Name :",JLabel.CENTER,gbc,new Insets(5,0,0,5),0,0,1,1);
        createTextField(infoPanel,15,gbc,"StatNameUpdate",listener,defaultInsets,1,0,1,1, true);

        // Create health stat
        createIconLabel(infoPanel,"resources/icons/heart.png",JLabel.CENTER,gbc,new Insets(5,0,0,5),0,1,1,1);
        createLabel(infoPanel,"100",JLabel.LEFT,gbc,defaultInsets,1,1,1,1);

        // Create hunger stat
        createIconLabel(infoPanel,"resources/icons/hunger.png",JLabel.CENTER,gbc,new Insets(5,0,0,5),0,2,1,1);
        createLabel(infoPanel,"100",JLabel.LEFT,gbc,defaultInsets,1,2,1,1);

        // Create speed stat
        createIconLabel(infoPanel,"resources/icons/speed.png",JLabel.CENTER,gbc,new Insets(5,0,0,5),0,3,1,1);
        createLabel(infoPanel,"100",JLabel.LEFT,gbc,defaultInsets,1,3,1,1);
    }

    /**
     * Generic method to create a button
     * @param panel the panel in which the button will be placed
     * @param text the button's text
     * @param gbc the GridBagConstraints used
     * @param actionCommand the ActionCommand used by the listener
     * @param listener the listener that will execute the button's action
     * @param insets if null, new Insets(0,0,0,0) are created
     * @param gridx x position on the grid
     * @param gridy y position on the grid
     * @param gridwidth the number of horizontal cell that the button should occupy
     * @param gridheight the number of vertical cell that the button should occupy
     */

    private static void createButton(JPanel panel, String text, GridBagConstraints gbc, String actionCommand, ActionListener listener, Insets insets, int gridx, int gridy, int gridwidth, int gridheight)
    {
        JButton button = new JButton(text);
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setActionCommand(actionCommand);
        button.addActionListener(listener);
        if(insets==null){
            gbc.insets = new Insets(0,0,0,0);
        }
        else
        {
            gbc.insets = insets;
        }
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        gbc.gridx = gridx;
        gbc.gridy= gridy;
        panel.add(button,gbc);
    }

    /**
     * Generic method to create a TextField
     * @see #createButton for params
     * @param columns the number of char that should fit in the field
     * @param isEditable
     */
    private static void createTextField(JPanel panel, int columns, GridBagConstraints gbc, String actionCommand, ActionListener listener, Insets insets, int gridx, int gridy, int gridwidth, int gridheight, boolean isEditable) {
        JTextField textField = new JTextField(columns);
        textField.addActionListener(listener);
        textField.setActionCommand(actionCommand);
        textField.setEditable(isEditable);
        if(insets==null){
            gbc.insets = new Insets(0,0,0,0);
        }
        else
        {
            gbc.insets = insets;
        }
        gbc.gridx=gridx;
        gbc.gridy=gridy;
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        panel.add(textField,gbc);
    }

    /**
     * Generic method to create a label
     * @see #createButton for params
     * @param text the label text
     * @param horizontalAlignement how should the text behave (centered horizontally, etc)
     */
    private static void createLabel(JPanel panel, String text, int horizontalAlignement, GridBagConstraints gbc, Insets insets, int gridx, int gridy, int gridwidth, int gridheight) {
        JLabel label = new JLabel(text, horizontalAlignement);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        if(insets==null) {
            gbc.insets = new Insets(0,0,0,0);
        }
        else {
            gbc.insets = insets;
        }
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        panel.add(label,gbc);
    }

    /**
     * Generic method to create a ComboBox
     * @see #createButton for params
     * @param strings the choices available in the ComboBox
     */
    private static void createComboBox(JPanel panel, String[] strings, GridBagConstraints gbc, String actionCommand, ActionListener listener, Insets insets, int gridx, int gridy, int gridwidth, int gridheight)
    {
        JComboBox comboBox = new JComboBox(strings);
        comboBox.setSelectedIndex(0);
        comboBox.setActionCommand(actionCommand);
        comboBox.addActionListener(listener);
        if(insets==null){
            gbc.insets = new Insets(0,0,0,0);
        }
        else
        {
            gbc.insets = insets;
        }
        gbc.gridwidth=gridwidth;
        gbc.gridheight=gridheight;
        gbc.gridx = gridx;
        gbc.gridy= gridy;
        panel.add(comboBox,gbc);
    }


    /* Create a health bar for an animal, might be useful later ?
    private static void createHealthBarFor(Animal animal, JPanel panel, GridBagConstraints gbc) {
        int i;
        ImageIcon heart = new ImageIcon("resources/icons/heart.png");
        ImageIcon heartBW = new ImageIcon("resources/icons/heartBW.png");
        Insets defaultInsets = new Insets(5,0,0,5);
        for(i=0;i<animal.getHP()/10;i++)
        {
            JLabel icon = new JLabel(heart,JLabel.CENTER);
            gbc.gridx = i+1;
            gbc.insets = defaultInsets;
            panel.add(icon,gbc);
        }
        for(; i<10; i++)
        {
            JLabel icon = new JLabel(heartBW,JLabel.CENTER);
            gbc.gridx = i+1;
            gbc.insets = defaultInsets;
            panel.add(icon,gbc);
        }
    }*/

    /**
     * Generic method to create an icon label
     * @param imagePath path to the image
     * @see #createLabel for other params
     */
    private static void createIconLabel(JPanel panel, String imagePath, int horizontalAlignement, GridBagConstraints gbc, Insets insets, int gridx, int gridy, int gridwidth, int gridheight) {
        JLabel label = new JLabel(new ImageIcon(imagePath), horizontalAlignement);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        if(insets==null) {
            gbc.insets = new Insets(0,0,0,0);
        }
        else {
            gbc.insets = insets;
        }
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        panel.add(label,gbc);
    }
}
