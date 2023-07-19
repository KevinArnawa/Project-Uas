abstract class Creature {
    private final String name;
    private int maxHp;
    private final int attack;
    private final int reward;

    public Creature(String name, int maxHp, int attack, int reward) {
        this.name = name;
        this.maxHp = maxHp;
        this.attack = attack;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public int getReward() {
        return reward;
    }
    public void takeDamage(int damage) {
        maxHp -= damage;
        if (maxHp < 0) {
            maxHp = 0;
        }
    }

    public boolean isDefeated() {
        return maxHp <= 0;
    }
}

class Slime extends Creature {
    public Slime() {
        super("Slime", 60, 20, 10);
    }
}

class Wolf extends Creature {
    public Wolf() {
        super("Wolf", 180, 35, 25);
    }
}

class Dragon extends Creature {
    public Dragon() {
        super("Dragon", 600, 80, 50);
    }
}