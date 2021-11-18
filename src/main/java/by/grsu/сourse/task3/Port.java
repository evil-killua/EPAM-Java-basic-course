package by.grsu.сourse.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Port {

    private List<Dock> docks;

    private Semaphore semaphore;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private volatile List<Container> containers;
    private int portCapacity;

    {
        containers = new ArrayList<>();
    }

    public Port(List<Dock> docks,int portCapacity) {
        this.docks = docks;
        this.portCapacity = portCapacity;
        semaphore = new Semaphore(docks.size());
        docks.forEach(d -> d.setSemaphore(semaphore));
    }

    public Dock getFreeDock() throws InterruptedException {

        semaphore.acquire();
        lock.writeLock().lock();
        Dock dock = docks.stream().filter(Dock::isFree).findFirst().get();
        dock.busy();
        lock.writeLock().unlock();

        return dock;
    }

    public List<Container> getContainers() {

        lock.readLock().lock();
        try {
            return containers;
        } finally {
            lock.readLock().unlock();
        }

    }

    public void setContainers(List<Container> containers) {
        lock.writeLock().lock();
        this.containers.addAll(containers);
        lock.writeLock().unlock();
    }

    public void removeContainer(Container container) {
        lock.writeLock().lock();
        containers.remove(container);
        lock.writeLock().unlock();
    }

    public List<Dock> getDocks() {
        return docks;
    }

    public int getPortCapacity() {
        return portCapacity;
    }
}
