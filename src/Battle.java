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
	public int playerDamage;
	int[] retval = new int[] {0, 0, 0};
	
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

	public int[] newBattle(int actionIndex) {

		if (actionIndex == 0) {
			playerDamage = player1.attack();
			
			retval[1] = playerDamage;
			
			System.out.println("\nPlayer attacks!");
			System.out.println(playerDamage + " damage done.");

			if (playerDamage >= currentMonster.getHealth()) {
				System.out.println(currentMonster.getName() + " is dead!");
				currentMonster.damaged(playerDamage);
				retval[0] = 1;
				return retval;
			} else {
				if (player1.getHealth() > 0) {
					currentMonster.damaged(playerDamage);
					System.out.println(currentMonster.getName() +" has " + currentMonster.getHealth() + " health remaining.");
					System.out.println(currentMonster.getName() + " attacks!");
				} else {
					retval[0] = 1;
					return retval;
				}
				int monsterDamage = currentMonster.attack();

				retval[2] = monsterDamage;
			
				System.out.println(monsterDamage + " damage done.");

				if (monsterDamage >= player1.getHealth()) {
					System.out.println("The player is dead!");
					player1.damaged(monsterDamage);
					dead = true;
					retval[0] = 1;
					return retval;
				} else {
					player1.damaged(monsterDamage);
					System.out.println("Player has " + player1.getHealth() + " health remaining.");
				}
			}

			retval[0] = 0;
			return retval;

		} else if (actionIndex == 1) {
			if (player1.getHPotions() > 0) {

				if (player1.getHealth() == player1.getMaxHP()) {
					System.out.println("You already have full health!");
					return retval;
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
					
					retval[2] = monsterDamage;

					System.out.println(monsterDamage + " damage done.");

					if (monsterDamage >= player1.getHealth()) {
						System.out.println("The player is dead!");
						player1.damaged(monsterDamage);
						dead = true;
						retval[0] = 1;
						return retval;
					} else {
						player1.damaged(monsterDamage);
						System.out.println("Player has " + player1.getHealth() + " health remaining.");
					}

					retval[0] = 0;
					return retval;
				}
			} else {
				System.out.println("Not enough health potions!");
				return retval;
			}
		} else if (actionIndex == 2) {
			if (player1.getMana() >= 5) {
				if (player1.getHealth() == player1.getMaxHP()) {
					System.out.println("You already have full health!");
					return retval;
				} else  {
					player1.heal(true);

					System.out.println("\nPlayer casts heal!\n");

					if (player1.getHealth() > player1.getMaxHP()) {
						System.out.println("Player healed to max health!");
						player1.setHealth(player1.getMaxHP());
					}

					System.out.println(currentMonster.getName() + " attacks!");

					int monsterDamage = currentMonster.attack();
					
					retval[2] = monsterDamage;

					System.out.println(monsterDamage + " damage done.");

					if (monsterDamage >= player1.getHealth()) {
						System.out.println("The player is dead!");
						player1.damaged(monsterDamage);
						dead = true;
						retval[0] = 1;
						return retval;
					} else {
						player1.damaged(monsterDamage);
						System.out.println("Player has " + player1.getHealth() + " health remaining.");
					}

					retval[0] = 0;
					return retval;
				}
			} else {
				System.out.println("Not enough mana!");
				return retval;
			}
		} else if (actionIndex == 3) {
			if (currentMonster == asgoroth) {
				System.out.println("A storm rumbles overhead... ASGOROTH IS SMITED DOWN");
				System.out.println("You win!");
				win = true;
				retval[0] = 1;
				return retval;
			} else {
				System.out.println("A storm rumbles overhead... YOU ARE SMITED DOWN");
				dead = true;
				retval[0] = 1;
				return retval;
			}
		} else if (actionIndex == 4) {

			if (player1.getMPotions() > 0) {

				if (player1.getMana() == player1.getMaxMP()) {
					System.out.println("You already have full mana!");
					return retval;
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
					
					retval[2] = monsterDamage;

					System.out.println(monsterDamage + " damage done.");

					if (monsterDamage >= player1.getHealth()) {
						System.out.println("The player is dead!");
						player1.damaged(monsterDamage);
						dead = true;
						retval[0] = 1;
						return retval;
					} else {
						player1.damaged(monsterDamage);
						System.out.println("Player has " + player1.getHealth() + " health remaining.");
					}

					retval[0] = 0;
					return retval;
				}
			} else {
				System.out.println("Not enough mana potions!");
				return retval;
			}
		}
		return retval;
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
	
	public int getDamage() {
		return playerDamage;
	}
	
	public int getPlayerHealth() {
		return player1.getHealth();
	}
}
