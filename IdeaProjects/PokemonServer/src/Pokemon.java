public class Pokemon {
    //number,name,type1,type2,total,hp,attack,defense,sp_attack,sp_defense,speed,generation,legendary
    int number,maxHp,attack,defense,spDefense,spAttack,speed,generation;
    String name;
    boolean isLegendary;

    public Pokemon(int number, int maxHp, int attack, int defense, int spDefense, int spAttack, int speed, int generation, String name, boolean isLegendary) {
        this.number = number;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.spDefense = spDefense;
        this.spAttack = spAttack;
        this.speed = speed;
        this.generation = generation;
        this.name = name;
        this.isLegendary = isLegendary;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(int spDefense) {
        this.spDefense = spDefense;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    public void setLegendary(boolean legendary) {
        isLegendary = legendary;
    }
}
