package com.liwncy.robot;


import java.awt.*;
import java.awt.event.InputEvent;

/**
 * @Classname Fishing
 * @Description //TODO $Robot简单例子,实现MC钓鱼脚本
 * @Date
 * @Author Liwncy
 */
public class Fishing {
    /**
     * @Author Liwncy
     * @Description //TODO 主函数
     * @Date 2020/5/21 14:18
     * @Params
     * @param args
     * @return void
     **/
    public static void main(String[] args) throws AWTException {
        int count = 200;
        fishing(count);
        //click(50);
    }
    /**
     * @Author Liwncy
     * @Description //TODO 右键点击测试
     * @Date 2020/5/21 14:18
     * @Params
     * @param count
     * @return void
     **/
    public static void click(int count) throws AWTException {
        Robot robot = new Robot();// 创建Robot对象
        robot.delay(10000);// 延迟10秒,切换屏幕,找准钓鱼位置
        for (int i = 0; i < count; i++) {
            robot.mousePress(InputEvent.BUTTON1_MASK); //按下右键
            robot.delay(150);// 延迟1秒
            robot.mouseRelease(InputEvent.BUTTON1_MASK); //松开右键
            System.out.println(count);
        }
    }
    /**
     * @Author Liwncy
     * @Description //TODO 钓鱼函数
     * @Date 2020/5/21 14:18
     * @Params
     * @param count
     * @return java.lang.String
     **/
    public static String fishing(int count) throws AWTException {
        Robot robot = new Robot();// 创建Robot对象
        robot.delay(10000);// 延迟10秒,切换屏幕,找准钓鱼位置
        for (int i = 0; i < count; i++) {
            // 0,每次循环前延时1秒
            robot.delay(2000);// 延迟1秒
            // 1,抛竿
            robot.mousePress(InputEvent.BUTTON3_MASK); //按下右键
            robot.delay(150);// 延迟1秒
            robot.mouseRelease(InputEvent.BUTTON3_MASK); //松开右键
            System.out.println("我丢!!!");
            // 2,钓鱼ing
            int colorSum = 0;
            //提示语的坐标和颜色:java.awt.Color[r=255,g=170,b=0]java.awt.Point[x=676,y=361]
            //正常水的坐标和颜色:java.awt.Color[r=80,g=95,b=218]java.awt.Point[x=677,y=374]
            do {
                robot.delay(500);// 延迟1秒
                Color tipsColor = robot.getPixelColor(676, 361);//提示出现位置
                System.out.println("钓鱼中:" + tipsColor);
                colorSum = tipsColor.getBlue();
            } while (colorSum > 10);
            // 3,收杆
            robot.mousePress(InputEvent.BUTTON3_MASK); //按下右键
            robot.delay(150);// 延迟0.15秒
            robot.mouseRelease(InputEvent.BUTTON3_MASK); //松开右键
            System.out.println("啊哈,上钩了!!!" + (i + 1) + "条啦!!");
        }
        return "";
    }
}
