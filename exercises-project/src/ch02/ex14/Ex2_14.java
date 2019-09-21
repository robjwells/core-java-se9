package ch02.ex14;

/**
 * Output of javap for Network$Member:
 *
 * public class javaimpatient.ch02.sec06.Network$Member {
 *   private java.lang.String name;
 *   private java.util.ArrayList<javaimpatient.ch02.sec06.Network$Member> friends;
 *   final javaimpatient.ch02.sec06.Network this$0;
 *   public javaimpatient.ch02.sec06.Network$Member(javaimpatient.ch02.sec06.Network, java.lang.String);
 *   public void deactivate();
 *   public void addFriend(javaimpatient.ch02.sec06.Network$Member);
 *   public boolean belongsTo(javaimpatient.ch02.sec06.Network);
 *   public java.lang.String toString();
 * }
 *
 * Output of javap for Network:
 *
 * public class javaimpatient.ch02.sec06.Network {
 *   private java.util.ArrayList<javaimpatient.ch02.sec06.Network$Member> members;
 *   public javaimpatient.ch02.sec06.Network();
 *   public javaimpatient.ch02.sec06.Network$Member enroll(java.lang.String);
 *   public java.lang.String toString();
 * }
 *
 * We see the reference to the enclosing class in the `this$0` field, the constructor, and
 * the belongsTo member. The first is the most interesting -- the way that the outer this
 * can be referenced.
 */
public class Ex2_14 {
}
