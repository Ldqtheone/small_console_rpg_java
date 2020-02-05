import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  Class that contains all the commands
 */
public class Commands
{
    /**
     * Method to read command from Menu
     * @return true to continue or false to exit
     */
    public static boolean read()
    {
        Scanner sc = new Scanner(System.in);
        printn("****** Menu ******");
        print("> ");
        switch (sc.nextLine())
        {
            case "help":
                help();
                return true;
            case "exit":
                return false;
            case "play":
                main.game = new Game();
                printn("New game created !");
                return true;
            case "create":
                if(main.game == null)
                    printn("You must to create a new game with command 'play' !");
                else
                    main.game.create();
                return true;
            case "characters":
                if(main.game == null)
                    printn("You must to create a new game with command 'play' !");
                else
                {
                    if(main.game.characters.size() == 0)
                        printn("No characters found ! Use 'create' to create a character.");
                    else
                        main.game.listCharacters();
                }
                return true;
            case "info":
                if(main.game == null)
                    Commands.printn("You must to create a new game with command 'play' !");
                else
                {
                    int index;
                    main.game.listCharacters();
                    do
                    {
                        printn("Enter '-1' to quit the information.");
                        printn("");
                        index = inputInt("Enter character index :");
                        if(index == -1)
                            break;
                        else if(index > main.game.characters.size() || index <= 0)
                            printn("Character not found !");
                        else
                            printn(main.game.characters.get(index - 1));
                    } while(index != -1);
                }
                return true;
            case "fight":
                if(main.game == null)
                    printn("You must to create a new game with command 'play' !");
                else
                {
                    if(main.game.characters.size() < 2)
                        printn("You need at least two characters !");
                    else
                        main.game.fight();
                }
                return true;
            case "remove":
                if(main.game == null)
                    printn("You must to create a new game with command 'play' !");
                else
                {
                    if(main.game.characters.size() == 0)
                        Commands.printn("Characters list is empty !");
                    else
                        main.game.remove();
                }
                return true;
            default:
                printn("Command Error !");
                printn("");
                help();
                return true;
        }
    }

    /**
     * Display all available commands
     */
    private static void help()
    {
        printn("Commands list :");
        printn("");
        printn("help        - To get all the commands");
        printn("play        - To create a new game");
        printn("create      - To create a character");
        printn("characters  - To show all existing characters");
        printn("info        - To show character information");
        printn("fight       - To start a fight");
        printn("remove      - To remove a character");
        printn("exit        - To quit the application");
        printn("");
        printn("************************");
        printn("");
    }

    /**
     * Display an Object with back to line
     * @param o The object that you want to write
     */
    public static void printn(Object o)
    {
        System.out.println(o);
    }

    /**
     * Display an Object without back to line
     * @param o The object that you want to write
     */
    public static void print(Object o)
    {
        System.out.print(o);
    }

    /**
     * Method inputInt
     * @param message a message display before the input
     * @return an input number
     */
    public static int inputInt(String message)
    {
        boolean valid = false;
        int n = 0;
        while(!valid)
        {
            try
            {
                printn(message);
                print("> ");
                n = new Scanner(System.in).nextInt();
                valid = true;
            } catch (InputMismatchException e)
            {
                printn("Error !");
                printn("Enter a number !");
            }
        }
        return n;
    }
}