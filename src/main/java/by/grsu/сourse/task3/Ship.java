package by.grsu.сourse.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Ship extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(Ship.class);
    private int capacity;
    private Integer shipNumber;
    private Port port;
    private List<Container> containers;
    private Exchanger<List<Container>> exchanger;


    public Ship(Integer shipNumber, int capacity, Port port, List<Container> containers, Exchanger<List<Container>> exchanger) {
        this.shipNumber = shipNumber;
        this.containers = containers;
        this.port = port;
        this.exchanger = exchanger;
        this.capacity = capacity;

        setName("Ship-" + shipNumber);
    }

    @Override
    public void run() {

        try {
            Dock dock = port.getFreeDock();
            logger.info("{} moored to the dock {}", getName(), dock.getDockNumber());

            if (containers.size() == 0) {

                loadingContainer();
            } else {

                unloadContainer();
            }

            swim(dock);

        } catch (InterruptedException e) {
            interrupt();
            logger.error("ship sank", e);

            throw new RuntimeException();
        }
    }

    private void exchangeCont() {

        logger.info("{} have {} container before exchange", getName(), containers.size());
        try {
            int contSize = containers.size();

            containers = exchanger.exchange(containers, 5, TimeUnit.SECONDS);

            if (contSize==0 && contSize==containers.size()) {

                logger.error("{} was unable to exchange containers with another ship",getName());
            }else {

                logger.info("{} have {} container after exchange", getName(), containers.size());
            }



        } catch (TimeoutException | InterruptedException e) {
            logger.error("{} didn't exchange containers with anyone", getName());
        }

    }

    private void unloadContainer() {

        logger.info("{} arrived to unload {} containers", getName(), containers.size());

        if (port.getPortCapacity() - port.getContainers().size() >= containers.size()) {

            port.setContainers(containers);
            containers.clear();
            logger.info("{} unloaded containers", getName());

        } else {

            logger.info("{} was unable to unload containers and is now trying to reload them onto another ship", getName());
            exchangeCont();
        }

    }

    private void loadingContainer() {
        logger.info("{} arrived to load containers", getName());

        if (port.getContainers().size() <= capacity && port.getContainers().size() != 0) {

            containers.addAll(port.getContainers());
            port.getContainers().clear();
            logger.info("{} have {} containers after load", getName(), containers.size());

        } else if (port.getContainers().size() > capacity) {

            for (int i = 0; i < capacity; i++) {
                Container container = port.getContainers().get(1);
                containers.add(container);
                port.removeContainer(container);
            }
            logger.info("{} have {} containers after load", getName(), containers.size());

        } else {

            logger.info("{} was unable to load containers and is now trying to load them from another ship", getName());
            exchangeCont();
        }
    }

    private void swim(Dock dock) {
        dock.release();
        logger.info("{} left the port", getName());
    }

}
