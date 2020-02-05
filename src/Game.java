import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class Game to start the game that contain all create / list / editing methods
 */
public class Game
{
    List<DefaultArchetype> characters;

    /**
     * Game method that contain the ArrayList of each characters created in the game
     * @see #characters ArrayList of DefaultArchetype
     */
    public Game()
    {
        characters = new ArrayList<DefaultArchetype>();
        /*characters.add(new WizardArchetype("BIBI",150, 400, 200, 200));
        characters.add(new ThiefArchetype("toto",150, 400, 200));
        characters.add(new WarriorArchetype("coco",150, 400, 200));*/
    }

    /**
     * Create method for creating a new character with all attributes
     */
    public void create()
    {
        Commands.printn("Creating a character...");
        switch (createArchetype())
        {
            case  "warrior" :
                characters.add(new WarriorArchetype(createName(),createDamage(), createLife(), createInitiative()));
                break;
            case  "wizard" :
                characters.add(new WizardArchetype(createName(),createDamage(), createLife(), createInitiative(), createMagicDamage()));
                break;
            case  "thief" :
                characters.add(new ThiefArchetype(createName(),createDamage(), createLife(), createInitiative()));
                break;
            default:
                characters.add(new DefaultArchetype(createName(), createDamage(), createLife(), createInitiative()));
        }
        Commands.printn("Character '" + characters.get(characters.size() - 1).getName() + "' has been created");
    }

