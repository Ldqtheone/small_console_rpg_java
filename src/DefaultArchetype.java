/**
 * DefaultArchetype Class
 * @see #characterName string Name of the archetype's character
 * @see #archetypeName string Name of the archetype
 * @see #life   int life  of the archetype
 * @see #damage int attack of the archetype
 * @see #initiative int initiative of the archetype
 */
public class DefaultArchetype
{
    private String characterName;
    private String archetypeName;
    private int damage;
    private int life;
    private int maxLife;
    private int initiative;

    /**
     * Archetype constructor
     * @param name string to set the character name
     * @param damage int to set the character damage
     * @param life int to set the character life
     * @param initiative int to set the character initiative
     */
    public DefaultArchetype (String name, int damage, int life, int initiative)
    {
        this.characterName = name;
        this.archetypeName = "default";
        this.damage = damage;
        this.life = life;
        this.maxLife = life;
        this.initiative = initiative;
    }

    /**
     * Getter getName
     * @return string of the character name
     */
    public String getName()
    {
        return this.characterName;
    }

    /**
     * Getter getArchetypeName
     * @return string of the archetype name
     */
    public String getArchetypeName()
    {
        return this.archetypeName;
    }

    /**
     * Setter setArchetypeName
     * @param value string to set the archetype name
     */
    public void setArchetypeName(String value)
    {
        this.archetypeName = value;
    }

    /**
     * Getter getLife
     * @return int life of the archetype
     */
    public int getLife ()
    {
        return this.life;
    }

    /**
     * Setter setLife
     * @param value int value to set the archetype life
     */
    public void setLife (int value)
    {
        this.life = value;
    }

    /**
     * Getter getMaxLife
     * @return int max life of the archetype
     */
    public int getMaxLife ()
    {
        return this.maxLife;
    }

    /**
     * Getter getDamage
     * @return int of the archetype damage
     */
    public int getDamage()
    {
        return this.damage;
    }

    /**
     * Getter getInitiative
     * @return int of the archetype initiative
     */
    public int getInitiative ()
    {
        return this.initiative;
    }

    /**
     * Method to reset the archetype properties
     */
    public void reset()
    {
        this.life = this.maxLife;
    }

    /**
     * Method attack
     * @return int of archetype attack
     */
    public int attack ()
    {
        return getDamage();
    }

    /**
     * Method setDamageReceived to update life after receiving damage
     * @param damageReceived int quantity of damage received
     */
    public void setDamageReceived(int damageReceived)
    {
        this.life -= damageReceived;
    }

    /**
     * Override method toString from Object
     * @return String with all archetype attributes
     */
    public String toString()
    {
        return  this.characterName + " is a " + this.archetypeName + ", had " + this.life + " HP, " + this.damage + " strength and " + this.initiative + " initiative.";
    }
}