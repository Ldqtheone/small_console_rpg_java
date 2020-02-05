import java.util.Random;

/**
 * ThiefArchetype Class extends by DefaultArchetype
 * @see #canCritical boolean for check if thief can do a critical hit
 * @see #criticalChance int chance number in percent to do a critical hit
 * @see #dodgeChance int chance number in percent to dodge a hit
 */
public class ThiefArchetype extends DefaultArchetype
{
    private int criticalChance;
    private boolean canCritical;
    private int dodgeChance;

    /**
     * ThiefArchetype constructor
     * @param name string to set the character name
     * @param damage int to set the character damage
     * @param life int to set the character life
     * @param initiative int to set the character initiative
     */
    public ThiefArchetype (String name, int damage, int life, int initiative)
    {
        super(name, damage, life, initiative) ;
        this.criticalChance = 10;
        this.canCritical = true;
        this.dodgeChance = 20;
        this.setArchetypeName("Thief");
    }

    /**
     * Override method reset from DefaultArchetype to reset the archetype properties
     */
    @Override
    public void reset()
    {
        this.setLife(this.getMaxLife());
        this.canCritical = true;
    }

    /**
     * Override method attack from DefaultArchetype
     * @return int of archetype's attack
     */
    @Override
    public int attack()
    {
        int damage = this.getDamage();
        if(this.canCritical)
        {
            if(new Random().nextInt(100) < this.criticalChance)
            {
                damage *=  2;
                this.canCritical = false;
                Commands.printn(this.getName() + " made a critical hit !");
            }
        }
        else
            this.canCritical = true;
        return damage;
    }

    /**
     * Override method setDamageReceived from DefaultArchetype to update life after receiving damage
     * @param damageReceived int quantity of damage received
     */
    @Override
    public void setDamageReceived(int damageReceived)
    {
        if(new Random().nextInt(100) < this.dodgeChance)
        {
            damageReceived = 0;
            Commands.printn(this.getName() + " dodge the attack : 0 damage received.");
        }
        this.setLife(this.getLife() - damageReceived);
    }
}