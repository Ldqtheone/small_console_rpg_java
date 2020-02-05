/**
 * WizardArchetype Class extends by DefaultArchetype
 * @see #magicDamage int number to do magical damage
 * @see #maxMagicDamage int number to init max magical damage
 */
public class WizardArchetype extends DefaultArchetype
{
    private int magicDamage;
    private int maxMagicDamage;

    /**
     * WizardArchetype constructor
     * @param name string to set the character name
     * @param damage int to set the character damage
     * @param life int to set the character life
     * @param initiative int to set the character initiative
     * @param magicDamage int to set the character magic damage
     */
    public WizardArchetype (String name,int damage, int life, int initiative,int magicDamage)
    {
        super(name, damage, life, initiative);
        this.magicDamage = magicDamage;
        this.maxMagicDamage = magicDamage;
        this.setArchetypeName("Wizard");
    }

    /**
     * Override method reset from DefaultArchetype to reset the archetype properties
     */
    @Override
    public void reset()
    {
        this.setLife(this.getMaxLife());
        this.magicDamage = this.maxMagicDamage;
    }

    /**
     * Override method attack from DefaultArchetype
     * @return int of archetype's attack
     */
    @Override
    public int attack()
    {
        int damageSend = this.getDamage() + this.magicDamage;
        if(this.magicDamage == 0)
        {
            Commands.printn(this.getName() + " 's stick is broken !");
        }
        else
        {
            Commands.printn(this.getName() + "'s stick inflict : " + (this.magicDamage) + " magical damage.");
            this.magicDamage /= 2;
        }
        return  damageSend;
    }
}