package com.example.demo.test;


import lombok.extern.slf4j.Slf4j;

/**
 * @Author ZHAO Yudong
 * @Date 2020/9/27 11:34
 * @description：
 */
@Slf4j
public class MathTest {
    public static void main(String[] args) {
        mathMethod();
    }

    private static void mathMethod() {

// Math.sqrt()//计算平方根 Math.cbrt()//计算立方根 Math.hypot(x,y)//计算 (x的平方+y的平方)的平方根

        log.info("Math.sqrt(16)----:" + Math.sqrt(16));//4.0
        log.info("Math.cbrt(8)----:" + Math.cbrt(8));//2.0
        log.info("Math.hypot(3,4)----:" + Math.hypot(3, 4));//5.0


// Math.pow(a,b)//计算a的b次方 Math.exp(x)//计算e^x的值

        log.info("------------------------------------------");
        log.info("Math.pow(3,2)----:" + Math.pow(3, 2));//9.0
        log.info("Math.exp(3)----:" + Math.exp(3));//20.085536923187668


//Math.max();//计算最大值 Math.min();//计算最小值

        log.info("------------------------------------------");
        log.info("Math.max(2.3,4.5)----:" + Math.max(7, 15));//15
        log.info("Math.min(2.3,4.5)----:" + Math.min(2.3, 4.5));//2.3


//Math.abs求绝对值

        log.info("------------------------------------------");
        log.info("Math.abs(-10.4)----:" + Math.abs(-10.4));//10.4
        log.info("Math.abs(10.1)----:" + Math.abs(10.1));//10.1


//Math.ceil天花板的意思，就是返回大的值

        log.info("------------------------------------------");
        log.info("Math.ceil(-10.1)----:" + Math.ceil(-10.1));//-10.0
        log.info("Math.ceil(10.7)----:" + Math.ceil(10.7));//11.0
        log.info("Math.ceil(-0.7)----:" + Math.ceil(-0.7));//-0.0
        log.info("Math.ceil(0.0)----:" + Math.ceil(0.0));//0.0
        log.info("Math.ceil(-0.0)----:" + Math.ceil(-0.0));//-0.0
        log.info("Math.ceil(-1.7)----:" + Math.ceil(-1.7));//-1.0


//Math.floor地板的意思，就是返回小的值

        log.info("------------------------------------------");
        log.info("Math.floor(-10.1)----:" + Math.floor(-10.1));//-11.0
        log.info("Math.floor(10.7)----:" + Math.floor(10.7));//10.0
        log.info("Math.floor(-0.7)----:" + Math.floor(-0.7));//-1.0
        log.info("Math.floor(0.0)----:" + Math.floor(0.0));//0.0
        log.info("Math.floor(-0.0)----:" + Math.floor(-0.0));//-0.0


//Math.random 取得一个大于或者等于0.0小于不等于1.0的随机数[0,1)

        log.info("------------------------------------------");
        log.info("Math.random()----:" + Math.random());//输出[0,1)间的随机数 0.8979626325354049
        log.info("Math.random()*100----:" + Math.random() * 100);//输出[0,100)间的随机数 32.783762836248144


// Math.rint 四舍五入 返回double值

        log.info("------------------------------------------");
        log.info("Math.rint(10.1)----:" + Math.rint(10.1));//10.0
        log.info("Math.rint(10.7)----:" + Math.rint(10.7));//11.0
        log.info("Math.rint(-10.5)----:" + Math.rint(-10.5));//-10.0
        log.info("Math.rint(-10.51)----:" + Math.rint(-10.51));//-11.0
        log.info("Math.rint(-10.2)----:" + Math.rint(-10.2));//-10.0
        log.info("Math.rint(9)----:" + Math.rint(9));//9.0


//Math.round 四舍五入 float时返回int值，double时返回long值

        log.info("------------------------------------------");
        log.info("Math.round(10.1)----:" + Math.round(10.1));//10
        log.info("Math.round(10.7)----:" + Math.round(10.7));//11
        log.info("Math.round(-10.5)----:" + Math.round(-10.5));//-10
        log.info("Math.round(-10.51)----:" + Math.round(-10.51));//-11
        log.info("Math.round(-10.2)----:" + Math.round(-10.2));//-10
        log.info("Math.round(9)----:" + Math.round(9));//9


//Math.nextUp(a) 返回比a大一点点的浮点数

        log.info("------------------------------------------");
        log.info("Math.nextUp(1.2)----:" + Math.nextUp(1.2));//1.2000000000000002


//Math.nextDown(a) 返回比a小一点点的浮点数

        log.info("------------------------------------------");
        log.info("Math.nextDown(1.2)----:" + Math.nextDown(1.2));//1.1999999999999997


//Math.nextAfter(a,b) 返回(a,b)或(b,a)间与a相邻的浮点数 b可以比a小

        log.info("------------------------------------------");
        log.info("Math.nextAfter(1.2, 2.7)----:" + Math.nextAfter(1.2, 2.7));//1.2000000000000002
        log.info("Math.nextAfter(1.2, -1)----:" + Math.nextAfter(1.2, -1));//1.1999999999999997

    }
}
