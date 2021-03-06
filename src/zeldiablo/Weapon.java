package zeldiablo;

import java.io.Serializable;
import java.util.Random;

/**
 * Generates a weapon, either with random values or fixed ones (depending on the
 * constructor)
 *
 * @author Wedenig Manuel
 */
public class Weapon implements Serializable {

    private String name;
    private int damage;
    private int x;
    private int min;
    private int max;
    private int n;
    private Random r;
    private Stats weaponstats;
    private String randomname;

    /**
     * This Class got two constructors, one for the random generated weapons and
     * one for custom generated weapons.
     */
    public Weapon(int level) {
        randomName();
        name = randomname;
        damage = 0;
        n = 0;
        x = 0;
        r = new Random();
        weaponstats = new Stats();
        randomDamage(level);
        randomAttack(level);
        randomDexterity(level);
        randomStamina(level);
        randomDefence(level);

    }

    public Weapon(String name, int damage, double attack, double dexterity, double stamina, double defence) {

        this.name = name;
        this.damage = damage;
        weaponstats = new Stats();
        weaponstats.setAttack(attack);
        weaponstats.setDexterity(dexterity);
        weaponstats.setStamina(stamina);
        weaponstats.setDefence(defence);
    }

    /**
     * Method to get the name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Method to set the name
     */
    public void setName(String newName) {
        name = newName;
    }

    public void setDamage(int value) {
        damage = value;
    }

    public Stats getStats() {
        return weaponstats;
    }

    /**
     * Method to calculate the damage of a random generated weapon. The loop
     * says: For every level the character got, the maximum of damage the weapon
     * is able to deal is increased by 10. After the loop the method calculates
     * the minimum and the maximum of the damage the weapon can deal. At last
     * the we call the random method to calculate a number between the value of
     * the maximum damage and the minimum of damage. At the value of the maximum
     * of damage i had to add +1 because the method random is not made for
     * things like this.
     */
    public void randomDamage(int level) {
        while (x < level) {
            n = n + 10;
            x++;
        }

        min = n / 2;
        max = n + 1;
        damage = r.nextInt(max - min) + min;

    }

    /**
     * Calculates the random attack value the weapon will grant the character
     * and sets the weaponstat "attack" of the weapon to the calculated value.
     */
    public void randomAttack(int level) {
        x = 0;
        n = 4;
        while (x < level) {
            n = n + 1;
            x++;
        }

        min = 0;
        max = n + 1;
        int attack = r.nextInt(max - min) + min;
        weaponstats.setAttack(attack);
    }

    /**
     * Calculates the random dexterity value the weapon will grant the character
     * and sets the weaponstat "dexterity" of the weapon to the calculated
     * value.
     */
    public void randomDexterity(int level) {
        x = 0;
        n = 4;
        while (x < level) {
            n = n + 1;
            x = x + 2;
        }

        min = 0;
        max = n + 1;
        int dexterity = r.nextInt(max - min) + min;
        weaponstats.setDexterity(dexterity);
    }

    /**
     * Calculates the random Stamina value the weapon will grant the character
     * and sets the weaponstat "Stamina" of the weapon to the calculated value.
     */
    public void randomStamina(int level) {
        x = 0;
        n = 4;
        while (x < level) {
            n = n + 1;
            x++;
        }

        min = 0;
        max = n;
        int stamina = r.nextInt(max - min) + min;
        weaponstats.setStamina(stamina);
    }

    /**
     * Calculates the random defence value the weapon will grant the character
     * and sets the weaponstat "defence" of the weapon to the calculated value.
     */
    public void randomDefence(int level) {
        x = 0;
        n = 4;
        while (x < level) {
            n = n + 1;
            x++;
        }

        min = 0;
        max = n;
        int defence = r.nextInt(max - min) + min;
        weaponstats.setDefence(defence);
    }

