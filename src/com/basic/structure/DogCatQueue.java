package com.basic.structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 猫狗队列
 */

// 猫狗类
class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}

// 宠物入队列
class PetEnterQueue {
    Pet pet;
    int index;

    public PetEnterQueue(Pet pet, int index) {
        this.pet = pet;
        this.index = index;
    }

    public Pet getPet() {
        return pet;
    }

    public int getIndex() {
        return index;
    }
}


public class DogCatQueue {
    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private int count;

    public DogCatQueue() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
        count = 0;
    }

    public void add(Pet pet) {
        if ("dog".equals(pet.getPetType())) {
            dogQueue.add(new PetEnterQueue(pet, count++));
        } else if ("cat".equals(pet.getPetType())) {
            catQueue.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException();
        }
    }

    // 队列中所有实例按进队列顺序弹出
    public Pet pollAll() {
        if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
            return dogQueue.peek().getIndex() < catQueue.peek().getIndex() ? dogQueue.poll().getPet() : catQueue.poll().getPet();
        } else if (!dogQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        } else if (!catQueue.isEmpty()) {
            return catQueue.poll().getPet();
        } else {
            throw new RuntimeException("no pet");
        }

    }

    //
    public Dog pollDog() {
        if (dogQueue.isEmpty()) {
            throw new RuntimeException("no dog");
        }
        //
        return (Dog) dogQueue.poll().getPet();
    }

    //
    public Cat pollCat() {
        if (catQueue.isEmpty()) {
            throw new RuntimeException("no cat");
        }
        return (Cat) catQueue.poll().getPet();
    }

    // 是否有cat实例或dog实例
    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

    public static void main(String[] args) {
        DogCatQueue test = new DogCatQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }


}
