package tempest.server;

public abstract class Ansi

{
  /////////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////////

  public static String clearScreen = "\33[1;1H\33[0J";
  public static String resetOrigin = "\33[?6l";
  public static String wrapAround = "\33[?7l";
  public static String clearLine = "\33[0J";

  /////////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////////
}