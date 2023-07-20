abstract class Creature {
    private final String name;
    private final int maxHp;
    private int npc_Hp;
    private final int attack;
    private final int reward;

    public Creature(String name, int maxHp,int npc_Hp, int attack, int reward) {
        this.name = name;
        this.maxHp = maxHp;
        this.npc_Hp = npc_Hp;
        this.attack = attack;
        this.reward = reward;
    }

    public void resetHp() {
        npc_Hp = maxHp;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return npc_Hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getReward() {
        return reward;
    }
    public void takeDamage(int damage) {
        npc_Hp -= damage;
        if (npc_Hp < 0) {
            npc_Hp = 0;
        }
    }
    public abstract int getRewardValue();

    public boolean isDefeated() {
        return npc_Hp <= 0;
    }
}

class Slime extends Creature {
    public Slime() {
        super("Slime", 60,60, 20, 10);
    }

    @Override
    public int getRewardValue() {
        return getReward();
    }
}

class Wolf extends Creature {
    public Wolf() {
        super("Wolf", 180, 180,35, 25);
    }

    @Override
    public int getRewardValue() {
        return getReward();
    }
}

class Dragon extends Creature {
    public Dragon() {
        super("Dragon", 600,600, 80, 50);
    }

    @Override
    public int getRewardValue() {
        return getReward();
    }
}