/* Exercise 1: Use @Override Correctly
✅ Problem Statement:
Create a parent class Animal with a method makeSound().
Then, create a Dog class that overrides this method using @Override.
🔹 Steps to Follow:
Define a makeSound() method in Animal class.
Override it in Dog class with @Override.
Instantiate Dog and call makeSound().
 */

package com.annotations;
class Animal {
    void makeSound(){
        System.out.println("Animal makes sound.");
    }
}
class Dog extends Animal {
    @Override
    void makeSound(){
        System.out.println("Dog barks Bow Bow");
    }
}
public class Exercise1 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
    }
}
