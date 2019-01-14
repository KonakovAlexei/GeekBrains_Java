import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*
Домашнее задание к уровку 4 GeekBrains JAVA 2 lvl:
1.	Создать окно для клиентской части чата: большое текстовое поле для отображения переписки в центре окна.
Однострочное текстовое поле для ввода сообщений и кнопка для отсылки сообщений на нижней панели.
Сообщение должно отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter.
При «отсылке» сообщение перекидывается из нижнего поля в центральное.
*/


public class Home4 {
    public static void main(String[] args) {
    Window window = new Window();
    }
    public static class Window extends JFrame {
        private JTextField field;
        private JTextArea jta;
        private JButton button;



    public Window() {
                setTitle("Simple chat");
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setBounds(100, 100, 500, 500);

                JPanel jp = new JPanel();
                jp.setLayout(new BorderLayout());

                jta = new JTextArea();
                jta.setLineWrap(true);
                JScrollPane jsp = new JScrollPane(jta);
                jp.add(jsp, BorderLayout.CENTER);

                JPanel bottomJp = new JPanel();
                bottomJp.setLayout(new BorderLayout());

                addTextField();
                bottomJp.add(field, BorderLayout.CENTER);

                addButton();
                bottomJp.add(button, BorderLayout.SOUTH);
                jp.add(bottomJp, BorderLayout.SOUTH);
                add(jp);

                setVisible(true);
                field.grabFocus();
            }

            private void sendMessage () {
                if (!field.getText().isEmpty()) {
                    jta.append(field.getText() + "\n");
                    field.setText("");
                    field.grabFocus();
                }
            }

            private void addTextField () {
                field = new JTextField();
                field.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        sendMessage();
                    }


                });
            }

            private void addButton () {
                button = new JButton("Отправить");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        sendMessage();
                    }


                }
                );
            }
        }

    }
