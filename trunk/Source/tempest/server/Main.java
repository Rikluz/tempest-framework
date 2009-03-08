package tempest.server;

import tempest.clients.ClientList;
import tempest.data.DataReader;
import tempest.interfaces.gameinterface.CommandTable;

public class Main

{
  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public static String DATA_PATH = ".//data//";

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public static void main(String args[])

  {
    DataReader reader = new DataReader();
    Mud.set(reader.read(DATA_PATH));

    Rooms.createRoomList();

    ClientList.init();
    PlayerList.init();
    CommandTable.getInstance();

    int port = parseArguments(args);
    Server mudServer = Server.getInstance();
    mudServer.open(port);
    mudServer.acceptingState();
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  private static int parseArguments(String[] args)

  {
    if (args.length == 0) return 7000;

    try

    {
      return Integer.parseInt(args[0]);
    }

    catch (Exception e)

    {
      System.out.println("Invalid port number. Using default 7000.");
      return 7000;
    }
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////
}