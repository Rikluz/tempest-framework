package tempest.interfaces;
import java.util.LinkedList;
import tempest.clients.*;
import tempest.primitives.*;

public abstract class MudInterface

{
  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  protected PlayerClient client;
  protected LinkedList <String> commandQueue;
  protected LinkedList <String> outputQueue;

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public abstract void handleInput();
  public abstract void handleOutput();
  public abstract void onDisconnect();
  public abstract void onReconnect();
  public abstract void onPush();
  public abstract void onPop();
  public abstract void focusGained();
  public abstract void exit();
  public abstract void echo(String s);
  public abstract void echo(MudString s);
  public abstract MudString getPrompt();

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public abstract void receiveCommand(String commandString)
    throws Exception;

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public MudInterface(PlayerClient client)

  {
    this.client = client;
    commandQueue = new LinkedList <String> ();
    outputQueue = new LinkedList <String> ();
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////
}