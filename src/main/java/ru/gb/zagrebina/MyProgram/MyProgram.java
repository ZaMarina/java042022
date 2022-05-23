package ru.gb.zagrebina.MyProgram;

import javax.swing.*;
import java.awt.*;//это классы которые позволит создать объекты кнопки, переключатели...
import java.awt.event.*;


public class MyProgram extends JFrame {
    JTextField nameField, emailField, sumField, monthField;

    private JButton credit = new JButton("Расчитать кредит");
    private JButton deposit = new JButton("Расчитать вклад");
    private JRadioButton work = new JRadioButton("Работающий");
    private JRadioButton notWork = new JRadioButton("Пенсионер");
    private JCheckBox check = new JCheckBox("Согласие на рассылку", false);


    public MyProgram() {
        setTitle("Мой Банковский калькулятор");
        setBounds(100, 100, 500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridLayout(8, 2, 5, 5));
        JLabel name = new JLabel("Введите Имя");//создадим запись
        nameField = new JTextField("", 1);//создадим поле, куда пользователь будет вводить данные. Поле занимает 1 колонку
        JLabel email = new JLabel("Введите email");
        emailField = new JTextField("@", 1);
        JLabel summa = new JLabel("Введите сумму");
        sumField = new JTextField("", 1);
        JLabel month = new JLabel("Введите срок в месяцах");
        monthField = new JTextField("", 1);

        container.add(name);
        container.add(nameField);
        container.add(email);
        container.add(emailField);
        container.add(summa);
        container.add(sumField);
        container.add(month);
        container.add(monthField);

        ButtonGroup group = new ButtonGroup();
        group.add(work);
        group.add(notWork);
        container.add(work);
        work.setSelected(true);//автоматически выбрана первая кнопка
        container.add(notWork);

        credit.addActionListener(creditListener);
        deposit.addActionListener(depositListener);
        container.add(credit);
        container.add(deposit);
        container.add(check);
    }

    ActionListener creditListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String name = nameField.getText();
            String email = emailField.getText();
            String summa = sumField.getText();
            String time = monthField.getText();
            double persent;
            double overpayment;//переплата
            double payments, monthPay, linearPersent, leftToPay;

            Double sumOperand = Double.parseDouble(sumField.getText());
            Double timeOperand = Double.parseDouble(monthField.getText());
            payments = sumOperand;
            leftToPay = sumOperand;

            if (work.isSelected()) {
                persent = 15.1;
            } else {
                persent = 11.5;
            }
                linearPersent = sumOperand * (persent / 100 / 12);//ежемес.процент
                monthPay = linearPersent + (sumOperand / timeOperand);//ежемес.платеж
                for (double i = sumOperand; i > 0; i -= monthPay) {

                    monthPay = linearPersent + (leftToPay / timeOperand);
                    System.out.format("Проц %-6.2fМес %-8.2fОст %-8.2f\n", linearPersent, monthPay,i);

                    payments = payments + leftToPay * (persent / 100 / 12);


                    linearPersent -= linearPersent - (leftToPay - monthPay) * (persent / 100 / 12);
                }
                System.out.println("Всего платежей " + payments);
                overpayment = payments - sumOperand;

                String message = "Ставка по нашему кредиту составит." + persent + ". За срок " + timeOperand + " месяцев общая сумма ваших выплат " + payments + ", ежемесячный платеж " + monthPay + "переплата по кредиту " + overpayment + "\n" + (check.isSelected() ? "Расчет отправлен на указанный email" : "Расчет на email не отправлен");

                JOptionPane.showMessageDialog(null, message, "Расчет по кредиту", JOptionPane.PLAIN_MESSAGE);

            }
        };

        ActionListener depositListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                String name = nameField.getText();
                String email = emailField.getText();
                String summa = sumField.getText();
                String time = monthField.getText();
                double result;//SummaF
                double persent, income;

                Double sumOperand = Double.parseDouble(sumField.getText());
                Double timeOperand = Double.parseDouble(monthField.getText());
                result = sumOperand;

                if (notWork.isSelected()) {
                    persent = 13.5;
                } else {
                    persent = 12.2;
                }

                for (int i = 0; i < timeOperand; i++) {
                    result = result + sumOperand * (persent / 100 / 12);

                    System.out.println(result);
                }
                income = result - sumOperand;
                System.out.println(income);

                String message = "Ставка по нашему вкладу." + persent + "По истечении " + timeOperand + " месяцев вы получите доход в размере " + income + "сумма вашего вклада составит" + result + "\n" + (check.isSelected() ? "Расчет отправлен на указанный email" : "Расчет на email не отправлен");

                JOptionPane.showMessageDialog(null, message, "Расчет по вкладу", JOptionPane.PLAIN_MESSAGE);

            }
        };

    }



