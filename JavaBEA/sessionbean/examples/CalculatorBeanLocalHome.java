/*
 * Generated by XDoclet - Do not edit!
 */
package examples;

/**
 * Local home interface for CalculatorBean.
 */
public interface CalculatorBeanLocalHome
   extends javax.ejb.EJBLocalHome
{
   public static final String COMP_NAME="java:comp/env/ejb/CalculatorBeanLocal";
   public static final String JNDI_NAME="CalculatorBeanLocal";

   public examples.CalculatorBeanLocal create()
      throws javax.ejb.CreateException;

}
