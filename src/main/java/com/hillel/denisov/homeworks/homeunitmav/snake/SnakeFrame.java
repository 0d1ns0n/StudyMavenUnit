package com.hillel.denisov.homeworks.homeunitmav.snake;

import com.hillel.denisov.homeworks.homeunitmav.snake.object.Apple;
import com.hillel.denisov.homeworks.homeunitmav.snake.object.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class SnakeFrame extends JPanel implements ActionListener {

    public static JFrame jFrame;
    public static int HP = 3;
    public static final int SCALE = 32; // шкала пискселей, размер клетки
    public static final int WIDTH = 20; // ширина
    public static final int HEIGHT = 20;// высота

    public Image apple = imageDownload("src/images/icons8-яблоко-48.png");
    public Image fon = imageDownload("src/images/dashanew.png");
    public Image snakeBody = imageDownload("src/images/snakeBody.png");
    public Image snakeHead = imageDownload("src/images/snakeHead.png");
    public Image snakeHeadRight = imageDownload("src/images/snakeHeadRight.png");
    public Image snakeBodyRight = imageDownload("src/images/snakeBodyRight.png");
    public Image snakeBodyLeft = imageDownload("src/images/snakeBodyLeft.png");
    public Image snakeHeadLeft = imageDownload("src/images/snakeHeadLeft.png");
    public Image snakeHeadDown = imageDownload("src/images/snakeHeadDown.png");
    public Image snakeBodyDown = imageDownload("src/images/snakeBodyDown.png");


    public Snake snake = new Snake(5, 6, 5, 5);
    public Apple applePos = new Apple(8, 2);

    public static int speed = 10;
    public Timer timer = new Timer(1000 / speed, this);
    public static MyButtonFrame myButtonFrame = new MyButtonFrame();
    public static ChangeFrame changeFrame = new ChangeFrame();

    public SnakeFrame() {

        timer.start();
        addKeyListener(new KeyB());
        setFocusable(true);

    }

    public static void frm() {
        jFrame = new JFrame("Твоя любимая игра");

        jFrame.setSize(WIDTH * SCALE + 16, HEIGHT * SCALE + 6);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.setResizable(false);

        jFrame.setLocationRelativeTo(null);

        jFrame.add(new SnakeFrame());

        jFrame.setVisible(true);
    }


    public static void main(String[] args) {

        myButtonFrame.setVisible(true);
        myButtonFrame.setLocationRelativeTo(null);
        myButtonFrame.setResizable(false);


    }


    @Override
    public void paint(Graphics g) {

        g.drawImage(fon, SCALE - 40, SCALE - 40, this);


        g.setColor(Color.black);
        for (int x = 0; x < WIDTH * SCALE; x += SCALE) {
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }
        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
            g.drawLine(0, y, WIDTH * SCALE, y);
        }

        for (int i = 0; i < snake.length; i++) {

            if (snake.runBody == 1) {
                repaint();
                g.drawImage(snakeBodyRight, snake.snakeX[i] * SCALE, snake.snakeY[i] * SCALE,
                        SCALE, SCALE, this);

                g.drawImage(snakeHeadRight, snake.snakeX[0] * SCALE, snake.snakeY[0] * SCALE,
                        SCALE, SCALE, this);
            }
            if (snake.runBody == 0) {
                repaint();
                g.drawImage(snakeBody, snake.snakeX[i] * SCALE, snake.snakeY[i] * SCALE,
                        SCALE, SCALE, this);

                g.drawImage(snakeHead, snake.snakeX[0] * SCALE, snake.snakeY[0] * SCALE,
                        SCALE, SCALE, this);
            }
            if (snake.runBody == 2) {
                repaint();
                g.drawImage(snakeBodyDown, snake.snakeX[i] * SCALE, snake.snakeY[i] * SCALE,
                        SCALE, SCALE, this);

                g.drawImage(snakeHeadDown, snake.snakeX[0] * SCALE, snake.snakeY[0] * SCALE,
                        SCALE, SCALE, this);
            }
            if (snake.runBody == 3) {
                repaint();
                g.drawImage(snakeBodyLeft, snake.snakeX[i] * SCALE, snake.snakeY[i] * SCALE,
                        SCALE, SCALE, this);

                g.drawImage(snakeHeadLeft, snake.snakeX[0] * SCALE, snake.snakeY[0] * SCALE,
                        SCALE, SCALE, this);
            }


        }

        g.drawImage(apple, applePos.posX * SCALE, applePos.posY * SCALE, SCALE, SCALE, this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();


        if ((snake.snakeX[0] == applePos.posX) && (snake.snakeY[0] == applePos.posY)) {
            applePos.randomPos();
            snake.length++;
        }
        for (int i = 1; i < snake.length; i++) {

            if ((snake.snakeX[i] == applePos.posX) && (snake.snakeY[i] == applePos.posY)) {
                applePos.randomPos();
            }
        }

        for (int i = 1; i < snake.length; i++) {

            if (snake.snakeY[0] == snake.snakeY[i] && snake.snakeX[0] == snake.snakeX[i]) {
                HP--;
                if (HP == 2) {
                    JOptionPane.showMessageDialog(this, "ОСТАЛОСЬ ДВЕ ПОПЫТКИ КРИВОРУКИЙ ДЫБИЛ", "ТЫ ДОЛБОЕБ", JOptionPane.INFORMATION_MESSAGE);
                }
                if (HP == 1) {
                    JOptionPane.showMessageDialog(this, "БОЖЕ КАКОЙ ТЫ ИДИОТ, У ТЕБЯ ОСТАЛАСЬ ОДНА ПОПЫТКА", "ТЫ ДОЛБОЕБ, СОБЕРИСЬ!", JOptionPane.INFORMATION_MESSAGE);
                }
                if (HP == 0) {
                    JOptionPane.showMessageDialog(this, "ПОПЫТОК БОЛЬШЕ НЕТ, ИДИ НАХУЙ", "ТЫ ДОЛБОЕБ", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                snake.length = 2;
            }
        }
        repaint();
    }

    public class KeyB extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int k = e.getKeyCode();
            if (k == KeyEvent.VK_UP && snake.runBody != 2) {
                snake.runBody = 0;
            }
            if (k == KeyEvent.VK_DOWN && snake.runBody != 0) {
                snake.runBody = 2;
            }
            if (k == KeyEvent.VK_LEFT && snake.runBody != 1) {
                snake.runBody = 3;
            }
            if (k == KeyEvent.VK_RIGHT && snake.runBody != 3) {
                snake.runBody = 1;
            }
        }
    }

    static Image imageDownload(String filName) {
        return new ImageIcon(filName).getImage();
    }

    static class ChangeFrame extends JFrame {
        public ChangeFrame() {
            setTitle("Выбери уровень кусок ты говна");
            setSize(400, 300);
            setResizable(false);
            setLocationRelativeTo(null);
            changePanel changePanel = new changePanel();
            add(changePanel);



        }

        static class changePanel extends Panel {
            public static Button easy = new Button("Я мамкинка зайка");
            public static Button medium = new Button("Ходил в качалку разок");
            public static Button hard = new Button("Могу наебашить твоему бате");

            public changePanel() {
                action esAct = new action(easy);
                action mAct = new action(medium);
                action hAct = new action(hard);
                easy.addActionListener(esAct);
                medium.addActionListener(mAct);
                hard.addActionListener(hAct);

                setLayout(new BorderLayout());
                JLabel back = new JLabel(new ImageIcon("src/images/snakeMunu.png"));
                back.setLayout(new FlowLayout());
                back.add(easy);
                back.add(medium);
                back.add(hard);
                add(back);

            }

            private static class action implements ActionListener {
                public action(Button b) {
                    tap = b;
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (tap == easy) {
                        speed = 2;
                        changeFrame.setVisible(false);
                    }
                    if (tap == medium) {
                        speed = 6;
                        changeFrame.setVisible(false);
                    }
                    if (tap == hard) {
                        speed = 12;
                        changeFrame.setVisible(false);
                    }
                }

                private final Button tap;
            }
        }
    }

    static class MyButtonFrame extends JFrame {

        public MyButtonFrame() {

            setTitle("Это самое главное меню, та и ебать тебя это не должно, какое это меню");
            setSize(800, 800);
            MyButtonPanel panel = new MyButtonPanel();
            add(panel);
            setVisible(true);
        }


        static class MyButtonPanel extends Panel {

            public MyButtonPanel() {
                Button bButton = new Button("Поехали");
                Button exitButton = new Button("Я дыбил");
                Button changeLvl = new Button("Выбери сложность");


                MyButtonPanel.MyListenerAction bAction = new
                        MyButtonPanel.MyListenerAction(Color.blue);
                MyButtonPanel.MyListenerAction exitAction = new
                        MyButtonPanel.MyListenerAction(Color.black);
                MyListenerAction change = new MyListenerAction(Color.pink);


                bButton.addActionListener(bAction);
                exitButton.addActionListener(exitAction);
                changeLvl.addActionListener(change);

                setLayout(new BorderLayout());
                JLabel back = new JLabel(new ImageIcon("src/images/snakeMunu.png"));
                back.setLayout(new FlowLayout());
                back.add(bButton);
                back.add(changeLvl);
                back.add(exitButton);
                add(back);
            }

            private class MyListenerAction implements ActionListener {
                public MyListenerAction(Color c) {
                    bColor = c;

                }

                public void actionPerformed(ActionEvent event) {

                    repaint();
                    if (bColor == Color.BLACK) {
                        System.exit(0);
                    }
                    if (bColor == Color.blue) {
                        myButtonFrame.setVisible(false);
                        frm();
                    }
                    if (bColor == Color.pink) {
                        changeFrame.setVisible(true);
                    }
                }

                private final Color bColor;

            }

        }
    }
}

