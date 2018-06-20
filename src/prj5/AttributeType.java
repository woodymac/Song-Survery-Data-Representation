package prj5;

//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Woody McIlhenny (woodymac)

/**
* Serves as a superclass for Major, Hobby, and State.
* (Relevant in Glyph's toString method)
* 
* @author Woody McIlhenny
* @version 2018.04.09
*/
public class AttributeType {

 /**
  * Creates a new AttributeEnumType object
  */
 public AttributeType() {
     // Nothing to initialize
 }


 /**
  * The add method is inherited by all subclasses
  * 
  * @param attr
  *            Determines the field that is changed.
  * 
  * @param bool1
  *            Determines if a field will be changed.
  * 
  * @param bool2
  *            Determines the field that is changed.
  * 
  * @param bool3
  *            Determines if a field will be changed.
  * 
  * @param bool4
  *            Determines the field that is changed.
  */
 public void add(
     AttributeEnum attr,
     boolean bool1,
     boolean bool2,
     boolean bool3,
     boolean bool4) {
     // This method is only here to be inherited
 }
}
