public class main
{
    /**
     * Main function
     */
    public static Game game;
    public static void main(String[] args)
    {
        starting();
        while (Commands.read())
        { }
        quit();
    }

    /**
     * Start display
     */
    private static void starting()
    {
        Commands.printn("Application has started");
        Commands.printn("####################################################");
        Commands.printn("");
        Commands.printn("Welcome to .... RoleAdventure");
        Commands.printn("");
        Commands.printn("####################################################");
        Commands.printn("");
    }

    /**
     * Exit display
     */
    private static void quit()
    {
        Commands.printn("####################################################");
        Commands.printn("");
        Commands.printn("Good Bye");
        Commands.printn("");
        Commands.printn("####################################################");
        Commands.printn("");
    }
}