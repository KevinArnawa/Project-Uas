public interface Healable {
    void takeDamage(int damage);
    boolean isDefeated();
    void addCoin(int RewardValue);

    void Heal(int amount);
}
