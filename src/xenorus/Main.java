package xenorus;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        /*
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myWin();
            }
        });*/
       // JFrame frame = myWin();

        String[] phoneNumbers = {" 84569122378", "+71 8956 3881 0"};
        phoneNumbers = function(phoneNumbers);
        for (int i=0; i<phoneNumbers.length; i++) {
            System.out.println(phoneNumbers[i]);
        }

    }

    static JFrame myWin() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //закрытие программы

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

        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(500,400));

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        //frame.setBounds(dimension.width, dimension.height, 400, 400);


        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        /*
        JButton southButton = new JButton("South");
        panel.add(southButton, BorderLayout.SOUTH);

        JButton eastButton = new JButton("East");
        panel.add(eastButton, BorderLayout.EAST);

        JButton westButton = new JButton("West");
        panel.add(westButton, BorderLayout.WEST);

        JButton centerButton = new JButton("Center");
        panel.add(centerButton, BorderLayout.CENTER);
        */

        return frame;
    }

    public static String[] function(String[] array) {
        //метод преобразует переданную базу номеров в ссылки для whatsapp

        String whatsapp = "https://api.whatsapp.com/send?phone=";
        int i = 0;
        String[] phoneNumber = new String[11]; //11 знаков в номере
        //массив для символов правильного номера
        //не забудь, нумерация массива идет с 0

        while (i < array.length) { //проходим по массиву целых номеров

            String[] characters = array[i].split(""); //разделяем строку (номер) на символы

            for (int k = characters.length-1; k>=0; k--) { //проходим по массиву символов

                if (characters[k].equals(" ") || characters[k].equals("+")) {
                    //заменяем лишние символы на _
                    characters[k] = "_";
                }
            }

                int g = 0; //счетчик для прохода по массиву с null
            int n = 0;
                //n - счетчик для прохода по массиву с нормальным номером
                while (n<=phoneNumber.length-1) {
                   if (characters[g].equals("_")) {
                       g++;
                   }
                   else {
                       phoneNumber[n] = characters[g];
                       g++;
                       n++;
                   }
                }

                if (phoneNumber[0].equals("8")) {
                    phoneNumber[0] = "7";
                }

            String number = String.join("", phoneNumber);
            array[i] = whatsapp + number;
            i++;
        }
        return array;
    }


}
