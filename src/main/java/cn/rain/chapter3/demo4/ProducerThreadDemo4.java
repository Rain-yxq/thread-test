package cn.rain.chapter3.demo4;

/**
 * description: 使用java并发包中的lock锁来完成手动上锁
 *
 * @author 任伟
 * @date 2018/6/20 23:25
 */
@SuppressWarnings("all")
public class ProducerThreadDemo4 implements Runnable {

    private ShareDate user;

    ProducerThreadDemo4(ShareDate user) {
        super();
        this.user = user;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                user.getLock().lock();
                if (user.isFlag()) {
                    user.getCondition().await();
                }
                Thread.sleep(500);
                if (count == 0) {
                    System.out.println("生产者将user设置成了 大力-男");
                    user.setUsername("大力");
                    user.setGender("男");
                } else {
                    System.out.println("生产者将user设置成了 小兰-女");
                    user.setUsername("小兰");
                    user.setGender("女");
                }
                count = (count + 1) % 2;
                user.setFlag(true);
                user.getCondition().signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                user.getLock().unlock();
            }
        }
    }
}
