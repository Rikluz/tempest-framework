package tempest.interfaces.menuinterface;

import java.util.Hashtable;
import tempest.clients.PlayerClient;
import tempest.data.Data;
import tempest.interfaces.MudInterface;
import tempest.primitives.MudOutput;
import tempest.primitives.MudString;
import tempest.server.Ansi;

public class MenuInterface extends MudInterface

{
  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  private boolean nullCommand;
  private boolean commandEntered;
  private Data menuData;
  private Data targetData;
  private Hashtable <MudString, Data> menuItems;

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public MenuInterface(PlayerClient client, Data menuData, Data targetData)

  {
    super(client);
    this.targetData = targetData;
    this.menuData = menuData;
    this.menuItems = new Hashtable <MudString, Data> ();
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void handleInput()

  {
    if (commandQueue.size() == 0) return;
    commandEntered = true;
    String command = commandQueue.removeFirst();

    if (command.length() != 0)

    {
      MudString temp = new MudString(command);
      Data menuItem = menuItems.get(temp);
      if (menuItem == null) echo("  #rInvalid selection.#N");
    }

    else nullCommand = true;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void handleOutput()

  {
    if (client.isLinkdead()) return;

    if (nullCommand)

    {
      MudString output = new MudString();
      output.append(Ansi.clearScreen);
      output.append(getPrompt());
      client.msg(output);
      nullCommand = false;
      return;
    }

    if (outputQueue.size() == 0) return;

    MudString output = new MudString();
    output.append(Ansi.clearScreen);

    if (!commandEntered) output.append("\r\n");

    commandEntered = false;

    for (int i=0; i<outputQueue.size(); i++)

    {
      output.append("\r\n");
      output.append(outputQueue.get(i));
    }

    output.appendLine();
    output.append(getPrompt());
    client.msg(output);
    outputQueue.clear();
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void receiveCommand(String commandString) throws Exception

  {
    commandString = commandString.trim();

    if (commandString.length() > 0)
      commandQueue.add(commandString);
    else nullCommand = true;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void echo(String s)

  {
    outputQueue.add(s);
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void echo(MudString s)

  {
    outputQueue.add(s.toString());
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void onPush()

  {

  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void onPop()

  {

  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void onDisconnect()

  {

  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void onReconnect()

  {

  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public MudString getPrompt()

  {
    MudString prompt = new MudString();
    prompt.appendLine();
    prompt.append(getMenu());
    prompt.appendLine();
    prompt.appendLine();
    prompt.append("  Select: ");
    return prompt;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void focusGained()

  {
    nullCommand = true;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void exit()

  {

  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  private MudString getMenu()

  {
    MudOutput output = new MudOutput();
    output.add(getDisplay());
    output.add("-");
    output.add(getMenuItems());

    MudString menu = new MudString();
    menu.append(output.boxify(2));

    return menu;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  private MudOutput getDisplay()

  {
    Data displayItems = menuData.get("display");
    MudOutput output = new MudOutput();

    for (Data item : displayItems)

    {
      MudString line = new MudString();
      line.append(item.name());
      line.append(": ");
      line.append(item.value());
      output.add(line);
    }

    return output;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  private MudOutput getMenuItems()

  {
    Data items = menuData.get("menu_items");
    MudOutput output = new MudOutput();
    int itemIndex = 1;
    menuItems.clear();

    for (Data item : items)

    {
      MudString strIndex = new MudString(Integer.toString(itemIndex++));
      menuItems.put(strIndex, item);
      MudString s = new MudString();
      s.append(strIndex);
      s.append(".) ");
      s.append(item.get("Text").value());
      output.add(s);
    }

    return output;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////
}