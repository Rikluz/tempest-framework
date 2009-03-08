package tempest.data;
import java.lang.Iterable;
import java.util.Iterator;
import tempest.primitives.*;

public abstract class Data implements Iterable <Data>

{
  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  protected static final MudInteger VARIABLE   = new MudInteger(1);
  protected static final MudInteger OBJECT     = new MudInteger(2);
  protected static final MudInteger COLLECTION = new MudInteger(3);

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  protected MudString name;
  protected MudInteger dataID;
  protected Data parent;

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public void add(Data D)           { D.setParent(this);                  }
  public void remove(Data D)        { D.setParent(null);                  }
  public void setParent(Data D)     { parent = D;                         }
  public Data parent()              { return parent;                      }
  public MudString name()           { return name;                        }
  public boolean isVariable()       { return (dataID.equals(VARIABLE));   }
  public boolean isObject()         { return (dataID.equals(OBJECT));     }
  public boolean isCollection()     { return (dataID.equals(COLLECTION)); }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public abstract MudString value();
  public abstract void setValue(MudString s);
  public abstract Iterator <Data> iterator();
  public abstract Data get(String objectName);
  public abstract Data get(MudString objectName);
  public abstract int size();
  public abstract Data clone();

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public static DataSet List(Data set)

  {
    DataSet list = new DataSet();
    for (Data data : set) list.add(data);
    return list;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public static DataSet Intersect(Data set1, Data set2)

  {
    return Data.Difference(set1, Difference(set1, set2));
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public static DataSet IntersectSingle(Data set1, Data set2)

  {
    return Data.Difference(set1, DifferenceSingle(set1, set2));
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public static DataSet Difference(Data set1, Data set2)

  {
    DataSet difference = new DataSet();
    for (Data data : set1) difference.add(data);
    for (Data data : set2) difference.remove(data);
    return difference;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public static DataSet DifferenceSingle(Data set1, Data set2)

  {
    DataSet difference = new DataSet();
    for (Data data : set1) difference.add(data);
    difference.remove(set2);
    return difference;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public static DataSet Union(Data set1, Data set2)

  {
    DataSet union = new DataSet();
    for (Data data : set1) union.add(data);
    for (Data data : set2) union.add(data);
    return union;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public static DataSet UnionSingle(Data set1, Data set2)

  {
    DataSet union = new DataSet();
    for (Data data : set1) union.add(data);
    union.add(set2);
    return union;
  }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////
}