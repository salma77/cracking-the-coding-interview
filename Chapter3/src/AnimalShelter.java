package Chapter3.src;

import java.util.LinkedList;

/**
 * An animal shelter, which holds only dogs and cats, operates on a strictly
 * "first in, first out" basis. People must adopt either the "oldest" (based on
 * arrival time) of all animals at the shelter, or they can select whether they
 * would prefer a dog or a cat (and will receive the oldest animal of that
 * type). They cannot select which specific animal they would like. Create the
 * data structures to maintain this system and implement operations such as
 * enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the built-in
 * Linked list data structure.
 */
public class AnimalShelter {

    abstract class Animal {
        private int order;
        protected String name;

        // Constructor
        public Animal(String name) {
            this.name = name;
        }

        /**
         * 
         * @return order of animal
         */
        public int getOrder() {
            return order;
        }

        /**
         * Sets order of animal
         * 
         * @param order order of animal
         */
        public void setOrder(int order) {
            this.order = order;
        }

        /**
         * Checks whether an animal is older than another animal
         * 
         * @param x the animal to be check with
         * @return
         */
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

        /**
         * remove dog from queue
         * 
         * @return
         */
        public Dog dequeueDog() {
            return dogs.poll();
        }

        /**
         * remove cat from queue
         * 
         * @return
         */
        public Cat dequeueCat() {
            return cats.poll();
        }

        /**
         * remove animal from queue
         * 
         * @return
         */
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

        /**
         * Add animal to queue and put it in the right order
         * 
         * @param x animal to be enqueued
         */
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
