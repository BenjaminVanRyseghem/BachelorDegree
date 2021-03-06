
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Wed Oct 05 14:41:33 CEST 2011
//----------------------------------------------------

package init.analyseurs;


/** CUP v0.11a beta 20060608 generated parser.
  * @version Wed Oct 05 14:41:33 CEST 2011
  */
public class ParserInit extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public ParserInit() {super();}

  /** Constructor which sets the default scanner. */
  public ParserInit(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ParserInit(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\002\000\002\002\002\000\002\002\004" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\003\000\004\002\001\001\002\000\004\002\005\001" +
    "\002\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\003\000\004\002\003\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ParserInit$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ParserInit$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$ParserInit$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$ParserInit$actions {
  private final ParserInit parser;

  /** Constructor */
  CUP$ParserInit$actions(ParserInit parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$ParserInit$do_action(
    int                        CUP$ParserInit$act_num,
    java_cup.runtime.lr_parser CUP$ParserInit$parser,
    java.util.Stack            CUP$ParserInit$stack,
    int                        CUP$ParserInit$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ParserInit$result;

      /* select the action based on the action number */
      switch (CUP$ParserInit$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= texte EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ParserInit$stack.elementAt(CUP$ParserInit$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ParserInit$stack.elementAt(CUP$ParserInit$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$ParserInit$stack.elementAt(CUP$ParserInit$top-1)).value;
		RESULT = start_val;
              CUP$ParserInit$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ParserInit$stack.elementAt(CUP$ParserInit$top-1)), ((java_cup.runtime.Symbol)CUP$ParserInit$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ParserInit$parser.done_parsing();
          return CUP$ParserInit$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // texte ::= 
            {
              Object RESULT =null;

              CUP$ParserInit$result = parser.getSymbolFactory().newSymbol("texte",0, ((java_cup.runtime.Symbol)CUP$ParserInit$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserInit$stack.peek()), RESULT);
            }
          return CUP$ParserInit$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

