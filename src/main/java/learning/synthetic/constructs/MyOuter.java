package learning.synthetic.constructs;

public class MyOuter {

    private MyInner inner;

    void createInner() {
        // The Compiler has to create a synthetic method
        // to construct a new MyInner because the constructor
        // is private.
        // --> synthetic "constructor" method
        inner = new MyInner();

        // The Compiler has to create a synthetic method
        // to doSomething on MyInner object because this
        // method is private.
        // --> synthetic "doSomething" method
        inner.doSomething();
    }

    private class MyInner {
        // the inner class holds a syntetic ref_pointer to
        // the outer "parent" class
        // --> synthetic field
        private MyInner() {
        }

        private void doSomething() {
        }
    }

}

/*
public class MyOuter
{
  private MyOuter.MyInner inner;
  
  public MyOuter() {}
  
  void createInner()
  {
    inner = new MyOuter.MyInner(this, null);

    MyOuter.MyInner.access$1(inner);
  }
}
*/