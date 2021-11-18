package by.grsu.сourse.task3;

import java.util.concurrent.Semaphore;

public class Dock {

    private Integer dockNumber;
    private Semaphore semaphore;
    private boolean free = true;

    public Dock(Integer dockNumber) {
        this.dockNumber = dockNumber;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public boolean isFree() {
        return free;
    }

    public void busy() {
        free = false;
    }

    public void release() {
        free = true;
        semaphore.release();
    }

    public Integer getDockNumber() {
        return dockNumber;
    }

}