    /**
     * There are two arrays for random generated names. "meleefirstname" is the
     * array which will be used in combination of "meleesecondname" to generate
     * a name for a melee weapon. The array "rangedfirstname" is not ready yet.
     * Finished it will work like the names for melee weapons. At the end of the
     * method it sets the name of "randomname" to the combination of an random
     * element of the two used arrays
     */
    public void randomName() {
        String[] meleefirstname = {"Dusk ", "Dark ", "Burning ", "Bright ", "Light ", "Frost ", "Night ", "Gem ", "Diamond ", "War ",
            "Infernal ", "Souldraining ", "Phantom ", "Fiendish ", "Bone ", "Skull ", "Abyssal ", "Cinder ",
            "Crystal ", "War ", "Frozen ", "Rage ", "Hunter's ", "Sanguine ", "Black ", "Blue ", "Red ",
            "Silver ", "Golden ", "Titanic ", "Wicked ", "Ghost ", "Soul ", "Pain ", "Deadly ", "Rusty ",
            "Demon ", "Old ", "Undead ", "Living ", "Devouring ", "Blazing ", "Chrome ", "Dragon ", "Flame ",
            "Omni ", "Vortex ", "Storm ", "Void ", "Hate ", "Arcane ", "Last ", "Serrated ", "Unsealed ", "Rainbowglass ",
            "Stardust ", "Tempest ", "Blaster ", "Doom ", "Miracle ", "Doom ", "Depths ", "Bloodgod's ", "Demise ",
            "Eternal ", "Hera's ", "Edea's ", "Athene's ", "Assault ", "Destruction ", "Unknown ", "Oblivion's ",
            "Vow's", "Age ", "Iceborn ", "Thunderborn ", "Lightborn ", "Stormborn ", "Darkborn ", "Lightsworn ",
            "Valkyrie's ", "Archfiend's ", "Salamandra's ", "Starborn ", "Shadowmist's ", "Toxic ", "Darkworld's ",
            "Keeper's ", "Luster ", "Ritual ", "Necro ", "Dust ", "Tormentor's ", "Buster ", "Nova ", "Tigerking's ",
            "Shdowborn ", "Forbidden's ", "Dragonborn ", "Hurrican ", "Ancient ", "Samurai ", "Odin's ", "Nordic ",
            "Solemn ", "Envoy's ", "Emissary's ", "Yamato's ", "Arasuda's ", "Berserker's ", "Mystic ", "Armageddon ",
            "Unleashed ", "Amaterasu's ", "Odd ", "Samsara's ", "Soulreaver's ", "Constellar ", "Cursed ",
            "Nightking's ", "Stormking's ", "Judgement ", "Blackshield ", "Dragonknight's ", "Serpentfire ", "Nightmare ",
            "The Prophet's ", "Fate ", "Deception ", "Common ", ""};

        String[] meleesecondname = {"Blade", "Dagger", "Sword", "Edge", "Knife", "Scepter", "Wand", "Hammer", "Axe", "Twinaxe",
            "Mallet", "Machete ", "Maw", "Scimitar ", "Rod", "Dirk", "Sabre", "Spear", "Brutalizer", "Sealbreaker",
            "Mace", "Katana", "Tachi", "Shoto", "Two-Hander", "Scythe", "Lance", "Broadsword", "Slayer", "Kunai",
            "Bloodthirster"};

//		String [] rangedfirstname = {"Nightstalkers Bow","Rangers Bow","Long Bow","Short Bow","Shadowmist Bow","Gem Bow",
//									 "Skull Bow","Snipers Bow","Smiting Bow","Frost Bow","Infernal Bow","Runaans Bow",
//									 "Bone Bow","Light Bow","Dusk Bow","Warbow","Recurve Bow,","Hunters Bow","Rapidfire Bow",
//										 "Giant Arrow Bow","Deathbringer Bow","Worldbreaker Bow","Master Bow","Lighning Bow",
//										 "Thunder Bow", "Lightray Bow","Eruption yBow","Souldraining Bow","Redeemers Bow","Fiendish Bow",
//										 "Deathblossom Bow","Forest keepers Bow","Phantom Bow","Crossbow","Abyss Bow",};
//		Not ready yet!
        String randommeleefirstname = (meleefirstname[new Random().nextInt(meleefirstname.length)]);
        String randommeleesecondname = (meleesecondname[new Random().nextInt(meleesecondname.length)]);
        randomname = randommeleefirstname + randommeleesecondname;

    }

}
