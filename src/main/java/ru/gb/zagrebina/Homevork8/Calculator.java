package ru.gb.zagrebina.Homevork8;

import javax.swing.*;//подключился импорт
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator extends JFrame {

    public Calculator() {
        setTitle("Calculator");//создали окно
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//закрытие окна остановка программы
        setBounds(300, 300, 400, 400);//координаты
        setLayout(new BorderLayout());// элементы по краям(кнопки) - компановщик со сторонами света

        //добавим дисплей
        JLabel display = new JLabel("0");//добавим дисплей
        display.setHorizontalAlignment(SwingConstants.RIGHT);//цифры справа пишутся(установим горизонтальное выравнивание)
        display.setFont(new Font("Arial", Font.BOLD, 18));//делаем шрифт больше(как в ворде, стиль, жирный, размер)
        add(display, BorderLayout.NORTH);//Добавляем дисплей.Наверх

        ActionListener numberListener = new ActionListener() {
            @Override//сделали листенер для кнопок
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();//возвращает нам кнопку на которую нажали
                String text = button.getText();//то что мы нажимаем в ркне на кнопки
                String displayText = display.getText();

                if (".".equals(text) && displayText.contains(".")) {
                    return;
                }
                if ("0".equals(displayText) && !".".equals(text)) {//если ноль уже есть то лидирубщая позиция будет ""
                    displayText = "";
                }
                displayText += text;
                display.setText(displayText);
            }
        };

        //пишем листенер для кнопок+-*/
        ActionListener buttonListener = new ActionListener() {
            private String operarion;//переменная на уровне класса
            private Double leftOperand;//и эта

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();//приведем к строке
                String action = source.getText();//действие
                Double rightOperand = Double.parseDouble(display.getText());//метод преобразует в число строку

                if ("=".equals(action)){
                    if (leftOperand !=null){
                        switch (operarion){
                            case "+":
                                display.setText(String.valueOf(leftOperand + rightOperand));
                                break;
                            case "-":
                                display.setText(String.valueOf(leftOperand - rightOperand));
                                break;
                            case "*":
                                display.setText(String.valueOf(leftOperand * rightOperand));
                                break;
                            case "/":
                                display.setText(String.valueOf(leftOperand / rightOperand));
                                break;
                        }
                        leftOperand = Double.parseDouble(display.getText());//присвоили
                        operarion = null;
                    }
                    return;
                }
                leftOperand = Double.parseDouble(display.getText());
                operarion = action;
                display.setText("0");
            }
        };//тут пишем.var

        JPanel numberPanel = new JPanel();//для размещения нескольких компановщиков на одном элементе
        GridLayout numberLayout = new GridLayout(4, 4, 10, 10);//можно указать промежуток между элементами
        numberPanel.setLayout(numberLayout);//устанавливаем в панель вот этот лайаут
        //добавим кнопки
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(numberListener);
            //преобразуем i  переменную в строку
            numberPanel.add(button);//добавим кнопку
        }

        JButton point = new JButton(".");
        point.addActionListener(numberListener);
        JButton negativaPozitiv = new JButton("+/-");

        numberPanel.add(point);
        numberPanel.add(negativaPozitiv);

        JPanel buttonPanel = new JPanel();//создадим панель для +-*/=
        GridLayout buttonLayout = new GridLayout(2, 3, 10, 10);//размер панели с кнопками для действий
        buttonPanel.setLayout(buttonLayout);

        for (char c : "c+-*/=".toCharArray()) {//превратим эту строку в массив чаров
            JButton button = new JButton(String.valueOf(c));
            button.addActionListener(buttonListener);
            buttonPanel.add(button);

        }
        add(numberPanel, BorderLayout.CENTER);//добавили панель в окошко
        add(buttonPanel, BorderLayout.SOUTH);//добавили вторую панель в окошко
        setVisible(true);//видимое окно

    }

    public static void main(String[] args) {
        new Calculator();
    }
}

