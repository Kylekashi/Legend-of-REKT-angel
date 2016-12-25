/**
 * @author Auer Marco
 */
package zeldiablo;

public class Stats {

    private double attack;
    private double dexterity;
    private double stamina;
    private double defence;
    private double hp;
    private double maxHP;
    private double critChance;
    private int level;
    private String statSummary;
    private boolean visible;

    public Stats(String characterClass, int level, String name) {
        attack = 0;
        dexterity = 0;
        stamina = 0;
        defence = 0;
        this.level = level;
        statAdjustment(characterClass, level, name);
        hp = stamina * 15;
        maxHP = hp;
        statSummary = "";
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public double getDefence() {
        return defence;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public double getHP() {
        return hp;
    }

    public void setHP(double hp) {
        this.hp = hp;
    }

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }

    public double getCritChance() {
        return critChance;
    }

    public String getStatSummary1() {
        return statSummary = "Attack: " + (int) attack + ". Dexterity: " + (int) dexterity + ". Stamina: " + (int) stamina + ". Defence: " + (int) defence;
    }

    public String getStatSummary2() {
        return statSummary = "HP: " + (int) hp + ". Max HP: " + (int) maxHP + ". Level: " + level + ". Crit: " + critChance;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void statAdjustment(String characterClass, int level, String name) {
        switch (characterClass) {
            case "Knight":
                attack = 10;
                dexterity = 5;
                stamina = 15;
                defence = 15;
                break;
            case "Berserker":
                attack = 15;
                dexterity = 20;
                stamina = 10;
                defence = 10;
                break;
            case "Hunter":
                attack = 10;
                dexterity = 10;
                stamina = 10;
                defence = 5;
                break;
            case "REKTangel":
                stamina = 1;
            case "Mob":
                attack = 15;
                stamina = 5;
                defence = 5;
                break;
            case "Boss1":
                attack = 20;
                stamina = 30;
                defence = 10;
                break;
            default:
                break;
        }

        switch (name) {
            case "Osl":
                attack *= 2;
                stamina *= 2;
                defence *= 2;
                break;
            case "debug":
                attack = 666;
                dexterity = 666;
                stamina = 666;
                defence = 666;
                break;
            default:
                break;
        }

        this.level = level;

        for (int x = level; x > 1; x--) {
            attack = attack + ((attack * 20) / 100);
            stamina = stamina + ((stamina * 20) / 100);
            defence = defence + ((defence * 20) / 100);

            switch (characterClass) {
                case "Knight":
                    dexterity += 1;
                    break;
                case "Berserker":
                    dexterity += 1.5;
                    break;
                case "Hunter":
                    dexterity += 1.25;
                    break;
                default:
                    break;
            }

        }

        Chance chanceCalc = new Chance(level, dexterity, characterClass);
        critChance = chanceCalc.calculateCritChance();

        this.hp = this.stamina * 15;
        this.maxHP = this.hp;
    }

}
