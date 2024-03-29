package tempest.interfaces.gameinterface;

import tempest.data.Data;
import tempest.primitives.MudInteger;
import tempest.primitives.MudString;

public abstract class EntityCommand

{
  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  protected EntityCommand()

  {
    level = new MudInteger();
    tablePriority = new MudInteger();
    abbreviation = new MudString();
    full = new MudString();
    shortcuts = new MudString();
    help = new MudString();
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public abstract MudString execute(Data entity, MudString parameter);

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  protected MudInteger level;
  protected MudInteger tablePriority;
  protected MudString abbreviation;
  protected MudString full;
  protected MudString shortcuts;
  protected MudString help;

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public MudString getFull()         { return full;         }
  public MudString getAbbreviation() { return abbreviation; }
  public MudString getShortcuts()    { return shortcuts;    }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////
}