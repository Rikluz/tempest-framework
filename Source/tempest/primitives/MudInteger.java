package tempest.primitives;

public class MudInteger

{
  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  private int value;

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////

  public MudInteger()                 { value = 0;                   }
  public MudInteger(int i)            { value = i;                   }
  public boolean equals(MudInteger I) { return (value == I.value()); }
  public boolean equals(int i)        { return (value == i);         }
  public int value()                  { return value;                }
  public void set(int i)              { value = i;                   }
  public void set(MudInteger I)       { value = I.value();           }

  /////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////
}