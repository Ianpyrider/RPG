public class Battle {

	PartyMember player1 = new PartyMember(20, 1, 1, 10);
	Monster orc = new Monster(7, 1, 0, "Kalel the orc");
	Monster goblin;
	Monster minotaur;
	Monster asgoroth;
	Monster currentMonster = orc;
	boolean dead = false;
	boolean playerAttack = false;
	boolean win = false;

	public  void resetBattle(int battleIndex) {
		if (battleIndex == 0) {
			System.out.println(currentMonster.getName() + " appears!");
		} else if (battleIndex == 1) {
			System.out.println("A new challenger approaches...");
			goblin = new Monster(5, 1, 3, "Jimmy the goblin");
			currentMonster = goblin;
			System.out.println("\n" + currentMonster.getName() + " appears!");
		} else if (battleIndex == 2) {
			System.out.println("A new challenger approaches...");
			minotaur = new Monster(10, 1, 1, "Ian the minotaur");
			currentMonster = minotaur;
			System.out.println("\n" + currentMonster.getName() + " appears!");
		} else if (battleIndex == 3) {
			System.out.println("A new challenger approaches...");
			asgoroth = new Monster(20, 10, 2, "Asgoroth, destroyer of worlds");
			currentMonster = asgoroth;
			System.out.println("\n" + currentMonster.getName() + " appears!");
		}
	}

	public boolean newBattle(int actionIndex) {

		if (actionIndex == 0) {
			int playerDamage = player1.attack();

			System.out.println("\nPlayer attacks!");
			System.out.println(playerDamage + " damage done.");

			if (playerDamage >= currentMonster.getHealth()) {
				System.out.println(currentMonster.getName() + " is dead!");
				currentMonster.damaged(playerDamage);
				return true;
			} else {
				if (player1.getHealth() > 0) {
					currentMonster.damaged(playerDamage);
					System.out.println(currentMonster.getName() +" has " + currentMonster.getHealth() + " health remaining.");
					System.out.println(currentMonster.getName() + " attacks!");
				} else {
					return true;
				}
				int monsterDamage = currentMonster.attack();

				System.out.println(monsterDamage + " damage done.");

				if (monsterDamage >= player1.getHealth()) {
					System.out.println("The player is dead!");
					player1.damaged(monsterDamage);
					dead = true;
					return true;
				} else {
					player1.damaged(monsterDamage);
					System.out.println("Player has " + player1.getHealth() + " health remaining.");
				}
			}

			return false;

		} else if (actionIndex == 1) {
			if (player1.getHPotions() > 0) {

				if (player1.getHealth() == player1.getMaxHP()) {
					System.out.println("You already have full health!");
					return false;
				} else {
					player1.heal(false);

					if (player1.getHealth() > player1.getMaxHP()) {
						System.out.println("Player healed to max health!");
						player1.setHealth(player1.getMaxHP());
					} else {
						System.out.println("\nHealed!\n");
					}

					System.out.println(currentMonster.getName() + " attacks!");

					int monsterDamage = currentMonster.attack();

					System.out.println(monsterDamage + " damage done.");

					if (monsterDamage >= player1.getHealth()) {
						System.out.println("The player is dead!");
						player1.damaged(monsterDamage);
						dead = true;
						return true;
					} else {
						player1.damaged(monsterDamage);
						System.out.println("Player has " + player1.getHealth() + " health remaining.");
					}

					return false;
				}
			} else {
				System.out.println("Not enough health potions!");
				return false;
			}
		} else if (actionIndex == 2) {
			if (player1.getMana() >= 5) {
				if (player1.getHealth() == player1.getMaxHP()) {
					System.out.println("You already have full health!");
					return false;
				} else  {
					player1.heal(true);

					System.out.println("\nPlayer casts heal!\n");

					if (player1.getHealth() > player1.getMaxHP()) {
						System.out.println("Player healed to max health!");
						player1.setHealth(player1.getMaxHP());
					}

					System.out.println(currentMonster.getName() + " attacks!");

					int monsterDamage = currentMonster.attack();

					System.out.println(monsterDamage + " damage done.");

					if (monsterDamage >= player1.getHealth()) {
						System.out.println("The player is dead!");
						player1.damaged(monsterDamage);
						dead = true;
						return true;
					} else {
						player1.damaged(monsterDamage);
						System.out.println("Player has " + player1.getHealth() + " health remaining.");
					}

					return false;
				}
			} else {
				System.out.println("Not enough mana!");
				return false;
			}
		} else if (actionIndex == 3) {
			if (currentMonster == asgoroth) {
				System.out.println("A storm rumbles overhead... ASGOROTH IS SMITED DOWN");
				System.out.println("You win!");
				win = true;
				return true;
			} else {
				System.out.println("A storm rumbles overhead... YOU ARE SMITED DOWN");
				dead = true;
				return true;
			}
		} else if (actionIndex == 4) {
			
			if (player1.getMPotions() > 0) {

				if (player1.getMana() == player1.getMaxMP()) {
					System.out.println("You already have full mana!");
					return false;
				} else {
					player1.restoreMana();

					if (player1.getMana() > player1.getMaxMP()) {
						System.out.println("Player healed to max mana!");
						player1.setMana(player1.getMaxMP());
					} else {
						System.out.println("\nMana restored!\n");
					}

					System.out.println(currentMonster.getName() + " attacks!");

					int monsterDamage = currentMonster.attack();

					System.out.println(monsterDamage + " damage done.");

					if (monsterDamage >= player1.getHealth()) {
						System.out.println("The player is dead!");
						player1.damaged(monsterDamage);
						dead = true;
						return true;
					} else {
						player1.damaged(monsterDamage);
						System.out.println("Player has " + player1.getHealth() + " health remaining.");
					}

					return false;
				}
			} else {
				System.out.println("Not enough mana potions!");
				return false;
			}
		}
	return false;
}

public int playerHPotions() {
	return player1.getHPotions();
}

public int playerMPotions() {
	return player1.getMPotions();
}

public  boolean playerDead() {
	return dead;
}

public boolean playerAttack() {
	return playerAttack;
}

public boolean win() {
	return win;
}
}
