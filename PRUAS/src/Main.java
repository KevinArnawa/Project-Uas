import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("==================== Welcome To Dragon Quest (Alpha Version 1.1) ====================");
        System.out.println();

        // Pemberian atribut player
        System.out.print("Silahkan Masukkan Nama: ");
        String p_nama = in.next();
        Player player = new Player(p_nama);
        player.resetHp();

        // Pemberian atribut creature
        Creature[] npc = {
                new Slime(),
                new Wolf(),
                new Dragon()
        };

        for (Creature enemy : npc) {
            enemy.resetHp();
        }

        // Main menu
        boolean quit = false;
        while (!quit) {
            System.out.println("\t\t\t\t    MAIN MENU");
            System.out.println();
            System.out.println("Menu" + "\t\t\t" + "Enemy" + "\t\t\t" + "Code" + "\t\t\t" + "Reward");
            System.out.println("_______________________________________________________________________________");
            for (int i = 1; i <= npc.length; i++) {
                System.out.println("Chapter " + (i) + "\t\t" + npc[i - 1].getName() + "\t\t\t" + "[" + (i) + "]" + "\t\t\t\t" + npc[i - 1].getReward());
            }
            System.out.println("Shop \t\t\t-- \t\t\t\t[s] \t\t\t0");
            System.out.println("Cek Status \t\t-- \t\t\t\t[c] \t\t\t0");
            System.out.println("Quit \t\t\t-- \t\t\t\t[q] \t\t\t0");
            System.out.println();
            System.out.print("Silahkan Memilih Tujuan: ");
            String select = in.next();
            System.out.println();

            switch (select) {
                case "1", "2", "3" -> {
                    int enemyIndex = Integer.parseInt(select) - 1;
                    Creature enemy = npc[enemyIndex];
                    int battleResult = battle(enemy, player);
                    if (battleResult == 1) {
                        System.out.println();
                        System.out.println("Anda Mendapat " + enemy.getReward() + " coin");
                        player.addCoin(enemy.getRewardValue());
                        player.resetHp();
                        enemy.resetHp();
                    } else {
                        player.decreaseLives();
                        System.out.println("Nyawa Anda Tersisa " + player.getLives());
                    }
                    System.out.println();
                }
                case "s" -> {
                    // Menu shop
                    boolean shop = false;
                    while (!shop) {
                        System.out.println("\t\t\t\t    MENU SHOP");
                        System.out.println();
                        System.out.println("Selamat Datang Di Shop, Selamat Berbelanja");
                        System.out.println("Coin anda : " + player.getCoin());
                        System.out.println();
                        System.out.println("Code \t" + "Item" + "\t\t" + "Damage" + "\t\t" + "Maxhp" + "\t\t" + "Coin");
                        System.out.println("_______________________________________________________________________________");
                        System.out.println("[1] \t" + "Wooden Sword  " + "\t" + "10" + "\t\t" + "20 HP" + "\t\t" + "50 Coin");
                        System.out.println("[2] \t" + "Iron Sword    " + "\t" + "20" + "\t\t" + "50 HP" + "\t\t" + "100 Coin");
                        System.out.println("[3] \t" + "Golden Sword  " + "\t" + "35" + "\t\t" + "100 HP" + "\t\t" + "200 Coin");
                        System.out.println("[4] \t" + "Diamond Sword " + "\t" + "50" + "\t\t" + "250 HP" + "\t\t" + "500 Coin");
                        System.out.println("[5] \t" + "Slayer Sword  " + "\t" + "100" + "\t\t" + "500 HP" + "\t\t" + "1000 Coin");
                        System.out.println("[q] \t" + "Keluar        " + "\t" + "--" + "\t\t" + "--" + "\t\t" + "--");
                        System.out.println();
                        System.out.print("Silahkan Pilih Menu: ");
                        String menuShop = in.next();
                        System.out.println();

                        switch (menuShop) {
                            case "q" -> shop = true;
                            case "1" -> {
                                if (player.getAttack() < 30 && player.getCoin() >= 50) {
                                    player.setAttack(30);
                                    player.resetHp();
                                    player.setMaxHp(80);
                                    player.decreaseCoin(50);
                                    System.out.println("Anda mendapatkan Wooden Sword!!");
                                } else {
                                    System.out.println("Anda tidak berhak mendapatkan item ini!!");
                                }
                                System.out.println();
                            }
                            case "2" -> {
                                if (player.getAttack() < 40 && player.getCoin() >= 100) {
                                    player.setAttack(40);
                                    player.setMaxHp(110);
                                    player.resetHp();
                                    player.decreaseCoin(100);
                                    System.out.println("Anda mendapatkan Iron Sword!!");
                                } else {
                                    System.out.println("Anda tidak berhak mendapatkan item ini!!");
                                }
                                System.out.println();
                            }
                            case "3" -> {
                                if (player.getAttack() < 55 && player.getCoin() >= 200) {
                                    player.setAttack(55);
                                    player.setMaxHp(160);
                                    player.resetHp();
                                    player.decreaseCoin(200.5);
                                    System.out.println("Anda mendapatkan Golden Sword!!");
                                } else {
                                    System.out.println("Anda tidak berhak mendapatkan item ini!!");
                                }
                                System.out.println();
                            }
                            case "4" -> {
                                if (player.getAttack() < 70 && player.getCoin() >= 500) {
                                    player.setAttack(70);
                                    player.setMaxHp(310);
                                    player.resetHp();
                                    player.decreaseCoin(500.5);
                                    System.out.println("Anda mendapatkan Diamond Sword!!");
                                } else {
                                    System.out.println("Anda tidak berhak mendapatkan item ini!!");
                                }
                                System.out.println();
                            }
                            case "5" -> {
                                if (player.getAttack() < 120 && player.getCoin() >= 1000) {
                                    player.setAttack(120);
                                    player.setMaxHp(560);
                                    player.resetHp();
                                    player.decreaseCoin(1000);
                                    System.out.println("Anda mendapatkan Slayer Sword!!");
                                } else {
                                    System.out.println("Anda tidak berhak mendapatkan item ini!!");
                                }
                                System.out.println();
                            }
                            case "mintauang" -> {
                                System.out.println("Anda mendapat 100000 coin !!!");
                                player.increaseCoin(100000);
                                System.out.println();
                            }
                            default -> {
                                System.out.println("Inputan Tidak Ada Pada Menu");
                                System.out.println();
                            }
                        }
                    }
                }
                case "c" -> {
                    // Menu cek status
                    System.out.println("\t\t\t\t    STATUS PEMAIN");
                    System.out.println();
                    System.out.println("Nama Pemain: " + player.getName());
                    System.out.println("Attack: " + player.getAttack());
                    System.out.println("Max HP: " + player.getMaxHp());
                    System.out.println("Coin: " + player.getCoin());
                    System.out.println("Nyawa: " + player.getLives());
                    System.out.println();
                }
                case "q" -> {
                    System.out.println("------------------------- Terima Kasih Telah Bermain --------------------------");
                    System.out.println("===============================================================================");
                    player.resetHp();
                    quit = true;
                }
                default -> {
                    System.out.println("Inputan Tidak Ada Pada Menu");
                    System.out.println();
                }
            }

            if (player.getLives() == 0) {
                System.out.println("---------------------------- Nyawa Anda Tersisa 00 ----------------------------");
                System.out.println("------------------------- Terima Kasih Telah Bermain --------------------------");
                System.out.println("===============================================================================");
                quit = true;
            }
        }
    }

    public static int battle(Creature enemy, Player player) {
        Scanner in = new Scanner(System.in);
        System.out.println("\t\t\t\t    CHAPTER " + enemy.getName());
        int turn = 1;
        System.out.println();

        label:
        while (true) {
            System.out.println("Turn " + turn);
            System.out.println("\t\t\t" + player.getName() + "\t\tVS\t\t" + enemy.getName());
            System.out.println("\t_______________________________________________________________");
            System.out.println("\tHp   |\t\t" + player.getHp() + "/" + player.getMaxHp() + "\t\t\t" + enemy.getHp() + "/" + enemy.getMaxHp());
            System.out.println("\tpower|\t\t" + player.getAttack() + "\t\t\t\t" + enemy.getAttack());
            System.out.println();
            System.out.println("[1] Menyerang (Damage " + player.getAttack() + ")\t[2] Healing (heal " + (player.getMaxHp() / 10) + ")\t[q] Menyerah");
            System.out.print("Giliranmu: ");
            String aksi = in.next();

            switch (aksi) {
                case "1":
                    System.out.println("Musuh terkena " + player.getAttack() + " damage");
                    enemy.takeDamage(player.getAttack());
                    break;
                case "2":
                    System.out.println("Anda memulihkan " + (player.getMaxHp() / 10) + " Hp");
                    player.Heal(player.getMaxHp() / 10);
                    break;
                case "q":
                    break label;
                default:
                    System.out.println("Inputan Tidak Ada Pada Menu");
                    break;
            }

            if (enemy.isDefeated()) {
                System.out.println("Musuh dikalahkan");
                return 1;
            }

            player.takeDamage(enemy.getAttack());

            if (player.isDefeated()) {
                System.out.println("Anda telah kalah");
                break;
            }

            turn++;
        }

        return 0;
    }
}
