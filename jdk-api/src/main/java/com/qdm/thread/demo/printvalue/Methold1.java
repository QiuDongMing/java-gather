package com.qdm.thread.demo.printvalue;

/**
 * @author qiudm
 * @date 2018/12/24 14:46
 * @desc
 */
public class Methold1 {

    public static void main(String[] args) {

        ToGo toGo = new ToGo(1);

        PrintNum printNum = new PrintNum(toGo);
        PrintChar printChar = new PrintChar(toGo);
        printNum.start();
        printChar.start();
    }
}


class PrintNum extends Thread {

    ToGo toGo;

    public PrintNum(ToGo toGo) {
        this.toGo = toGo;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 52; i++) {
            synchronized (toGo) {
                if (toGo.getVal() == 2) {
                    try {
                        toGo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(i);
                if(i % 2 == 0) {
                    toGo.setVal(2);
                    toGo.notifyAll();
                    continue;
                }

            }
        }
    }
}


class PrintChar extends Thread {

    ToGo toGo;

    public PrintChar(ToGo toGo) {
        this.toGo = toGo;
    }

    @Override
    public void run() {
        for (int i = 65; i <= 91; i++) {
            synchronized (toGo) {
                while (toGo.getVal() == 1) {
                    try {
                        toGo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print((char) i);
                toGo.setVal(1);
                toGo.notifyAll();
            }

        }
    }
}








class ToGo {
    private int val = 1;

    ToGo(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}


