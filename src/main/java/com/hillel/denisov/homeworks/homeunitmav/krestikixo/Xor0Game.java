package com.hillel.denisov.homeworks.homeunitmav.krestikixo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Xor0Game extends JComponent {
    public static final int FIELD_EMPTY = 0;
    public static final int FIELD_X = 10;
    public static final int FIELD_0 = 200;
    int[][] field;
    boolean isXturn;

    public Xor0Game() {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        field = new int[3][3];
        initGame();
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);
        if (e.getButton() == MouseEvent.BUTTON1) {
            int x = e.getX(); // корды х клика
            int y = e.getY(); // корды у клика
            int i = (int) ((float) x / getWidth() * 3);
            int j = (int) ((float) y / getHeight() * 3);
            if (field[i][j] == FIELD_EMPTY) {
                field[i][j] = isXturn ? FIELD_X : FIELD_0;
                isXturn = !isXturn;
                repaint();
                int res = checkWin();
                if (res != 0) {
                    if (res == FIELD_0 * 3) {
                        JOptionPane.showMessageDialog(this, " 0 WIIN", "WIIN", JOptionPane.INFORMATION_MESSAGE);
                    } else if (res == FIELD_X * 3) {
                        JOptionPane.showMessageDialog(this, "X WIIN", "WIIN", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "NOT WIN", "NOT WINNERS", JOptionPane.INFORMATION_MESSAGE);
                    }
                    initGame();
                    repaint();
                }
            }
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, getWidth(), getHeight());
        drawGrid(g);
        drawX0(g);
    }
    int checkWin() {
        int diag = 0;
        int diag2 = 0;
        for (int i = 0; i < 3; i++) {
            diag += field[i][i];
            diag2 += field[i][2 - i];
        }
        if (diag == FIELD_0 * 3 || diag == FIELD_X * 3) {
            return diag;
        }
        if (diag2 == FIELD_0 * 3 || diag2 == FIELD_X * 3) {
            return diag2;
        }
        int check_i, check_j;
        boolean hasEmpty = false;
        for (int i = 0; i < 3; i++) {
            check_i = 0;
            check_j = 0;
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == 0) {
                    hasEmpty = true;
                }
                check_i += field[i][j];
                check_j += field[j][i];
            }
            if (check_i == FIELD_0 * 3 || check_i == FIELD_X * 3) {
                return check_i;
            }
            if (check_j == FIELD_0 * 3 || check_j == FIELD_X * 3) {
                return check_j;
            }
        }
        if (hasEmpty) return 0;
        else return -1;
    }

    public void initGame() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                field[i][j] = FIELD_EMPTY;
            }
        }
        isXturn = true;
    }

    public void drawX(int i, int j, Graphics g) {
        g.setColor(Color.black);
        int dw = getWidth() / 3;
        int dh = getHeight() / 3;
        int x = i * dw;
        int y = j * dh;
        g.drawLine(x, y, x + dw, y + dh);
        g.drawLine(x, y + dh, x + dw, y);
    }

    public void draw0(int i, int j, Graphics g) {
        g.setColor(Color.black);
        int dw = getWidth() / 3;
        int dh = getHeight() / 3;
        int x = i * dw;
        int y = j * dh;
        g.drawOval(x + 5 * dw / 100, y, dw * 9 / 10, dh);
    }

    public void drawX0(Graphics g) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == FIELD_X) {
                    drawX(i, j, g);
                } else if (field[i][j] == FIELD_0) {
                    draw0(i, j, g);
                }
            }
        }
    }

    public void drawGrid(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        int dw = w / 3;
        int dh = h / 3;
        g.setColor(Color.BLUE);
        for (int i = 0; i < 3; i++) {
            g.drawLine(0, dh * i, w, dh * i);
            g.drawLine(dw * i, 0, dw * i, h);
        }
    }


}
