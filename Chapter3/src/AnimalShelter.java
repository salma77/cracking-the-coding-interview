package Chapter3.src;

import java.util.LinkedList;

public class AnimalShelter {

    abstract class Animal {
        private int order;
        protected String name;

        public Animal(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public boolean isOlder(Animal x) {
            return (this.order < x.getOrder());
        }
    }

    public class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
    }

    public class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }

    public class Animals {
        LinkedList<Dog> dogs = new LinkedList<Dog>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        int order = 0;

        public Dog dequeueDog() {
            return dogs.poll();
        }

        public Cat dequeueCat() {
            return cats.poll();
        }

        public Animal dequeueAll() {
            if (dogs.size() == 0)
                return dequeueCat();
            if (cats.size() == 0)
                return dequeueDog();
            if (dogs.peek().isOlder(cats.peek()))
                return dequeueDog();
            else
                return dequeueCat();
        }

        public void enqueue(Animal x) {
            x.setOrder(order);
            order++;
            if (x instanceof Dog)
                dogs.addLast((Dog) x);
            else
                cats.addLast((Cat) x);
        }

    }
}
