package by.grsu.сourse.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    private static Port port;
    private static List<Ship> ships;

    @BeforeEach
    public void setPort(){

        List<Dock> docks = Main.docks();
        Exchanger<List<Container>> exchanger = new Exchanger<>();
        port = new Port(docks,5);

        ships = new ArrayList<>();
        List<Container> containers = new ArrayList<>();
        containers.add(new Container(1));
        containers.add(new Container(1));
        containers.add(new Container(1));
        ships.add(new Ship(1, 3 , port,containers,exchanger));
        ships.add(new Ship(2,3, port,new ArrayList<>(),exchanger));
        ships.forEach(Thread::start);

    }

    @Test
    public void busyDock() throws InterruptedException {

        for (Dock dock : port.getDocks()) {
            assertFalse(dock.isFree());
        }
    }

    @Test
    public void threadState() throws InterruptedException {

        Thread.sleep(6000);

        for (Ship ship :ships) {

            assertEquals(ship.getState(), Thread.State.TERMINATED);
        }
    }

    @Test
    public void portStorage() throws InterruptedException {

        Thread.sleep(1000);

        if (ships.get(1).getState().equals(Thread.State.TIMED_WAITING)){
            assertEquals(port.getContainers().size(),3);
        }else {
            assertEquals(port.getContainers().size(),0);
        }

    }

}