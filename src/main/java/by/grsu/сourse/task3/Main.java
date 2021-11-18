package by.grsu.сourse.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {

        List<Dock> docks = docks();

        Port port = new Port(docks,5);
        List<Ship> ships = getShips(port);

        ships.forEach(Thread::start);
    }

    public static List<Ship> getShips(Port port) {

        List<Ship> ships = new ArrayList<>();
        Exchanger<List<Container>> exchanger = new Exchanger<>();

        for (int i = 0; i < 5; i++) {
            ships.add(new Ship(i+1, 3 , port, containers(), exchanger));
        }
        return ships;
    }

    public static List<Container> containers() {

        List<Container> containers = new ArrayList<>();
        int count = (int) (Math.random() * (3+1));

        for (int i = 0; i < count; i++) {

            containers.add(getContainer());
        }

        return containers;
    }

    public static Container getContainer() {

        int weight = 1 + (int) (Math.random() * 6);
        return new Container(weight);
    }

    public static List<Dock> docks() {

        List<Dock> terminals = new ArrayList<>();
        terminals.add(new Dock(1));
        terminals.add(new Dock(2));
        return terminals;
    }
}
