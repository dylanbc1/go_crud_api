package ui;

import model.BFSGraphController;

import javax.swing.*;

public class BFSGraphManager {

    private static BFSGraphController<String> controller;

    public static void main(String[] args) {
        init();
        showMainMenu();
    }

    public static void init(){
        controller = new BFSGraphController<>();
    }

    public static void showMainMenu(){
        String msg = "-------------- GRAPH SOFTWARE -------------\n" +
                "1) Add a vertex.\n" +
                "2) Add an edge.\n" +
                "3) Know if the graph is strongly connected.\n" +
                "4) Clear the graph.\n" +
                "0) Exit.";

        int decision = Integer.parseInt(JOptionPane.showInputDialog(null, msg));

        while(decision!=0){

            switch (decision){
                case 1:
                    addVertex();
                    break;
                case 2:
                    addAdjacency();
                    break;
                case 3:
                    stronglyConnected();
                    break;
                case 4:
                    clear();
                    break;
                case 0:
                    JOptionPane.showInputDialog("Thank you for using our system! Come back soon.");
                    break;
            }

            decision = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        }
    }

    public static void addVertex(){
        String value = JOptionPane.showInputDialog(null, "Type the value of the node (name, id, ...).");

        if(!value.equals("")){
            if(controller.insertNode(value)){
                JOptionPane.showMessageDialog(null, "The node has been added successfully");
            } else {
                JOptionPane.showMessageDialog(null, "The node hasn't been added successfully.\n" +
                        "Maybe another node has the same value!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "The node hasn't been added successfully.\n" +
                    "Type a valid value.");
        }
    }

    public static void addAdjacency(){
        String value1 = JOptionPane.showInputDialog(null, "Type the value of the node where the edge come from");
        String value2 = JOptionPane.showInputDialog(null, "Type the value of the node where the edge arrives");

        if(controller.addAdjacency(value1, value2)){
            JOptionPane.showMessageDialog(null, "The edge has been added successfully");
        } else {
            JOptionPane.showMessageDialog(null, "The edge hasn't been added successfully.\n" +
                    "Maybe one of the nodes aren't in the graph or the edge already exists!");
        }
    }

    public static void stronglyConnected(){
        if(controller.stronglyConnectedBFS()){
            JOptionPane.showMessageDialog(null, "THE GRAPH IS STRONGLY CONNECTED");
        } else {
            JOptionPane.showMessageDialog(null, "THE GRAPH ISN'T STRONGLY CONNECTED");
        }
    }

    public static void clear(){
        if(controller.clear()){
            JOptionPane.showMessageDialog(null, "The graph has been cleared");
        } else {
            JOptionPane.showMessageDialog(null, "The graph hasn't been cleared");
        }
    }
}
