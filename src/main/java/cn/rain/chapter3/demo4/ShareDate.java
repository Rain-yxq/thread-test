package cn.rain.chapter3.demo4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * description: 线程间的共享数据，其中包括lock锁和condition
 *
 * @author 任伟
 * @date 2018/6/20 23:22
 */
public class ShareDate {
    private String username;
    private String gender;
    private boolean flag;
    private Lock lock;
    private Condition condition;

    ShareDate(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "ShareDate{" +
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
