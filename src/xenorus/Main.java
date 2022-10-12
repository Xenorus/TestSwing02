package xenorus;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void myWin() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Test Frame");
        //создание окна
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //определение функции закрытия программы

        JPanel panel = new JPanel();
        //панель
        panel.setLayout(new BorderLayout());
        //элемент, клонтролирующий расположение элементов на панели

        //КНОПКИ
        JButton northButton = new JButton("North");
        //Кнопка имя = новая Кнопка("текст на кнопке");
        //на самом деле, классическое создание экземпляра класса
        panel.add(northButton, BorderLayout.NORTH);
        //панель.добавить(имя_элемента, Лайаут.расположение);
        //добавление кнопки на панель

        JButton southButton = new JButton("South");
        panel.add(southButton, BorderLayout.SOUTH);

        JButton eastButton = new JButton("East");
        panel.add(eastButton, BorderLayout.EAST);

        JButton westButton = new JButton("West");
        panel.add(westButton, BorderLayout.WEST);

        JButton centerButton = new JButton("Center");
        panel.add(centerButton, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        //frame.setPreferredSize(new Dimension(500,400));

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2, dimension.height / 2, 400, 400);


        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // write your code here
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myWin();
            }
        });
    }
}
