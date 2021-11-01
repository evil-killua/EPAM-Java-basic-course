package by.grsu.сourse.task2.entity.impl;

import by.grsu.сourse.task2.entity.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Sentence implements Component {

    private List<Component> components;

    {
        components = new ArrayList<>();
    }

    public Sentence() {
    }

    public Sentence(List<Component> components) {
        this.components = components;
    }

    public Sentence(Component... component) {
        components.addAll(Arrays.asList(component));
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public void addComponent(Component component) {
        components.add(component);
    }


    public int getNumberOfWord() {

        int count = 0;

        for (Component component : components)
            if (component instanceof Word)
                count++;

        return count;
    }

    @Override
    public String print() {

        String result = components.get(0).print();
        Component currentComponent;

        for (int i = 1; i < components.size(); i++) {
            currentComponent = components.get(i);

            if (currentComponent instanceof Word) {
                result += " " + currentComponent.print();
            } else {
                result += currentComponent.print();
            }

        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(components, sentence.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public String toString() {
        return components.toString();
    }
}