    /**
     * createName method for create new character player name
     * @return #name of the new character created
     */
    private String createName()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        String name;
        do
        {
            Commands.print("");
            Commands.print("> Enter your name : ");
            name = sc.nextLine();
            if(name.equals(""))
            {
                Commands.printn("Name is empty !");
                continue;
            }
            if(usedName(name))
                continue;
            do
            {
                Commands.printn("Valid the name '" + name + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return name;
    }

    /**
     * createDamage method for create new character player damage
     * @return #damage of the new character created
     */
    private int createDamage()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        int damage;
        do
        {
            Commands.print("");
            damage = Commands.inputInt("Enter character's power strike : ");
            if(damage == 0)
            {
                Commands.printn("Power Strike is null !");
                continue;
            }
            do
            {
                Commands.printn("Valid power strike '" + damage + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return damage;
    }

    /**
     * createMagicDamage method for create new character wizard player magic damage
     * @return #magicDamage of the new character created
     */
    private int createMagicDamage()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        int magicDamage = 0;
        do
        {
            Commands.print("");
            magicDamage = Commands.inputInt("Enter character's magic damage : ");
            if(magicDamage == 0)
            {
                Commands.printn("Magic damage is null !");
                continue;
            }
            do
            {
                Commands.printn("Valid magic damage '" + magicDamage + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return magicDamage;
    }

    /**
     * createInitiative method for create new character player initiative
     * @return #initiative of the new character created
     */
    private int createInitiative()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        int initiative = 0;
        do
        {
            Commands.print("");
            initiative = Commands.inputInt("Enter character's initiative: ");
            if(initiative == 0)
            {
                Commands.printn("Initiative is null !");
                continue;
            }
            do
            {
                Commands.printn("Valid initiative '" + initiative + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return initiative;
    }

    /**
     * createLife method for create new character player life
     * @return #life of the new character created
     */
    private int createLife()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        int life = 0;
        do
        {
            Commands.print("");
            life = Commands.inputInt("Enter character's life : ");
            if(life == 0)
            {
                Commands.printn("Life is null !");
                continue;
            }
            do
            {
                Commands.printn("Valid life '" + life + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return life;
    }

    /**
     * usedName method for check if a name is already use or not
     * @param name : the name of the character
     * @return boolean true if name already in use and false if name available
     */
    private boolean usedName(String name)
    {
        for(DefaultArchetype character : characters)
        {
            if(character.getName().equals(name))
            {
                Commands.printn("Name is already used !");
                return true;
            }
        }
        return false;
    }

    /**
     * createArchetype method for generate archetype of each new character
     * @return #archetype of the new character
     */
    private String createArchetype()
    {
        Scanner sc = new Scanner(System.in);
        String valid = "";
        String archetype;
        List<String> archetypes = new ArrayList<String>();
        archetypes.add("warrior");
        archetypes.add("wizard");
        archetypes.add("thief");
        listArchetype(archetypes);
        do
        {
            Commands.print("");
            Commands.print("> Choose your class: ");
            archetype = sc.nextLine().toLowerCase();
            if(archetype == "")
            {
                Commands.printn("Class is empty !");
                continue;
            }
            if(archetypes.indexOf(archetype) == -1)
            {
                Commands.printn("The class '" + archetype + "' doesn't exist !");
                continue;
            }
            do
            {
                Commands.printn("Valid the class '" + archetype + "' ? Yes / No");
                Commands.print("> ");
                valid = sc.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        return archetype;
    }

    /**
     * listArchetype method to list all of the archetypes available for character creation.
     * @param archetypes available in the list
     */
    public void listArchetype(List<String> archetypes)
    {
        Commands.printn("List of archetype :");
        Commands.printn("");
        for(int i = 0; i < archetypes.size(); i++)
        {
            Commands.printn(" - " + archetypes.get(i));
        }

        Commands.printn("");
        Commands.printn("**********************");
    }

    /**
     * listCharacters method to display all characters already created
     */
    public void listCharacters()
    {
        Commands.printn("List of characters :");
        Commands.printn("");
        for(int i = 0; i < characters.size(); i++)
        {
            Commands.printn((i + 1) + " - " + characters.get(i).getName() +
                    " (" + characters.get(i).getArchetypeName() + ")");
        }

        Commands.printn("");
        Commands.printn("**********************");
    }


    /**
     * fight method to start a fight between two players
     * Select two characters in the characters list who have to fight
     */
    public void fight()
    {
        DefaultArchetype playerTwo = null;

        Commands.printn("You're going to initiate a fight between two fighters.");
        listCharacters();
        DefaultArchetype playerOne = characters.get(Commands.inputInt("Choose your first fighter id : ")-1);

        do
        {
            if(playerTwo != null && playerOne.getName().equals(playerTwo.getName()))
                Commands.printn("Character already selected.");
            playerTwo = characters.get(Commands.inputInt("Choose your second fighter id : ") - 1);
        } while (playerOne.getName().equals(playerTwo.getName()));

        if(playerTwo.getInitiative() > playerOne.getInitiative())
        {
           var tempToChange = playerOne;
           playerOne = playerTwo;
           playerTwo = tempToChange;
        }

        Commands.printn("The fight between "+ playerOne.getName() + " and "+ playerTwo.getName() + " begin !\n");
        Commands.printn(playerOne.getName() + " has the initiative.");

        int round = 1;
        while (isAlive(playerOne) && isAlive(playerTwo))
        {
            Commands.printn("");
            Commands.printn("*** Round : " + round + " ***");
            attackFight(playerOne, playerTwo);
            if (isAlive(playerTwo))
                attackFight(playerTwo, playerOne);
            round++;
        }
        if (isAlive(playerOne))
            Commands.printn( playerOne.getArchetypeName() + " : " + playerOne.getName() + " is the best Winner in the street !");
        else
            Commands.printn( playerTwo.getArchetypeName() + " : " + playerTwo.getName() + " is the best Winner in the street !");
        Commands.printn("");
        playerOne.reset();
        playerTwo.reset();
    }

    /**
     * attackFight method for display all characters informations at each rounds start
     * @param striker is the character who become an attack
     * @param target is the character who receive the attack
     */
    private void attackFight(DefaultArchetype striker, DefaultArchetype target)
    {
        Commands.printn("Name         : " + striker.getName());
        Commands.printn("Archetype    : " + striker.getArchetypeName());
        Commands.printn("Health point : " + striker.getLife() + " / " + striker.getMaxLife());
        Commands.printn("Power Attack : " + striker.getDamage());
        int damageSend = striker.attack();
        Commands.printn("Damage       : " + damageSend);
        Commands.printn("");
        target.setDamageReceived(damageSend);
        Commands.printn("");

        if(!isAlive(target))
            Commands.printn(target.getName() + " is dead !");
    }

    /**
     * isAlive method use for check if character is alive or not checking is life
     * @param player is the player checked
     * @return true if life is superior 0 , false if life is inferior 0
     */
    public boolean isAlive(DefaultArchetype player)
    {
        return player.getLife() > 0;
    }

    /**
     * remove method to remove a character from the character list with his index number
     */
    public void remove()
    {
        String valid = "";
        Scanner selectRemove = new Scanner(System.in);
        main.game.listCharacters();
        int indexRemove;
        do
        {
            Commands.printn("");
            Commands.printn("Enter '-1' to cancel.");
            indexRemove = Commands.inputInt("Enter character index : ");
            if (indexRemove == -1)
                break;
            else if(indexRemove <= 0 || indexRemove > characters.size())
            {
                Commands.printn("Character not found !");
                continue;
            }
            do
            {
                Commands.printn("Valid remove '"  + characters.get(indexRemove - 1).getName() + "' ? Yes / No");
                Commands.print("> ");
                valid = selectRemove.nextLine().toLowerCase();
            } while (!valid.equals("yes") && !valid.equals("no"));
        } while(!valid.equals("yes"));
        if (indexRemove != -1)
            characters.remove(indexRemove - 1);
        Commands.printn("**********************");
    }
}