package com.qima.test.zoo.reflect;

/**
 * @author A80390
 */
public class Hero {
    private String name;
    private float hp;
    private float armor;
    private int moveSpeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    /**
     * 无参构造方法
     */
    public Hero() {
        System.out.println("调用了公有无参的构造方法.........");
    }

    /**
     * 默认的构造方法
     */
    Hero(String str) {
        System.out.println("默认的构造方法 str = " + str);
    }

    /**
     * 有一个参数的构造方法
     * @param name
     */
    public Hero(char name){
        System.out.println("姓名：" + name);
    }

    /**
     * 有多个参数的构造方法
     * @param name
     * @param hp
     */
    public Hero(String name ,float hp){
        System.out.println("姓名："+name+"血量："+ hp);
    }

    /**
     * 受保护的构造方法
     * @param n
     */
    protected Hero(boolean n){
        System.out.println("受保护的构造方法 n = " + n);
    }

    /**
     * 私有构造方法
     * @param hp
     */
    private Hero(float hp){
        System.out.println("私有的构造方法   血量："+ hp);
    }
}
