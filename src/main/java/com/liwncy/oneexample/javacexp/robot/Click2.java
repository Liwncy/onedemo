package com.liwncy.oneexample.javacexp.robot;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @Classname
 * @Description //TODO $
 * @Date
 * @Author
 */
public class Click2 {


    private static Robot robot;

    public static void main(String[] args) {
        int jisu = 0;
        try {
            robot = new Robot();// 创建Robot对象
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        robot.delay(10000);
        Point mousepoint = MouseInfo.getPointerInfo().getLocation();
        Color pixel = robot.getPixelColor(mousepoint.x, mousepoint.y);
        System.out.println("当前鼠标的坐标和颜色" + pixel + mousepoint);//来打印当前鼠标的坐标，从而找到对的位置

        while (pixel != null) {
            robot.delay(5000);
            Color pixel0 = robot.getPixelColor(944, 602);
            Color pixel1 = robot.getPixelColor(872, 566);
            Color pixel2 = robot.getPixelColor(863, 308);

            if (pixel0.equals(new Color(224, 158, 48))) {
                System.out.print("找到目标" + "\n");
                robot.delay(200);
                robot.mouseMove(944, 602);
                robot.delay(200);
                robot.mousePress(KeyEvent.BUTTON1_MASK);
                robot.mouseRelease(KeyEvent.BUTTON1_MASK);
                robot.delay(200);

            } else if (pixel1.equals(new Color(220, 154, 47))) {
                System.out.print("找到目标" + "\n");
                robot.delay(200);
                robot.mouseMove(872, 566);
                robot.delay(200);
                robot.mousePress(KeyEvent.BUTTON1_MASK);
                robot.mouseRelease(KeyEvent.BUTTON1_MASK);
                robot.delay(200);
            } else if (pixel2.equals(new Color(22, 31, 97))) {
                System.out.print("找到目标" + "刷图次数" + jisu + "\n");
                robot.delay(200);
                robot.mouseMove(863, 308);
                robot.delay(200);
                robot.mousePress(KeyEvent.BUTTON1_MASK);
                robot.mouseRelease(KeyEvent.BUTTON1_MASK);
                robot.delay(200);
                jisu++;
            } else {
                robot.delay(5000);
            }
        }
    }


}
