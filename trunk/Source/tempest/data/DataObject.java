package tempest.data;
import java.util.Iterator;
import tempest.primitives.*;

public class DataObject extends Data

{
  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  private HashList vars;

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public MudString value()           { return new MudString(""); }
  public void setValue(MudString s)  { return;                   }
  public Iterator <Data> iterator()  { return vars.iterator();   }
  public Data get(String objName)    { return vars.get(objName); }
  public Data get(MudString objName) { return vars.get(objName); }
  public int size()                  { return vars.size();       }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public DataObject(MudString objectName)

  {
    dataID = OBJECT;
    name = objectName;
    vars = new HashList(51);
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void add(Data var)

  {
    super.add(var);
    vars.add(var.name(), var);
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void remove(Data var)

  {
    super.remove(var);
    vars.remove(var.name());
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public Data clone()

  {
    DataObject newObject = new DataObject(name);

    for (Data data : vars)
      newObject.add(data.clone());

    return newObject;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////
}