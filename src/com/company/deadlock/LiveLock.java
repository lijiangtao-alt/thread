package com.company.deadlock;

import java.util.Random;

/**
 * @Description 活锁问题，死循环，项目没有进展，还耗费资源
 * @Author lijiangtao
 * @Date 2020/9/23 19:33
 * @Version 1.0
 */
public class LiveLock {

    static class Spoon {
        private Diner owner;

        public Spoon(Diner owner) {
            this.owner = owner;
        }
        public Diner getOwner() {
            return owner;
        }
        public void setOwner(Diner owner) {
            this.owner = owner;
        }

        public synchronized void use() {
            System.out.printf("%s has !", owner.name);
        }
    }

    static class Diner {
        private String name;
        private boolean isHungry;

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                if (spoon.owner != this) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                Random random = new Random();
                if (spouse.isHungry && random.nextInt(10)<9) {
                    System.out.println(name + ":亲爱的" + spouse.name + "你先吃");
                    spoon.setOwner(spouse);
                    continue;
                }
                spoon.use();
                isHungry = false;
                System.out.println(name + ":我吃完了");
                spoon.setOwner(spouse);

            }
        }
    }

    public static void main(String[] args) {

        Diner husband = new Diner();
        Diner wife = new Diner();

        Spoon spoon = new Spoon(husband);
        new Thread(new Runnable() {
            @Override
            public void run() {
                husband.eatWith(spoon, wife);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                wife.eatWith(spoon, husband);
            }
        }).start();
    }
}
