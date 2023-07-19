public class Player implements Healable {
    private String name;
    private int maxHp;
    private int attack;
    private int coin;
    private int lives;

    public Player(String name) {
        this.name = name;
        this.maxHp = 60;
        this.attack = 20;
        this.coin = 0;
        this.lives = 3;
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

    public int getCoin() {
        return coin;
    }

    public int getLives() {
        return lives;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void increaseCoin(int amount) {
        coin += amount;
    }

    public void decreaseCoin(int amount) {
        coin -= amount;
        if (coin < 0) {
            coin = 0;
        }
    }
    //overloading method decreaseCoin
    public void decreaseCoin(double amount) {
        int roundedAmount = (int) Math.round(amount);
        coin -= roundedAmount;
        if (coin < 0) {
            coin = 0;
        }
    }

    public void decreaseLives() {
        lives--;
    }
    @Override
    public void takeDamage(int damage) {
        maxHp -= damage;
        if (maxHp < 0) {
            maxHp = 0;
        }
    }
    @Override
    public boolean isDefeated() {
        return maxHp <= 0;
    }

    @Override
    public void addCoin() {
        coin++;
    }

    @Override
    public void Heal(int amount) {
        maxHp += amount;
        if (maxHp > 60) {
            maxHp = 60;
        }
    }
}
