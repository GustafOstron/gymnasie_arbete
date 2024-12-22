package src.GamePart;

import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

import src.Neurals.NeuralNetworkV2;

import static src.GamePart.NeuralTrainer.blockValueToNeuronInput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Game game;
    static NeuralNetworkV2 nnw;
    public static void main(String[] args) {
        //int[][] playingField = {{2,2,0,4},{0,0,4,4},{512,1024,2048,0},{0,0,0,0}};
        game = new Game();
        nnw = new NeuralNetworkV2(16,3,20,4);
        game.addKeyListener(keyListnerBuilder());
        game.addBlocks();

        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setVisible(true);
    }

    public static KeyListener keyListnerBuilder(){
        return new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e.getKeyCode());
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        game.moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        game.moveDown();
                        break;
                    case KeyEvent.VK_LEFT:
                        game.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        game.moveRight();
                        break;
                    default:
                        break;
                }
                /*
                double[] dou = blockValueToNeuronInput(game.getPlayingField()).stream().mapToDouble(Double::doubleValue).toArray();
                double[] det = Arrays.copyOf(dou, 16);
                System.out.println(Arrays.toString(nnw.getOutput(det)));

                 */
            }
        };
    }
}


